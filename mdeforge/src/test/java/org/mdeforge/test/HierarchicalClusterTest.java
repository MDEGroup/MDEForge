package org.mdeforge.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.apporiented.algorithm.clustering.Cluster;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/rest-dispatcher-servlet-security.xml"})
public class HierarchicalClusterTest {

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	
	private final double threshold = 0.7;
	@Test
	public void testHC() {
		Cluster hc = ecoreMetamodelService.getHierarchicalCluster();
		List<Cluster> clusterList = ecoreMetamodelService.getClustersWithThreshold(hc, threshold);
		List<org.mdeforge.business.model.Cluster> myClusterList = ecoreMetamodelService.getRealClustersFromHierarchicalCluster(clusterList);
		for (org.mdeforge.business.model.Cluster cluster : myClusterList) {
			System.out.println("_____________");
			System.out.println("\n Art");
			for (org.mdeforge.business.model.Artifact art: cluster.getArtifacts()) {
				System.out.println(art.getName());
			}
			System.out.println("\n Rel");
			for (org.mdeforge.business.model.Relation art: cluster.getRelations()) {
				System.out.println(art.getFromArtifact().getName() + "_" + art.getToArtifact().getName());
			}
		}
		
	}
	
	
//	public static void main(String[] args) {
//		String[] names = new String[] { "O1", "O2", "O3", "O4", "O5", "O6" };
//		double[][] distances = new double[][] { 
//		    { 0, 1, 9, 7, 11, 14 },
//		    { 1, 0, 4, 3, 8, 10 }, 
//		    { 9, 4, 0, 9, 2, 8 },
//		    { 7, 3, 9, 0, 6, 13 }, 
//		    { 11, 8, 2, 6, 0, 10 },
//		    { 14, 10, 8, 13, 10, 0 }};
//
//		ClusteringAlgorithm alg = new DefaultClusteringAlgorithm();
//		Cluster cluster = alg.performClustering(distances, names,
//		    new SingleLinkageStrategy());
//		
//		DendrogramPanel dp = new DendrogramPanel();
//		dp.setModel(cluster);
//		int w = 1000;
//	    int h = 1000;
//	    dp.setSize(w, h);
//		BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//	    Graphics2D g = bi.createGraphics();
//	    dp.paint(g);
//	    dp.print(g);
//	    File outputfile = new File("/Users/juridirocco/Desktop/tempForge/asd.jpx");
//	    try {
//			ImageIO.write(bi, "jpg", outputfile);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	

}
