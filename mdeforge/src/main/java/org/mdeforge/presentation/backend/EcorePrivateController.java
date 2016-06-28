package org.mdeforge.presentation.backend;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.ContainmentRelation;
import org.mdeforge.business.model.CosineSimilarityRelation;
import org.mdeforge.business.model.DiceSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.SimilarityRelation;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/private/EcoreMetamodel")
public class EcorePrivateController extends ArtifactPrivateController<EcoreMetamodel> {
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private User user;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Autowired
	private ContainmentRelationService containmentRelationService;
	@Autowired
	private DiceSimilarityRelationService diceSimilarityRelationService;
	@Autowired
	private CosineSimilarityRelationService cosineSimilarityRelationService;
	@Autowired
	private MetricRepository metricRepository;
		
	public String details(Model model, @RequestParam String artifact_id) {
		super.details(model, artifact_id);
//		ecore.getRelations().addAll(similarityRelationService.findTopProximity(ecore, 5));
//		ecore.getRelations().addAll(containmentRelationService.findTopProximity(ecore, 5));
//		ecore.getRelations().addAll(diceSimilarityRelationService.findTopProximity(ecore, 5));
//		ecore.getRelations().addAll(cosineSimilarityRelationService.findTopProximity(ecore, 5));
		return "private.use.metamodel_details";
	}
	
	@RequestMapping(value = "/artifact_project", method =  RequestMethod.GET )
	public String detailsByProject(Model model, @RequestParam String project_id, @RequestParam String artifact_id) {
		super.detailsByProject(model, project_id, artifact_id);
		return "private.use.metamodel_details";
	}

	@RequestMapping(value = "/metamodel_compare", method = { RequestMethod.GET })
	public String metamodelCompareStart(Model model) {
		
		List<EcoreMetamodel> ecoreMetamodelList = ecoreMetamodelService.findAllWithPublicByUser(user);
		model.addAttribute("ecoreMetamodelList", ecoreMetamodelList);
				
		return "private.use.metamodel_compare";
	}

	@RequestMapping(value = "/metamodel_compare", method = { RequestMethod.POST })
	public String metamodelCompareExecute(Model model, @RequestParam String left_metamodel_id, @RequestParam String right_metamodel_id) {
		EcoreMetamodel leftMetamodel = ecoreMetamodelService.findOne(left_metamodel_id);
		model.addAttribute("leftMetamodel", leftMetamodel);
		EcoreMetamodel rightMetamodel = ecoreMetamodelService.findOne(right_metamodel_id);
		model.addAttribute("rightMetamodel", rightMetamodel);
		List<Metric> leftMetrics = metricRepository.findByArtifactId(new ObjectId(leftMetamodel.getId())); 
		List<Metric> rightMetrics = metricRepository.findByArtifactId(new ObjectId(rightMetamodel.getId()));
		leftMetamodel.getMetrics().addAll(leftMetrics);
		rightMetamodel.getMetrics().addAll(rightMetrics);
		/*
		 * Similarity Relations
		 */
		SimilarityRelation similarityRelation = similarityRelationService.findOneByArtifacts(leftMetamodel, rightMetamodel);
		model.addAttribute("similarityRelation", similarityRelation);
		CosineSimilarityRelation cosineSimilarityRelation = cosineSimilarityRelationService.findOneByArtifacts(leftMetamodel, rightMetamodel);
		model.addAttribute("cosineSimilarityRelation", cosineSimilarityRelation);
		DiceSimilarityRelation diceSimilarityRelation = diceSimilarityRelationService.findOneByArtifacts(leftMetamodel, rightMetamodel);
		model.addAttribute("diceSimilarityRelation", diceSimilarityRelation);
		ContainmentRelation containmentRelation = containmentRelationService.findOneByArtifacts(leftMetamodel, rightMetamodel);
		model.addAttribute("containmentRelation", containmentRelation);
		/*
		 * List of metamodels
		 */
		List<EcoreMetamodel> ecoreMetamodelList = ecoreMetamodelService.findAllWithPublicByUser(user);
		model.addAttribute("ecoreMetamodelList", ecoreMetamodelList);
		
		return "private.use.metamodel_compare";
	}

	@Override
	public String uploadNewArtifactStart(Model model) {
		super.uploadNewArtifactStart(model);
		return "private.use.metamodel_upload";
	}
	
	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String uploadNewArtifact(
			Model model,@ModelAttribute EcoreMetamodel artifact,
			@RequestParam("artifactfile") MultipartFile file) throws IOException {
		EcoreMetamodel m = artifact;
		byte[] bytes = file.getBytes();
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName(file.getOriginalFilename());
		gfm.setByteArray(bytes);
		m.setCreated(new Date());
		m.setAuthor(user);
		m.setFile(gfm);
		EcoreMetamodel result = ecoreMetamodelService.create(m);
		boolean report = false;
		if(result != null){
			report = true;
		}
		model.addAttribute("report", report);
		return "redirect:/private/my_artifacts";
	}
	
	@Override
	public String artifactList(Model model) {
		model.addAttribute("type", EcoreMetamodel.class.getSimpleName());
		return super.artifactList(model);
	}
}
