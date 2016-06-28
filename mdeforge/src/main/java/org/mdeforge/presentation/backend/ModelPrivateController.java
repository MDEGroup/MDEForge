package org.mdeforge.presentation.backend;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.ModelForm;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

//@Controller
//@RequestMapping("/private/Model")
public class ModelPrivateController extends ArtifactPrivateController<Model> {
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;

	@Autowired
	private ModelService modelService;
	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	
	public String details(org.springframework.ui.Model model, @RequestParam String artifact_id) {
		super.details(model, artifact_id);
		return "private.use.model_details";
	}
	
	@RequestMapping(value = "/artifact_project", method =  RequestMethod.GET )
	public String detailsByProject(org.springframework.ui.Model model, @RequestParam String project_id, @RequestParam String artifact_id) {
		super.detailsByProject(model, project_id, artifact_id);
		return "private.use.model_details";
	}

	public String uploadNewArtifactStart(org.springframework.ui.Model model) {
		super.uploadNewArtifactStart(model);
		List<EcoreMetamodel> el = ecoreMetamodelService
				.findAllWithPublicByUser(user);
		model.addAttribute("metamodelList", el);
		return "private.use.model_upload";
	}
	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
	public String uploadNewATLTransormatiom(org.springframework.ui.Model model,
			@ModelAttribute ("artifact") ModelForm modelIn,
			@RequestParam("artifactfile") MultipartFile file)
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
		m = modelService.create(m);
		return "/private/EcoreMetamodel/artifact?artifact_id=" + m.getId();
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
	@Override
	public String artifactList(org.springframework.ui.Model model) {
		model.addAttribute("type", EcoreMetamodel.class.getSimpleName());
		return super.artifactList(model);
	}
}
