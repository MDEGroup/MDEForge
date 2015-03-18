package org.mdeforge.business.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.IInjector;
import org.eclipse.m2m.atl.core.IModel;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFReferenceModel;
import org.eclipse.m2m.atl.core.launch.ILauncher;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceImpl;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.MetricProvider;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.AggregatedIntegerMetric;
import org.mdeforge.business.model.AggregatedRealMetric;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.emf.metric.Container;
import org.mdeforge.emf.metric.MetricFactory;
import org.mdeforge.emf.metric.MetricPackage;
import org.mdeforge.integration.ATLTransformationRepository;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.MetricRepository;
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
import org.springframework.web.multipart.MultipartFile;

@Service
public class ATLTransformationServiceImpl implements ATLTransformationService, MetricProvider {

	@Autowired
	private ATLTransformationRepository ATLTransformationRepository;

	@Autowired
	private MetricRepository metricRepository;
	
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
	private ArtifactRepository artifactRepository;

	@Autowired
	private GridFileMediaService gridFileMediaService;

	@Autowired
	private RelationRepository relationRepository;
	
	
	@Override
	public ATLTransformation findOneBySharedUser(String idMetamodel, User user)
			throws BusinessException {
		ATLTransformation mm = ATLTransformationRepository.findOne(idMetamodel);
		for (User us : mm.getShared()) {
			if (us.getId().equals(user.getId()))
			{
				mm.setFile(gridFileMediaService.getGridFileMedia(mm.getFile()));
				return mm;
			}
				
		}
		throw new BusinessException();
	}


	public void delete(ATLTransformation metamodel) {
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
		ATLTransformationRepository.delete(metamodel);

	}

	@Override
	public ATLTransformation findByName(String name) throws BusinessException {
		return ATLTransformationRepository.findByName(name);
	}

