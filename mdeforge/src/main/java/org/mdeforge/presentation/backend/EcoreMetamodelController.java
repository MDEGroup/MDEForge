package org.mdeforge.presentation.backend;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.bson.types.ObjectId;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.CosineSimilarityRelationService;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ContainmentRelation;
import org.mdeforge.business.model.CosineSimilarityRelation;
import org.mdeforge.business.model.DiceSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.SimilarityRelation;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.MetricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/private/EcoreMetamodel")
public class EcoreMetamodelController {
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
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
	private ProjectService projectService;
	@Autowired
	private UserService userService;
	@Autowired
	private MetricRepository metricRepository;
	
	@RequestMapping(value = "/list/shared_and_public", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EcoreMetamodel> getSharedAndPublicEcoreMetamodel () {
		List<EcoreMetamodel> list = ecoreMetamodelService.findAllWithPublicByUser(user);
		return list;
	}
	@RequestMapping(value = "/list", method=RequestMethod.GET, 
			produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EcoreMetamodel> getSharedEcoreMetamodel () {
		List<EcoreMetamodel> list = ecoreMetamodelService.findAllSharedByUser(user);
		return list;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
	public String ecoreMetamodel(Model model, @RequestParam String id) {
		
		EcoreMetamodel ecoreMM = ecoreMetamodelService.findOneById(id, user);		
		
		model.addAttribute("ecoreMM", ecoreMM);
		return "ecore_metamodel.details";
	}
	
	@RequestMapping(value = "/metamodel_details", method = { RequestMethod.GET })
	public String metamodelDetails(Model model, @RequestParam String metamodel_id) {
		
		EcoreMetamodel ecore = ecoreMetamodelService.findOneById(metamodel_id, user);
		List<Metric> metricList = metricRepository.findByArtifactId(new ObjectId(ecore.getId()));
		ecore.getMetrics().addAll(metricList);
//		ecore.getRelations().addAll(
//				similarityRelationService.findTopProximity(ecore, 5));
//		ecore.getRelations().addAll(
//				containmentRelationService.findTopProximity(ecore, 5));
//		ecore.getRelations().addAll(
//				diceSimilarityRelationService.findTopProximity(ecore, 5));
//		ecore.getRelations().addAll(
//				cosineSimilarityRelationService.findTopProximity(ecore, 5));
		model.addAttribute("ecoreMetamodel", ecore);
		String pathToDownload = gridFileMediaService.getFilePath(ecore);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("ecoreMetamodelFile", ecoreMetamodelFile);

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
	
	@RequestMapping(value = "/upload", method = { RequestMethod.GET })
	public String uploadNewMetamodelStart(Model model) throws IOException {
		EcoreMetamodel emm = new EcoreMetamodel();
		model.addAttribute("metamodel",emm);
		List<Project> pl = projectService.findByUser(user);
		model.addAttribute("projecList",pl);
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "private.use.metamodel.upload_page";
	}
	
	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String uploadNewMetamodel(
			Model model,@ModelAttribute EcoreMetamodel metamodel,
			@RequestParam("metamodelfile") MultipartFile file) throws IOException {
		
		
		EcoreMetamodel m = metamodel;
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
//	@RequestMapping(value = "/upload/inner", method = { RequestMethod.POST })
//	public @ResponseBody EcoreMetamodel uploadNewMetamodelResturnRest(
//			Model model,@ModelAttribute EcoreMetamodel metamodel,
//			@RequestParam("metamodelfile") MultipartFile file) throws IOException {
//		
//		
//		EcoreMetamodel m = metamodel;
//		byte[] bytes = file.getBytes();
//		GridFileMedia gfm = new GridFileMedia();
//		gfm.setFileName(file.getOriginalFilename());
//		gfm.setByteArray(bytes);
//		m.setCreated(new Date());
//		m.setAuthor(user);
//		m.setFile(gfm);
//		
//		EcoreMetamodel result = ecoreMetamodelService.create(m);
//		
//		boolean report = false;
//		if(result != null){
//			report = true;
//		}
//		model.addAttribute("report", report);
//		return m;
//	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {

	        binder.registerCustomEditor(Project.class, "projects", new PropertyEditorSupport() {
	         @Override
	         public void setAsText(String id) {
	            setValue((id.equals(""))?null:projectService.findOne(id));
	         }
	     });
	        binder.registerCustomEditor(User.class, "shared", new PropertyEditorSupport() {
	        	@Override
	        	public void setAsText(String id) {
	        		setValue((id.equals(""))?null:userService.findOne(id));
	        	}
	        });
	}
	
	@RequestMapping(value = "/metamodel_download", method = RequestMethod.GET)
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

}
