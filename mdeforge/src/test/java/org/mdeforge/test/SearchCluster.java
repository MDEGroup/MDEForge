package org.mdeforge.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.Clusterizzation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.ClusterizzationRepository;
import org.mdeforge.integration.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class SearchCluster {
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Autowired
	private ContainmentRelationService containmentRelationService;
	@Autowired
	private ClusterizzationRepository clusterizzationRepository;
	@Autowired
	private CosineSimilarityRelationService cosineSimilarityRelationService;
	@Autowired
	private MetricRepository metricRepository;
	
	private static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(Base64.encode(encoded));

	}
	
	private final double threshold = 0.7;
	@Ignore
	@Test
	public void testClusterSearch() throws IOException, InterruptedException {
		//TEST METAMODEL
		EcoreMetamodel serachSample = new EcoreMetamodel();
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName("Conference2_0.ecore");
		gfm.setContent(readFile("temp/Conference2_0.ecore"));
		serachSample.setFile(gfm);
		Clusterizzation clusters = new Clusterizzation();		
		clusters = clusterizzationRepository.findOne("564df04477c8fb25bb009054");	
		System.out.println("######### SEARCH COMPUTATION  CLUSTER  ###########");
		Date startSearch = new Date();
		List <Cluster> list = new ArrayList<Cluster>();
		List<Artifact> result = new ArrayList<Artifact>();
		int count = 0;
		for (Cluster cluster : clusters.getClusters()) {
			count++;
			double d = ecoreMetamodelService.calculateContainment((EcoreMetamodel)cluster.getMostRepresentive(), serachSample);
			if (d>=threshold)
				list.add(cluster);
			if (d>=threshold)
				result.add(cluster.getMostRepresentive());
		}
		for (Cluster cluster : list) {
			if(cluster.getArtifacts().size()!=1)
				for (Artifact artifact : cluster.getArtifacts()) {
					if(!artifact.getId().equals(cluster.getMostRepresentive().getId()))  {
						count ++;
						Double d =ecoreMetamodelService.calculateContainment((EcoreMetamodel)artifact, serachSample);
						if(d>=threshold){
							result.add(artifact);
						} 
					}
			}
		}
		for (Artifact ecoreMetamodel : result) {
			System.out.print(ecoreMetamodel.getName() + ", ");
		}
		System.out.println();
		System.out.println("Operation: " + count );
		System.out.println("ResultSize: " + result.size());
		Date finishSearch = new Date();
		System.out.println("######### SEARCH COMPUTATION: TOTAL TIME ###########" + (finishSearch.getTime() - startSearch.getTime()));
	}
	@Ignore
	@Test
	public void testWithoutCluster() throws IOException, InterruptedException {
		EcoreMetamodel serachSample = new EcoreMetamodel();
		serachSample.setName("Conference2_0.ecore");
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName("ECORE.ecore");
		gfm.setContent(readFile("temp/Conference2_0.ecore"));
		serachSample.setFile(gfm);
		System.out.println("######### NO CLUSTER COMPUTATION ###########");
		Date start = new Date();
		List<EcoreMetamodel> list = ecoreMetamodelService.searchByExample(serachSample, threshold);
		for (EcoreMetamodel ecoreMetamodel : list) {
			System.out.print(ecoreMetamodel.getName() + ", ");
		}
		System.out.println();
		System.out.println("ResultSize: " + list.size());
		Date finish = new Date();
		System.out.println("######### SEARCH COMPUTATION: TOTAL TIME ###########" + (finish.getTime() - start.getTime()));
	}
	
	@Ignore
	@Test
	public void testCluster() {
		User user = new User();
		user.setId("5514b943d4c6c379396fe8b7");
		Double clusterThreshold = 0.3;
		List<Cluster> clusters = new ArrayList<Cluster>();		
		clusters = ecoreMetamodelService.getSimilarityClusters(clusterThreshold, similarityRelationService).getClusters();
		for (Cluster cluster : clusters) {
			if (cluster.getArtifacts().size()==1) {
				EcoreMetamodel art = ((EcoreMetamodel)cluster.getArtifacts().toArray()[0]);
				List<Metric> metricList = metricRepository
						.findByArtifactId(new ObjectId(art.getId()));
				System.out.print(art.getName());
				boolean guard = false;
				for (Metric metric : metricList) {
					if (metric.getName().equals("Number of MetaClass")) {
						if (((SimpleMetric) metric).getValue().equals("1") || 
								((SimpleMetric) metric).getValue().equals("0")) {
							System.out.print("; " + ((SimpleMetric)metric).getValue());
							guard = true;
							ecoreMetamodelService.delete(art, user);
						}
					}
				}
				if (!guard) {
					System.out.println("");
					metricRepository.delete(metricList);
				}
			}
		}
	}

	@Ignore
	@Test
	public void NullMetamodel() {
		User user = new User();
		user.setId("5514b943d4c6c379396fe8b7");
		List<EcoreMetamodel> ecoreList = ecoreMetamodelService.findAll();
		boolean guard1 = false;
		boolean guard2 = false;
		int count = 0;
		for (EcoreMetamodel ecoreMetamodel : ecoreList) {
			guard1 = false;
			guard2 = false;
			Metric metricMC = metricRepository.findOneByNameAndArtifactId("Number of MetaClass", new ObjectId(ecoreMetamodel.getId()));			 
			if (metricMC != null) 
				if (((SimpleMetric) metricMC).getValue().equals("1")) {
					guard1 = true;
				}
			Metric metricEStructuralFeature = metricRepository.findOneByNameAndArtifactId("Number of Total eStructuralFeature", new ObjectId(ecoreMetamodel.getId()));		 
			if (metricEStructuralFeature != null) 
				if (((SimpleMetric) metricEStructuralFeature).getValue().equals("0") ||
						((SimpleMetric) metricEStructuralFeature).getValue().equals("1")) {
					System.out.println("========");
					System.out.println(ecoreMetamodel.getName());
					System.out.println("OK2");
					System.out.println(((SimpleMetric) metricMC).getValue());
					guard2 = true;
				}
			if (guard1 && guard2)
				count++;
		}
		System.out.println("TOTAL" + count);
	}
	@Ignore
	@Test
	public void fromZoo() {
		List<EcoreMetamodel> al = ecoreMetamodelService.findAll();
		for (EcoreMetamodel ecoreMetamodel : al) {
			System.out.println(ecoreMetamodel.getName());
		}
		System.out.println(al.size());
	}
	@Ignore
	@Test
	public void reclusterAnalisys() {
		final double CLUSTER_THRESHOLD = 0.27;
		final double[] RECLUSTER_THRESHOLD = {0.7,0.75,0.8, 0.85, 0.9, 0.95};
		
		Clusterizzation clusterizzation = ecoreMetamodelService.getSimilarityClusters(CLUSTER_THRESHOLD, similarityRelationService);
		int count = 0;
		int singleton = 0;
		int maxCluster = 0;
		for (Cluster cluster : clusterizzation.getClusters()) {
			count += cluster.getArtifacts().size();
			if (maxCluster<cluster.getArtifacts().size())
				maxCluster = cluster.getArtifacts().size();
			if (cluster.getArtifacts().size()== 1)
				singleton++;
		}
		clusterizzation.setAlgoritmhs("Similiarity");
		clusterizzation.setSingleton(singleton);
		clusterizzation.setThreshold(CLUSTER_THRESHOLD);
		clusterizzation.setNumberOfCluster(clusterizzation.getClusters().size());
		clusterizzationRepository.save(clusterizzation);
		System.out.print(clusterizzation.getId() + ";");
		System.out.print(clusterizzation.getAlgoritmhs() + ";");
		System.out.print("NONE;");
		System.out.print(clusterizzation.getThreshold() + ";");
		System.out.print(clusterizzation.getThresholdRecluster() + ";");
		System.out.print("Containment" + ";");
		System.out.print(count + ";");
		System.out.print(clusterizzation.getClusters().size() + ";");
		System.out.print(singleton + ";");
		System.out.print((clusterizzation.getClusters().size() - singleton) + ";");
		System.out.println(maxCluster);
		
		
		for (double d : RECLUSTER_THRESHOLD) {
			Clusterizzation clusterizzation2 = ecoreMetamodelService.getSimilarityClusters(CLUSTER_THRESHOLD, similarityRelationService);
			Clusterizzation reClusterizzation = ecoreMetamodelService.recluster(clusterizzation2, d, containmentRelationService);
			count = 0;
			maxCluster = 0;
			singleton = 0;
			for (Cluster cluster : reClusterizzation.getClusters()) {
				count += cluster.getArtifacts().size();
				if (maxCluster<cluster.getArtifacts().size())
					maxCluster = cluster.getArtifacts().size();
				if (cluster.getArtifacts().size()== 1)
					singleton++;
			}
			reClusterizzation.setNumberOfCluster(reClusterizzation.getClusters().size());
			reClusterizzation.setAlgoritmhs("Similiarity + Containment");
			reClusterizzation.setSingleton(singleton);
			reClusterizzation.setThreshold(CLUSTER_THRESHOLD);
			reClusterizzation.setThresholdRecluster(d);
			clusterizzationRepository.save(reClusterizzation);
			System.out.print(reClusterizzation.getId() + ";");
			System.out.print(reClusterizzation.getAlgoritmhs() + ";");
			
			System.out.print("YES;");
			System.out.print(reClusterizzation.getThreshold() + ";");
			System.out.print(reClusterizzation.getThresholdRecluster() + ";");
			System.out.print("Cosine" + ";");
			System.out.print(count + ";");
			System.out.print(reClusterizzation.getClusters().size() + ";");
			System.out.print(singleton + ";");
			System.out.print((reClusterizzation.getClusters().size() - singleton) + ";");
			System.out.println(maxCluster);
			
			
		}
	}
	
	@Ignore
	@Test 
	public void MemaodelsWithoutMetric() {
		List<EcoreMetamodel> ecoreList = ecoreMetamodelService.findAll();
		System.out.println(ecoreList.size());
		int cont = 0;
		for (EcoreMetamodel ecoreMetamodel : ecoreList) {
			try {
				String s = ((SimpleMetric)metricRepository.findOneByNameAndArtifactId("Number of MetaClass", new ObjectId(ecoreMetamodel.getId()))).getValue();
				if(s.equals("1") || s.equals("0")) {
					System.out.println(ecoreMetamodel.getName() + " " + s);
					cont++;
				}
			} catch (Exception e) {
				System.out.println("pippo");
				if(ecoreMetamodel!=null)
					System.out.println(ecoreMetamodel.getName());
				else 
					System.out.println("ERRORE");
			}
			
		}
		System.out.println(cont);
	}
	
	
	@Test
	public void produceMatrix() {
		BufferedReader br = null;
		List<Clusterizzation> clusterizzationList = clusterizzationRepository.findAll();
		int k = 0;
		for (Clusterizzation c : clusterizzationList) {
			try {
				br = new BufferedReader(new FileReader("listArtifact"));
				List<EcoreMetamodel> metamodelList = new ArrayList<EcoreMetamodel>();
				String sCurrentLine;
				while (((sCurrentLine = br.readLine()) != null)) {
					metamodelList.add(ecoreMetamodelService.findOneByName(sCurrentLine));
				}
				PrintWriter pw = new PrintWriter(c.getThreshold() + "_" + c.getThresholdRecluster(), "UTF-8");
				int[][] matrix = new int [metamodelList.size()][metamodelList.size()];
				for (int i = 0; i < metamodelList.size(); i++) {
					String print = "";
					Artifact iesimo = ecoreMetamodelService.getCluster(metamodelList.get(i), c).getMostRepresentive();
					for (int j = 0; j < metamodelList.size(); j++) {
						Artifact jesimo = ecoreMetamodelService.getCluster(metamodelList.get(j), c).getMostRepresentive();
						if (iesimo.equals(jesimo))
							matrix[i][j] = 1;
						else
							matrix[i][j] = 0;
						print = print+ matrix[i][j];
						if(j!=metamodelList.size()-1)
							print = print + ";";
					}		
					pw.println(print);
				}
				pw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
