package org.mdeforge.presentation.backend;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.eclipse.epsilon.ecl.parse.Ecl_EolParserRules.newExpression_return;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.ATLTransformationForm;
import org.mdeforge.business.model.form.ModelForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/private/Model")
public class ModelController {
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;

	@Autowired
	private ModelService modelService;
	@Autowired
	private UserService userService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private User user;
	@Autowired
	private ProjectService projectService;
	@RequestMapping(value = "/list", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Model> getEcoreMetamodel () {
		List<org.mdeforge.business.model.Model> list = modelService.findAllWithPublicByUser(user);
		return list;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
	public String ecoreMetamodel(org.springframework.ui.Model model, @RequestParam String id) {
		
		Model ecoreMM = modelService.findOneById(id, user);		
		
		model.addAttribute("ecoreMM", ecoreMM);
		return "ecore_metamodel.details";
	}
	@RequestMapping(value = "/model_details", method = { RequestMethod.GET })
	public String modelDetails(org.springframework.ui.Model model, @RequestParam String model_id) {

		Model modelEMF = modelService.findOneById(model_id, user);
		model.addAttribute("model", modelEMF);
		
		String pathToDownload = gridFileMediaService.getFilePath(modelEMF);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("modelFile", ecoreMetamodelFile);

		return "private.use.model_details";
	}
	@RequestMapping(value = "/upload", method = { RequestMethod.GET })
	public String uploadATLTransormatiomStart(org.springframework.ui.Model model) throws IOException {
		ModelForm modelIn = new ModelForm();
		model.addAttribute("model", modelIn);
		List<Project> pl = projectService.findByUser(user);
		model.addAttribute("projecList", pl);
		List<EcoreMetamodel> el = ecoreMetamodelService
				.findAllWithPublicByUser(user);
		model.addAttribute("metamodelList", el);
		List<User> userList = userService.findAll();
		model.addAttribute("userList", userList);
		return "private.use.model.upload_page";
	}

	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String uploadNewATLTransormatiom(org.springframework.ui.Model model,
			@ModelAttribute ("transformation") ModelForm modelIn,
			@RequestParam("modelfile") MultipartFile file)
			throws IOException {
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(modelIn);
		ctr.setToArtifact(modelIn.getConformToRelation());
		modelIn.getRelations().add(ctr);
		Model m = new Model();
		BeanUtils.copyProperties(modelIn, m);
		byte[] bytes = file.getBytes();
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName(file.getOriginalFilename());
		gfm.setByteArray(bytes);
		m.setCreated(new Date());
		m.setAuthor(user);
		m.setFile(gfm);
		modelService.create(m);
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
		binder.registerCustomEditor(EcoreMetamodel.class, "conformToRelation",
				new PropertyEditorSupport() {
					@Override
					public void setAsText(String id) {
						setValue((id.equals("")) ? null : ecoreMetamodelService
								.findOne(id));
					}
				});
	}
}
