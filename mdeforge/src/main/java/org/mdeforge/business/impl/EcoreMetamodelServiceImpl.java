package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.compare.Comparison;
import org.eclipse.emf.compare.EMFCompare;
import org.eclipse.emf.compare.Match;
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
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.AggregatedIntegerMetric;
import org.mdeforge.business.model.AggregatedRealMetric;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.ContainmentRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.SimilarityRelation;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
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

@Service
public class EcoreMetamodelServiceImpl extends CRUDArtifactServiceImpl<EcoreMetamodel> implements EcoreMetamodelService {
	@Autowired
	private EcoreMetamodelRepository ecoreMetamodelRepository;
	@Autowired
	private MetricRepository metricRepository;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Autowired
	private ContainmentRelationService containmentRelationService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	@Override
	public EcoreMetamodel create(EcoreMetamodel artifact) throws BusinessException {
		if(isValid(artifact))
			return super.create(artifact);
		throw new BusinessException();
	}
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
			String path = gridFileMediaService.getFilePath(emm);
			injector.inject(inputModel, new FileInputStream(new File(path)), null);
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
			metricRepository.save(result);
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
		int counterLeft = 0;
		int counterRight = 0;
		
		for (Match match : matches) {
			List<Match> lm = Lists.newArrayList(match.getAllSubmatches());
			if(match.getLeft()!=null)
				counterLeft++;
			if(match.getRight()!=null)
				counterRight++;
			total += lm.size();
			for (Match match2 : lm){
				if(match2.getLeft()!=null)
					counterLeft++;
				if(match2.getRight()!=null)
					counterRight++;
				if (match2.getLeft() != null && match2.getRight() != null)
					counter++;
			}
			if (match.getLeft() != null && match.getRight() != null)
				counter++;
		}

//		List<Diff> differences = comparison.getDifferences();
//		// Let's merge every single diff
//		// IMerger.Registry mergerRegistry = new IMerger.RegistryImpl();
//		IMerger.Registry mergerRegistry = IMerger.RegistryImpl
//				.createStandaloneInstance();
//		IBatchMerger merger = new BatchMerger(mergerRegistry);
//		merger.copyAllLeftToRight(differences, new BasicMonitor());
		double resultValue = (counter * 1.0) / ((counterLeft<counterRight)?counterLeft:counterRight);

		
		//Used to save Diff model
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());

		ResourceSet resSet = new ResourceSetImpl();
		// create a resource
		Resource resource = resSet.createResource(URI.createURI(basePath
				+ "/compare.xmi"));
		resource.getContents().add(comparison);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
		similarityRelationService.findByArtifacts(art1, art2);
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
//
//	@Override
//	public String getSimilarityGraph(double threshold, int computation) throws BusinessException {
//		try {
//			
//			String result = "nodes = [\n";
//			List<Cluster> clusterList = getClusters(threshold, computation);
//			HashMap	<String, Integer>  hm = new HashMap<String, Integer>();
//			AtomicInteger i = new AtomicInteger();
//			AtomicInteger j = new AtomicInteger();
//
//			for (Cluster cluster : clusterList) {
//				int groupId = j.incrementAndGet();
//				for (Artifact ecoreMetamodel : cluster.getArtifacts()) {
//					if(!hm.containsKey( ecoreMetamodel.getId())) {
//						int unique = i.incrementAndGet();
//						hm.put(ecoreMetamodel.getId(), unique);
//					}
//					result += "\t{id: "+ hm.get(ecoreMetamodel.getId()) 
//							+ ", label:'"+ ecoreMetamodel.getName() +"', group:" + groupId + "},\n";
//				}
//			}
//
//			result = result.substring(0,result.length()-2);
//			result += "];\n";
//			result += "edges = [\n";
//			List<SimilarityRelation> relations = similarityRelationService.findAll(threshold, computation);
//			int size = relations.size();
//			for (SimilarityRelation relation : relations) {
//				Double d = (relation.getValue()*10);
//				result += "{from:"+ hm.get(relation.getFromArtifact().getId())+", to: " + hm.get(relation.getToArtifact().getId()) + ", value: " + d.intValue() + ", label:" + relation.getValue() + "}";
//				if(--size != 0)
//					result +=",\n";
//				else result +="\n";
//			}
//			result += "];\n";
//			return result;
//		} catch (Exception e) {
//			throw new BusinessException();
//		}
//	}
	
	@Override
	public String getSimilarityGraph(double threshold) throws BusinessException {
		try {
			
			String result = "nodes = [\n";
			List<Cluster> clusterList = getSimilarityClusters(threshold);
			HashMap	<String, Integer>  hm = new HashMap<String, Integer>();
			AtomicInteger i = new AtomicInteger();
			AtomicInteger j = new AtomicInteger();

			for (Cluster cluster : clusterList) {
				int groupId = j.incrementAndGet();
				for (Artifact ecoreMetamodel : cluster.getArtifacts()) {
					if(!hm.containsKey( ecoreMetamodel.getId())) {
						int unique = i.incrementAndGet();
						hm.put(ecoreMetamodel.getId(), unique);
					}
					result += "\t{id: "+ hm.get(ecoreMetamodel.getId()) 
							+ ", label:'"+ ecoreMetamodel.getName() +"', group:" + groupId + "},\n";
				}
			}

			result = result.substring(0,result.length()-2);
			result += "];\n";
			result += "edges = [\n";
			List<SimilarityRelation> relations = similarityRelationService.findAll(threshold);
			System.out.println(relations.size());
			int size = relations.size();
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
	
	@Override
	public List<Cluster> getSimilarityClusters(double threshold) throws BusinessException {
		List<Cluster> clusterList = new ArrayList<Cluster>();
		List<SimilarityRelation> similarityRelations = similarityRelationService.findAll(threshold);
		Map<String,Cluster> tempHash = new HashMap<String,Cluster>();
		for (SimilarityRelation similarityRelation : similarityRelations) {
			String fromId = similarityRelation.getFromArtifact().getId();
			String toId = similarityRelation.getToArtifact().getId();
			if(!tempHash.containsKey(fromId) && 
					!tempHash.containsKey(toId)) {
				Cluster c = new Cluster();
				c.getRelations().add(similarityRelation);
				c.getArtifacts().add(similarityRelation.getFromArtifact());
				c.getArtifacts().add(similarityRelation.getToArtifact());
				List<Property> propertyList = similarityRelation.getFromArtifact().getProperties();
				propertyList.addAll(similarityRelation.getToArtifact().getProperties());
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				tempHash.put(fromId, c);
				tempHash.put(toId, c);
				clusterList.add(c);
			}
			if(tempHash.containsKey(fromId) && 
					!tempHash.containsKey(toId)) {
				Cluster c = tempHash.get(fromId);
				c.getArtifacts().add(similarityRelation.getToArtifact());
				c.getRelations().add(similarityRelation);
				tempHash.put(toId, c);
				tempHash.put(fromId, c);
				List<Property> propertyList = similarityRelation.getToArtifact().getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
			}
			if(!tempHash.containsKey(fromId) && 
					tempHash.containsKey(toId)) {
				Cluster c = tempHash.get(similarityRelation.getToArtifact().getId());
				c.getArtifacts().add(similarityRelation.getFromArtifact());
				c.getRelations().add(similarityRelation);
				tempHash.put(fromId, c);
				tempHash.put(toId, c);
				List<Property> propertyList = similarityRelation.getFromArtifact().getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
			}
			if(tempHash.containsKey(fromId) && 
					tempHash.containsKey(toId) &&
					tempHash.get(fromId) != tempHash.get(toId)) {
				Cluster fromCluster = tempHash.get(fromId);
				Cluster toCluster = tempHash.get(toId);
				clusterList.remove(toCluster);
				clusterList.remove(fromCluster);
				fromCluster.getRelations().addAll(toCluster.getRelations());
				fromCluster.getArtifacts().addAll(toCluster.getArtifacts());
				fromCluster.getDomains().addAll(toCluster.getDomains());
				for (Artifact art : fromCluster.getArtifacts()) {
					Cluster cc = tempHash.get(art.getId());
					clusterList.remove(cc);
					tempHash.put(art.getId(), fromCluster);
				}
				clusterList.add(fromCluster);
				tempHash.put(toId, fromCluster);
				tempHash.put(fromId, fromCluster);
			}
		}
		
		List<EcoreMetamodel> ecoreMetamodels = findAllPublic();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodels) {
			if(tempHash.get(ecoreMetamodel.getId())==null) {
				Cluster c = new Cluster();
				c.setMostRepresentive(ecoreMetamodel);
				c.getArtifacts().add(ecoreMetamodel);
				List<Property> propertyList = ecoreMetamodel.getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				clusterList.add(c);
			}
				
		}
		
		for (Cluster cluster : clusterList) {
			int kMax = 0;
			int kMin = Integer.MAX_VALUE;
			int countRelation = 0;
			Artifact mostRepresentive = null;
			for (Artifact elem : cluster.getArtifacts()) {
				List<Relation> srl = findInCluster(elem, cluster);//similarityRelationService.findByEcoreMetamodel((EcoreMetamodel)elem, threshold,1);
				if (srl.size()>kMax){
					kMax = srl.size();
					mostRepresentive = elem;
				}	
				if (srl.size()<kMin)
					kMin = srl.size();
				countRelation += srl.size();
			}
			if(cluster.getArtifacts().size()==1) {
				Iterator<Artifact> iterator = cluster.getArtifacts().iterator();
				mostRepresentive = iterator.next();
			} else 
				
			cluster.setkMax(kMax);
			cluster.setkMin(kMin);
			cluster.setkAvg(countRelation / (cluster.getArtifacts().size()*1.0));
			cluster.setMostRepresentive(mostRepresentive);
		}
		
		return clusterList;
	}
	private List<Relation> findInCluster(Artifact elem, Cluster cluster) {
		List<Relation> result = new ArrayList<Relation>();
		for (Relation rel : cluster.getRelations()) {
			if (rel.getToArtifact().getId().equals(elem.getId()) ||
					rel.getFromArtifact().getId().equals(elem.getId()))
					result.add(rel);
		}
		return result;
	}

	@Override
	public List<Cluster> getContainmentClusters(double threshold) throws BusinessException {
		List<Cluster> clusterList = new ArrayList<Cluster>();
		List<ContainmentRelation> similarityRelations = containmentRelationService.findAll(threshold);
		Map<String,Cluster> tempHash = new HashMap<String,Cluster>();
		for (ContainmentRelation similarityRelation : similarityRelations) {
			String fromId = similarityRelation.getFromArtifact().getId();
			String toId = similarityRelation.getToArtifact().getId();
			if(!tempHash.containsKey(fromId) && 
					!tempHash.containsKey(toId)) {
				Cluster c = new Cluster();
				c.getRelations().add(similarityRelation);
				c.getArtifacts().add(similarityRelation.getFromArtifact());
				c.getArtifacts().add(similarityRelation.getToArtifact());
				List<Property> propertyList = similarityRelation.getFromArtifact().getProperties();
				propertyList.addAll(similarityRelation.getToArtifact().getProperties());
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				tempHash.put(fromId, c);
				tempHash.put(toId, c);
				clusterList.add(c);
			}
			if(tempHash.containsKey(fromId) && 
					!tempHash.containsKey(toId)) {
				Cluster c = tempHash.get(fromId);
				c.getArtifacts().add(similarityRelation.getToArtifact());
				c.getRelations().add(similarityRelation);
				tempHash.put(toId, c);
				tempHash.put(fromId, c);
				List<Property> propertyList = similarityRelation.getToArtifact().getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
			}
			if(!tempHash.containsKey(fromId) && 
					tempHash.containsKey(toId)) {
				Cluster c = tempHash.get(similarityRelation.getToArtifact().getId());
				c.getArtifacts().add(similarityRelation.getFromArtifact());
				c.getRelations().add(similarityRelation);
				tempHash.put(fromId, c);
				tempHash.put(toId, c);
				List<Property> propertyList = similarityRelation.getFromArtifact().getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
			}
			if(tempHash.containsKey(fromId) && 
					tempHash.containsKey(toId) &&
					tempHash.get(fromId) != tempHash.get(toId)) {
				Cluster fromCluster = tempHash.get(fromId);
				Cluster toCluster = tempHash.get(toId);
				clusterList.remove(toCluster);
				clusterList.remove(fromCluster);
				fromCluster.getRelations().addAll(toCluster.getRelations());
				fromCluster.getArtifacts().addAll(toCluster.getArtifacts());
				fromCluster.getDomains().addAll(toCluster.getDomains());
				for (Artifact art : fromCluster.getArtifacts()) {
					Cluster cc = tempHash.get(art.getId());
					clusterList.remove(cc);
					tempHash.put(art.getId(), fromCluster);
				}
				clusterList.add(fromCluster);
				tempHash.put(toId, fromCluster);
				tempHash.put(fromId, fromCluster);
			}
		}
		
		List<EcoreMetamodel> ecoreMetamodels = findAllPublic();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodels) {
			if(tempHash.get(ecoreMetamodel.getId())==null) {
				Cluster c = new Cluster();
				c.getArtifacts().add(ecoreMetamodel);
				List<Property> propertyList = ecoreMetamodel.getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				clusterList.add(c);
			}
				
		}
		
		for (Cluster cluster : clusterList) {
			int kMax = 0;
			int kMin = Integer.MAX_VALUE;
			int countRelation = 0;
			Artifact mostRepresentive = null;
			for (Artifact elem : cluster.getArtifacts()) {
				
				List<Relation> srl = findInCluster(elem, cluster);//similarityRelationService.findByEcoreMetamodel((EcoreMetamodel)elem, threshold,1);
				if (srl.size()>kMax){
					kMax = srl.size();
					mostRepresentive = elem;
				}	
				if (srl.size()<kMin)
					kMin = srl.size();
				countRelation += srl.size();
			}
			cluster.setkMax(kMax);
			cluster.setkMin(kMin);
			cluster.setkAvg(countRelation / (cluster.getArtifacts().size()*1.0));
			cluster.setMostRepresentive(mostRepresentive);
		}
		
		return clusterList;
	}
	///*****NEW****/////////////////
	private List<HashMap<String, Cluster>> getHierarchicalCluster (double[] height) {
		List<HashMap<String, Cluster>> privateStructure = new ArrayList<HashMap<String, Cluster>>();
		List<EcoreMetamodel> ecoreMetamodels = findAllPublic();
		Cluster first = new Cluster();
		first.getDomains().add("Total");
		HashMap<String, Cluster> root = new HashMap<String, Cluster>();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodels) {
			root.put(ecoreMetamodel.getId(), first);
		}
		privateStructure.add(root);

		for(int i = 0; i < height.length; i++) {
			privateStructure.add(getMapSimilarityClusters(height[i]));
		}
		
		HashMap<String, Cluster> leaf = new HashMap<String, Cluster>();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodels) {
			Cluster c = new Cluster();
			c.getArtifacts().add(ecoreMetamodel);
			for (Property property : ecoreMetamodel.getProperties())
				if (property.getName().toLowerCase().contains("domain") || 
						property.getName().toLowerCase().contains("domains"))
					c.getDomains().add(property.getValue());
			leaf.put(ecoreMetamodel.getId(), c);
		}

		privateStructure.add(leaf);
		
		return privateStructure;
	}
	@Override
	public String getHierarchicalClusterGraph(double[] height) {
		List<HashMap<String, Cluster>> privateStructure = getHierarchicalCluster(height);
		HashMap<String, Cluster> previousClusterMap = null;
		String node = "var nodes = [\n";
		String edge = "var edges = [\n";
		HashMap<Cluster, String> idCluster = new HashMap<Cluster, String>();
		AtomicInteger i = new AtomicInteger();
		for (HashMap<String, Cluster> clusterMap : privateStructure) {
			List<Cluster> arrayCluster = new ArrayList<Cluster>();
			arrayCluster.addAll(getUniqueCluster(clusterMap));
			for (Cluster cluster : arrayCluster) {
				int l = i.incrementAndGet();
				node += "{id : " + l +" },\n";
				idCluster.put(cluster, l + "");
				if (previousClusterMap != null){
					Cluster previousCluster = previousClusterMap.get(cluster.getArtifacts().iterator().next().getId());
					edge += "{from: " + idCluster.get(previousCluster) + ", to: "+ l +"},\n";
				}
				
			}
			previousClusterMap = clusterMap;
		}
		node = node.substring(0,node.length()-2);
		edge = edge.substring(0,edge.length()-2);
		
		return node + "];\n" + edge + "];\n";
	}
	private Set<Cluster> getUniqueCluster(HashMap<String, Cluster> clustersMap) {
		Iterator<Map.Entry<String, Cluster>> it =  clustersMap.entrySet().iterator();
		Set<Cluster> set = new HashSet<>();
		while (it.hasNext()) {
			Map.Entry<String, Cluster> pair = it.next();
			set.add(pair.getValue());
		}
		return set;
	}
	
	private HashMap<String, Cluster> getMapSimilarityClusters(double threshold) throws BusinessException {
		List<Cluster> clusterList = new ArrayList<Cluster>();
		List<SimilarityRelation> similarityRelations = similarityRelationService.findAll(threshold);
		HashMap<String,Cluster> tempHash = new HashMap<String,Cluster>();
		for (SimilarityRelation similarityRelation : similarityRelations) {
			String fromId = similarityRelation.getFromArtifact().getId();
			String toId = similarityRelation.getToArtifact().getId();
			if(!tempHash.containsKey(fromId) && 
					!tempHash.containsKey(toId)) {
				Cluster c = new Cluster();
				c.getRelations().add(similarityRelation);
				c.getArtifacts().add(similarityRelation.getFromArtifact());
				c.getArtifacts().add(similarityRelation.getToArtifact());
				List<Property> propertyList = similarityRelation.getFromArtifact().getProperties();
				propertyList.addAll(similarityRelation.getToArtifact().getProperties());
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				tempHash.put(fromId, c);
				tempHash.put(toId, c);
				clusterList.add(c);
			}
			if(tempHash.containsKey(fromId) && 
					!tempHash.containsKey(toId)) {
				Cluster c = tempHash.get(fromId);
				c.getArtifacts().add(similarityRelation.getToArtifact());
				c.getRelations().add(similarityRelation);
				tempHash.put(toId, c);
				tempHash.put(fromId, c);
				List<Property> propertyList = similarityRelation.getToArtifact().getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
			}
			if(!tempHash.containsKey(fromId) && 
					tempHash.containsKey(toId)) {
				Cluster c = tempHash.get(similarityRelation.getToArtifact().getId());
				c.getArtifacts().add(similarityRelation.getFromArtifact());
				c.getRelations().add(similarityRelation);
				tempHash.put(fromId, c);
				tempHash.put(toId, c);
				List<Property> propertyList = similarityRelation.getFromArtifact().getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || 
							property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
			}
			if(tempHash.containsKey(fromId) && 
					tempHash.containsKey(toId) &&
					tempHash.get(fromId) != tempHash.get(toId)) {
				Cluster fromCluster = tempHash.get(fromId);
				Cluster toCluster = tempHash.get(toId);
				clusterList.remove(toCluster);
				clusterList.remove(fromCluster);
				fromCluster.getRelations().addAll(toCluster.getRelations());
				fromCluster.getArtifacts().addAll(toCluster.getArtifacts());
				fromCluster.getDomains().addAll(toCluster.getDomains());
				for (Artifact art : fromCluster.getArtifacts()) {
					Cluster cc = tempHash.get(art.getId());
					clusterList.remove(cc);
					tempHash.put(art.getId(), fromCluster);
				}
				clusterList.add(fromCluster);
				tempHash.put(toId, fromCluster);
				tempHash.put(fromId, fromCluster);
			}
		}
		
		List<EcoreMetamodel> ecoreMetamodels = findAllPublic();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodels) {
			if(tempHash.get(ecoreMetamodel.getId())==null) {
				Cluster c = new Cluster();
				c.setMostRepresentive(ecoreMetamodel);
				c.getArtifacts().add(ecoreMetamodel);
				List<Property> propertyList = ecoreMetamodel.getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				tempHash.put(ecoreMetamodel.getId(), c);
			}
				
		}
		
		
		return tempHash;
	}
	////END NEW//////
}