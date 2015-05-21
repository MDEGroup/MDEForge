package org.mdeforge.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.CosineSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.search.ResourceSerializer;
import org.mdeforge.business.search.SimilarityMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apporiented.algorithm.clustering.Cluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/rest-dispatcher-servlet-security.xml" })
public class HierarchicalClusterTest {

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;

	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Autowired
	private ContainmentRelationService containmentRelationService;
	@Autowired
	private DiceSimilarityRelationService diceRelationService;
	@Autowired
	private CosineSimilarityRelationService cosineSimilarityRelationService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	private final double threshold = 0.7;

	@Ignore
	@Test
	public void testHC() {
		Cluster hc = ecoreMetamodelService.getHierarchicalCluster(similarityRelationService);
		List<Cluster> clusterList = ecoreMetamodelService.getClustersWithThreshold(hc, threshold, similarityRelationService);
		List<org.mdeforge.business.model.Cluster> myClusterList = ecoreMetamodelService
				.getRealClustersFromHierarchicalCluster(clusterList, similarityRelationService);
		for (org.mdeforge.business.model.Cluster cluster : myClusterList) {
			System.out.println("_____________");
			System.out.println("\n Art");
			for (org.mdeforge.business.model.Artifact art : cluster.getArtifacts()) {
				System.out.println(art.getName());
			}
			System.out.println("\n Rel");
			for (org.mdeforge.business.model.Relation art : cluster.getRelations()) {
				System.out.println(art.getFromArtifact().getName() + "_" + art.getToArtifact().getName());
			}
		}

	}
	@Ignore
	@Test
	public void extractContent() {
		EcoreMetamodel emm1 = ecoreMetamodelService.findOne("552bbd40d4c659da8e19eead");
		ResourceSet load_resourceSet = new ResourceSetImpl();
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource load_resource = load_resourceSet.getResource(URI.createURI(gridFileMediaService.getFilePath(emm1)),
				true);

		EcoreMetamodel emm2 = ecoreMetamodelService.findOne("552bbd2fd4c659da8e19ee19");
		ResourceSet load_resourceSet2 = new ResourceSetImpl();
		load_resourceSet2.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMIResourceFactoryImpl());
		Resource load_resource2 = load_resourceSet2.getResource(URI.createURI(gridFileMediaService.getFilePath(emm2)),
				true);

		String test = ResourceSerializer.serialize(load_resource);
		String test2 = ResourceSerializer.serialize(load_resource2);
		System.out.println(test);
		System.out.println(test2);
		SimilarityMethods cs = new SimilarityMethods();
		double sim_score = cs.cosineSimilarityScore(test, test2);
		System.out.println("Vediamo: "+ sim_score );
	}
	@Ignore
	@Test
	public void similaritt() {
		 
		System.out.println("###START");
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		EcoreMetamodel [] ecoreMMArray = ecoreMMlist.toArray(new EcoreMetamodel[ecoreMMlist.size()]);
		for (int i =0; i < ecoreMMArray.length-1; i++) 
			for (int j = i+1; j <ecoreMMArray.length; j++) {
				System.out.println(i + "_" + j);
				ecoreMetamodelService.calculateSimilarity(ecoreMMArray[i], ecoreMMArray[j]);
			}
		System.out.println("Stop");
	 }
	@Ignore
	@Test
	public void exportDiceSimilarity() {
		try {
			PrintWriter pw = new PrintWriter(new File(basePath + "cosibeDistance.txt"));
			List<CosineSimilarityRelation> dsrl = cosineSimilarityRelationService.findAll();
			int i = 1;
			for (CosineSimilarityRelation diceSimilarityRelation : dsrl){ 
				pw.println(diceSimilarityRelation.getValue());
				System.out.println(i);
				i++;
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void exportSimilarityMatrix() {
		try {
			PrintWriter pw = new PrintWriter(new File(basePath + "proximityMatrixDice.txt"));
			double [][] dsrl = ecoreMetamodelService.getProximityMatrix(diceRelationService);
			for (int i=0; i < dsrl.length; i++){
				for (int j = 0; j < dsrl[i].length; j++) {
					if(j < dsrl[i].length-1)
						pw.print(  String.format(Locale.US,"%.6f;", dsrl[i][j] ) );
					else pw.print(String.format(Locale.US,"%.6f", dsrl[i][j] ));
				}
				pw.println();
				
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
