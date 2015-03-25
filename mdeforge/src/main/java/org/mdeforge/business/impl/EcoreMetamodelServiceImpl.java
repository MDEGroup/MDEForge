package org.mdeforge.business.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.bson.types.ObjectId;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
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
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetricProvider;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.AggregatedIntegerMetric;
import org.mdeforge.business.model.AggregatedRealMetric;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.emf.metric.Container;
import org.mdeforge.emf.metric.MetricFactory;
import org.mdeforge.emf.metric.MetricPackage;
import org.mdeforge.integration.EcoreMetamodelRepository;
import org.mdeforge.integration.MetricRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EcoreMetamodelServiceImpl implements EcoreMetamodelService, MetricProvider {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private ArtifactService artifactService;
	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private EcoreMetamodelRepository ecoreMetamodelRepository;
	@Autowired
	private MetricRepository metricRepository;
	@Autowired
	private WorkspaceRepository workspaceRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private GridFileMediaService gridFileMediaService;

	@Override
	public void delete(EcoreMetamodel ecoreMetamodel) {
		for (Project p : ecoreMetamodel.getProjects())
			for (Artifact mm : p.getArtifacts())
				if (mm.getId().equals(ecoreMetamodel.getId()))
					p.getArtifacts().remove(mm);
		for (Workspace p : ecoreMetamodel.getWorkspaces())
			for (Artifact mm : p.getArtifacts())
				if (mm.getId().equals(ecoreMetamodel.getId()))
					p.getArtifacts().remove(mm);
		for (User p : ecoreMetamodel.getShared())
			for (Artifact m : p.getSharedArtifact())
				if (m.getId().equals(ecoreMetamodel.getId()))
					p.getSharedArtifact().remove(m);
		// gridFileMediaService.delete(metamodel.getFile());
		ecoreMetamodelRepository.delete(ecoreMetamodel);

	}

	@Override
	public List<EcoreMetamodel> findEcoreMetamodelByURI(String URI) {
		return null;
	}

	@Override
	public EcoreMetamodel findByName(String name) throws BusinessException {
		return ecoreMetamodelRepository.findByName(name);
	}

	@Override
	public void update(EcoreMetamodel ecoreMetamodel) {
		try {
			if (ecoreMetamodel.getId() == null)
				throw new BusinessException();

			// UploadFile
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName("");
			fileMedia.setByteArray(Base64.decode(ecoreMetamodel.getFile()
					.getContent().getBytes()));
			ecoreMetamodel.setFile(fileMedia);

			// verify s owner
			findByOwner(ecoreMetamodel.getId(), ecoreMetamodel.getAuthor());

			for (Workspace ws : ecoreMetamodel.getWorkspaces()) {
				workspaceService.findById(ws.getId(), ecoreMetamodel.getAuthor());
			}
			// check project Auth
			for (Project p : ecoreMetamodel.getProjects()) {
				projectService.findById(p.getId(), ecoreMetamodel.getAuthor());
			}
			if (ecoreMetamodel.getFile() != null) {
				gridFileMediaService.store(ecoreMetamodel.getFile());
			}

			ecoreMetamodel.setModified(new Date());
			ecoreMetamodelRepository.save(ecoreMetamodel);
			for (Workspace ws : ecoreMetamodel.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (!artifactService.isArtifactInWorkspace(w.getId(),
						ecoreMetamodel.getId())) {
					w.getArtifacts().add(ecoreMetamodel);
					workspaceRepository.save(w);
				}
			}
			for (Project ps : ecoreMetamodel.getProjects()) {
				Project p = projectService.findById(ps.getId(), ecoreMetamodel.getAuthor());
				if (!artifactService.isArtifactInProject(p.getId(),
						ecoreMetamodel.getId())) {
					p.getArtifacts().add(ecoreMetamodel);
					projectRepository.save(p);
				}
			}
			for (User us : ecoreMetamodel.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				if (!artifactService.isArtifactInUser(u,
						ecoreMetamodel.getId())) {
					u.getSharedArtifact().add(ecoreMetamodel);
					userRepository.save(u);
				}
			}
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public List<EcoreMetamodel> findAll() {
		return ecoreMetamodelRepository.findAll();
	}

	

	@Override
	public ArtifactList findAllEcoreMetamodelsByUserId(User user)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria
				.where("shared")
				.in(user.getId())
				.andOperator(
						Criteria.where("_class").is(
								EcoreMetamodel.class.getCanonicalName())));
		List<EcoreMetamodel> ecoreMetamodels = operations.find(query, EcoreMetamodel.class);
		return new ArtifactList(ecoreMetamodels);
	}

	@Override
	public String create(EcoreMetamodel ecoreMetamodel) throws BusinessException {
		// check workspace Auth
		try {
			// GetUser
			if (ecoreMetamodel.getId() != null)
				throw new BusinessException();

			// File handler
			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName(ecoreMetamodel.getName());
			fileMedia.setByteArray(Base64.decode(ecoreMetamodel.getFile()
					.getContent().getBytes()));
			ecoreMetamodel.setFile(fileMedia);

			// check workspace Auth
			for (Workspace ws : ecoreMetamodel.getWorkspaces()) {
				workspaceService.findById(ws.getId(), ecoreMetamodel.getAuthor());
			}
			// check project Auth
			for (Project p : ecoreMetamodel.getProjects()) {
				projectService.findById(p.getId(), ecoreMetamodel.getAuthor());
			}
			if (ecoreMetamodel.getFile() != null) {
				gridFileMediaService.store(ecoreMetamodel.getFile());
			}
			ecoreMetamodel.setCreated(new Date());
			ecoreMetamodel.setModified(new Date());
			
			User user = userRepository.findOne(ecoreMetamodel.getAuthor().getId());
			ecoreMetamodel.setAuthor(user);
			ecoreMetamodel.getShared().add(user);
			
			// Update bi-directional reference
			ecoreMetamodelRepository.save(ecoreMetamodel);
			for (Workspace ws : ecoreMetamodel.getWorkspaces()) {
				Workspace w = workspaceService.findOne(ws.getId());
				if (w == null)
					throw new BusinessException();
				w.getArtifacts().add(ecoreMetamodel);
				workspaceRepository.save(w);
			}
			for (Project ps : ecoreMetamodel.getProjects()) {
				Project p = projectService.findById(ps.getId(), ecoreMetamodel.getAuthor());
				p.getArtifacts().add(ecoreMetamodel);
				projectRepository.save(p);
			}
			for (User us : ecoreMetamodel.getShared()) {
				User u = userService.findOne(us.getId());
				if (u == null)
					throw new BusinessException();
				u.getSharedArtifact().add(ecoreMetamodel);
				userRepository.save(u);
			}
			return ecoreMetamodel.getId();
		} catch (Exception e) {
			throw new BusinessException();
		}
	}

	@Override
	public ArtifactList findAllWithPublic(User user)
			throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("shared").in(user.getId());
		Criteria c2 = Criteria.where("open").is("true");
		query.addCriteria(c1.orOperator(c2));
		List<EcoreMetamodel> result = n.find(query, EcoreMetamodel.class);
		return new ArtifactList(result);
	}

	@Override
	public ArtifactList findAllPublic() throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria
				.where("open")
				.is(true)
				.orOperator(
						Criteria.where("_class").is(
								EcoreMetamodel.class.getCanonicalName()));
		query.addCriteria(c2);
		List<EcoreMetamodel> result = n.find(query, EcoreMetamodel.class);
		return new ArtifactList(result);
	}

	// Inizio Alexander
	@Override
	public void upload(EcoreMetamodel ecoreMetamodel, MultipartFile file) {
		ecoreMetamodelRepository.save(ecoreMetamodel);
	}

	@Override
	public ResponseGrid<EcoreMetamodel> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<EcoreMetamodel> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = ecoreMetamodelRepository.findByOpen(true, new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.ASC, requestGrid
							.getSortCol()));
		} else {
			rows = ecoreMetamodelRepository.findByOpen(true, new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.DESC,
					requestGrid.getSortCol()));
		}
		return new ResponseGrid<EcoreMetamodel>(requestGrid.getsEcho(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}

	@Override
	public void download(EcoreMetamodel ecoreMetamodel) {
	}

	// fine Alexander

	@Override
	public EcoreMetamodel findByOwner(String idEcoreMetamodel, User user)
			throws BusinessException {
		EcoreMetamodel mm = ecoreMetamodelRepository.findOne(idEcoreMetamodel);
		try {
			if (!mm.getAuthor().getId().equals(user.getId()))
				throw new BusinessException();
		} catch (Exception e) {
			throw new BusinessException();
		}
		return mm;
	}

	@Override
	public EcoreMetamodel findOneBySharedUser(String idEcoreMetamodel, User user)
			throws BusinessException {
		EcoreMetamodel mm = ecoreMetamodelRepository.findOne(idEcoreMetamodel);
		for (User us : mm.getShared()) {
			if (us.getId().equals(user.getId()))
			{
				mm.setFile(gridFileMediaService.getGridFileMedia(mm.getFile()));
				return mm;
			}
				
		}
		throw new BusinessException();
	}

	@Override
	public EcoreMetamodel findOne(String id) throws BusinessException {
		EcoreMetamodel emm = ecoreMetamodelRepository.findOne(id);
		emm.setFile(gridFileMediaService.getGridFileMedia(emm.getFile()));
		return emm;
	}

	@Override
	public void deleteEcoreMetamodel(String idEcoreMetamodel, User user) {
		artifactService.delete(idEcoreMetamodel, user);
	}
	@Override
	public ArtifactList findEcoreMetamodelInWorkspace(String idWorkspace, User user) throws BusinessException{
		workspaceService.findById(idWorkspace, user);
		ArtifactList aList = new ArtifactList( ecoreMetamodelRepository.findByWorkspaceId(new ObjectId(idWorkspace)));
		return aList;
	}
	

	@Override
	public ArtifactList findEcoreMetamodelInProject(String idProject, User user) throws BusinessException{
		projectService.findById(idProject, user);
		ArtifactList aList = new ArtifactList(ecoreMetamodelRepository.findByProjectId(new ObjectId(idProject)));
		return aList;
	}

	@Value("#{cfgproperties[basePath]}")
	private String basePath;
	@Override
	public List<Metric> calculateMetrics(Artifact emm) throws BusinessException{
		
		
		ILauncher transformationLauncher = new EMFVMLauncher();
		ModelFactory modelFactory = new EMFModelFactory();
		IInjector injector = new EMFInjector();
		IExtractor extractor = new EMFExtractor();
		/*
		 * Load metamodels
		 */
		try {
			
			IReferenceModel outputMetamodel = modelFactory.newReferenceModel();
			injector.inject(outputMetamodel, basePath + "Metric.ecore");
			IReferenceModel inputMetamodel = modelFactory.newReferenceModel();
			injector.inject(inputMetamodel, org.eclipse.emf.ecore.EcorePackage.eNS_URI);
			
			IModel inputModel = modelFactory.newModel(inputMetamodel);
			IModel outModel = modelFactory.newModel(outputMetamodel);

			String mm = new String (emm.getFile().getByteArray()); 
	    		
			File temp = File.createTempFile("tempfile", ".tmp"); 
			FileInputStream fis = new FileInputStream(temp);
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
    	    bw.write(mm);
    	    bw.close();
			injector.inject(inputModel, fis, null);
			transformationLauncher.initialize(new HashMap<String,Object>());
			transformationLauncher.addInModel(inputModel, "IN", "Ecore");
			transformationLauncher.addOutModel(outModel , "OUT" , "Metric") ;
			transformationLauncher.launch(ILauncher.RUN_MODE, null, new HashMap<String,Object>(), 
					(Object[])getModulesList(basePath + "EcoreMetric.asm"));

			extractor.extract(outModel, basePath + "sampleCompany_Cut.xmi");
			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
			emfModelFactory.unload((EMFReferenceModel) inputMetamodel);
			emfModelFactory.unload((EMFReferenceModel) outputMetamodel);
			
			List<Metric> result = getMetricList(basePath + "sampleCompany_Cut.xmi", emm);
			File temp2 = new File(basePath + "sampleCompany_Cut.xmi");
			temp2.delete();
			temp.delete();
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

	@Override
	public void registerMetamodel(EcoreMetamodel ecoreMetamodel) throws BusinessException {
		ecoreMetamodel = ecoreMetamodelRepository.findOne(ecoreMetamodel.getId());
		ecoreMetamodel.getFile();
		ecoreMetamodel.setFile(gridFileMediaService.getGridFileMedia(ecoreMetamodel.getFile()));
		String path = gridFileMediaService.getFilePath(ecoreMetamodel);
		File fileName = new File(path);
		URI uri = URI.createFileURI(fileName.getAbsolutePath());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		// enable extended metadata
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(
				rs.getPackageRegistry());
		rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA,
				extendedMetaData);
		Resource r = rs.getResource(uri, true);
		EObject eObject = r.getContents().get(0);
		if (eObject instanceof EPackage) {
			EPackage p = (EPackage) eObject;
			EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
		}
		
	}


}
