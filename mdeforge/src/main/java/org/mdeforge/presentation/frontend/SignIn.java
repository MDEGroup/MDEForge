package org.mdeforge.presentation.frontend;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.ArtifactNotFoundException;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.DemoService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.VerificationToken;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.common.spring.security.OnRegistrationCompleteEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.node.ObjectNode;
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
	ApplicationEventPublisher eventPublisher;
	@Autowired
	GridFsTemplate operations;
	@Autowired
	private DemoService demoService;
	

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

	


}
