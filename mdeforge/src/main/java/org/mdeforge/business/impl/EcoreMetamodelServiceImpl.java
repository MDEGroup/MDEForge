package org.mdeforge.business.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.Diff;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
import org.eclipse.emf.compare.merge.BatchMerger;
import org.eclipse.emf.compare.merge.IBatchMerger;
import org.eclipse.emf.compare.merge.IMerger;
import org.eclipse.emf.compare.scope.DefaultComparisonScope;
import org.eclipse.emf.compare.scope.IComparisonScope;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.AggregatedIntegerMetric;
import org.mdeforge.business.model.AggregatedRealMetric;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.SimilarityRelation;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.emf.metric.Container;
import org.mdeforge.emf.metric.MetricFactory;
import org.mdeforge.emf.metric.MetricPackage;
import org.mdeforge.integration.EcoreMetamodelRepository;
import org.mdeforge.integration.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

@Service(value = "EcoreMetamodel")
public class EcoreMetamodelServiceImpl extends ArtifactServiceImpl<EcoreMetamodel> implements EcoreMetamodelService {
	@Autowired
	private EcoreMetamodelRepository ecoreMetamodelRepository;
	@Autowired
	private MetricRepository metricRepository;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	@Override
	public List<EcoreMetamodel> findEcoreMetamodelByURI(String URI) {
		return null;
	}

