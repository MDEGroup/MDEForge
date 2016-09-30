package org.mdeforge.presentation.frontend;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/public")
public class PublicController {

	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private ATLTransformationService aTLTransformationService;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {
		return "public.index";
	}

	@RequestMapping(value = "/about", method = { RequestMethod.GET })
	public String about() {
		return "public.about";
	}

	@RequestMapping(value = "/members", method = { RequestMethod.GET })
	public String members() {
		return "public.members";
	}

	@RequestMapping(value = "/publications", method = { RequestMethod.GET })
	public String publications() {
		return "public.publications";
	}

	@RequestMapping("/login")
	public String login() {
		return "public.login";
	}
	@RequestMapping(value = "/exist_user", method = { RequestMethod.GET })
	public @ResponseBody boolean existUser(@RequestParam("username") String username){
		return (userService.findOneByUsername(username)==null)?false:true;
	}
	@RequestMapping(value = "/exist_mail", method = { RequestMethod.GET })
	public @ResponseBody boolean existEmail(@RequestParam("email") String email){
		return (userService.findOneByEmail(email)==null)?false:true;
	}
	
	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET })
	public String dashboard(Model model) throws IOException {

		long numUsers = userService.countUsers();
		long numATL = aTLTransformationService.countAll();
		long numEcore = ecoreMetamodelService.countAll();
		long numModel = modelService.countAll();
		long numProject = projectService.countAll();
		List<EcoreMetamodel> recentsEcore = ecoreMetamodelService.findRecentArtifacts();
		List<ATLTransformation> recentsATL = aTLTransformationService.findRecentArtifacts();
		List<org.mdeforge.business.model.Model> recentsModel = modelService.findRecentArtifacts();
		model.addAttribute("numArtifacts", numATL + numEcore + numModel);
		model.addAttribute("numUsers", numUsers);
		model.addAttribute("numATL", numATL);
		model.addAttribute("numEcore", numEcore);
		model.addAttribute("numModel", numModel);
		model.addAttribute("numProject", numProject);
		model.addAttribute("recentsEcore", recentsEcore);
		model.addAttribute("recentsATL", recentsATL);
		model.addAttribute("recentsModel", recentsModel);
		return "public.browse.dashboard";
	}
}
