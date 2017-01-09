package org.mdeforge.presentation.frontend;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Comment;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		model.addAttribute("comment", new Comment());
		String pathToDownload = gridFileMediaService.getFilePath(artifact);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("artifactFile", ecoreMetamodelFile);
		return "public.browse.artifact_details";
	}
	
	@RequestMapping(value = "/share", method = { RequestMethod.GET })
	public @ResponseBody HttpEntity<String> metamodelShareDetails(Model model, @RequestParam String metamodel_id) {
		try {
			artifactService.addUserInArtifact(user.getId(), metamodel_id, user);
			return  new ResponseEntity<String>("ok", HttpStatus.OK);
		} catch (BusinessException e) {
			return  new ResponseEntity<String>("ko", HttpStatus.UNPROCESSABLE_ENTITY);
		}
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
				+ ecoreMetamodel.getFile().getFileName());
		org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}

	@RequestMapping(value = "/artifacts", method = { RequestMethod.GET })
	public String artifactList(Model model) {
		return "public.browse.artifacts_list";
	}

	@RequestMapping(value = "/artifactsRest", method = { RequestMethod.GET })
	public  @ResponseBody ResponseGrid<T> artifactListPaginated(
			@ModelAttribute RequestGrid requestGrid) {
		return artifactService.findAll(requestGrid);
	}
	
	@RequestMapping(value = "/comment", method = { RequestMethod.POST })
	public @ResponseBody HttpEntity<String> createComment(@ModelAttribute Comment comment, @RequestParam(value="idArtifact") String idArtifact, Model model) {
		try{
			comment.setUser(user);
			artifactService.addComment(comment,idArtifact);
		}catch(Exception e){
			return new ResponseEntity<String>("Errors", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@RequestMapping(value = "/comment", method = { RequestMethod.DELETE })
	public @ResponseBody HttpEntity<String> deleteComment(@RequestParam(value="idComment") String idComment, @RequestParam(value="idArtifact") String idArtifact, Model model) {
		try{
			artifactService.deleteComment(idComment,idArtifact);
		}catch(Exception e){
			return new ResponseEntity<String>("Errors", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	@RequestMapping(value = "/artifact_name", method = { RequestMethod.GET })
	public String artifactFromName(@RequestParam String name,Model model) throws IOException{
		Artifact ecoreMetamodel = artifactService.findOneByName(name);
		return "redirect:/private/ATLTransformation/transformation_details?transformation_id=" + ecoreMetamodel.getId();
	}
	
}
