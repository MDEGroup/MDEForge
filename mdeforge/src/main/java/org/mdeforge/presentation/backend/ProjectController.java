package org.mdeforge.presentation.backend;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.EditorService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Editor;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private WorkspaceService workspaceService;
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private User user;
	@Autowired
	private MetamodelService metamodelService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	@Autowired
	private EditorService editorService;
	
	
	@RequestMapping("/list")
	public String elenco(org.springframework.ui.Model model, @RequestParam("workspacename") String workspacename) {
		model.addAttribute("workspacename",workspacename);
		return "project.list";
	}
	
	@RequestMapping(value = "/create", method = { RequestMethod.GET })
	public String create_start(@RequestParam("workspacename") String workspacename, org.springframework.ui.Model model) {
		Project project = new Project();
		project.getWorkspaces().add(workspaceService.findByName(workspacename));
		model.addAttribute("project", project);
		
		return "private.use.project";
	}

	@RequestMapping(value = "/create", method = { RequestMethod.POST })
	public String create(@ModelAttribute Project project, org.springframework.ui.Model model) {
		projectService.create(project, user);
//		for(Workspace w : project.getWorkspaces())
//		{
//			Workspace workspace = workspaceService.findById(w.getId());
//			model.addAttribute("workspacename", workspace.getName());
//		}
		return "redirect:/project/list";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
		Project project = projectService.findByName(name);
		model.addAttribute("project", project);
		return "project.delete";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute Project project, org.springframework.ui.Model model) {
		projectService.delete(project, user);
//		for(Workspace w : project.getWorkspaces())
//		{
//			Workspace workspace = workspaceService.findById(w.getId());
//			model.addAttribute("workspacename", workspace.getName());
//		}
		return "redirect:/project/list";
	}
	
	
	@RequestMapping(value = "/update", method = { RequestMethod.GET })
	public String update_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
		Project project = projectService.findByName(name);
		model.addAttribute("project", project);
		return "project.update";
	}
	
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public String update(@ModelAttribute Project project, org.springframework.ui.Model model) {
		projectService.update(project, user);
//		for(Workspace w : project.getWorkspaces())
//		{
//			Workspace workspace = workspaceService.findById(w.getId());
//			model.addAttribute("workspacename", workspace.getName());
//		}
		return "redirect:/project/list";
	}
	
	@RequestMapping("/findelementspaginated")
	public @ResponseBody ResponseGrid<Project> findelementspaginated(@ModelAttribute RequestGrid requestGrid) {
		return projectService.findAllPaginated(requestGrid);
	}


	
	
	
	@RequestMapping("/detail")
	public String artifactlist(org.springframework.ui.Model model, @RequestParam("projectname") String projectname) {
		model.addAttribute("projectname",projectname);
		return "project.detail";
	}
	
	
	
	@RequestMapping(value = "/metamodel/create", method = { RequestMethod.GET })
	public String createmetamodel_start(@RequestParam("projectname") String projectname, org.springframework.ui.Model model) {
		Metamodel metamodel = new Metamodel();
		Project project = projectService.findByName(projectname);
		metamodel.getProjects().add(project);
		model.addAttribute("metamodel", metamodel);
		return "project.metamodel.create";
	}
	
//	@RequestMapping(value = "/metamodel/create", method = { RequestMethod.POST })
//	public String createmetamodel(@ModelAttribute Metamodel metamodel, @RequestParam("metamodelfile") MultipartFile file, org.springframework.ui.Model model) throws IOException {
////	s	metamodel.setFile(IOUtils.toString(file.getInputStream()));
//		metamodelService.upload(metamodel,file);
//		if(!metamodel.getProjects().isEmpty())
//		{
//			Project project = projectService.findById(metamodel.getProjects().iterator().next().getId(), user);
//			model.addAttribute("projectname",project.getName());
//		}
//		return "redirect:/project/detail";		
//	}
//	
//	@RequestMapping(value = "/metamodel/update", method = { RequestMethod.GET })
//	public String updatemetamodel_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Metamodel metamodel = metamodelService.findByName(name);
//		model.addAttribute("metamodel", metamodel);
//		return "project.metamodel.update";
//	}
//	
//	@RequestMapping(value = "/metamodel/update", method = { RequestMethod.POST })
//	public String updatemetamodel(@ModelAttribute Metamodel metamodel, @RequestParam("metamodelfile") MultipartFile file, org.springframework.ui.Model model) throws IOException {
//		if(file.isEmpty()){
//			Metamodel metamodelOLD = metamodelService.findByName(metamodel.getName());
//			metamodel.setFile(metamodelOLD.getFile());
//		}else{
////			metamodel.setFile(IOUtils.toString(file.getInputStream()));
//		}
//		
//		metamodelService.update(metamodel);
////		Project project = projectService.findById(metamodel.getProject().getId());
////		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";
//	}
//	
//	@RequestMapping(value = "/metamodel/delete", method = RequestMethod.GET)
//	public String deletemetamodel_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Metamodel metamodel = metamodelService.findByName(name);
//		model.addAttribute("metamodel", metamodel);
//		return "project.metamodel.delete";
//	}
//	
//	@RequestMapping(value = "/metamodel/delete", method = RequestMethod.POST)
//	public String deletemetamodel(@ModelAttribute Metamodel metamodel, org.springframework.ui.Model model) {
//		if(!metamodel.getProjects().isEmpty())
//		{
//			Project project = projectService.findById(metamodel.getProjects().iterator().next().getId(), user);
//			model.addAttribute("projectname",project.getName());
//		}
//		metamodelService.delete(metamodel);
//		return "redirect:/project/detail";
//	}
//	
//	@RequestMapping("/findmetamodelspaginated")
//	public @ResponseBody ResponseGrid<Metamodel> findmetamodelspaginated(@ModelAttribute RequestGrid requestGrid) {
//		return metamodelService.findAllPaginated(requestGrid);
//	}

	
	
	
	
	/*
	 * 
	 */
	
