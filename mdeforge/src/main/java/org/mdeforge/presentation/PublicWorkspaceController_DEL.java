package org.mdeforge.presentation;

import java.io.IOException;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.EditorService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Editor;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/public")
public class PublicWorkspaceController_DEL {
	
//	@Autowired
//	private MetamodelService metamodelService;
//	@Autowired
//	private WorkspaceService workspaceService;
//	@Autowired
//	private ModelService modelService;
//	@Autowired
//	@Qualifier("Artifact")
//	private ArtifactService artifactService;
//	@Autowired
//	private EditorService editorService;
//	@Autowired
//	private User user;
//
//	
//	@RequestMapping("/metamodel/list")
//	public String metamodel_list(org.springframework.ui.Model model) {
//		model.addAttribute("workspaces", workspaceService.findAll());
//		
//		return "public.metamodel.list";
//	}
//	
//	@RequestMapping(value = "/metamodel/create", method = { RequestMethod.GET })
//	public String createmetamodel_start(org.springframework.ui.Model model) {
//		Metamodel metamodel = new Metamodel();
//		model.addAttribute("metamodel", metamodel);
//		model.addAttribute("workspaces", workspaceService.findAll());
//		return "public.metamodel.create";
//	}
//	
//	@RequestMapping(value = "/metamodel/create", method = { RequestMethod.POST })
//	public String createmetamodel(@ModelAttribute Metamodel metamodel,@ RequestParam("metamodelfile") MultipartFile file) throws IOException {
////		metamodel.setFile(IOUtils.toString(file.getInputStream()));
//		metamodelService.upload(metamodel, file);
//		return "redirect:/public/metamodel/list";		
//	}
//	
//	@RequestMapping(value = "/metamodel/update", method = { RequestMethod.GET })
//	public String updatemetamodel_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Metamodel metamodel = metamodelService.findByName(name);
//		model.addAttribute("metamodel", metamodel);
//		return "public.metamodel.update";
//	}
//	
//	@RequestMapping(value = "/metamodel/update", method = { RequestMethod.POST })
//	public String updatemetamodel(@ModelAttribute Metamodel metamodel, @RequestParam("metamodelfile") MultipartFile file) throws IOException {
//		if(file.isEmpty()){
//			Metamodel metamodelOLD = metamodelService.findByName(metamodel.getName());
//			metamodel.setFile(metamodelOLD.getFile());
//		}else{
//			//metamodel.setFile(IOUtils.toString(file.getInputStream()));
//		}
//		
//		metamodelService.update(metamodel);
//		return "redirect:/public/metamodel/list";
//	}
//	
//	@RequestMapping(value = "/metamodel/delete", method = RequestMethod.GET)
//	public String deletemetamodel_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Metamodel metamodel = metamodelService.findByName(name);
//		model.addAttribute("metamodel", metamodel);
//		return "public.metamodel.delete";
//	}
//	
//	@RequestMapping(value = "/metamodel/delete", method = RequestMethod.POST)
//	public String deletemetamodel(@ModelAttribute Metamodel metamodel) {
//		metamodelService.delete(metamodel);
//		return "redirect:/public/metamodel/list";
//	}
//	
//	
//	
//	/*
//	 * 
//	 */
//	
//	
//	@RequestMapping("/model/list")
//	public String model_list(org.springframework.ui.Model model) {
//		return "public.model.list";
//	}
//	
//	@RequestMapping(value = "/model/create", method = { RequestMethod.GET })
//	public String createmodel_start(org.springframework.ui.Model model) {
//		Model model_forge = new Model();
//		model.addAttribute("model", model_forge);
//		return "public.model.create";
//	}
//	
//	@RequestMapping(value = "/model/create", method = { RequestMethod.POST })
//	public String createmodel(@ModelAttribute Model model,@ RequestParam("modelfile") MultipartFile file) throws IOException {
////		model.setFile(IOUtils.toString(file.getInputStream()));
//		modelService.create(model);
//		return "redirect:/public/model/list";		
//	}
//	
//	@RequestMapping(value = "/model/update", method = { RequestMethod.GET })
//	public String updatemodel_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Model model_forge = (Model) modelService.findOneByName(name, user);
//		model.addAttribute("model", model_forge);
//		return "public.model.update";
//	}
//	
//	@RequestMapping(value = "/model/update", method = { RequestMethod.POST })
//	public String updatemodel(@ModelAttribute Model model, @RequestParam("modelfile") MultipartFile file) throws IOException {
//		if(file.isEmpty()){
//			Model modelOLD = (Model) modelService.findOneByName(model.getName(), user);
//			model.setFile(modelOLD.getFile());
//		}else{
////			model.setFile(IOUtils.toString(file.getInputStream()));
//		}
//		
//		modelService.update(model);
//		return "redirect:/public/model/list";
//	}
//	
//	@RequestMapping(value = "/model/delete", method = RequestMethod.GET)
//	public String deletemodel_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Model model_forge = (Model) modelService.findOneByName(name, user);
//		model.addAttribute("model", model_forge);
//		return "public.model.delete";
//	}
//	
//	@RequestMapping(value = "/model/delete", method = RequestMethod.POST)
//	public String deletemodel(@ModelAttribute Model model) {
//		modelService.delete(model, user);
//		return "redirect:/public/model/list";
//	}
//	
//	@RequestMapping("/transformation/list")
//	public String transformation_list() {
//		return "public.transformation.list";
//	}
//	
//	@RequestMapping(value = "/transformation/create", method = { RequestMethod.GET })
//	public String createtransformation_start(org.springframework.ui.Model model) {
//		Transformation transformation = new Transformation();
//		model.addAttribute("transformation", transformation);
//		return "public.transformation.create";
//	}
//	
//	@RequestMapping(value = "/transformation/create", method = { RequestMethod.POST })
//	public String createtransformation(@ModelAttribute Transformation transformation,@ RequestParam("transformationfile") MultipartFile file) throws IOException {
//		//transformation.setFile(IOUtils.toString(file.getInputStream()));
//		artifactService.create(transformation);
//		return "redirect:/public/transformation/list";		
//	}
//	
//	@RequestMapping(value = "/transformation/update", method = { RequestMethod.GET })
//	public String updatetransformation_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Transformation transformation = (Transformation) artifactService.findOneByName(name, user);
//		model.addAttribute("transformation", transformation);
//		return "public.transformation.update";
//	}
//	
//	@RequestMapping(value = "/transformation/update", method = { RequestMethod.POST })
//	public String updatetransformation(@ModelAttribute Transformation transformation, @RequestParam("transformationfile") MultipartFile file) throws IOException {
//		if(file.isEmpty()){
//			Transformation transformationOLD = (Transformation) artifactService.findOneByName(transformation.getName(), user);
//			transformation.setFile(transformationOLD.getFile());
//		}else{
////			transformation.setFile(IOUtils.toString(file.getInputStream()));
//		}
//		
//		artifactService.update(transformation);
//		return "redirect:/public/transformation/list";
//	}
//	
//	@RequestMapping(value = "/transformation/delete", method = RequestMethod.GET)
//	public String deletetransformation_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Transformation transformation = (Transformation) artifactService.findOneByName(name, user);
//		model.addAttribute("transformation", transformation);
//		return "public.transformation.delete";
//	}
//	
//	@RequestMapping(value = "/transformation/delete", method = RequestMethod.POST)
//	public String deletetransformation(@ModelAttribute Transformation transformation) {
//		artifactService.delete(transformation, user);
//		return "redirect:/public/transformation/list";
//	}
//
//
//	
//	
//	
//	
//	
//	@RequestMapping("/editor/list")
//	public String editor_list() {
//		return "public.editor.list";
//	}
//	
//	@RequestMapping(value = "/editor/create", method = { RequestMethod.GET })
//	public String createeditor_start(org.springframework.ui.Model model) {
//		Editor editor = new Editor();
//		model.addAttribute("editor", editor);
//		return "public.editor.create";
//	}
//	
//	@RequestMapping(value = "/editor/create", method = { RequestMethod.POST })
//	public String createeditor(@ModelAttribute Editor editor,@ RequestParam("editorfile") MultipartFile file) throws IOException {
////		editor.setFile(IOUtils.toString(file.getInputStream()));
//		editorService.upload(editor);
//		return "redirect:/public/editor/list";		
//	}
//	
//	@RequestMapping(value = "/editor/update", method = { RequestMethod.GET })
//	public String updateeditor_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Editor editor = editorService.findByName(name);
//		model.addAttribute("editor", editor);
//		return "public.editor.update";
//	}
//	
//	@RequestMapping(value = "/editor/update", method = { RequestMethod.POST })
//	public String updateeditor(@ModelAttribute Editor editor, @RequestParam("editorfile") MultipartFile file) throws IOException {
//		if(file.isEmpty()){
//			Editor editorOLD = editorService.findByName(editor.getName());
//			editor.setFile(editorOLD.getFile());
//		}else{
////			editor.setFile(IOUtils.toString(file.getInputStream()));
//		}
//		
//		editorService.update(editor);
//		return "redirect:/public/editor/list";
//	}
//	
//	@RequestMapping(value = "/editor/delete", method = RequestMethod.GET)
//	public String deleteeditor_start(@RequestParam("name") String name, org.springframework.ui.Model model) {
//		Editor editor = editorService.findByName(name);
//		model.addAttribute("editor", editor);
//		return "public.editor.delete";
//	}
//	
//	@RequestMapping(value = "/editor/delete", method = RequestMethod.POST)
//	public String deleteeditor(@ModelAttribute Editor editor) {
//		editorService.delete(editor);
//		return "redirect:/public/editor/list";
//	}
//	
//	@RequestMapping("/findmetamodelspaginated")
//	public @ResponseBody ResponseGrid<Metamodel> findmetamodelspaginated(@ModelAttribute RequestGrid requestGrid) {
//		return metamodelService.findAllPaginated(requestGrid);
//	}
//	
//	@RequestMapping("/findmodelspaginated")
//	public @ResponseBody ResponseGrid<org.mdeforge.business.model.Model> findmodelspaginated(@ModelAttribute RequestGrid requestGrid) {
////		return modelService.findAllPaginated(requestGrid);
//		return null;
//	}
//	
//	@RequestMapping("/findtransformationspaginated")
//	public @ResponseBody ResponseGrid<Transformation> findtransformationspaginated(@ModelAttribute RequestGrid requestGrid) {
//		return null;//artifactService.findAllPaginated(requestGrid);
//	}
//	
//	@RequestMapping("/findeditorspaginated")
//	public @ResponseBody ResponseGrid<Editor> findeditorspaginated(@ModelAttribute RequestGrid requestGrid) {
//		return editorService.findAllPaginated(requestGrid);
//	}

}
