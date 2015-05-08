package org.mdeforge.presentation.frontend;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.CosineSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class PublicController {
	

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Autowired
	private ContainmentRelationService containmentRelationService;
	@Autowired
	private CosineSimilarityRelationService cosineSimilarityRelationService;
	@Autowired
	private DiceSimilarityRelationService diceSimilarityRelationService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	
	
	
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {			
		return "public.index";
	}
	
	@RequestMapping(value = "/browse/dashboard", method = { RequestMethod.GET })
	public String dashboard() {			
		return "public.browse.dashboard";
	}
	
	@RequestMapping(value = "/browse/metamodel_details", method = { RequestMethod.GET })
	public String metamodelDetails(Model model, @RequestParam String metamodel_id) {	
		
		EcoreMetamodel ecoreMetamodel = ecoreMetamodelService.findOne(metamodel_id);
		model.addAttribute("ecoreMetamodel", ecoreMetamodel);
//		String filePath = gridFileMediaService.getFilePath(ecoreMetamodel);
//		System.out.println(filePath);
		
		return "public.browse.metamodel_details";
	}
	
	@RequestMapping(value = "/browse/metamodels_list", method = { RequestMethod.GET })
	public String metamodelsList(Model model) {					
		
		List<EcoreMetamodel> ecoreMetamodelsList = ecoreMetamodelService.findAll();		
		model.addAttribute("ecoreMetamodelsList", ecoreMetamodelsList);
		
		return "public.browse.metamodels_list";
	}
	
	@RequestMapping(value = "/browse/cluster", method = { RequestMethod.GET })
	public String cluster(Model model, 
			@RequestParam (value="threshold", required=true, defaultValue="0.3") Double threshold, 
			@RequestParam (value="computation", required=true, defaultValue="1") int computation
		) {
		

		/*
		 * TABLE
		 */
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
			if(cluster.getArtifacts().size()==1){
				noCluster++;
			}
		}
		average =  (count*1.0)/(clusters.size()*1.0);
		model.addAttribute("clusters", clusters);
		model.addAttribute("average", average);
		model.addAttribute("max", maxCluster);
		model.addAttribute("noCluster", noCluster);
		
		
		//Mettiamo anche le informazioni relative alla Threshold e Computation
		model.addAttribute("threshold", threshold);
		model.addAttribute("computation", computation);
		
		
		return "public.browse.cluster";
	}
	
	@RequestMapping(value = "/browse/cluster_graph", method = { RequestMethod.GET })
	public String test(Model model, 
			@RequestParam (value="threshold", required=true, defaultValue="0.3") Double threshold, 
			@RequestParam (value="computation", required=true, defaultValue="1") int computation
		) {
		
		/*
		 * GRAPH
		 */
		String graph = null;
		switch (computation) {
		case 1:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold, similarityRelationService);
			break;
		case 2:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold, containmentRelationService);
			break;
		case 3:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold, cosineSimilarityRelationService);	
			break;		
		case 4:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold, diceSimilarityRelationService);
			break;
		}
		model.addAttribute("graph", graph);
		
		/*
		 * TABLE
		 */
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
			if(cluster.getArtifacts().size()==1){
				noCluster++;
			}
		}
		average =  (count*1.0)/(clusters.size()*1.0);
		model.addAttribute("clusters", clusters);
		model.addAttribute("average", average);
		model.addAttribute("max", maxCluster);
		model.addAttribute("noCluster", noCluster);
		
		//Mettiamo anche le informazioni relative alla Threshold e Computation
		model.addAttribute("threshold", threshold);
		model.addAttribute("computation", computation);
				
		
		return "public.browse.cluster.graph";
	}
}
