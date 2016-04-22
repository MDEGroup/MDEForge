package org.mdeforge.presentation.frontend;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.SemanticSimilarityRelationService;
import org.mdeforge.business.SemanticSimilarityRelationServiceV1;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.Clusterizzation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.ClusterizzationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public/EcoreMetamodel")
public class EcorePublicController extends ArtifactPublicController<EcoreMetamodel> {
	final double thresholdSimilarityRelation = 		0.0;
	final double thresholdContainmentRelation = 		0.0;
	final double thresholdCosineSimilarityRelation = 	0.0;
	final double thresholdDiceSimilarityRelation = 	0.0;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private ClusterizzationRepository clusterizzationRepository;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Autowired
	private SemanticSimilarityRelationServiceV1 semanticSimilarityV1RelationService;
	@Autowired
	private SemanticSimilarityRelationService semanticSimilarityRelationService;
	@Autowired
	private DiceSimilarityRelationService diceSimilarityRelationService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired 
	private User user;

	
	
	public String details(Model model, @RequestParam String artifact_id) {

		super.details(model, artifact_id);
//		ecoreMetamodel.getRelations().addAll(
//				similarityRelationService.findTopProximity(ecoreMetamodel, 5));
//		ecoreMetamodel.getRelations().addAll(
//				containmentRelationService.findTopProximity(ecoreMetamodel, 5));
//		ecoreMetamodel.getRelations().addAll(
//				diceSimilarityRelationService.findTopProximity(ecoreMetamodel, 5));
//		ecoreMetamodel.getRelations().addAll(
//				cosineSimilarityRelationService.findTopProximity(ecoreMetamodel, 5));
		return "public.browse.metamodel_details";
	}

	@RequestMapping(value = "/cluster", method = { RequestMethod.GET })
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
//			Clusterizzation clu = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService);
//			clusters = ecoreMetamodelService.recluster(clu, 0.9, cosineSimilarityRelationService).getClusters();
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService).getClusters();			
			break;
		case 2:
			threshold = (threshold < thresholdContainmentRelation) ? thresholdContainmentRelation : threshold;			
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, semanticSimilarityV1RelationService).getClusters();
			break;
		case 3:
			threshold = (threshold < thresholdCosineSimilarityRelation) ? thresholdCosineSimilarityRelation : threshold;
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, semanticSimilarityRelationService).getClusters();
			break;
		case 4:
			threshold = (threshold < thresholdDiceSimilarityRelation) ? thresholdDiceSimilarityRelation : threshold;
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, diceSimilarityRelationService).getClusters();
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
	
	@RequestMapping(value = "/cluster_from_DB", method = { RequestMethod.GET })
	public String clusterFromDB(
			Model model,
			@RequestParam(value = "id") String id) {
		Clusterizzation clusterizzation = clusterizzationRepository.findOne(id);
		List<Cluster> clusters = clusterizzation.getClusters(); 
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
		model.addAttribute("threshold", clusterizzation.getThreshold());
		model.addAttribute("computation", clusterizzation.getAlgoritmhs());
		model.addAttribute("numberOfMetamodels", count);
		return "public.browse.cluster";
	}

	@RequestMapping(value = "/cluster_graph", method = { RequestMethod.GET })
	public String clusterGraph(
			Model model,
			@RequestParam(value = "threshold", required = true, defaultValue = "0.30") Double threshold,
			@RequestParam(value = "computation", required = true, defaultValue = "1") int computation) {
		List<Cluster> clusters = new ArrayList<Cluster>();
		switch (computation) {
		case 1:			
			threshold = (threshold < thresholdSimilarityRelation) ? thresholdSimilarityRelation : threshold;			
			//Clusterizzation clu = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService);
			//clusters = ecoreMetamodelService.recluster(clu, 1).getClusters();
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, similarityRelationService).getClusters();			
			break;
		case 2:
			threshold = (threshold < thresholdContainmentRelation) ? thresholdContainmentRelation : threshold;			
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, semanticSimilarityV1RelationService).getClusters();
			break;
		case 3:
			threshold = (threshold < thresholdCosineSimilarityRelation) ? thresholdCosineSimilarityRelation : threshold;
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, semanticSimilarityRelationService).getClusters();
			break;
		case 4:
			threshold = (threshold < thresholdDiceSimilarityRelation) ? thresholdDiceSimilarityRelation : threshold;
			clusters = ecoreMetamodelService.getSimilarityClusters(threshold, diceSimilarityRelationService).getClusters();
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
					semanticSimilarityV1RelationService);
			break;
		case 3:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold,
					semanticSimilarityRelationService);
			break;
		case 4:
			graph = ecoreMetamodelService.getSimilarityGraph(threshold,
					diceSimilarityRelationService);
			break;
		}
		model.addAttribute("graph", graph);
		return "public.browse.cluster.graph";
	}
	
	public String artifactFromName(@RequestParam String name,Model model) throws IOException{
		EcoreMetamodel ecoreMetamodel = ecoreMetamodelService.findOneByName(name);
		return "redirect:/public/EcoreMetamodel/artifacts?artifact_id="+ ecoreMetamodel.getId();
	}
}
