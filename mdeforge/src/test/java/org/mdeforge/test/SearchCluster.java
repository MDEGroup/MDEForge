package org.mdeforge.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
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
	
	private static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(Base64.encode(encoded));

	}
	@Test
	public void testCluster() throws IOException, InterruptedException {
		//TEST METAMODEL
		System.out.println("######### CLUSTER COMPUTATION ###########");
		Date start = new Date();
		System.out.println("START: " + start);
		EcoreMetamodel serachSample = new EcoreMetamodel();
		serachSample.setName("Example.ecore");
		List<String> tags = Arrays.asList("DB, DataBase, Data Base, Relational".split(","));
		serachSample.setTags(tags);
		serachSample.setDescription("Describes the basic structure of a general Relational DB");
		serachSample.setAuthors("Metamodels Authors");
		serachSample.setOpen(true);	
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName("MySQL.ecore");
		gfm.setContent(readFile("temp/MySQL.ecore"));
		serachSample.setFile(gfm);
		//COMPARATOR
		Comparator<Double> c = new Comparator<Double>() {
				public int compare(Double a, Double b) {
					if (a >= b) {
						return -1;
					} else {
						return 1;
					} // returning 0 would merge keys
				}
			};
		
		Double threshold = 0.3;
		List<Cluster> clusters = new ArrayList<Cluster>();
					
		clusters = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService);			
		List <Cluster> list = new ArrayList<Cluster>();
		for (Cluster cluster : clusters) {
			
			double d = ecoreMetamodelService.calculateContainment((EcoreMetamodel)cluster.getMostRepresentive(), serachSample);
			if (d>=threshold)
				list.add(cluster);
		}
		List<Artifact> result = new ArrayList<Artifact>();
		for (Cluster cluster : list) {
			for (Artifact artifact : cluster.getArtifacts()) {
				Double d =ecoreMetamodelService.calculateContainment((EcoreMetamodel)cluster.getMostRepresentive(), serachSample);
				if(d>threshold && !artifact.getId().equals(cluster.getMostRepresentive().getId())){
					result.add(artifact);
					System.out.println(artifact.getName());
				}
			}
			System.out.println(cluster.getMostRepresentive().getName());
		}
		System.out.println("ResultSize: " + result.size());
		Date finish = new Date();
		System.out.println("FINISH: " + finish);
		System.out.println("Process time: " + (finish.getTime() - start.getTime()));
	}
	@Test
	public void testWithoutCluster() throws IOException, InterruptedException {
		//TEST METAMODEL
		System.out.println("######### NO CLUSTER COMPUTATION ###########");
		Date start = new Date();
		System.out.println("START: " + start);
		EcoreMetamodel serachSample = new EcoreMetamodel();
		Double threshold = 0.3;
		serachSample.setName("Example.ecore");
		List<String> tags = Arrays.asList("DB, DataBase, Data Base, Relational".split(","));
		serachSample.setTags(tags);
		serachSample.setDescription("Describes the basic structure of a general Relational DB");
		serachSample.setAuthors("Metamodels Authors");
		serachSample.setOpen(true);	
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName("MySQL.ecore");
		gfm.setContent(readFile("temp/MySQL.ecore"));
		serachSample.setFile(gfm);
		//COMPARATOR
		
		List<EcoreMetamodel> list = ecoreMetamodelService.searchByExample(serachSample, threshold);
		for (EcoreMetamodel ecoreMetamodel : list) {
			System.out.println(ecoreMetamodel.getName());
		}
		System.out.println("ResultSize: " + list.size());
		Date finish = new Date();
		System.out.println("FINISH: " + finish);
		System.out.println("Process time: " + (finish.getTime() - start.getTime()));
	}
	
	
}
