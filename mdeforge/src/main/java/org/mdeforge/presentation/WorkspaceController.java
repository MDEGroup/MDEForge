package org.mdeforge.presentation;

import java.util.List;

import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//TODO cambiare il mapping
@RequestMapping("/private/workspace")
public class WorkspaceController {

	@Autowired
	private WorkspaceService workspaceService;
	
	@Autowired
	private User user;
	
	
	
	@RequestMapping("")
	public String details(Model model, @RequestParam String id) {	
		
		Workspace workspace = workspaceService.findById(id, user);		
		model.addAttribute("workspace", workspace);		
		
		System.out.println(workspace.getProjects().size());
		
		return "workspace.details";
	}
	
	

	@RequestMapping("/list")
	public String elenco(Model model) {		
		List<Workspace> workspaces_list = workspaceService.findAllByUsernamme(user);		
		model.addAttribute("workspaces_list", workspaces_list);		
		return "workspace.list";
	}

	@RequestMapping(value = "/create", method = { RequestMethod.GET })
	public String create_start(Model model) {
		Workspace workspace = new Workspace();
		model.addAttribute("workspace", workspace);
		return "workspace.create";
	}

	@RequestMapping(value = "/create", method = { RequestMethod.POST })
	public String create(@ModelAttribute Workspace workspace, Model model) {
		workspace.setOwner(user);		
		workspaceService.create(workspace);
		return "redirect:/private/workspace/list";
	}
	
	
	@RequestMapping(value = "/update", method = { RequestMethod.GET })
	public String update_start(@RequestParam("id") String id, Model model) {
		Workspace workspace = workspaceService.findOne(id);		
		model.addAttribute("workspace", workspace);
		return "workspace.update";
	}
	
	
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public String update(@ModelAttribute Workspace workspace) {		
		workspace.setOwner(user);
		workspaceService.update(workspace);
		return "redirect:/private/workspace/list";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete_start(@RequestParam("id") String id, Model model) {
		Workspace workspace = workspaceService.findOne(id);
		model.addAttribute("workspace", workspace);
		return "workspace.delete";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute Workspace workspace) {
		workspaceService.delete(workspace);
		return "redirect:/private/workspace/list";
	}
	

	@RequestMapping("/findelementspaginated")
	public @ResponseBody ResponseGrid<Workspace> findelementspaginated(@ModelAttribute RequestGrid requestGrid) {
		return workspaceService.findAllPaginated(requestGrid);

	}

}
