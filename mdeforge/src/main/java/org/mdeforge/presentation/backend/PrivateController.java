package org.mdeforge.presentation.backend;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/private")
public class PrivateController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private User user;
	
	@Autowired
	private ATLTransformationService aTLTransformationService;
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	

	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET })
	public String dashboard(Model model) throws IOException {
		
		model.addAttribute("user",user);
		
//		List<Artifact> myArtifactsList = artifactService.findMyArtifacts(user);
		List<Artifact> myArtifactsList = artifactService.findRecentArtifacts();
		model.addAttribute("myArtifactsList",myArtifactsList);
		
		List<Project> myProjectList = projectService.findRecent();
		model.addAttribute("myProjectList",myProjectList);
		
		
		long countT = aTLTransformationService.countAll();
		model.addAttribute("totalNumberOfTransformations",countT);
		
		long allMM = ecoreMetamodelService.countAll();
		model.addAttribute("totalNumberOfMetamodels",allMM);
		
		long allM = modelService.countAll();
		model.addAttribute("totalNumberOfModels",allM);
		
		long allA = artifactService.countAll();
		model.addAttribute("totalNumberOfArtifacts",allA);
		
//		List<Project> myProjectList = projectService.findSharedNoWorkspace(user);
		model.addAttribute("totalNumberOfProjects",myProjectList.size());

		return "private.use.dashboard";
	}

	@RequestMapping(value = "/shared_artifacts", method = { RequestMethod.GET })
	public String sharedArtifacts(Model model) throws IOException {
		
		List<Artifact> sharedArtifactList = artifactService.findSharedNoProject(user);
		model.addAttribute("sharedArtifactList",sharedArtifactList);
		model.addAttribute("pageName", "Shared Artifacts");
		return "private.use.shared_artifacts";
	}

	@RequestMapping(value = "/shared_projects", method = { RequestMethod.GET })
	public String sharedProjects(Model model) throws IOException {
		
		List<Project> sharedProjectList = projectService.findSharedNoWorkspace(user);
		model.addAttribute("sharedProjectList",sharedProjectList);
		
		return "private.use.shared_projects";
	}

	@RequestMapping(value = "/my_artifacts", method = { RequestMethod.GET })
	public String myArtifacts(Model model) throws IOException {
		
		List<Artifact> myArtifactsList = artifactService.findMyArtifacts(user);
		model.addAttribute("sharedArtifactList",myArtifactsList);
		model.addAttribute("pageName","My Artifacts");
		
		return "private.use.my_artifacts";
	}
	@RequestMapping(value = "/artifact/delete", method = RequestMethod.GET)
	public String deleteArtifact(@RequestParam("idArtifact") String idArtifact, org.springframework.ui.Model model) {
		Artifact artifact = artifactService.findOneById(idArtifact, user);
		artifactService.delete(artifact, user);
		return "redirect:/private/my_artifacts";
	}
	
	
}
