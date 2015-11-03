package org.mdeforge.presentation;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.ContainmentRelation;
import org.mdeforge.business.model.CosineSimilarityRelation;
import org.mdeforge.business.model.DiceSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.SimilarityRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, containmentRelationService);
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
	@RequestMapping(value = "/test_content", method = { RequestMethod.GET })
	public String getMetamodelContent(Model model, @RequestParam (value="name") String name) {
		EcoreMetamodel emm = ecoreMetamodelService.findOneByName(name);
		String s = ecoreMetamodelService.serializeContent(emm);
		model.addAttribute("content", s);
		return "public.browse.test.content";
	}
	@RequestMapping(value = "/test_relation", method = { RequestMethod.GET })
	public String getMetamodelRelation(Model model, @RequestParam (value="name1") String name1,
			@RequestParam (value="name2") String name2) {
		EcoreMetamodel emm1 = ecoreMetamodelService.findOneByName(name1);
		EcoreMetamodel emm2 = ecoreMetamodelService.findOneByName(name2);
		SimilarityRelation similarity = 
				(similarityRelationService.findOneByArtifacts(emm1, emm2)==null)
					?similarityRelationService.findOneByArtifacts(emm2, emm1)
						:similarityRelationService.findOneByArtifacts(emm1, emm2);
		ContainmentRelation containment = 
				(containmentRelationService.findOneByArtifacts(emm1, emm2)==null)
					?containmentRelationService.findOneByArtifacts(emm2, emm1)
						:containmentRelationService.findOneByArtifacts(emm1, emm2);
		CosineSimilarityRelation cosine = 
				(cosineSimilarityRelationService.findOneByArtifacts(emm1, emm2)==null)
					?cosineSimilarityRelationService.findOneByArtifacts(emm2, emm1)
						:cosineSimilarityRelationService.findOneByArtifacts(emm1, emm2);
		DiceSimilarityRelation dice = 
				(diceSimilarityRelationService.findOneByArtifacts(emm1, emm2)==null)
				?diceSimilarityRelationService.findOneByArtifacts(emm2, emm1)
					:diceSimilarityRelationService.findOneByArtifacts(emm1, emm2);
		model.addAttribute("similarity", similarity.getValue());
		model.addAttribute("containment", containment.getValue());
		model.addAttribute("cosine", cosine.getValue());
		model.addAttribute("dice", dice.getValue());
		return "public.browse.test.relation";
	}
	
	
	
	
	@RequestMapping(value = "/{type:.+}", method = RequestMethod.GET)
	public String getPages(@PathVariable("type") String type)
			throws Exception {

		if ("error".equals(type)) {
			// go handleCustomException
			throw new BusinessException("E888", "This is custom message");
		} else if ("io-error".equals(type)) {
			// go handleAllException
			throw new IOException();
		} else {
			return "error.404";
		}

	}

}
