package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.mdeforge.business.ATLTransformationService;
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
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.utils.JavaBeanCopier;
import org.mdeforge.business.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
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
	@Autowired
	private UserService userService;
	@Value("#{cfgproperties[basePath]}")
	private  String basePath;

	private static String resourcesBasePath = "/initialWorkspace/Families2Persons/";
	private static String resourcesInputMM = "Families.ecore";
	private static String resourcesOutputMM = "Persons.ecore";
	private static String resourcesAtlTransfomation = "Families2Persons.atl";
	private static String resourcesInputModel = "sample-Families.xmi";

	private static String nMMInput = "_Families.ecore";
	private static String nMMOutput = "_Persons.ecore";
	private static String nModelInput = "_sample-Families.xmi";
	private static String nTransformationInput = "_Families2Person.atl";
	private static String tTagIn = "Families";
	private static String tTagOut = "Persons";
	private static String descriptionMMInput = "This basic metamodel allows to represent families. A family, "
			+ "which has a name, is composed of several persons identified by their firstname. ";
	private static String descriptionMMOutput = "This simple metamodel describes a person (firstname, surname). It is used for illustration purposes.";
	private static String descriptionModelInput = "For use in demo";
	private static String descriptionTransformation = "The goal is to present a use case of a model to model transformation written in ATL."
			+ "This use case is named: Families to Persons" + " Initially we have a text describing a list of families."
			+ "We want to transform this into another text describing a list of persons.";

	private static String nWorkspace = "Family to Person Workspace";
	private static String descriptionWorkspace = "Example of workspace";
	private static String nProject = "Family to Person Project";
	private static String descriptionProject = "Example of Project";

	@Override
	public void createDemoNewRegistration(User u) {
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
		
		w.setDescription(descriptionWorkspace);
		w.setName(nWorkspace);
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
		List<Artifact> artifactList = new ArrayList<Artifact>();

		Project p = new Project();
		p.setOwner(u);
		p.setName(nProject);
		p.setDescription(descriptionProject);
		artifactList = createArtifactsForDemo(u);
		p.setArtifacts(artifactList);
		projectService.create(p, u);
	

		return p;
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

		String familiesToPersonsPath = getClass().getResource(resourcesBasePath).getPath();
		String userName = u.getUsername();
		String nameMMInput = userName + nMMInput;
		String nameMMOutput = userName + nMMOutput;
		String nameModelInput = userName + nModelInput;
		String nameTransformationInput = userName + nTransformationInput;
		Utils utils = new Utils();
		/*
		 * CREATION PATH basePath/username/
		 * In this directory We are going to put user's artifacts
		 * we suppose the username is unique.
		 * We need this variable because We use that to create a path as: 
		 * basePath/username/
		 * basePath in our case is C:\development\MDEForge\forgedir
		 */
		String customPath=userName+File.separator;
		System.out.println(customPath);
		utils.createPath(basePath+File.separator+customPath);
		
			try {
			/*
			 * CREATION FAMILIES ARTIFACT
			 */

			GridFileMedia inputMMgfm = gridFileMediaService.createObjectFromFile(
					familiesToPersonsPath + resourcesInputMM, utils.getNameFromPath(resourcesInputMM));
			System.out.println("UTILS----------->: "+utils.getNameFromPath(resourcesInputMM));
			System.out.println("FAMILY----------->: "+familiesToPersonsPath + resourcesInputMM);
			EcoreMetamodel families = new EcoreMetamodel();
			families.setName(nameMMInput);
			families.setDescription(descriptionMMInput);
			families.setOpen(false);
			families.setFile(inputMMgfm);
			/*
			 * test
			 */

			families.setAuthor(u);
//			WE need set the file name as "username/nomefile(customPath+resourcesInputMM)" because the directory is created with 
//			FileSystemResource resource = new FileSystemResource(basePath + gdf.getFileName()); (it's inside GridFileMediaServiceImpl)
//			when we call ecoreMetamodelService.create(families); 
			
			families.getFile().setFileName(customPath+resourcesInputMM);			
			ecoreMetamodelService.create(families);
			artifactList.add(families);
			
			
			/*
			 * CREATION PERSONS ARTIFACT
			 */

			GridFileMedia outputMMgfm = gridFileMediaService.createObjectFromFile(
					familiesToPersonsPath + resourcesOutputMM, utils.getNameFromPath(resourcesOutputMM));
			EcoreMetamodel persons = new EcoreMetamodel();
			persons.setName(nameMMOutput);
			persons.setDescription(descriptionMMOutput);
			persons.setOpen(false);
			persons.setFile(outputMMgfm);
			persons.setAuthor(u);
			persons.getFile().setFileName(customPath+resourcesOutputMM);	
			ecoreMetamodelService.create(persons);
			artifactList.add(persons);
			
//			ResourceSet rs = new ResourceSetImpl();
//			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());

			/*
			 * CREATION MODEL INPUT ARTIFACT
			 */

			GridFileMedia inputModelGfm = gridFileMediaService.createObjectFromFile(
					familiesToPersonsPath + resourcesInputModel, utils.getNameFromPath(resourcesInputModel));
			org.mdeforge.business.model.Model simpleFamilyModel = new org.mdeforge.business.model.Model();
			simpleFamilyModel.setName(nameModelInput);
			simpleFamilyModel.setOpen(false);
			simpleFamilyModel.setDescription(descriptionModelInput);

			simpleFamilyModel.setFile(inputModelGfm);

			ConformToRelation ctr = new ConformToRelation();
			ctr.setFromArtifact(simpleFamilyModel);
			ctr.setToArtifact(families);
			simpleFamilyModel.getRelations().add(ctr);
			simpleFamilyModel.setAuthor(u);
			simpleFamilyModel.getFile().setFileName(customPath+resourcesInputModel);	
			modelService.create(simpleFamilyModel);
			artifactList.add(simpleFamilyModel);

			/*
			 * CREATION TRANSFORMATION ARTIFACT
			 */

			GridFileMedia transformationGfm = gridFileMediaService.createObjectFromFile(
					familiesToPersonsPath + resourcesAtlTransfomation,
					utils.getNameFromPath(resourcesAtlTransfomation));
			ATLTransformation transformation = new ATLTransformation();
			transformation.setName(nameTransformationInput);
			transformation.setDescription(descriptionTransformation);

			CoDomainConformToRelation cdct = new CoDomainConformToRelation();
			cdct.setFromArtifact(transformation);
			cdct.setToArtifact(persons);
			cdct.setReferenceModelName(tTagOut);
			cdct.setName("OUT");

			DomainConformToRelation dct = new DomainConformToRelation();
			dct.setFromArtifact(transformation);
			dct.setToArtifact(families);
			dct.setReferenceModelName(tTagIn);
			dct.setName("IN");
			transformation.getRelations().add(cdct);
			transformation.getRelations().add(dct);
			transformation.setOpen(false);
			transformation.setFile(transformationGfm);
			transformation.setAuthor(u);
			transformation.getFile().setFileName(customPath+resourcesAtlTransfomation);	
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



}
