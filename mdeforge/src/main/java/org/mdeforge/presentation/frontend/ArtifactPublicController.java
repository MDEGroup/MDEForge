package org.mdeforge.presentation.frontend;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


public abstract class ArtifactPublicController<T extends Artifact> {

	@Autowired
	protected CRUDArtifactService<T> artifactService;
	@Autowired
	protected GridFileMediaService gridFileMediaService;
	@Autowired 
	protected User user;

	@RequestMapping(value = "/artifact", method =  RequestMethod.GET )
	public String details(Model model, @RequestParam String artifact_id) {
		Artifact artifact = artifactService.findOnePublic(artifact_id);
		model.addAttribute("artifact", artifact);
		String pathToDownload = gridFileMediaService.getFilePath(artifact);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("artifactFile", ecoreMetamodelFile);
		return "public.browse.artifact_details";
	}
	@RequestMapping(value = "/share", method =  RequestMethod.GET )
	public String metamodelShareDetails(Model model, @RequestParam String metamodel_id) {
		Artifact ecoreMetamodel = artifactService.findOnePublic(metamodel_id);
		model.addAttribute("ecoreMetamodel", ecoreMetamodel);
		String pathToDownload = gridFileMediaService.getFilePath(ecoreMetamodel);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("ecoreMetamodelFile", ecoreMetamodelFile);
		return "private.use.metamodel_details";
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void downloadMetamodel(@RequestParam String artifact_id,
			HttpServletResponse response) throws IOException {
		Artifact ecoreMetamodel = artifactService
				.findOne(artifact_id);
		InputStream is = gridFileMediaService
				.getFileInputStream(ecoreMetamodel);
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ ecoreMetamodel.getName() + ".ecore");
		org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}

	@RequestMapping(value = "/artifacts", method = { RequestMethod.GET })
	public String artifactList(Model model) {
		List<T> ecoreMetamodelsList = artifactService.findAll();
		model.addAttribute("ecoreMetamodelsList", ecoreMetamodelsList);
		return "public.browse.artifacts_list";
	}

		
	@RequestMapping(value = "/artifact_name", method = { RequestMethod.GET })
	public String artifactFromName(@RequestParam String name,Model model) throws IOException{
		Artifact ecoreMetamodel = artifactService.findOneByName(name);
		return "redirect:/private/ATLTransformation/transformation_details?transformation_id=" + ecoreMetamodel.getId();
	}
}
