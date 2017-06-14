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
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private ATLTransformationService atlTransformationService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/signin", method = { RequestMethod.GET })
	public String signIn(Model model) {
		// call method for adding new workspace and Project as an example
		System.out.println("Sono dentro signin");
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
		createDemoNewRegistration(user);

		/*
		 * END TO CREATE WORKSPACE AND PROJECT FOR DEMO
		 */

		model.addAttribute("user", user);
		return "public.registration.status";
	}

		/**
		 * This is a function with that I create a Demo for a new User
		 * @param u
		 */
	private void createDemoNewRegistration(User u) {
		List<Workspace> workspaceList = new ArrayList<Workspace>();
		workspaceList.add(createWorkspaceForDemo(u));
		u.setWorkspaces(workspaceList);

	}

	/**
	 * This is a function with that I can initialize a new workspace for DEMO.
	 * 
	 * @param u
	 * 
	 * @return Workspace
	 */

	private Workspace createWorkspaceForDemo(User u) {
		Workspace w = new Workspace();
		w.setOwner(u);
		w.setDescription("Example of workspace");
		w.setName("Family to Person Workspace");
		List<Project> projectList = new ArrayList<Project>();
		projectList.add(createProjectForDemo(u));
		w.setProjects(projectList);
		workspaceService.create(w);

		return w;
	}

	/**
	 * This is a function with that I can initialize a new project for DEMO.
	 * 
	 * @return Project
	 */

	private Project createProjectForDemo(User u) {
		Project p = new Project();
		p.setOwner(u);
		p.setName("Family to Person Project");
		p.setDescription("Example of Project");
		p.setArtifacts(createArtifactsForDemo(u));
		// create an object project into database
		projectService.create(p, u);

		return p;
	}

	private String getNameFromPath(String path) {
		Path p = Paths.get(path);
		String file = p.getFileName().toString();
		return file;

	}

	private List<Artifact> createArtifactsForDemo(User u) {
		/*
		 * In the our case We get the artifacts from a static directory We
		 * created in the project before the directory is gotten with : String
		 * familiesToPersonsPath =
		 * getClass().getResource("/initialWorkspace/Families2Persons/").getPath
		 * ();
		 */
		List<Artifact> artifactList = new ArrayList<Artifact>();
		String resourcesBasePath = "/initialWorkspace/Families2Persons/";
		String resourcesInputMM = "/Families.ecore";
		String resourcesOutputMM = "/Persons.ecore";
		String resourcesAtlTransfomation = "/Families2Persons.atl";
		String resourcesInputModel = "/sample-Families.xmi";
		String familiesToPersonsPath = getClass().getResource(resourcesBasePath).getPath();
		try {
			/*
			 * CREATION FAMILIES ARTIFACT
			 */

			GridFileMedia inputMMgfm = gridFileMediaService
					.createObjectFromFile(familiesToPersonsPath + resourcesInputMM, getNameFromPath(resourcesInputMM));

			EcoreMetamodel families = new EcoreMetamodel();
			families.setName("Families");
			families.setDescription("This basic metamodel allows to represent families. A family, "
					+ "which has a name, is composed of several persons identified by their firstname. ");
			families.setOpen(false);
			families.setFile(inputMMgfm);
			families.setAuthor(u);
			ecoreMetamodelService.create(families);
			artifactList.add(families);
			/*
			 * CREATION PERSONS ARTIFACT
			 */

			GridFileMedia outputMMgfm = gridFileMediaService.createObjectFromFile(
					familiesToPersonsPath + resourcesOutputMM, getNameFromPath(resourcesOutputMM));
			EcoreMetamodel persons = new EcoreMetamodel();
			persons.setName("Persons");
			persons.setDescription(
					"This simple metamodel describes a person (firstname, surname). It is used for illustration purposes.");
			persons.setOpen(false);
			persons.setFile(outputMMgfm);
			persons.setAuthor(u);
			ecoreMetamodelService.create(persons);
			System.out.println("artefatto Person: " + persons.getId());
			artifactList.add(persons);

			/*
			 * CREATION MODEL INPUT ARTIFACT
			 */

			GridFileMedia inputModelGfm = gridFileMediaService.createObjectFromFile(
					familiesToPersonsPath + resourcesInputModel, getNameFromPath(resourcesInputModel));

			org.mdeforge.business.model.Model simpleFamilyModel = new org.mdeforge.business.model.Model();
			simpleFamilyModel.setName("Simple families model");
			simpleFamilyModel.setOpen(false);
			simpleFamilyModel.setDescription("For use in demo");

			simpleFamilyModel.setFile(inputModelGfm);

			ConformToRelation ctr = new ConformToRelation();
			ctr.setFromArtifact(simpleFamilyModel);
			ctr.setToArtifact(families);
			simpleFamilyModel.getRelations().add(ctr);

			simpleFamilyModel.setAuthor(u);
			modelService.create(simpleFamilyModel);
			artifactList.add(simpleFamilyModel);

			/*
			 * CREATION TRANSFORMATION ARTIFACT
			 */

			GridFileMedia transformationGfm = gridFileMediaService.createObjectFromFile(
					familiesToPersonsPath + resourcesAtlTransfomation, getNameFromPath(resourcesAtlTransfomation));

			ATLTransformation transformation = new ATLTransformation();
			transformation.setName("Families2Preson");
			transformation.setDescription(
					"The goal is to present a use case of a model to model transformation written in ATL."
							+ "This use case is named: Families to Persons"
							+ " Initially we have a text describing a list of families."
							+ "We want to transform this into another text describing a list of persons.);");

			transformation.setOpen(false);
			CoDomainConformToRelation cdct = new CoDomainConformToRelation();
			cdct.setFromArtifact(transformation);
			cdct.setToArtifact(persons);
			cdct.setReferenceModelName("Persons");
			cdct.setName("OUT");

			DomainConformToRelation dct = new DomainConformToRelation();
			dct.setFromArtifact(transformation);
			dct.setToArtifact(families);
			dct.setReferenceModelName("Families");
			dct.setName("IN");
			transformation.getRelations().add(cdct);
			transformation.getRelations().add(dct);
			transformation.setOpen(false);
			transformation.setFile(transformationGfm);
			transformation.setAuthor(u);
			atlTransformationService.create(transformation);
			artifactList.add(transformation);
		} catch (Exception e) {
			// TODO: handle exception
		}

		for (Artifact artifact : artifactList) {
			System.out.println("Artifatto nome: " + artifact.getName());
		}
		return artifactList;

	}

	@RequestMapping(value = "/testDemo", method = { RequestMethod.GET })
	public String testDemo(Model model) {
		// call method for adding new workspace and Project as an example
		User u = new User();
		u = userService.findOne("55ae5947d4c677485a267bca");
		List<Workspace> workspaceList = new ArrayList<Workspace>();
		workspaceList.add(createWorkspaceForDemo(u));
		u.setWorkspaces(workspaceList);
		model.addAttribute("user", u);

		return "public.signin";
	}

}
