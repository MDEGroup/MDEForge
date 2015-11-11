package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.bson.types.ObjectId;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.common.ATLExecutionException;
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
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.eclipse.m2m.atl.engine.emfvm.launch.EMFVMLauncher;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.DuplicateNameException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.TransformationException;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.AggregatedIntegerMetric;
import org.mdeforge.business.model.AggregatedRealMetric;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.business.model.User;
import org.mdeforge.emf.metric.Container;
import org.mdeforge.emf.metric.MetricFactory;
import org.mdeforge.emf.metric.MetricPackage;
import org.mdeforge.integration.ATLTransformationRepository;
import org.mdeforge.integration.MetricRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ATLTransformationServiceImpl extends
		CRUDArtifactServiceImpl<ATLTransformation> implements
		ATLTransformationService {
	@Autowired
	private ATLTransformationRepository ATLTransformationRepository;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private MetricRepository metricRepository;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	Logger logger = LoggerFactory.getLogger(ATLTransformationServiceImpl.class);
	
	@Override
	public ATLTransformation findOnePublic(String id) {
		ATLTransformation a = super.findOnePublic(id);
		try {
			a.setMetrics(getMetrics(a));
		} catch (BusinessException e) {
			logger.error(e.getMessage());
		}
		return a;
	}
	
	@Override
	public ATLTransformation findOneById(String idArtifact, User user) throws BusinessException {
		ATLTransformation a = super.findOneById(idArtifact, user);
		a.setMetrics(getMetrics(a));
		return a;
	}
	
	@Override
	public ATLTransformation create(ATLTransformation artifact) {
		if(findOneByName(artifact.getName())!=null) {
			logger.error("DuplicateName");
			throw new DuplicateNameException();
		}
		ATLTransformation result = super.create(artifact);
		try {
			artifact.setMetrics(getMetrics(artifact));
		} catch (Exception e) {
			logger.error("Some errors when try to calculate metric for metamodel");
			throw new BusinessException();
		}
		artifactRepository.save(artifact);
		return result;
	}
	
	@Override
	public ResponseGrid<ATLTransformation> findAllPaginated(
			RequestGrid requestGrid) throws BusinessException {
		Page<ATLTransformation> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = ATLTransformationRepository.findAll(new PageRequest(
					requestGrid.getiDisplayStart()
							/ requestGrid.getiDisplayLength(), requestGrid
							.getiDisplayLength(), Direction.ASC, requestGrid
							.getSortCol()));
		} else {
			rows = ATLTransformationRepository.findAll(new PageRequest(
					requestGrid.getiDisplayStart()
							/ requestGrid.getiDisplayLength(), requestGrid
							.getiDisplayLength(), Direction.DESC, requestGrid
							.getSortCol()));
		}
		return new ResponseGrid<ATLTransformation>(requestGrid.getsEcho(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}

	@Override
	public List<Model> execute(ATLTransformation transformation, List<Model> models, User user) {
		user = userService.findOne(user.getId());
		List<CoDomainConformToRelation> listOutput = new ArrayList<CoDomainConformToRelation>();
		List<DomainConformToRelation> listInput = new ArrayList<DomainConformToRelation>();
		for (Relation relation : transformation.getRelations()) {
			if (relation instanceof CoDomainConformToRelation)
				listOutput.add((CoDomainConformToRelation) relation);
			if (relation instanceof DomainConformToRelation)
				listInput.add((DomainConformToRelation) relation);
		}
		if (models.size() != listInput.size())
			throw new TransformationException();
		boolean guard = true;
		for (Model model : models)
			for (Relation relation : model.getRelations())
				if (relation instanceof ConformToRelation) {
					guard = isPresent(relation.getToArtifact(), listInput);
					if(model.getId()!=null)	{
						model = modelService.findOne(model.getId());
					}
					else if(guard) {
						model.setAuthor(user);
						model.getShared().add(user);
						modelService.create(model);
					}
				}
		if (!guard)
			throw new TransformationException();
		try {
			return doTransformation(transformation, listInput, listOutput, models, user);
		} catch (ATLExecutionException | ATLCoreException | IOException e) {
			throw new TransformationException();
		}
	}

	private boolean isPresent(Artifact art,
			List<DomainConformToRelation> listArtifact) {
		for (DomainConformToRelation rel : listArtifact)
			if (rel.getToArtifact().getId().equals(art.getId()))
				return true;
		return false;

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
	public List<Metric> calculateMetrics(Artifact AtlTransformation)
			throws BusinessException {
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
			String transfPath = inject((ATLTransformation) AtlTransformation);
			FileInputStream fis = new FileInputStream(transfPath);

			injector.inject(inputModel, fis, null);
			
			
			transformationLauncher.initialize(new HashMap<String, Object>());
			transformationLauncher.addInModel(inputModel, "IN", "ATL");
			transformationLauncher.addOutModel(outModel, "OUT", "Metric");
			transformationLauncher.launch(ILauncher.RUN_MODE, null,
					new HashMap<String, Object>(),
					(Object[]) getModulesList(basePath + "ATLMetric.asm"));

			extractor.extract(outModel, "sampleCompany_Cut.xmi");
			EMFModelFactory emfModelFactory = (EMFModelFactory) modelFactory;
			emfModelFactory.unload((EMFReferenceModel) inputMetamodel);
			emfModelFactory.unload((EMFReferenceModel) outputMetamodel);

			List<Metric> result = getMetricList("sampleCompany_Cut.xmi",
					AtlTransformation);
			File temp2 = new File("sampleCompany_Cut.xmi");
			metricRepository.save(result);
			temp2.delete();
			return result;
		} catch (ATLCoreException e) {
			throw new BusinessException(e.getMessage());
		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
	}

	private InputStream[] getModulesList(String modules_input)
			throws IOException {
		InputStream[] modules = null;
		String[] moduleNames = modules_input.split(",");
		modules = new InputStream[moduleNames.length];
		for (int i = 0; i < moduleNames.length; i++) {
			//AtlCompiler.compile(new FileInputStream(new File(modules_input)), "TEMO.asm");
			String asmModulePath = new Path(moduleNames[i].trim())
					.removeFileExtension().addFileExtension("asm").toString();
			Atl2006Compiler compiler = new Atl2006Compiler();
			compiler.compile(new FileInputStream(new File(modules_input)), asmModulePath);

			
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

		Resource resource = resSet.createResource(URI.createURI(path));
		try {
			resource.load(null);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Container myForge = (Container) resource.getContents().get(0);
		List<Metric> result = new ArrayList<Metric>();
		@SuppressWarnings("rawtypes")
		Iterator it = myForge.getMetrics().iterator();
		while (it.hasNext()) {
			org.mdeforge.emf.metric.Metric at2 = (org.mdeforge.emf.metric.Metric) it
					.next();
			Metric metric = null;
			if (at2 instanceof org.mdeforge.emf.metric.impl.SimpleMetricImpl) {
				SimpleMetric metric2 = new SimpleMetric();
				metric2.setName(at2.getName());
				metric2.setDescription(at2.getDescription());
				metric2.setValue(((org.mdeforge.emf.metric.impl.SimpleMetricImpl) at2)
						.getValue());
				metric = metric2;
			}
			if (at2 instanceof org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) {
				AggregatedIntegerMetric metric2 = new AggregatedIntegerMetric();
				metric2.setAverage(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2)
						.getAverage());
				metric2.setMaximum(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2)
						.getMaximum());
				metric2.setMedian(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2)
						.getMedian());
				metric2.setMinimum(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2)
						.getMinimum());
				metric2.setName(at2.getName());
				metric2.setDescription(at2.getDescription());
				metric = metric2;
			}
			if (at2 instanceof org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) {
				AggregatedRealMetric metric2 = new AggregatedRealMetric();
				metric2.setAverage(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2)
						.getAverage());
				metric2.setMaximum(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2)
						.getMaximum());
				metric2.setMedian(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2)
						.getMedian());
				metric2.setMinimum(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2)
						.getMinimum());
				metric2.setName(at2.getName());
				metric2.setDescription(at2.getDescription());
				metric = metric2;
			}
			metric.setArtifact(art);
			// metricRepository.save(metric);
			result.add(metric);
		}

		return result;
	}

	@Override
	public List<Metric> getMetrics(Artifact emm) throws BusinessException {
		try{
			List<Metric> metricList = metricRepository
			
					.findByArtifactId(new ObjectId(emm.getId()));
			if (metricList.size() == 0)
				metricList = calculateMetrics(emm);
			return metricList;
		} catch (NullPointerException e) {
			throw new BusinessException("No artifact found");
		}
	}

	@Override
	public String inject(ATLTransformation atlTransformation)
			throws BusinessException {
		String outputFilePath = basePath + atlTransformation.getName() + ".xmi";
		AtlResourceImpl ri = new AtlResourceImpl();
		ResourceSet rs = new ResourceSetImpl();
		rs.getResources().add(ri);
		try {
			ri.load(gridFileMediaService.getFileInputStream(atlTransformation),
					null);
			Resource xmiRes = rs.createResource(URI.createURI(outputFilePath));
			xmiRes.getContents().addAll(ri.getContents());
			xmiRes.save(null);
			return outputFilePath;

		} catch (FileNotFoundException e) {
			throw new BusinessException();
		} catch (IOException e) {
			throw new BusinessException();
		}
	}


	private List<Model> doTransformation(ATLTransformation transformation,
			List<DomainConformToRelation> inputRelation,
			List<CoDomainConformToRelation> outputRelation, List<Model> models, User user)
			throws ATLCoreException, IOException, ATLExecutionException {
		user = userService.findOne(user.getId());
		IInjector injector = new EMFInjector();
		ModelFactory modelFactory = new EMFModelFactory();
		ILauncher transformationLauncher = new EMFVMLauncher();
		List<InputStream> inputStreamsToClose = new ArrayList<InputStream>();
		Map<String, Object> launcherOptions = getOptions();
		transformationLauncher.initialize(launcherOptions);
		for (DomainConformToRelation inRel : inputRelation) {
			IReferenceModel inputMetamodel = modelFactory.newReferenceModel();
			injector.inject(inputMetamodel, gridFileMediaService
					.getFileInputStream(inRel.getToArtifact()), null);
			IModel inputModel = modelFactory.newModel(inputMetamodel);
			injector.inject(
					inputModel,
					gridFileMediaService.getFileInputStream(
							getModelByMetamodel(inRel.getToArtifact(), models)),null
							);
			transformationLauncher.addInModel(inputModel, inRel.getName(),
					inRel.getReferenceModelName());
		}
		Map<IModel, CoDomainConformToRelation> outputList = new HashMap<IModel, CoDomainConformToRelation>();
		for (CoDomainConformToRelation outRel : outputRelation) {
			IReferenceModel outputMetamodel = modelFactory.newReferenceModel();
			injector.inject(outputMetamodel, gridFileMediaService
					.getFileInputStream(outRel.getToArtifact()), null);
			IModel outputModel = modelFactory.newModel(outputMetamodel);
			outputList.put(outputModel,outRel);
			transformationLauncher.addOutModel(outputModel, outRel.getName(),
					outRel.getReferenceModelName());
		}

		InputStream[] modulesStreams = getModulesList(gridFileMediaService
				.getFilePath(transformation));
		inputStreamsToClose.addAll(Arrays.asList(modulesStreams));
		@SuppressWarnings("unused")
		Object result = transformationLauncher.launch("run",
				new NullProgressMonitor(), launcherOptions,
				(Object[]) modulesStreams);
		for (InputStream inputStream : inputStreamsToClose) {
			inputStream.close();
		}

		IExtractor extractor = new EMFExtractor();
		List<Model> modelsResult = new ArrayList<Model>();
		Iterator<Entry<IModel, CoDomainConformToRelation>> i = outputList.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry<IModel, CoDomainConformToRelation> item = i.next();
			
			Date  ss1 = new Date();
			SimpleDateFormat formatter5 = new SimpleDateFormat("yyyyMMddHHmmss");
			String formats1 = formatter5.format(ss1);
			
			String tempModelPath = basePath + "generatedBy_" + transformation.getName() + "_" + formats1 + ".xmi";
			String fileName = "generatedBy_" + transformation.getName().replace(" ", "").replace("/.", "") + "_" + formats1 + ".xmi";
			extractor.extract(item.getKey(), tempModelPath);
			
			Model model = new Model();
			model.setName(fileName);
			model.setAuthor(user);
			ConformToRelation cfr = new ConformToRelation();
			cfr.setFromArtifact(model);
			cfr.setToArtifact(item.getValue().getToArtifact());
			
			model.setCreated(new Date());
			model.getRelations().add(cfr);
			
			GridFileMedia gfr = gridFileMediaService.createObjectFromFile(tempModelPath, fileName);
			
			model.setFile(gfr);
			modelService.create(model);
			
			modelsResult.add(model);
			
		}
		return modelsResult;
		//TODO Salvere modelli prodotti!
	}

	private Artifact getModelByMetamodel(Artifact toArtifact, List<Model> models) {
		for (Model model : models) {
			for (Relation rel : model.getRelations()) {
				if (rel instanceof ConformToRelation) {
					if (rel.getToArtifact().getId().equals(toArtifact.getId()))
						return model;
				}
			}
		}
		throw new TransformationException();
	}

	/**
	 * Semplice funzione di get che ritorna le opzioni settate dal costruttore
	 * all'atto di definizione della classe
	 * 
	 * @return Map<String, Object> options
	 */
	private Map<String, Object> getOptions() {

		Map<String, Object> options;
		options = new HashMap<String, Object>();
		options.put("supportUML2Stereotypes", "false");
		options.put("printExecutionTime", "true");
		options.put("OPTION_CONTENT_TYPE", "false");
		options.put("allowInterModelReferences", "false");
		options.put("step", "false");
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new EcoreResourceFactoryImpl());

		return options;
	}

	/**
	 * La funzione ritorna i moduli che sono presenti nel file della
	 * trasformazione. Ogni file di trasformazione (.atl) può contenere più
	 * moduli al suo interno (ognuno dei ha al suo interno il mapping che
	 * effettua la trasformazione). Ognuno di questi moduli al suo interno avrà
	 * una variabile di IN ed una di OUT per es. Ognuno di questi moduli viene
	 * poi salvato separatamente in un file .asm.
	 * 
	 * @return InputStream[]
	 * @throws IOException
	 */
	// private InputStream getModulesList(String transformationPath) throws
	// IOException {
	// InputStream modules = null;
	//
	// String asmModulePath = new
	// Path(transformationPath.trim()).removeFileExtension().addFileExtension("asm").toString();
	// modules = new FileInputStream(asmModulePath);
	//
	// return modules;
	// }

}
