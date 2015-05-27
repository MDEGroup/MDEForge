package org.mdeforge.presentation.frontend;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.CosineSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class PublicController {
	
	final double thresholdSimilarityRelation = 		0.15;
	final double thresholdContainmentRelation = 		0.4;
	final double thresholdCosineSimilarityRelation = 	0.2;
	final double thresholdDiceSimilarityRelation = 	0.6;

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
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {
		return "public.index";
	}
	@RequestMapping(value = "/about", method = { RequestMethod.GET })
	public String about() {
		return "public.about";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "public.login";
	}

	@RequestMapping(value = "/browse", method = { RequestMethod.GET })
	public String dashboard(Model model, HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		response.sendRedirect(request.getContextPath()+"/public/browse/cluster_graph");

//		List<EcoreMetamodel> ecoreMetamodelsList = ecoreMetamodelService
//				.findAll();
//		model.addAttribute("ecoreMetamodelsList", ecoreMetamodelsList);
//		List<User> users = userService.findAll();
//		model.addAttribute("users", users);
//		return "public.browse.dashboard";
		return null;
	}

	@RequestMapping(value = "/browse/metamodel_details", method = { RequestMethod.GET })
	public String metamodelDetails(Model model, @RequestParam String metamodel_id) {

		EcoreMetamodel ecoreMetamodel = ecoreMetamodelService.findOnePublic(metamodel_id);
		model.addAttribute("ecoreMetamodel", ecoreMetamodel);
		String pathToDownload = gridFileMediaService.getFilePath(ecoreMetamodel);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("ecoreMetamodelFile", ecoreMetamodelFile);

		return "public.browse.metamodel_details";
	}

	@RequestMapping(value = "/browse/metamodel_download", method = RequestMethod.GET)
	public void downloadMetamodel(@RequestParam String metamodel_id,
			HttpServletResponse response) throws IOException {

		EcoreMetamodel ecoreMetamodel = ecoreMetamodelService
				.findOne(metamodel_id);
		InputStream is = gridFileMediaService
				.getFileInputStream(ecoreMetamodel);

		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ ecoreMetamodel.getName() + ".ecore");
		// copy it to response's OutputStream
		org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}

	@RequestMapping(value = "/browse/metamodels_list", method = { RequestMethod.GET })
	public String metamodelsList(Model model) {

		List<EcoreMetamodel> ecoreMetamodelsList = ecoreMetamodelService
				.findAll();
		model.addAttribute("ecoreMetamodelsList", ecoreMetamodelsList);

		return "public.browse.metamodels_list";
	}

	@RequestMapping(value = "/browse/cluster", method = { RequestMethod.GET })
	public String cluster(
			Model model,
			@RequestParam(value = "threshold", required = true, defaultValue = "0.30") Double threshold,
			@RequestParam(value = "computation", required = true, defaultValue = "1") int computation) {
		
		
		/*
		 * TABLE
		 */
		List<Cluster> clusters = new ArrayList<Cluster>();
		switch (computation) {
		case 1:	
			
			
			
			threshold = (threshold < thresholdSimilarityRelation) ? thresholdSimilarityRelation : threshold;			
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService);			
			break;
		case 2:
			threshold = (threshold < thresholdContainmentRelation) ? thresholdContainmentRelation : threshold;			
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, containmentRelationService);
			break;
		case 3:
			threshold = (threshold < thresholdCosineSimilarityRelation) ? thresholdCosineSimilarityRelation : threshold;
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, cosineSimilarityRelationService);
			break;
		case 4:
			threshold = (threshold < thresholdDiceSimilarityRelation) ? thresholdDiceSimilarityRelation : threshold;
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, diceSimilarityRelationService);
			break;
		}
		
		int maxCluster = 0;
		double average = 0;
		int count = 0;
		int noCluster = 0;
		for (Cluster cluster : clusters) {
			maxCluster = (maxCluster < cluster.getArtifacts().size()) ? cluster
					.getArtifacts().size() : maxCluster;
			count += cluster.getArtifacts().size();
			if (cluster.getArtifacts().size() == 1) {
				noCluster++;
			}
		}
		average = (count * 1.0) / (clusters.size() * 1.0);
		model.addAttribute("clusters", clusters);
		model.addAttribute("average", average);
		model.addAttribute("max", maxCluster);
		model.addAttribute("noCluster", noCluster);
		// Mettiamo anche le informazioni relative alla Threshold e Computation
		model.addAttribute("threshold", threshold);
		model.addAttribute("computation", computation);
		model.addAttribute("numberOfMetamodels", count);
		return "public.browse.cluster";
	}

	@RequestMapping(value = "/browse/cluster_graph", method = { RequestMethod.GET })
	public String clusterGraph(
			Model model,
			@RequestParam(value = "threshold", required = true, defaultValue = "0.30") Double threshold,
			@RequestParam(value = "computation", required = true, defaultValue = "1") int computation) {

		
		
		List<Cluster> clusters = new ArrayList<Cluster>();
		switch (computation) {
		case 1:			
			threshold = (threshold < thresholdSimilarityRelation) ? thresholdSimilarityRelation : threshold;			
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService);			
			break;
		case 2:
			threshold = (threshold < thresholdContainmentRelation) ? thresholdContainmentRelation : threshold;			
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, containmentRelationService);
			break;
		case 3:
			threshold = (threshold < thresholdCosineSimilarityRelation) ? thresholdCosineSimilarityRelation : threshold;
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, cosineSimilarityRelationService);
			break;
		case 4:
			threshold = (threshold < thresholdDiceSimilarityRelation) ? thresholdDiceSimilarityRelation : threshold;
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, diceSimilarityRelationService);
			break;
		}
		
		int maxCluster = 0;
		double average = 0;
		int count = 0;
		int noCluster = 0;
		for (Cluster cluster : clusters) {
			maxCluster = (maxCluster < cluster.getArtifacts().size()) ? cluster
					.getArtifacts().size() : maxCluster;
			count += cluster.getArtifacts().size();
			if (cluster.getArtifacts().size() == 1) {
				noCluster++;
			}
		}
		average = (count * 1.0) / (clusters.size() * 1.0);
		model.addAttribute("clusters", clusters);
		model.addAttribute("average", average);
		model.addAttribute("max", maxCluster);
		model.addAttribute("noCluster", noCluster);
		// Mettiamo anche le informazioni relative alla Threshold e Computation
		model.addAttribute("threshold", threshold);
		model.addAttribute("computation", computation);
		model.addAttribute("numberOfMetamodels", count);
		
		/*
		 * GRAPH
		 */
		String graph = null;
		switch (computation) {
		case 1:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold,
					similarityRelationService);
			break;
		case 2:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold,
					containmentRelationService);
			break;
		case 3:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold,
					cosineSimilarityRelationService);
			break;
		case 4:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold,
					diceSimilarityRelationService);
			break;
		}
		model.addAttribute("graph", graph);
		return "public.browse.cluster.graph";
	}
	
	@RequestMapping(value = "/browse/metamodel_name_from_graph", method = { RequestMethod.GET })
	public void clusterGraphMetamodelNameFromGraph(@RequestParam String name,Model model, HttpServletResponse response, HttpServletRequest request) throws IOException{
		
		EcoreMetamodel ecoreMetamodel = ecoreMetamodelService.findOneByName(name);
		
		response.sendRedirect(request.getContextPath()+"/public/browse/metamodel_details?metamodel_id="+ecoreMetamodel.getId());
	}
}
