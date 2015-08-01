package org.mdeforge.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Workspace;

public class ProjectTest {

	private static ATLTransformationService atlTransformationService; 
	private static ETLTransformationService etlTransformationService; 
	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ProjectService projectService; 
	private static WorkspaceService workspaceService; 
	@BeforeClass
	public static void setup() throws Exception {
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "Admin", "test123");
		etlTransformationService = new ETLTransformationService("http://localhost:8080/mdeforge/", "Admin", "test123");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin", "test123");
		projectService = new ProjectService("http://localhost:8080/mdeforge/", "Admin", "test123");
		workspaceService = new WorkspaceService("http://localhost:8080/mdeforge/", "Admin", "test123");
	}
	
	@Test
	public void getProjects() throws Exception {
		List<Project> projectList = projectService.getProjects();
		for (Project project : projectList) {
			System.out.println(project.getName());
		}
	}
	@Test
	public void getProject() throws Exception {
		Project project = projectService.getProject("5514b9a6d4c6c379396fe8b9");
		System.out.println("Secondo" + project.getName());
	}
	
}
