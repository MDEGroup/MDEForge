package org.mdeforge.presentation.backend;

import java.beans.PropertyEditorSupport;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

public abstract class ArtifactPrivateController<T extends Artifact> {

	@Autowired
	protected CRUDArtifactService<T> artifactService;
	@Autowired
	protected GridFileMediaService gridFileMediaService;
	@Autowired 
	protected User user;
	@Autowired
	protected ProjectService projectService;
	@Autowired
	protected UserService userService;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public ArtifactPrivateController() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@RequestMapping(value = "/artifact", method =  RequestMethod.GET )
	public String details(Model model, @RequestParam String artifact_id) {
		Artifact artifact = artifactService.findOneById(artifact_id, user);
		model.addAttribute("artifact", artifact);
		String pathToDownload = gridFileMediaService.getFilePath(artifact);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("artifactFile", ecoreMetamodelFile);
		return "private.use.artifact_details";
	}
	
	@RequestMapping(value = "/artifact_project", method =  RequestMethod.GET )
	public String detailsByProject(Model model, @RequestParam String project_id, @RequestParam String artifact_id) {
		Artifact artifact = artifactService.findOneInProject(project_id, artifact_id, user);
		model.addAttribute("artifact", artifact);
		String pathToDownload = gridFileMediaService.getFilePath(artifact);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("artifactFile", ecoreMetamodelFile);
		return "private.use.artifact_details";
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void download(@RequestParam String artifact_id,
			HttpServletResponse response) throws IOException {

		Artifact atlMetamodel = artifactService.findOneById(artifact_id, user);
		InputStream is = gridFileMediaService.getFileInputStream(atlMetamodel);
		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename=" + atlMetamodel.getName());
		org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}
	
	@RequestMapping(value = "/artifacts", method = { RequestMethod.GET })
	public String artifactList(Model model) {
		model.addAttribute("all",false);
		return "private.use.artifacts_list";
	}
	@RequestMapping(value = "/artifactsWithGenerated", method = { RequestMethod.GET })
	public String artifactListWithGenerated(Model model) {
		model.addAttribute("all",true);
		return "private.use.artifacts_list_generated";
	}
	
	@RequestMapping(value = "/artifactsRest", method = { RequestMethod.GET })
	public  @ResponseBody ResponseGrid<T> artifactListPaginated(
			@ModelAttribute RequestGrid requestGrid) {
		return artifactService.findMyArtifacts(user, requestGrid, false);
	}
	@RequestMapping(value = "/artifactsRestWithGenerated", method = { RequestMethod.GET })
	public  @ResponseBody ResponseGrid<T> artifactListPaginatedWithGenerated(
			@ModelAttribute RequestGrid requestGrid) {
		return artifactService.findMyArtifacts(user, requestGrid);
	}
	@RequestMapping(value = "/upload", method = { RequestMethod.GET })
	public String uploadNewArtifactStart(Model model) {
		T emm;
		try {
			emm = clazz.newInstance();
			model.addAttribute("artifact",emm);
			List<Project> pl = projectService.findByUser(user);
			model.addAttribute("projecList",pl);
			List<User> userList = userService.findAll();
			model.addAttribute("userList", userList);
		} catch (InstantiationException e) {
			
		} catch (IllegalAccessException e) {
		}
		return "private.use.metamodel.upload_page";
		
	}
	@RequestMapping(value = "/list/shared_and_public", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<T> getSharedAndPublicEcoreMetamodel () {
		List<T> list = artifactService.findAllWithPublicByUser(user);
		return list;
	}
	@RequestMapping(value = "/list", method=RequestMethod.GET, 
			produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<T> getSharedEcoreMetamodel () {
		List<T> list = artifactService.findAllSharedByUser(user);
		return list;
	}
	@InitBinder
	public void initBinder(WebDataBinder binder, WebRequest request) {

	        binder.registerCustomEditor(Project.class, "projects", new PropertyEditorSupport() {
	         @Override
	         public void setAsText(String id) {
	            setValue((id.equals(""))?null:projectService.findOne(id));
	         }
	     });
	        binder.registerCustomEditor(User.class, "shared", new PropertyEditorSupport() {
	        	@Override
	        	public void setAsText(String id) {
	        		setValue((id.equals(""))?null:userService.findOne(id));
	        	}
	        });
	}
}
