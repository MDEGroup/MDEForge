package org.mdeforge.presentation.frontend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.DemoService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.VerificationToken;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.utils.Utils;
import org.mdeforge.common.spring.security.OnRegistrationCompleteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.gridfs.GridFSFile;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

@Controller
public class SignIn {

	Logger logger = LoggerFactory.getLogger(SignIn.class);
	@Autowired
	protected AuthenticationManager authenticationManager;
	@Autowired
	ReCaptchaImpl reCaptcha;
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	@Autowired
	ApplicationEventPublisher eventPublisher;
	@Autowired
	GridFsTemplate operations;
	@Autowired
	private DemoService demoService;
	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Value("#{cfgproperties[basePath]}")
	private String basePath;

	@RequestMapping(value = "/signin", method = { RequestMethod.GET })
	public String signIn(Model model) {
		// call method for adding new workspace and Project as an example
		// User u = new User();
		// List<Workspace> workspaceList = new ArrayList<Workspace>();
		// workspaceList.add(initialWorkspace(u));
		// u.setWorkspaces(workspaceList);
		// model.addAttribute("user", u);

		return "public.signin";
	}

	@RequestMapping(value = "/signin", method = { RequestMethod.POST })
	public String signInPost(Model model, @ModelAttribute("user") User user, @RequestParam("photo") MultipartFile photo,
			@RequestParam("recaptcha_challenge_field") String challangeField,
			@RequestParam("recaptcha_response_field") String responseField, HttpServletRequest request) {
		String remoteAddress = request.getServerName();
		try {
			GridFSFile s = operations.store(photo.getInputStream(), photo.getOriginalFilename(), "");
			logger.info(s.getId().toString());
			user.setImage(operations.store(photo.getInputStream(), photo.getOriginalFilename(), "").getId().toString());
		} catch (IOException e1) {
			logger.info("ERROR");
		}
		logger.info("Recapcha");
		ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(remoteAddress, challangeField, responseField);
		if (reCaptchaResponse.isValid()) {
			String appUrl = request.getContextPath();
			try {
				logger.info("Resolved");
				eventPublisher.publishEvent(new OnRegistrationCompleteEvent(user, request.getLocale(), appUrl));
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} else {

			logger.info(reCaptchaResponse.getErrorMessage());
			model.addAttribute("user", user);
			model.addAttribute("captcha", true);
			return "public.signin";
		}
		return "public.registration.request";
	}

	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
	public String confirmRegistration(HttpServletRequest request, Model model, @RequestParam("token") String token) {
		VerificationToken verificationToken = userService.getVerificationToken(token);
		if (verificationToken == null) {
			model.addAttribute("message", "The user couldn't be found!");
			return "public.registration.status";
		}
		Calendar cal = Calendar.getInstance();
		if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			model.addAttribute("message", "The token has been expired!");
			return "public.registration.status";
		}
		User user = verificationToken.getUser();
		model.addAttribute("message", "User is confirmed. Please login!");
		user.setEnabled(true);
		userService.saveRegisteredUser(user);
		/*
		 * START TO CREATE WORKSPACE AND PROJECT FOR DEMO
		 */
		demoService.createDemoNewRegistration(user);

		/*
		 * END TO CREATE WORKSPACE AND PROJECT FOR DEMO
		 */

		model.addAttribute("user", user);
		return "public.registration.status";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test() throws IOException {
		System.out.println("start test");
		
		// Project dello user jack1982te
		final String projectId = "595cc24681c15fcf524d8402";
		// final String artifacId = "594d5d8b81c10b68fe525465";
		final String userTestId = "595cc27381c15fcf524d8408";
		// workspace about test
		final String workspaceId = "595cc28881c15fcf524d848e";
		projectService.cloneProject(userTestId, projectId,workspaceId);
		
	
		System.out.println("fine test");
		
		
		return new java.util.Date().getTime() + "";
	}

	private Project cloneProject(String userId, String projectToCloneId,String workspaceId) {
		
		/*
		 * When we clone the project We need remove the old artifact and clone them next time because they are linked to by original project
		 * We need manage those case:
		 * - multiple clone 
		 * -
		 * 
		 */
		Utils utils = new Utils();
		User u = userService.findOne(userId);
		Workspace w = new Workspace();
		
		
		List<Artifact> artifactList = new ArrayList<Artifact>();
		List<Artifact> cloneArtifactList = new ArrayList<Artifact>();
		String myDate= utils.createDate("yyyyMMddHHmmss");
		w = workspaceService.findOne(workspaceId);
		Project project = projectService.findOne(projectToCloneId);
		Project projectClone = new Project();
		projectClone = project.clone();
		String nameProject = "clone_"+ myDate +"_"+ project.getName();
		artifactList = project.getArtifacts();
		

		projectClone.setOwner(u);
		projectClone.setName(nameProject);
		projectClone.setId(null);
	
		String dirUser = u.getUsername() + File.separator;

		/*
		 * WE clone the artifacts and set up:
		 * the author (user), the name of file (it's composed by
		 */
		for (Artifact artifact : artifactList) {

			GridFileMedia gfmObj = new GridFileMedia();
			String path = new String();
			String filename;

			path = gridFileMediaService.getFilePath(artifact);
			filename = utils.getNameFromPath(path);
			try {
				gfmObj = gridFileMediaService.createObjectFromFile(path, filename);
			} catch (IOException e) {
				logger.error(e.getMessage());
			}

			Artifact artifactClone = new Artifact();
			List<Project> projectClonelist = new ArrayList<Project>();
			projectClonelist = artifactClone.getProjects();
			artifactClone = artifact.clone();
			artifactClone.setFile(gfmObj);
			artifactClone.setAuthor(u);
			artifactClone.setName("clone_" + myDate +"_"+ filename);
			artifactClone.getFile().setFileName(dirUser + "clone_" + myDate +"_"+ filename);
			artifactClone.setId(null);
			

			artifactClone.getProjects().clear();
			gridFileMediaService.getFilePathFromContent(gfmObj);
			 artifactService.create(artifactClone);
			cloneArtifactList.add(artifactClone);

		}
//		deleting old artifacts
		projectClone.getArtifacts().clear();

		List<Workspace> listWorkspace = new ArrayList<Workspace>();
		listWorkspace.add(w);
		projectClone.getWorkspaces().remove(workspaceId);
		projectClone.setWorkspaces(listWorkspace);
		projectClone.setArtifacts(cloneArtifactList);
//		 workspaceService.addProjectInWorkspace(idProject, idWorkspace, user)
		projectService.create(projectClone, u);
		
		return projectClone;
		

	}

}
