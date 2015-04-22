package org.mdeforge.presentation;


import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.Cluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	
	@RequestMapping(value = "/clusterGraph", method = { RequestMethod.GET })
	public String clusterGraph(org.springframework.ui.Model model, @RequestParam Double threshold,@RequestParam int computation ) {
		String graph = ecoreMetamodelService.getSimilarityGraph(threshold,computation);
		model.addAttribute("graph", graph);
		return "test.cluster.graph";
	}
	@RequestMapping(value = "/cluster", method = { RequestMethod.GET })
	public String cluster(org.springframework.ui.Model model, @RequestParam Double threshold, @RequestParam int computation) {
		List<Cluster> clusters = ecoreMetamodelService.getClusters(threshold,computation);
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
	
	
	@RequestMapping(value = "/editor", method = { RequestMethod.GET })
	public String editor(org.springframework.ui.Model model) {
		
		
		return "test.editor";
	}
	
}
