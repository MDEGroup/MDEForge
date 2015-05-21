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
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.AggregatedIntegerMetric;
import org.mdeforge.business.model.AggregatedRealMetric;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.SimpleMetric;
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

@Service
public class ATLTransformationServiceImpl extends CRUDArtifactServiceImpl<ATLTransformation> implements ATLTransformationService {
	@Autowired
	private ATLTransformationRepository ATLTransformationRepository;
	@Autowired
	private MetricRepository metricRepository;
	@Autowired
	private GridFileMediaService gridFileMediaService;

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
	public List<Metric> calculateMetrics(Artifact AtlTransformation) throws BusinessException {
//		ILauncher transformationLauncher = new EMFVMLauncher();
//		ModelFactory modelFactory = new EMFModelFactory();
//		IInjector injector = new EMFInjector();
//		IExtractor extractor = new EMFExtractor();
//		/*
//		 * Load metamodels
//		 */
//		try {
//			IReferenceModel outputMetamodel = modelFactory.newReferenceModel();
//			injector.inject(outputMetamodel, basePath + "/Metric.ecore");
//			IReferenceModel inputMetamodel = modelFactory.newReferenceModel();
//			injector.inject(inputMetamodel, 
//					org.eclipse.emf.ecore.EcorePackage.eNS_URI);
//			IModel inputModel = modelFactory.newModel(inputMetamodel);
//			IModel outModel = modelFactory.newModel(outputMetamodel);
//			String path = inject((ATLTransformation)AtlTransformation);
//	    	injector.inject(inputModel, new FileInputStream(new File(path)), 
//	    			null);
//			transformationLauncher.initialize(new HashMap<String,Object>());
//			transformationLauncher.addInModel(inputModel, "IN", "ATL");
//			transformationLauncher.addOutModel(outModel , "OUT" , "Metric") ;
//			transformationLauncher.launch(ILauncher.RUN_MODE, null, 
//					new HashMap<String,Object>(), 
//					(Object[])getModulesList(basePath + "ATLMetric.asm"));
//			extractor.extract(outModel, "sampleCompany_Cut.xmi");
//			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
//			emfModelFactory.unload((EMFReferenceModel) inputMetamodel);
//			emfModelFactory.unload((EMFReferenceModel) outputMetamodel);
//			List<Metric> result = getMetricList(basePath
//					+ "sampleCompany_Cut.xmi", AtlTransformation);
//			File temp2 = new File("sampleCompany_Cut.xmi");
//			temp2.delete();
//			metricRepository.save(result);
//			return result;
//		} catch (ATLCoreException e) {
//			throw new BusinessException();
//		} catch (IOException e) {
//			throw new BusinessException();
//		}
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
			
			injector.inject(inputMetamodel, basePath + "ATL.ecore");
			
			
			IModel inputModel = modelFactory.newModel(inputMetamodel);
			IModel outModel = modelFactory.newModel(outputMetamodel);
			String transfPath = inject((ATLTransformation)AtlTransformation);
			FileInputStream fis = new FileInputStream(transfPath);
			
			injector.inject(inputModel, fis, null);
			transformationLauncher.initialize(new HashMap<String,Object>());
			transformationLauncher.addInModel(inputModel, "IN", "ATL");
			transformationLauncher.addOutModel(outModel , "OUT" , "Metric") ;
			transformationLauncher.launch(ILauncher.RUN_MODE, null, new HashMap<String,Object>(), 
					(Object[])getModulesList(basePath + "ATLMetric.asm"));

			extractor.extract(outModel, "sampleCompany_Cut.xmi");
			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
			emfModelFactory.unload((EMFReferenceModel) inputMetamodel);
			emfModelFactory.unload((EMFReferenceModel) outputMetamodel);
			
			List<Metric> result = getMetricList("sampleCompany_Cut.xmi", AtlTransformation);
			File temp2 = new File("sampleCompany_Cut.xmi");
			metricRepository.save(result);
			fis.close();
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
		@SuppressWarnings("unused")
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
	    @SuppressWarnings("rawtypes")
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
	    		metric2.setAverage(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2).getAverage());
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
	    	//metricRepository.save(metric);
	    	result.add(metric);
    	}
		
	    return result;
	}
	
	

	@Override
	public List<Metric> getMetrics(Artifact emm) throws BusinessException {
		List<Metric> metricList = metricRepository
				.findByArtifactId(new ObjectId(emm.getId()));
		if (metricList.size() == 0)
			metricList = calculateMetrics(emm);
		return metricList;
	}

	@Override
	public String inject(ATLTransformation atlTransformation)
			throws BusinessException {
		System.out.println("Start Injection");
		String outputFilePath = basePath + atlTransformation.getName() + ".xmi";
		AtlResourceImpl ri = new AtlResourceImpl();
		ResourceSet rs = new ResourceSetImpl();
		rs.getResources().add(ri);
		try
		{
			ri.load(gridFileMediaService.getFileInputStream(atlTransformation), null);
			Resource xmiRes = rs.createResource(URI.createURI(outputFilePath));
			xmiRes.getContents().addAll(ri.getContents());
			xmiRes.save(null);
			return outputFilePath;
	
		} catch(FileNotFoundException e) {
			throw new BusinessException();
		} catch (IOException e) {
			throw new BusinessException();
		}
	}
	private AtlResourceImpl getATLModelObject(ATLTransformation ATLFile){
		
		AtlResourceImpl ri = new AtlResourceImpl();
		ResourceSet rs = new ResourceSetImpl();
		rs.getResources().add(ri);
		try
		{
			ri.load(gridFileMediaService.getFileInputStream(ATLFile), null);
			Resource xmiRes = rs.createResource(URI.createURI("jjjj.xmi"));
			xmiRes.getContents().addAll(ri.getContents());
			return ri;
		}catch(FileNotFoundException e)	{
			throw new BusinessException();
		} catch (IOException e) {
			throw new BusinessException();
		}
	}
}


