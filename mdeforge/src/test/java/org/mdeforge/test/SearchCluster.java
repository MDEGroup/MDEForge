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

import org.junit.Ignore;
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
		Date startCluster = new Date();
		
		Double clusterThreshold = 0.3;
		Double searchThreshold = 0.50;
		List<Cluster> clusters = new ArrayList<Cluster>();		
		clusters = ecoreMetamodelService.getSimilarityClusters(clusterThreshold, similarityRelationService);	
		Date endCluster = new Date();
		System.out.println("######### CLUSTER COMPUTATION: TOTAL TIME ###########" + (endCluster.getTime() - startCluster.getTime()));
		
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
		
		System.out.println("######### SEARCH COMPUTATION              ###########");
		Date startSearch = new Date();
		List <Cluster> list = new ArrayList<Cluster>();
		List<Artifact> result = new ArrayList<Artifact>();
		int count = 0;
		for (Cluster cluster : clusters) {
			count++;
			double d = ecoreMetamodelService.calculateContainment((EcoreMetamodel)cluster.getMostRepresentive(), serachSample);
			if (d>=clusterThreshold)
				list.add(cluster);
			if (d>=searchThreshold)
				result.add(cluster.getMostRepresentive());
		}
		System.out.println("# clusters: " + clusters.size());
		for (Cluster cluster : list) {
			if(cluster.getArtifacts().size()!=1)
				for (Artifact artifact : cluster.getArtifacts()) {
					if(!artifact.getId().equals(cluster.getMostRepresentive().getId()))  {
						count ++;
						Double d =ecoreMetamodelService.calculateContainment((EcoreMetamodel)artifact, serachSample);
						if(d>=searchThreshold){
							result.add(artifact);
						} 
					}
			}
		}
		for (Artifact ecoreMetamodel : result) {
			System.out.println(ecoreMetamodel.getName());
		}
		System.out.println("Operation: " + count );
		System.out.println("ResultSize: " + result.size());
		Date finishSearch = new Date();
		System.out.println("######### SEARCH COMPUTATION: TOTAL TIME ###########" + (finishSearch.getTime() - startSearch.getTime()));
	}
	
	@Test
	public void testWithoutCluster() throws IOException, InterruptedException {
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
		
		Double threshold = 0.5;
		
		System.out.println("######### NO CLUSTER COMPUTATION ###########");
		Date start = new Date();
		List<EcoreMetamodel> list = ecoreMetamodelService.searchByExample(serachSample, threshold);
		for (EcoreMetamodel ecoreMetamodel : list) {
			System.out.println(ecoreMetamodel.getName());
		}
		System.out.println("ResultSize: " + list.size());
		Date finish = new Date();
		System.out.println("######### SEARCH COMPUTATION: TOTAL TIME ###########" + (finish.getTime() - start.getTime()));
	}
	
	
}
