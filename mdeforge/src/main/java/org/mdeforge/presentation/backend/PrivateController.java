package org.mdeforge.presentation.backend;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/private")
public class PrivateController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	@Autowired
	private User user;
	

	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET })
	public String dashboard() throws IOException {

		return "private.use.dashboard";
	}

	@RequestMapping(value = "/shared_artifacts", method = { RequestMethod.GET })
	public String sharedArtifacts(Model model) throws IOException {
		
		List<Artifact> sharedArtifactList = artifactService.findSharedNoProject(user);
		model.addAttribute("sharedArtifactList",sharedArtifactList);
		return "private.use.shared_artifacts";
	}

	@RequestMapping(value = "/shared_projects", method = { RequestMethod.GET })
	public String sharedProjects(Model model) throws IOException {
		
		//TODO togliere la findAll e sostituirla solo con i progetti SHARED
		List<Project> sharedProjectList = projectService.findSharedNoWorkspace(user);
		model.addAttribute("sharedProjectList",sharedProjectList);
		
		return "private.use.shared_projects";
	}

	@RequestMapping(value = "/my_artifacts", method = { RequestMethod.GET })
	public String myArtifacts(Model model) throws IOException {
		
		//TODO togliere la findAll e sostituirla solo con i progetti CHE POSSIEDE L'UTENTE
		List<Artifact> myArtifactsList = artifactService.findAll();
		
		model.addAttribute("myArtifactsList",myArtifactsList);
		
		return "private.use.my_artifacts";
	}
	
	
}
