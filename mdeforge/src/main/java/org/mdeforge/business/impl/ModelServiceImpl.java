package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.ValidateService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.ModelRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.RelationRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service
public class ModelServiceImpl implements ModelService, ValidateService {
	@Autowired
	private ArtifactRepository artifactRepository;
	@Autowired
	private RelationRepository relationRepository;
	@Autowired
	private ArtifactService artifactService;
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private WorkspaceRepository workspaceRepository;
	@Autowired
	private GridFileMediaService gridFileMediaService; 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	@Override
	public void upload(Model model) {
		modelRepository.save(model);
	}

	@Override
	public void download(Model model) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Model model) {
		modelRepository.delete(model);

	}

	@Override
	public List<Model> findModelsByMetamodel(Metamodel metamodel) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ResponseGrid<Model> findAllPaginated(RequestGrid requestGrid) throws BusinessException {
		Page<Model>  rows = null;
		if (requestGrid.getSortDir().compareTo("asc")==0){
			rows = modelRepository.findAll(new PageRequest(requestGrid.getiDisplayStart(), requestGrid.getiDisplayLength(),Direction.ASC, requestGrid.getSortCol()));
		}else{
			rows = modelRepository.findAll(new PageRequest(requestGrid.getiDisplayStart(), requestGrid.getiDisplayLength(),Direction.DESC, requestGrid.getSortCol()));
		}
		return new ResponseGrid<Model>(requestGrid.getsEcho(), rows.getNumberOfElements(), rows.getTotalElements(), rows.getContent());
	}
	
	@Override
	public Model findByName(String name) throws BusinessException {
		return modelRepository.findByName(name);
	}

	@Override
	public void update(Model model) {
		modelRepository.save(model);
	}
	

	@Override
	public List<Model> findAll() {
		return modelRepository.findAll();
	}

//	@Override
//	public boolean isValid(EmfModel model) {
//		
//	}

//	@Override
//	public List<String> getMetamodelsURIs() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<URI> getMetamodelFileUris(EmfModel model) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	public String create(Model model) throws BusinessException {
		// check workspace Auth
		try {
			// GetUser
			if (model.getId() != null)
				throw new BusinessException();

			// File handler
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName(model.getName());
			fileMedia.setByteArray(Base64.decode(model.getFile()
					.getContent().getBytes()));
			model.setFile(fileMedia);

			// check workspace Auth
			for (Workspace ws : model.getWorkspaces()) {
				workspaceService.findById(ws.getId(), model.getAuthor());
			}
			// check project Auth
			for (Project p : model.getProjects()) {
				projectService.findById(p.getId(), model.getAuthor());
			}
			if (model.getFile() != null) {
				gridFileMediaService.store(model.getFile());
			}
			model.setCreated(new Date());
			model.setModified(new Date());
			
			User user = userRepository.findOne(model.getAuthor().getId());
			model.setAuthor(user);
			model.getShared().add(user);
			
			List<Relation> relationTemp = model.getRelations();
			model.setRelations(new ArrayList<Relation>());
			modelRepository.save(model);
			// check relation
			for (Relation rel : relationTemp) {
				Artifact toArtifact = artifactService.findOneForUser(rel
						.getToArtifact().getId(), model.getAuthor());
				if (!artifactService.existRelation(toArtifact.getId(),
						model.getId())) {
					rel.setFromArtifact(model);
					model.getRelations().add(rel);
					relationRepository.save(rel);
					artifactRepository.save(model);
					Artifact temp = artifactRepository.findOne(rel
							.getToArtifact().getId());
					if (temp.getRelations() == null)
						temp.setRelations(new ArrayList<Relation>());
					temp.getRelations().add(rel);
					artifactRepository.save(temp);
				}
			}
			// Update bi-directional reference
			modelRepository.save(model);
			for (Workspace ws : model.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (w == null)
					throw new BusinessException();
				w.getArtifacts().add(model);
				workspaceRepository.save(w);
			}
			for (Project ps : model.getProjects()) {
				Project p = projectService.findById(ps.getId(), model.getAuthor());
				p.getArtifacts().add(model);
				projectRepository.save(p);
			}
			for (User us : model.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				u.getSharedArtifact().add(model);
				userRepository.save(u);
			}
			return model.getId();
		} catch (Exception e) {
			throw new BusinessException();
		}
	}
	
	@Override
	public Model findOne(String id) throws BusinessException {
		Model model = modelRepository.findOne(id);
		if (model != null)
			model.setFile(gridFileMediaService.getGridFileMedia(model.getFile()));
		else
			throw new BusinessException();
		return model;
	}
	@Override
	public List<Model> findAllModelsByUserId(User user)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria
				.where("shared")
				.in(user.getId())
				.andOperator(
						Criteria.where("_class").is(
								Model.class.getCanonicalName())));
		List<Model> models = operations.find(query,
				Model.class);
		return models;
	}
	@Override
	public List<Model> findAllWithPublic(User user) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user.getId());
		Criteria c2 = Criteria.where("open").is("true");
		query.addCriteria(c1.orOperator(c2));
		List<Model> result = n.find(query, Model.class);
		return result;
	}

	@Override
	public void deleteModel(String idEcoreMetamodel, User user) {
		artifactService.delete(idEcoreMetamodel, user);
	}
	@Override
	public Model findOneBySharedUser(String idEcoreMetamodel, User user)
			throws BusinessException {
		Model mm = modelRepository.findOne(idEcoreMetamodel);
		for (User us : mm.getShared()) {
			if (us.getId().equals(user.getId())) {
				mm.setFile(gridFileMediaService.getGridFileMedia(mm.getFile()));
				return mm;
			}

		}
		throw new BusinessException();
	}

	@Override
	public boolean isValid(Artifact art)throws BusinessException {
		EcoreMetamodel emm = null;
		for (Relation rel : art.getRelations()) {
			if (rel instanceof ConformToRelation) {
				Artifact temm = rel.getToArtifact();
				emm = ecoreMetamodelService.findOne(temm.getId());
			}
		}
		if (emm == null) throw new BusinessException();
		if (art instanceof Model){
			try {
				ecoreMetamodelService.registerMetamodel(emm);
				XMIResourceImpl resource = new XMIResourceImpl();
				File temp = new File(gridFileMediaService.getFilePath(art));
				 
				resource.load( new FileInputStream(temp), new HashMap<Object,Object>());
				EObject data = resource.getContents().get(0); 


				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(data);
				if (diagnostic.getSeverity() == Diagnostic.ERROR) 
					return false;
				else return true;
				
			} catch (Exception e) {
				return false;
			}
		}
		else return false;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Model> findAllPublic() throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria
				.where("open")
				.is(true)
				.orOperator(
						Criteria.where("_class").is(
								Model.class.getCanonicalName()));
		query.addCriteria(c2);
		List<Model> result = n.find(query, Model.class);
		return result;
	}
}
