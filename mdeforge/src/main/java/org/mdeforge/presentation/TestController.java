package org.mdeforge.presentation;


import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private ContainmentRelationService containmentRelationService;
	@Autowired
	private CosineSimilarityRelationService cosineSimilarityRelationService;
	@Autowired
	private DiceSimilarityRelationService diceSimilarityRelationService;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	
	@RequestMapping(value = "/clusterGraph", method = { RequestMethod.GET })
	public String clusterGraph(org.springframework.ui.Model model, @RequestParam Double threshold, @RequestParam int computation) {
		String graph = null;
		if(computation == 1)
			graph = ecoreMetamodelService.getSimilarityGraph(threshold, similarityRelationService);
		else
			graph = ecoreMetamodelService.getSimilarityGraph(threshold, similarityRelationService);
		model.addAttribute("graph", graph);
		return "test.cluster.graph";
	}
	@RequestMapping(value = "/cluster", method = { RequestMethod.GET })
	public String cluster(org.springframework.ui.Model model, @RequestParam Double threshold, @RequestParam int computation) {
		List<Cluster> clusters = new ArrayList<Cluster>();
		if(computation == 1)
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService);
		else 
			clusters = ecoreMetamodelService.getContainmentClusters(threshold, similarityRelationService);
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
		model.addAttribute("clusters", clusters);
		model.addAttribute("average", average);
		model.addAttribute("max", maxCluster);
		model.addAttribute("noCluster", noCluster);
		
		return "test.cluster";

	}
	
	
	@RequestMapping(value = "/temp", method = { RequestMethod.GET })
	public String editor(org.springframework.ui.Model model) {
		//ecoreMetamodelService.plotHierarchicalCluster();
		return "welcome";
	}
	
	@RequestMapping(value = "/cluster_test", method = { RequestMethod.GET })
	public String clusterTest(Model model, 
			@RequestParam (value="threshold", required=true, defaultValue="0.3") Double threshold, 
			@RequestParam (value="computation", required=true, defaultValue="1") int computation
			) {
		List<Cluster> clusters = new ArrayList<Cluster>();
		switch (computation) {
		case 1:
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService);
			break;
		case 2:
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, containmentRelationService);
			break;
		case 3:
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, cosineSimilarityRelationService);	
			break;		
		case 4:
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, diceSimilarityRelationService);
			break;
		}
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
		model.addAttribute("clusters", clusters);
		model.addAttribute("average", average);
		model.addAttribute("max", maxCluster);
		model.addAttribute("noCluster", noCluster);
		
		return "public.browse.test";
	}

}
