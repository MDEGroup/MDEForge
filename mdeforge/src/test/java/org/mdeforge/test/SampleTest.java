package org.mdeforge.test;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.CRUDRelationService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.SimilarityRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/rest-dispatcher-servlet-security.xml"})

public class SampleTest {

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private MetamodelService metamodelService;
	@Autowired
	private UserService userService;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	
	@Ignore
	@Test
	public void getListSimilarity() {
		try {
			List<SimilarityRelation> similarityRelationList = similarityRelationService.findAll(1);
			PrintWriter p = new PrintWriter("/Users/juridirocco/Desktop/include2.txt");
			for (SimilarityRelation similarityRelation : similarityRelationList) {
				p.println(similarityRelation.getValue());
			}
			p.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	final static double[] testArray = {0.1,
						  0.125,
						  0.15,
						  0.175,
						  0.2,
						  0.225,
						  0.25,
						  0.275,
						  0.3,
						  0.325,
						  0.35,
						  0.375,
						  0.4,
						  0.425,
						  0.45,
						  0.475,
						  0.5};
	@Ignore
	@Test
	public void getSimilarityResults() {
		try {
			PrintWriter p = new PrintWriter("/Users/juridirocco/Desktop/result2.txt");
			for (double d : testArray) {
				List<Cluster> clusters = ecoreMetamodelService.getSimilarityClusters(d, similarityRelationService);
				int maxCluster = 0;
				double average = 0;
				int count = 0;
				int noCluster = 0;
				for (Cluster cluster : clusters) {
					maxCluster = (maxCluster < cluster.getArtifacts().size())?cluster.getArtifacts().size():maxCluster;
					count += cluster.getArtifacts().size();
					if(cluster.getArtifacts().size()==1)
						noCluster++;
				}
				average =  (count*1.0)/(clusters.size()*1.0);
				String s = d + ";" + clusters.size() + ";" + average + ";" + maxCluster + ";" + noCluster + ";" + (clusters.size() - noCluster);
				p.println(s);
			}
			p.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void getFileNode() {
		try {
			PrintWriter p = new PrintWriter("/Users/juridirocco/Desktop/juri.txt");
			List<SimilarityRelation> srl = similarityRelationService.findAll();
			for (SimilarityRelation similarityRelation : srl) {
				p.println(similarityRelation.getToArtifact().getName() + ";" + 
						similarityRelation.getFromArtifact().getName() + ";" + similarityRelation.getValue());
			}
			p.close();
		}
		catch (Exception e) {}
		
	}
	@Test
	public void getStringTest() {
		try {
			PrintWriter p = new PrintWriter("/Users/juridirocco/Desktop/listaMetamodelli.txt");
			List<EcoreMetamodel> srl = ecoreMetamodelService.findAllPublic();
			for (EcoreMetamodel similarityRelation : srl) {
				p.println(similarityRelation.getName());
			}
			p.close();
		}
		catch (Exception e) {}
		
	}
}