	@Override
	public void update(ATLTransformation transformation) {
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
			Transformation transTemp = ATLTransformationRepository
					.findOne(transformation.getId());
			gridFileMediaService.delete(transTemp.getFile().getId());
			if (transformation.getFile() != null) {
				gridFileMediaService.store(transformation.getFile());
			}

			List<Relation> relationTemp = transformation.getRelations();
			transformation.setRelations(new ArrayList<Relation>());
			ATLTransformationRepository.save(transformation);
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
	public List<ATLTransformation> findAll() {
		return ATLTransformationRepository.findAll();
	}

	@Override
	public List<ATLTransformation> findAllTransformations()
			throws BusinessException {
		return ATLTransformationRepository.find();
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
	public void create(ATLTransformation transformation) throws BusinessException {
		try {
			
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName("");
			fileMedia.setByteArray(Base64.decode(transformation.getFile()
					.getContent().getBytes()));
			transformation.setFile(fileMedia);
			//injection TEST
			Injector inj = new Injector();
			
			
			String mm = new String (transformation.getFile().getByteArray()); 
    		
			File tempFile = File.createTempFile("tempfile", ".tmp"); 
			FileInputStream fis = new FileInputStream(tempFile);
			BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
    	    bw.write(mm);
    	    bw.close();
			
			inj.inject(fis);
			
			
			
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
			ATLTransformationRepository.save(transformation);

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
	public void upload(ATLTransformation metamodel, MultipartFile file) {
		ATLTransformationRepository.save(metamodel);
	}

	@Override
	public ResponseGrid<ATLTransformation> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<ATLTransformation> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = ATLTransformationRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.ASC, requestGrid
							.getSortCol()));
		} else {
			rows = ATLTransformationRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.DESC,
					requestGrid.getSortCol()));
		}
		return new ResponseGrid<ATLTransformation>(requestGrid.getsEcho(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}

	@Override
	public void download(ATLTransformation metamodel) {
	}

	// fine Alexander

	@Override
	public ATLTransformation findByOwner(String idMetamodel, String idUser)
			throws BusinessException {
		ATLTransformation mm = ATLTransformationRepository.findOne(idMetamodel);
		try {
			if (!mm.getAuthor().getId().equals(idUser))
				throw new BusinessException();
		} catch (Exception e) {
			throw new BusinessException();
		}
		return mm;

	}

	@Override
	public ATLTransformation findOne(String id) throws BusinessException {
		return ATLTransformationRepository.findOne(id);
	}

	@Override
	public void upload(Transformation transformation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void execute(ATLTransformation transformation) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ATLTransformation> findTransformationsBySourceMetamodels(
			ATLTransformation metamodel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ATLTransformation> findTransformationsByTargetMetamodels(
			ATLTransformation metamodel) {
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
		ArtifactList aList = new ArtifactList( ATLTransformationRepository.findByWorkspaceId(new ObjectId(idWorkspace)));
		return aList;
	}
	@Override
	public ArtifactList findtTransformationInProject(String idProject, User user) throws BusinessException{
		projectService.findById(idProject, user);
		ArtifactList aList =  new ArtifactList(ATLTransformationRepository.findByProjectId(new ObjectId(idProject)));
		return aList;
	}


	@Override
	public List<Metric> calculateMetrics(Artifact emm) throws BusinessException {
		ILauncher transformationLauncher = new EMFVMLauncher();
		ModelFactory modelFactory = new EMFModelFactory();
		IInjector injector = new EMFInjector();
		IExtractor extractor = new EMFExtractor();
		/*
		 * Load metamodels
		 */
		try {
			IReferenceModel outputMetamodel = modelFactory.newReferenceModel();
			injector.inject(outputMetamodel, "/Users/juridirocco/Documents/workspace/MDEForgeLuna2/mdeforge/utils/Metric.ecore");
			IReferenceModel inputMetamodel = modelFactory.newReferenceModel();
			
			injector.inject(inputMetamodel, org.eclipse.emf.ecore.EcorePackage.eNS_URI);
			
			
			IModel inputModel = modelFactory.newModel(inputMetamodel);
			IModel outModel = modelFactory.newModel(outputMetamodel);
//			
//			
			
			String mm = new String (emm.getFile().getByteArray()); 
	    		
			File temp = File.createTempFile("tempfile", ".tmp"); 
			FileInputStream fis = new FileInputStream(temp);
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
    	    bw.write(mm);
    	    bw.close();
			injector.inject(inputModel, fis, null);
			transformationLauncher.initialize(new HashMap<String,Object>());
			transformationLauncher.addInModel(inputModel, "IN", "ATL");
			transformationLauncher.addOutModel(outModel , "OUT" , "Metric") ;
			transformationLauncher.launch(ILauncher.RUN_MODE, null, new HashMap<String,Object>(), 
					(Object[])getModulesList("/Users/juridirocco/Documents/workspace/MDEForgeLuna2/mdeforge/utils/ATLMetric.asm.asm"));

			extractor.extract(outModel, "sampleCompany_Cut.xmi");
			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
			emfModelFactory.unload((EMFReferenceModel) inputMetamodel);
			emfModelFactory.unload((EMFReferenceModel) outputMetamodel);
			
			List<Metric> result = getMetricList("sampleCompany_Cut.xmi", emm);
			File temp2 = new File("sampleCompany_Cut.xmi");
			temp2.delete();
			return result;
		} catch (ATLCoreException e) {
			throw new BusinessException();
		} catch (IOException e) {
			throw new BusinessException();
		}
	}
	private InputStream[] getModulesList(String modules_input) throws IOException {
		InputStream[] modules = null;
		String[] moduleNames = modules_input.split(",");
		modules = new InputStream[moduleNames.length];
		for (int i = 0; i < moduleNames.length; i++) {
			String asmModulePath = new Path(moduleNames[i].trim()).removeFileExtension().addFileExtension("asm").toString();			
			modules[i] = new FileInputStream(asmModulePath);
		}
		return modules;
	}
	
	private List<Metric> getMetricList(String path, Artifact art) {
		
		MetricPackage.eINSTANCE.eClass();
	    // Retrieve the default factory singleton
		MetricFactory factory = MetricFactory.eINSTANCE;
	    Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
	    Map<String, Object> m = reg.getExtensionToFactoryMap();
	    m.put("xmi", new XMIResourceFactoryImpl());
	    // Obtain a new resource set
	    ResourceSet resSet = new ResourceSetImpl();
	    // Create a resource
	    
	    Resource resource = resSet.createResource(URI
	        .createURI(path));
	    try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

	    Container myForge = (Container) resource.getContents().get(0);
	    List<Metric> result = new ArrayList<Metric>();
	    Iterator it = myForge.getMetrics().iterator();	    
	    while (it.hasNext())
	    {
	    	org.mdeforge.emf.metric.Metric at2 = (org.mdeforge.emf.metric.Metric)it.next();
	    	Metric metric = null;
	    	if (at2 instanceof org.mdeforge.emf.metric.impl.SimpleMetricImpl)
	    	{
	    		SimpleMetric metric2 = new SimpleMetric();
	    		metric2.setName(at2.getName());
	    		metric2.setDescription(at2.getDescription());
	    		metric2.setValue(((org.mdeforge.emf.metric.impl.SimpleMetricImpl) at2).getValue());
	    		metric = metric2;
	    	}
	    	if (at2 instanceof org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl)
	    	{
	    		AggregatedIntegerMetric metric2 = new AggregatedIntegerMetric();
	    		metric2.setAverage(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2).getAverage());
	    		metric2.setMaximum(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2).getMaximum());
	    		metric2.setMedian(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2).getMedian());
	    		metric2.setMinimum(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2).getMinimum());
	    		metric2.setName(at2.getName());
	    		metric2.setDescription(at2.getDescription());
	    		metric = metric2;
	    	}
	    	if (at2 instanceof org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl)
	    	{
	    		AggregatedRealMetric metric2 = new AggregatedRealMetric();
	    		metric2.setAverage(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2).getAverage());
	    		metric2.setMaximum(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2).getMaximum());
	    		metric2.setMedian(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2).getMedian());
	    		metric2.setMinimum(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2).getMinimum());
	    		metric2.setName(at2.getName());
	    		metric2.setDescription(at2.getDescription());
	    		metric = metric2;
	    	}
	    	metric.setArtifact(art);
	    	metricRepository.save(metric);
	    	result.add(metric);
    	}
		
	    return result;
//		return null;
	}
}

class Injector {
	
	public String inject(FileInputStream ATLFile){
		
		AtlResourceImpl ri = new AtlResourceImpl();
		ResourceSet rs = new ResourceSetImpl();
		rs.getResources().add(ri);
		try
		{
			
			//ri.getContents().get(0)
			ri.load(ATLFile, null);
			Resource xmiRes = rs.createResource(URI.createURI("jjjj.xmi"));
			xmiRes.getContents().addAll(ri.getContents());
			xmiRes.save(null);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("\t\tSingle injection of "+ATLFile+" executed");
		return ATLFile+".xmi";
	}
}