//	@RequestMapping(value = "/model/create", method = { RequestMethod.GET })
//	public String createmodel_start(@RequestParam("projectname") String projectname, org.springframework.ui.Model model) {
//		Model model_forge = new Model();
//		Project project = projectService.findByName(projectname);
//		model_forge.getProjects().add(project);
//		model.addAttribute("model", model_forge);
//		return "project.model.create";
//	}
//	
//	@RequestMapping(value = "/model/create", method = { RequestMethod.POST })
//	public String createmodel(@ModelAttribute Model model_forge, @RequestParam("modelfile") MultipartFile file, org.springframework.ui.Model model) throws IOException {
////		model_forge.setFile(IOUtils.toString(file.getInputStream()));
//		modelService.create(model_forge);
//		for (Project p : model_forge.getProjects()) {
//			Project project = projectService.findById(p.getId(), user);
//			model.addAttribute("projectname",project.getName());
//		}
//		
//		return "redirect:/project/detail";		
//	}
	
//	@RequestMapping(value = "/model/update", method = { RequestMethod.GET })
//	public String updatemodel_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Model model_forge = (Model) modelService.findOneByName(name, user);
//		model.addAttribute("model", model_forge);
//		return "project.model.update";
//	}
//	
//	@RequestMapping(value = "/model/update", method = { RequestMethod.POST })
//	public String updatemodel(@ModelAttribute Model model_forge, @RequestParam("modelfile") MultipartFile file, org.springframework.ui.Model model) throws IOException {
//		if(file.isEmpty()){
//			Model modelOLD = (Model) modelService.findOneByName(model_forge.getName(), user);
//			model_forge.setFile(modelOLD.getFile());
//		}else{
////			model_forge.setFile(IOUtils.toString(file.getInputStream()));
//		}
//		
//		modelService.update(model_forge);
//		Project project = null;
//		if(!model_forge.getProjects().isEmpty())
//			project = projectService.findById(model_forge.getProjects().iterator().next().getId(), user);
//		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";
//	}
//	
//	@RequestMapping(value = "/model/delete", method = RequestMethod.GET)
//	public String deletemodel_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Model model_forge = (Model) modelService.findOneByName(name, user);
//		model.addAttribute("model", model_forge);
//		return "project.model.delete";
//	}
//	
//	@RequestMapping(value = "/model/delete", method = RequestMethod.POST)
//	public String deletemodel(@ModelAttribute Model model_forge, org.springframework.ui.Model model) {
//		modelService.delete(model_forge, user);
//		Project project = null;
//		if(!model_forge.getProjects().isEmpty())
//			project = projectService.findById(model_forge.getProjects().iterator().next().getId(), user);
//		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";
//	}
//	
//	@RequestMapping("/findmodelspaginated")
//	public @ResponseBody ResponseGrid<Model> findmodelspaginated(@ModelAttribute RequestGrid requestGrid) {
//		//return modelService.findAllPaginated(requestGrid);
//		return null;
//	}
//	
//	
//	
//	
//	
//	
//	
//	@RequestMapping(value = "/transformation/create", method = { RequestMethod.GET })
//	public String createtransformation_start(@RequestParam("projectname") String projectname, org.springframework.ui.Model model) {
//		Transformation transformation = new Transformation();
//		Project project = projectService.findByName(projectname);
//		transformation.getProjects().add(project);
//		model.addAttribute("transformation", transformation);
//		return "project.transformation.create";
//	}
//	
//	@RequestMapping(value = "/transformation/create", method = { RequestMethod.POST })
//	public String createtransformation(@ModelAttribute Transformation transformation, @RequestParam("transformationfile") MultipartFile file, org.springframework.ui.Model model) throws IOException {
////		transformation.setFile(IOUtils.toString(file.getInputStream()));
//		artifactService.create(transformation);
//		Project project = null;
//		if(!transformation.getProjects().isEmpty())
//			project = projectService.findById(transformation.getProjects().iterator().next().getId(), user);
//		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";		
//	}
//	
//	@RequestMapping(value = "/transformation/update", method = { RequestMethod.GET })
//	public String updatetransformation_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Transformation transformation = (Transformation) artifactService.findOneByName(name, user);
//		model.addAttribute("transformation", transformation);
//		return "project.transformation.update";
//	}
//	
//	@RequestMapping(value = "/transformation/update", method = { RequestMethod.POST })
//	public String updatetransformation(@ModelAttribute Transformation transformation, @RequestParam("transformationfile") MultipartFile file, org.springframework.ui.Model model) throws IOException {
//		if(file.isEmpty()){
//			Transformation transformationOLD = (Transformation) artifactService.findOneByName(transformation.getName(), user);
//			transformation.setFile(transformationOLD.getFile());
//		}else{
////			transformation.setFile(IOUtils.toString(file.getInputStream()));
//		}
//		
//		artifactService.update(transformation);
//		Project project = null;
//		if(!transformation.getProjects().isEmpty())
//			project = projectService.findById(transformation.getProjects().iterator().next().getId(), user);
//		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";
//	}
//	
//	@RequestMapping(value = "/transformation/delete", method = RequestMethod.GET)
//	public String deletetransformation_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Transformation transformation = (Transformation) artifactService.findOneByName(name, user);
//		model.addAttribute("transformation", transformation);
//		return "project.transformation.delete";
//	}
//	
//	
//	@RequestMapping(value = "/transformation/delete", method = RequestMethod.POST)
//	public String deletetransformation(@ModelAttribute Transformation transformation, org.springframework.ui.Model model) {
//		artifactService.delete(transformation, user);
//		Project project = null;
//		if(!transformation.getProjects().isEmpty())
//			project = projectService.findById(transformation.getProjects().iterator().next().getId(), user);
//		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";
//	}
//	
//	@RequestMapping("/findtransformationspaginated")
//	public @ResponseBody ResponseGrid<Transformation> findtransformationspaginated(@ModelAttribute RequestGrid requestGrid) {
//		return null;//artifactService.findAllPaginated(requestGrid);
//	}
//
//	
//	
//	
//	
//	
//	
//	@RequestMapping(value = "/editor/create", method = { RequestMethod.GET })
//	public String createeditor_start(@RequestParam("projectname") String projectname, org.springframework.ui.Model model) {
//		Editor editor = new Editor();
//		Project project = projectService.findByName(projectname);
//		editor.getProjects().add(project);
//		model.addAttribute("editor", editor);
//		return "project.editor.create";
//	}
//	
//	@RequestMapping(value = "/editor/create", method = { RequestMethod.POST })
//	public String createeditor(@ModelAttribute Editor editor, @RequestParam("editorfile") MultipartFile file, org.springframework.ui.Model model) throws IOException {
////		editor.setFile(IOUtils.toString(file.getInputStream()));
//		editorService.upload(editor);
//		Project project = null;
//		if(!editor.getProjects().isEmpty())
//			project = projectService.findById(editor.getProjects().iterator().next().getId(), user);
//		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";		
//	}
//	
//	
//	@RequestMapping(value = "/editor/update", method = { RequestMethod.GET })
//	public String updateeditor_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Editor editor = editorService.findByName(name);
//		model.addAttribute("editor", editor);
//		return "project.editor.update";
//	}
//	
//	@RequestMapping(value = "/editor/update", method = { RequestMethod.POST })
//	public String updateeditor(@ModelAttribute Editor editor, @RequestParam("editorfile") MultipartFile file, org.springframework.ui.Model model) throws IOException {
//		if(file.isEmpty()){
//			Editor editorOLD = editorService.findByName(editor.getName());
//			editor.setFile(editorOLD.getFile());
//		}else{
////			editor.setFile(IOUtils.toString(file.getInputStream()));
//		}
//		
//		editorService.update(editor);
//		Project project = null;
//		if(!editor.getProjects().isEmpty())
//			project = projectService.findById(editor.getProjects().iterator().next().getId(), user);
//		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";
//	}
//	
//	@RequestMapping(value = "/editor/delete", method = RequestMethod.GET)
//	public String deleteeditor_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Editor editor = editorService.findByName(name);
//		model.addAttribute("editor", editor);
//		return "project.editor.delete";
//	}
//	
//	@RequestMapping(value = "/editor/delete", method = RequestMethod.POST)
//	public String deleteeditor(@ModelAttribute Editor editor, org.springframework.ui.Model model) {
//		editorService.delete(editor);
//		Project project = null;
//		if(!editor.getProjects().isEmpty())
//			project = projectService.findById(editor.getProjects().iterator().next().getId(), user);
//		model.addAttribute("projectname",project.getName());
//		return "redirect:/project/detail";
//	}
	
	@RequestMapping("/findeditorspaginated")
	public @ResponseBody ResponseGrid<Editor> findeditorspaginated(@ModelAttribute RequestGrid requestGrid) {
		return editorService.findAllPaginated(requestGrid);
	}
	
	
		

}
