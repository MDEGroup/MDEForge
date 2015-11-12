package org.mdeforge.presentation.backend;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.ATLTransformationForm;
import org.springframework.beans.BeanUtils;
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
@RequestMapping("/private/ATLTransformation")
public class ATLPrivateController {

	@Autowired
	private ATLTransformationService aTLTransformationService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private User user;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;

	@RequestMapping(value = "/list/shared_and_public", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ATLTransformation> getSharedAndPublicEcoreMetamodel () {
		List<ATLTransformation> list = aTLTransformationService.findAllWithPublicByUser(user);
		return list;
	}
	@RequestMapping(value = "/list", method=RequestMethod.GET, 
			produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ATLTransformation> getSharedEcoreMetamodel () {
		List<ATLTransformation> list = aTLTransformationService.findAllSharedByUser(user);
		return list;
	}

	@RequestMapping(value = "/transformation_details", method = { RequestMethod.GET })
	public String transformationDetails(Model model,
			@RequestParam String transformation_id) {

		ATLTransformation atlTransformation = aTLTransformationService
				.findOneById(transformation_id, user);

		model.addAttribute("atlTransformation", atlTransformation);

		String pathToDownload = gridFileMediaService
				.getFilePath(atlTransformation);
		File atlTransformationFile = new File(pathToDownload);
		model.addAttribute("atlTransformationFile", atlTransformationFile);

		return "private.use.transformation_details";
	}

	@RequestMapping(value = "/execute_transformation", method = { RequestMethod.GET })
	public String transformationExecution(Model model,
			@RequestParam String transformation_id) {

		// TODO ancora da implementare!

		ATLTransformation atlTransformation = aTLTransformationService
				.findOne(transformation_id);

		model.addAttribute("atlTransformation", atlTransformation);
		String pathToDownload = gridFileMediaService
				.getFilePath(atlTransformation);
		File atlTransformationFile = new File(pathToDownload);
		List<org.mdeforge.business.model.Model> models = modelService
				.findByTransformation(atlTransformation);
		model.addAttribute("atlTransformationFile", atlTransformationFile);
		model.addAttribute("models", models);

		return "private.use.transformation_execution";
	}

	@RequestMapping(value = "/result_transformation", method = { RequestMethod.POST })
	public String transformationResult(Model model,
			@RequestParam String transformation_id,
			@RequestParam List<String> models_in) {
		List<org.mdeforge.business.model.Model> models = new ArrayList<org.mdeforge.business.model.Model>();
		for (String modelId : models_in) {
			models.add(modelService.findOne(modelId));
		}
		ATLTransformation atl = aTLTransformationService
				.findOne(transformation_id);
		List<org.mdeforge.business.model.Model> result = aTLTransformationService
				.execute(atl, models, user);
		model.addAttribute("models", result);
		return "private.use.result_transformation";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.GET })
	public String uploadATLTransormatiomStart(Model model) throws IOException {
		ATLTransformationForm transformation = new ATLTransformationForm();
		model.addAttribute("transformation", transformation);
		List<Project> pl = projectService.findByUser(user);
		model.addAttribute("projecList", pl);
		List<EcoreMetamodel> el = ecoreMetamodelService
				.findAllWithPublicByUser(user);
		model.addAttribute("metamodelList", el);
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "private.use.transformation.upload_page";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String uploadNewATLTransormatiom(Model model,
			@ModelAttribute ("transformation") ATLTransformationForm transformation,
			//@ModelAttribute ArrayList<DomainConformToRelation> domainConformToRelationList,
			@RequestParam("transformationfile") MultipartFile file)
			throws IOException {

		transformation.getRelations().addAll(transformation.getDomainConformToRelation());
		transformation.getRelations().addAll(transformation.getCoDomainConformToRelation());
		ATLTransformation m = new ATLTransformation();
		BeanUtils.copyProperties(transformation, m);
		byte[] bytes = file.getBytes();
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName(file.getOriginalFilename());
		gfm.setByteArray(bytes);
		m.setCreated(new Date());
		m.setAuthor(user);
		m.setFile(gfm);
		ATLTransformation result = aTLTransformationService.create(m);

		boolean report = false;
		if (result != null) {
			report = true;
		}

		model.addAttribute("report", report);

		return "redirect:/private/my_artifacts";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {
		binder.registerCustomEditor(Project.class, "projects",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String id) {
						setValue((id.equals("")) ? null : projectService
								.findOne(id));
					}
				});
		binder.registerCustomEditor(User.class, "shared",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String id) {
						setValue((id.equals("")) ? null : userService
								.findOne(id));
					}
				});
	}
}
