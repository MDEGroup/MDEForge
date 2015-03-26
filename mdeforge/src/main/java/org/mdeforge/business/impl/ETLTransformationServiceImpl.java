package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.ecl.parse.Ecl_EolParserRules.throwStatement_return;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IRelativePathResolver;
import org.eclipse.epsilon.etl.EtlModule;
import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ETLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ETLTransformationRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.RelationRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ETLTransformationServiceImpl implements ETLTransformationService {

	@Autowired
	private ETLTransformationRepository ETLTransformationRepository;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;

	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private ArtifactService artifactService;

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;

	@Autowired
	private ArtifactRepository artifactRepository;

	@Autowired
	private GridFileMediaService gridFileMediaService;

	@Autowired
	private RelationRepository relationRepository;
	
	@Value("#{cfgproperties[basePath]}")
	private String basePath;
	
	@Override
	public ETLTransformation findOneBySharedUser(String idMetamodel, User user)
			throws BusinessException {
		ETLTransformation mm = ETLTransformationRepository.findOne(idMetamodel);
		for (User us : mm.getShared()) {
			if (us.getId().equals(user.getId()))
			{
				mm.setFile(gridFileMediaService.getGridFileMedia(mm.getFile()));
				return mm;
			}
				
		}
		throw new BusinessException();
	}


	public void delete(ETLTransformation metamodel) {
		for (Project p : metamodel.getProjects())
			for (Artifact mm : p.getArtifacts())
				if (mm.getId().equals(metamodel.getId()))
					p.getArtifacts().remove(mm);
		for (Workspace p : metamodel.getWorkspaces())
			for (Artifact mm : p.getArtifacts())
				if (mm.getId().equals(metamodel.getId()))
					p.getArtifacts().remove(mm);
		for (User p : metamodel.getShared())
			for (Artifact m : p.getSharedArtifact())
				if (m.getId().equals(metamodel.getId()))
					p.getSharedArtifact().remove(m);
		// gridFileMediaService.delete(metamodel.getFile());
		ETLTransformationRepository.delete(metamodel);

	}

	@Override
	public ETLTransformation findByName(String name) throws BusinessException {
		return ETLTransformationRepository.findByName(name);
	}

	@Override
	public void update(ETLTransformation transformation) {
		try {
			if (transformation.getId() == null)
				throw new BusinessException();
			// verify metamodel owner
			findByOwner(transformation.getId(), transformation.getAuthor()
					.getId());

			// UploadFile
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName("");
			fileMedia.setByteArray(Base64.decode(transformation.getFile()
					.getContent().getBytes()));
			transformation.setFile(fileMedia);

			for (Workspace ws : transformation.getWorkspaces()) {
				workspaceService.findById(ws.getId(), transformation.getAuthor());
			}
			// check project Auth
			for (Project p : transformation.getProjects()) {
				projectService.findById(p.getId(), transformation.getAuthor());
			}
			Transformation transTemp = ETLTransformationRepository
					.findOne(transformation.getId());
			gridFileMediaService.delete(transTemp.getFile().getId());
			if (transformation.getFile() != null) {
				gridFileMediaService.store(transformation.getFile());
			}

			List<Relation> relationTemp = transformation.getRelations();
			transformation.setRelations(new ArrayList<Relation>());
			ETLTransformationRepository.save(transformation);
			// check relation
			for (Relation rel : relationTemp) {
				Artifact toArtifact = artifactService.findOneForUser(rel
						.getToArtifact().getId(), transformation.getAuthor());
				if (artifactService.existRelation(toArtifact.getId(),
						transformation.getId())) {
					rel.setFromArtifact(transformation);
					transformation.getRelations().add(rel);
					relationRepository.save(rel);
					artifactRepository.save(transformation);
					Artifact temp = artifactRepository.findOne(rel
							.getToArtifact().getId());
					if (temp.getRelations() == null)
						temp.setRelations(new ArrayList<Relation>());
					temp.getRelations().add(rel);
					artifactRepository.save(temp);
				}
			}

			for (Workspace ws : transformation.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (!artifactService.isArtifactInWorkspace(w.getId(),
						transformation.getId())) {
					w.getArtifacts().add(transformation);
					workspaceRepository.save(w);
				}
			}
			for (Project ps : transformation.getProjects()) {
				Project p = projectService.findById(ps.getId(), transformation.getAuthor());
				if (!artifactService.isArtifactInProject(p.getId(),
						transformation.getId())) {
					p.getArtifacts().add(transformation);
					projectRepository.save(p);
				}
			}
			for (User us : transformation.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				if (!artifactService.isArtifactInUser(u,
						transformation.getId())) {
					u.getSharedArtifact().add(transformation);
					userRepository.save(u);
				}
			}
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public List<ETLTransformation> findAll() {
		return ETLTransformationRepository.findAll();
	}

	@Override
	public List<ETLTransformation> findAllTransformations()
			throws BusinessException {
		return ETLTransformationRepository.find();
	}

	@Override
	public ArtifactList findAllTransformationsByUserId(String username)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria
				.where("shared")
				.in(username)
				.andOperator(
						Criteria.where("_class").is(
								Transformation.class.getCanonicalName())));
		List<Transformation> metamodels = operations.find(query,
				Transformation.class);
		return new ArtifactList(metamodels);
	}

	@Override
	public void create(ETLTransformation transformation) throws BusinessException {
		try {
			
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName("");
			fileMedia.setByteArray(Base64.decode(transformation.getFile()
					.getContent().getBytes()));
			transformation.setFile(fileMedia);
		
			if (transformation.getId() != null)
				throw new BusinessException();
			// UploadFile
			for (Workspace ws : transformation.getWorkspaces()) {
				workspaceService.findById(ws.getId(), transformation.getAuthor());
			}
			// check project Auth
			for (Project p : transformation.getProjects()) {
				projectService.findById(p.getId(), transformation.getAuthor());
			}

			if (transformation.getFile() != null) {
				gridFileMediaService.store(transformation.getFile());
			}
			// Update bi-directional reference
			List<Relation> relationTemp = transformation.getRelations();
			transformation.setRelations(new ArrayList<Relation>());

			User user = userRepository.findOne(transformation.getAuthor().getId());
			transformation.setAuthor(user);
			transformation.getShared().add(user);
			ETLTransformationRepository.save(transformation);

			// check relation
			for (Relation rel : relationTemp) {
				artifactService.findByOwner(rel.getToArtifact().getId(),
						transformation.getAuthor());
				rel.setFromArtifact(transformation);
				transformation.getRelations().add(rel);
				relationRepository.save(rel);
				artifactRepository.save(transformation);
				Artifact temp = artifactRepository.findOne(rel.getToArtifact()
						.getId());
				if (temp.getRelations() == null)
					temp.setRelations(new ArrayList<Relation>());
				temp.getRelations().add(rel);
				artifactRepository.save(temp);
			}

			for (Workspace ws : transformation.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (w == null)
					throw new BusinessException();
				w.getArtifacts().add(transformation);
				workspaceRepository.save(w);
			}
			for (Project ps : transformation.getProjects()) {
				Project p = projectService.findById(ps.getId(), transformation.getAuthor());
				p.getArtifacts().add(transformation);
				projectRepository.save(p);
			}
			for (Relation rel : transformation.getRelations()) {
				relationRepository.save(rel);
			}

			for (User us : transformation.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				u.getSharedArtifact().add(transformation);
				userRepository.save(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public ArtifactList findAllWithPublic(String user)
			throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user);
		Criteria c2 = Criteria.where("open").is("true");
		query.addCriteria(c1.orOperator(c2));
		List<Transformation> result = n.find(query, Transformation.class);
		return new ArtifactList(result);
	}

	@Override
	public ArtifactList findAllPublic() throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria
				.where("open")
				.is(true)
				.andOperator(
						Criteria.where("_class").is(
								Transformation.class.getCanonicalName())));

		List<Transformation> result = n.find(query, Transformation.class);
		return new ArtifactList(result);
	}

	// Inizio Alexander
	@Override
	public void upload(ETLTransformation metamodel, MultipartFile file) {
		ETLTransformationRepository.save(metamodel);
	}

	@Override
	public ResponseGrid<ETLTransformation> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<ETLTransformation> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = ETLTransformationRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.ASC, requestGrid
							.getSortCol()));
		} else {
			rows = ETLTransformationRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.DESC,
					requestGrid.getSortCol()));
		}
		return new ResponseGrid<ETLTransformation>(requestGrid.getsEcho(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}

	@Override
	public void download(ETLTransformation metamodel) {
	}

	// fine Alexander

	@Override
	public ETLTransformation findByOwner(String idMetamodel, String idUser)
			throws BusinessException {
		ETLTransformation mm = ETLTransformationRepository.findOne(idMetamodel);
		try {
			if (!mm.getAuthor().getId().equals(idUser))
				throw new BusinessException();
		} catch (Exception e) {
			throw new BusinessException();
		}
		return mm;

	}

	@Override
	public ETLTransformation findOne(String id) throws BusinessException {
		return ETLTransformationRepository.findOne(id);
	}

	@Override
	public void upload(Transformation transformation) {
		// TODO Auto-generated method stub

	}

	private File getSource(String filePath) throws URISyntaxException {
		return new File(filePath);
	}
	
	@Override
	public void execute(ETLTransformation transformation) {
		List<String> sourceMetamodel = new ArrayList<String>();
		List<String> targetMetamodel = new ArrayList<String>();
		for(Relation rel : transformation.getRelations()) {
			if (rel instanceof DomainConformToRelation)
				if(rel.getToArtifact() instanceof EcoreMetamodel) {
					ecoreMetamodelService.registerMetamodel((EcoreMetamodel) rel.getToArtifact());
					rel.setToArtifact(ecoreMetamodelService.findOne(rel.getToArtifact().getId()));
					sourceMetamodel.add(gridFileMediaService.getFilePath(rel.getToArtifact()));
				}
			if (rel instanceof CoDomainConformToRelation)
				if(rel.getToArtifact() instanceof EcoreMetamodel) {
					ecoreMetamodelService.registerMetamodel((EcoreMetamodel) rel.getToArtifact());
					rel.setToArtifact(ecoreMetamodelService.findOne(rel.getToArtifact().getId()));
					targetMetamodel.add(gridFileMediaService.getFilePath(rel.getToArtifact()));
				}		
		}
		String transformationPath = gridFileMediaService.getFilePath(transformation);
		EtlModule module = new EtlModule();
		//TODO DANIELE DEVE ESSERE SETTATO DINAMICAMENTE E NON 
		//STATICAMENTE
		transformation.setTargetName("Target");
		Random randomGenerator = new Random();
		String outputPath = basePath + randomGenerator.nextInt(100);
		
		try {
			module.parse(getSource(transformationPath));
			
			List<IModel> models = new ArrayList<IModel>();
			
			//TODO DANIELE Dovrebbe fare forEach sui models_in 
			//OCCHIO AD ASSOCIARE IL GIUSTO METAMODELLO AL MODELLO
			for (Model model : transformation.getModels_in()) {
				String path = gridFileMediaService.getFilePath(model);
				//TODO DANIELE vedi commento nel data model
				models.add(createEmfModel(transformation.getSourceName(),
					path, sourceMetamodel,
					true, false));
			}
			//TODO DANIELE Anche qui dovrebbe diventare una lista di modelli in output
			//con foreach sui modelli in output
			models.add(loadEmptyModel(transformation.getTargetName(),
					targetMetamodel, outputPath));
	
			// to register the emf models into models repository
			for (IModel model : models) {
				((EtlModule) module).getContext().getModelRepository()
						.addModel(model);
			}
			((EtlModule) module).execute();
			((EtlModule) module).getContext().getModelRepository().dispose();
		} catch (URISyntaxException e) {
			throw new BusinessException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException();
		}
	}

	
	private EmfModel createEmfModel(String name, String model, List<String> metamodel,
			boolean readOnLoad, boolean storeOnDisposal)
			throws EolModelLoadingException, URISyntaxException,
			EolModelElementTypeNotFoundException {

		EmfModel emfModel = new EmfModel();
		
		emfModel.setMetamodelFiles(metamodel);
		emfModel.setModelFileUri(URI.createFileURI(new File(model).getAbsolutePath()));
		emfModel.setStoredOnDisposal(true);
		emfModel.setReadOnLoad(false);
		emfModel.setName(name);

		return emfModel;
	}
	
	private EmfModel createEmfModel(String name, Model model, List<String> metamodel,
			boolean readOnLoad, boolean storeOnDisposal)
			throws EolModelLoadingException, URISyntaxException,
			EolModelElementTypeNotFoundException {

		EmfModel emfModel = new EmfModel();
		
		emfModel.setMetamodelFiles(metamodel);
		emfModel.setModelFileUri(URI.createFileURI(new File("temp/").getAbsolutePath()));
		emfModel.setStoredOnDisposal(true);
		emfModel.setReadOnLoad(false);
		emfModel.setName(name);

		return emfModel;
	}
	private EmfModel loadEmptyModel(String name, List<String> metamodelPath,
			String outPath) throws EolModelLoadingException, URISyntaxException {

		EmfModel emfModel = new EmfModel();

//		StringProperties properties = new StringProperties();
//		properties.put(EmfModel.PROPERTY_NAME, name);
//		properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,getFile(path).toURI().toString());
//		properties.put(EmfModel.PROPERTY_MODEL_URI, URI.createFileURI(new File(outPath).getAbsolutePath()));
//		properties.put(EmfModel.PROPERTY_READONLOAD, false + "");
//		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, true + "");	
//		emfModel.load(properties, (IRelativePathResolver) null);
		
		ArrayList<URI> metamodelFiles = new ArrayList<URI>();
		for (String path : metamodelPath) {
			metamodelFiles.add(
					URI.createFileURI(getFile(path).getAbsolutePath())
					);
		}
		
		emfModel.setMetamodelFileUris(metamodelFiles);
		emfModel.setModelFileUri(URI.createFileURI(new File(outPath).getAbsolutePath()));
		emfModel.setStoredOnDisposal(true);
		emfModel.setReadOnLoad(false);
		emfModel.setName(name);
		
		emfModel.load();
		return emfModel;
	}


	protected File getFile(String fileName) throws URISyntaxException {
		return new File(fileName);
	}
	
	@Override
	public List<ETLTransformation> findTransformationsBySourceMetamodels(
			ETLTransformation metamodel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ETLTransformation> findTransformationsByTargetMetamodels(
			ETLTransformation metamodel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteTransformation(String idMetamodel, User user)
			throws BusinessException {
		artifactService.delete(idMetamodel, user);
	}
	
	@Override
	public ArtifactList findtTransformationInWorkspace(String idWorkspace, User user) throws BusinessException{
		workspaceService.findById(idWorkspace, user);
		ArtifactList aList = new ArtifactList( ETLTransformationRepository.findByWorkspaceId(new ObjectId(idWorkspace)));
		return aList;
	}
	@Override
	public ArtifactList findtTransformationInProject(String idProject, User user) throws BusinessException{
		projectService.findById(idProject, user);
		ArtifactList aList =  new ArtifactList(ETLTransformationRepository.findByProjectId(new ObjectId(idProject)));
		return aList;
	}
}