	@Override
	public ResponseGrid<EcoreMetamodel> findAllEcorePaginated(RequestGrid requestGrid) throws BusinessException {
		Page<EcoreMetamodel> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = ecoreMetamodelRepository.findByOpen(
					true,
					new PageRequest(requestGrid.getiDisplayStart() / requestGrid.getiDisplayLength(), requestGrid
							.getiDisplayLength(), Direction.ASC, requestGrid.getSortCol()));
		} else {
			rows = ecoreMetamodelRepository.findByOpen(
					true,
					new PageRequest(requestGrid.getiDisplayStart() / requestGrid.getiDisplayLength(), requestGrid
							.getiDisplayLength(), Direction.DESC, requestGrid.getSortCol()));
		}
		return new ResponseGrid<EcoreMetamodel>(requestGrid.getsEcho(), rows.getNumberOfElements(),
				rows.getTotalElements(), rows.getContent());
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
			injector.inject(outputMetamodel, basePath + "Metric.ecore");
			IReferenceModel inputMetamodel = modelFactory.newReferenceModel();
			injector.inject(inputMetamodel, org.eclipse.emf.ecore.EcorePackage.eNS_URI);
			IModel inputModel = modelFactory.newModel(inputMetamodel);
			IModel outModel = modelFactory.newModel(outputMetamodel);
			String mm = new String(emm.getFile().getByteArray());
			File temp = File.createTempFile("tempfile", ".tmp");
			FileInputStream fis = new FileInputStream(temp);
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			bw.write(mm);
			bw.close();
			injector.inject(inputModel, fis, null);
			transformationLauncher.initialize(new HashMap<String, Object>());
			transformationLauncher.addInModel(inputModel, "IN", "Ecore");
			transformationLauncher.addOutModel(outModel, "OUT", "Metric");
			transformationLauncher.launch(ILauncher.RUN_MODE, null, new HashMap<String, Object>(),
					(Object[]) getModulesList(basePath + "EcoreMetric.asm"));
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
			String asmModulePath = new Path(moduleNames[i].trim()).removeFileExtension().addFileExtension("asm")
					.toString();
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
		Iterator<org.mdeforge.emf.metric.Metric> it = myForge.getMetrics().iterator();
		while (it.hasNext()) {
			org.mdeforge.emf.metric.Metric at2 = (org.mdeforge.emf.metric.Metric) it.next();
			Metric metric = null;
			if (at2 instanceof org.mdeforge.emf.metric.impl.SimpleMetricImpl) {
				SimpleMetric metric2 = new SimpleMetric();
				metric2.setName(at2.getName());
				metric2.setDescription(at2.getDescription());
				metric2.setValue(((org.mdeforge.emf.metric.impl.SimpleMetricImpl) at2).getValue());
				metric = metric2;
			}
			if (at2 instanceof org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) {
				AggregatedIntegerMetric metric2 = new AggregatedIntegerMetric();
				metric2.setAverage(((org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) at2).getAverage());
				metric2.setMaximum(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2).getMaximum());
				metric2.setMedian(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2).getMedian());
				metric2.setMinimum(((org.mdeforge.emf.metric.impl.AggregatedIntegerMetricImpl) at2).getMinimum());
				metric2.setName(at2.getName());
				metric2.setDescription(at2.getDescription());
				metric = metric2;
			}
			if (at2 instanceof org.mdeforge.emf.metric.impl.AggregatedRealMetricImpl) {
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
	}

	@Override
	public void registerMetamodel(EcoreMetamodel ecoreMetamodel) throws BusinessException {
		ecoreMetamodel = ecoreMetamodelRepository.findOne(ecoreMetamodel.getId());
		ecoreMetamodel.getFile();
		ecoreMetamodel.setFile(gridFileMediaService.getGridFileMedia(ecoreMetamodel.getFile()));
		String path = gridFileMediaService.getFilePath(ecoreMetamodel);
		File fileName = new File(path);
		URI uri = URI.createFileURI(fileName.getAbsolutePath());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
		ResourceSet rs = new ResourceSetImpl();
		// enable extended metadata
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(rs.getPackageRegistry());
		rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA, extendedMetaData);
		Resource r = rs.getResource(uri, true);
		List<EObject> eObject = r.getContents();
		for (EObject eObject2 : eObject) {
			if (eObject2 instanceof EPackage) {
				EPackage p = (EPackage) eObject2;
				registerSubPackage(p);
			}
		}
	}

	private void registerSubPackage(EPackage p) {
		EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
		for (EPackage pack : p.getESubpackages()) {
			registerSubPackage(pack);
		}
	}

	@Override
	public boolean isValid(Artifact art) {
		if (art instanceof EcoreMetamodel) {
			try {
				@SuppressWarnings("unused")
				EcoreFactory factory = EcoreFactory.eINSTANCE;
				ResourceSet resourceSet = new ResourceSetImpl();
				resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
						.put("ecore", new EcoreResourceFactoryImpl());
				File temp = new File(gridFileMediaService.getFilePath(art));
				Resource resource = resourceSet.createResource(URI.createFileURI(temp.getAbsolutePath()));
				resource.load(null);
				EcoreUtil.resolveAll(resourceSet);
				EObject eo = resource.getContents().get(0);
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eo);
				if (diagnostic.getSeverity() == Diagnostic.ERROR)
					return false;
				else
					return true;
			} catch (Exception e) {
				return false;
			}
		} else
			return false;
	}

	@Override
	public double calculateSimilarity(Artifact art1, Artifact art2) {
		try {
		URI uri1 = URI.createFileURI(gridFileMediaService.getFilePath(art1));
		URI uri2 = URI.createFileURI(gridFileMediaService.getFilePath(art2));

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());

		ResourceSet resourceSet1 = new ResourceSetImpl();
		ResourceSet resourceSet2 = new ResourceSetImpl();

		resourceSet1.getResource(uri1, true);
		resourceSet2.getResource(uri2, true);

		IComparisonScope scope = new DefaultComparisonScope(resourceSet1,
				resourceSet2, null);
		Comparison comparison = EMFCompare.builder().build().compare(scope);

		List<Match> matches = comparison.getMatches();
		int total = matches.size();
		int counter = 0;
		for (Match match : matches) {
			List<Match> lm = Lists.newArrayList(match.getAllSubmatches());
			total += lm.size();
			for (Match match2 : lm)
				if (match2.getLeft() != null && match2.getRight() != null)
					counter++;
			if (match.getLeft() != null && match.getRight() != null)
				counter++;
		}

		List<Diff> differences = comparison.getDifferences();
		// Let's merge every single diff
		// IMerger.Registry mergerRegistry = new IMerger.RegistryImpl();
		IMerger.Registry mergerRegistry = IMerger.RegistryImpl
				.createStandaloneInstance();
		IBatchMerger merger = new BatchMerger(mergerRegistry);
		merger.copyAllLeftToRight(differences, new BasicMonitor());
		double resultValue = (counter * 1.0) / total;

		
		//Used to save Diff model
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		// create a resource
		Resource resource = resSet.createResource(URI.createURI(basePath
				+ "/compare.xmi"));
		resource.getContents().add(comparison);
//		try {
//			resource.save(Collections.EMPTY_MAP);
//		} catch (IOException e) {
//			e.printStackTrace();
//			throw new BusinessException();
//		}
		SimilarityRelation sr = new SimilarityRelation();
		sr.setFromArtifact(art1);
		sr.setToArtifact(art2);
		sr.setValue(resultValue);
		relationRepository.save(sr);
		return resultValue;
		}catch(Exception e) {
			System.out.println("ERROR from" + art1.getName() + "_" + art1.getId() + " to " + art2.getName() + "_" + art2.getId());
			return 0;
		}
	}

	@Override
	public String getSimilarityGraph(double treshold) throws BusinessException {
		try {
			
			String result = "nodes = [\n";
			List<EcoreMetamodel> ecoreMetamodels = findAllPublic(EcoreMetamodel.class);
			int size = ecoreMetamodels.size();
			HashMap	<String, Integer>  hm = new HashMap<String, Integer>();
			AtomicInteger i = new AtomicInteger();
			for (EcoreMetamodel ecoreMetamodel : ecoreMetamodels) {
				if(!hm.containsKey( ecoreMetamodel.getId())) {
					int unique = i.incrementAndGet();
					hm.put(ecoreMetamodel.getId(), unique);
				}
				result += "\t{id: "+ hm.get(ecoreMetamodel.getId()) +", label:'"+ ecoreMetamodel.getName() +"'}";
				if(--size != 0)
					result +=",\n";
				else result +="\n";
				
			}
			result += "]\n";
			result += "edges = [\n";
			List<SimilarityRelation> relations = similarityRelationService.findAll(treshold);
			System.out.println(relations.size());
			size = relations.size();
			for (SimilarityRelation relation : relations) {
				Double d = (relation.getValue()*10);
				result += "{from:"+ hm.get(relation.getFromArtifact().getId())+", to: " + hm.get(relation.getToArtifact().getId()) + ", value: " + d.intValue() + ", label:" + relation.getValue() + "}";
				if(--size != 0)
					result +=",\n";
				else result +="\n";
			}
			result += "];\n";
			return result;
		} catch (Exception e) {
			throw new BusinessException();
		}
	}
}
