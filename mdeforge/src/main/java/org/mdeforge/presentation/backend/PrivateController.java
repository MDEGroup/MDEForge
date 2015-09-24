package org.mdeforge.presentation.backend;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
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
	
	

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String dashboard() throws IOException {

		return "private.use.dashboard";
	}

	@RequestMapping(value = "/shared_artifacts", method = { RequestMethod.GET })
	public String sharedArtifacts(Model model) throws IOException {
		
		//TODO togliere la findAll e sostituirla solo con gli artefatti SHARED
		List<Artifact> sharedArtifactList = artifactService.findAll();
		
		model.addAttribute("sharedArtifactList",sharedArtifactList);
		
		return "private.use.shared_artifacts";
	}

	@RequestMapping(value = "/shared_projects", method = { RequestMethod.GET })
	public String sharedProjects(Model model) throws IOException {
		
		//TODO togliere la findAll e sostituirla solo con i progetti SHARED
		List<Project> sharedProjectList = projectService.findAll();
		
		model.addAttribute("sharedProjectList",sharedProjectList);
		
		return "private.use.shared_projects";
	}
	
	
}
