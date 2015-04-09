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
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.MetricProvider;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.AggregatedIntegerMetric;
import org.mdeforge.business.model.AggregatedRealMetric;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.emf.metric.Container;
import org.mdeforge.emf.metric.MetricFactory;
import org.mdeforge.emf.metric.MetricPackage;
import org.mdeforge.integration.ATLTransformationRepository;
import org.mdeforge.integration.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service (value="ATLTransformation")
public class ATLTransformationServiceImpl extends ArtifactServiceImpl implements ATLTransformationService, MetricProvider {

	@Autowired
	private ATLTransformationRepository ATLTransformationRepository;
	@Autowired
	private MetricRepository metricRepository;

	@Override
	public Artifact findOneByName(String name, User user) throws BusinessException {
		return findOneByName(name, user, ATLTransformation.class);
	}

	@Override
	public List<ATLTransformation> findAllTransformations()
			throws BusinessException {
		return ATLTransformationRepository.find();
	}



	@Override
	public List<Artifact> findAllWithPublicByUser(User user)
			throws BusinessException {
		return findAllWithPublicByUser(user, ATLTransformation.class);
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
	// fine Alexander

	@Override
	public Artifact findOneByOwner(String idMetamodel, User idUser)
			throws BusinessException {
		Artifact mm = findOneByOwner(idMetamodel, idUser, ATLTransformation.class);
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
	public List<Artifact> findArtifactInWorkspace(String idWorkspace, User user) throws BusinessException{
		workspaceService.findById(idWorkspace, user);
		return findArtifactInWorkspace(idWorkspace, user, ATLTransformation.class);
	}
	@Override
	public List<Artifact> findArtifactInProject(String idProject, User user) throws BusinessException{
		projectService.findById(idProject, user);
		return findArtifactInProject(idProject, user, ATLTransformation.class);
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
