package org.mdeforge.presentation;


import java.util.List;

import org.mdeforge.business.ClusterService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.Artifact;
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
	@Autowired
	private ClusterService clusterService;
	
	
	
	
	@RequestMapping(value = "/clusterGraph", method = { RequestMethod.GET })
	public String clusterGraph(org.springframework.ui.Model model, @RequestParam Double threshold ) {
		String graph = ecoreMetamodelService.getSimilarityGraph(threshold);
		model.addAttribute("graph", graph);
		return "test.cluster.graph";
	}
	@RequestMapping(value = "/cluster", method = { RequestMethod.GET })
	public String cluster(org.springframework.ui.Model model, @RequestParam Double threshold ) {
		List<Cluster> clusters = clusterService.getClusters(threshold);
		for (Cluster cluster : clusters) {
			
			for (Artifact artifact : cluster.getArtifacts()) {
				System.out.println(artifact.getName());
			}
			System.out.println("___________________");
		}
		model.addAttribute("clusters", clusters);
		double average = 0;
		int count = 0;
		for (Cluster cluster : clusters) {
			count += cluster.getArtifacts().size();
		}
		average =  (count*1.0)/(clusters.size()*1.0);
		model.addAttribute("average", average);
		return "test.cluster";
	}

}
