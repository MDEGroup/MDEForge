package org.mdeforge.presentation.frontend;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.Cluster;
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

	
	
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {			
		return "public.index";
	}
	
	
	
	
	
	@RequestMapping(value = "/browse/dashboard", method = { RequestMethod.GET })
	public String dashboard() {			
		return "public.browse.dashboard";
	}
	
	@RequestMapping(value = "/browse/metamodels_list", method = { RequestMethod.GET })
	public String metamodelsList(Model model) {					
		
		List<EcoreMetamodel> ecoreMetamodelsList = ecoreMetamodelService.findAll();		
		model.addAttribute("ecoreMetamodelsList", ecoreMetamodelsList);
		
		return "public.browse.metamodels_list";
	}
	
	@RequestMapping(value = "/browse/cluster", method = { RequestMethod.GET })
	public String cluster(Model model, 
			@RequestParam (value="threshold", required=true, defaultValue="0.5") Double threshold, 
			@RequestParam (value="computation", required=true, defaultValue="1") int computation
		) {
		
		/*
		 * GRAPH
		 */
		String graph = null;
		if(computation == 1)
			graph = ecoreMetamodelService.getSimilarityGraph(threshold);
		else
			graph = ecoreMetamodelService.getSimilarityGraph(threshold);
		model.addAttribute("graph", graph);
		
		
		/*
		 * TABLE
		 */
		List<Cluster> clusters = new ArrayList<Cluster>();
		if(computation == 1){
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold);
		}else{
			clusters = ecoreMetamodelService.getContainmentClusters(threshold);			
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
			System.out.println(cluster.getkMax());
		}
		average =  (count*1.0)/(clusters.size()*1.0);
		model.addAttribute("clusters", clusters);
		model.addAttribute("average", average);
		model.addAttribute("max", maxCluster);
		model.addAttribute("noCluster", noCluster);
		
		
		return "public.browse.cluster";
	}
	@RequestMapping(value = "/browse/cluster_test", method = { RequestMethod.GET })
	public String test(Model model, 
			@RequestParam (value="threshold", required=true, defaultValue="0.5") Double threshold, 
			@RequestParam (value="computation", required=true, defaultValue="1") int computation
		) {
		
		/*
		 * GRAPH
		 */
		String graph = null;
		if(computation == 1)
			graph = ecoreMetamodelService.getSimilarityGraph(threshold);
		else
			graph = ecoreMetamodelService.getSimilarityGraph(threshold);
		model.addAttribute("graph", graph);
				
		
		return "public.browse.cluster.test";
	}
	
	@RequestMapping(value = "/browse/cluster_test_hierarchical", method = { RequestMethod.GET })
	public String testHierachival(Model model) {
		
		/*
		 * GRAPH
		 */
		String graph = null;
		double [] d = {0.5,0.4,0.3,0.2,0.1};
		graph = ecoreMetamodelService.getHierarchicalClusterGraph(d);
		model.addAttribute("graph", graph);
				
		return "public.browse.cluster.test_hierarchical";
	}
	

}
