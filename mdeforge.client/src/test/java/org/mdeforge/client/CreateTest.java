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

public class CreateTest {

	private static ATLTransformationService atlTransformationService; 
	private static ETLTransformationService etlTransformationService; 
	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ProjectService projectService; 
	private static WorkspaceService workspaceService; 
	@BeforeClass
	public static void setup() throws Exception {
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		etlTransformationService = new ETLTransformationService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		projectService = new ProjectService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		workspaceService = new WorkspaceService("http://localhost:8080/mdeforge/", "maja", "majacdg");
	}
	
	@Ignore
	@Test
	public void addWorkspace() throws Exception {
		Workspace w = new Workspace();
		w.setName("Francesco WorkSpace");
		w.setDescription("Test Project");
		workspaceService.addWorkspace(w);
	}
	
	@Ignore
	@Test
	public void addProject() throws Exception {
		Project p = new Project();
		p.setName("Progetto di prova");
		p.setWorkspaces(new ArrayList<Workspace>());
		List<Workspace> ws = workspaceService.getWorkspaces();
		for (Workspace workspace : ws) {
			p.getWorkspaces().add(workspace);
		}
		projectService.addProject(p);
	}
	
	@Test
	public void addEcoreMetamodel() throws Exception {
		EcoreMetamodel emm = new EcoreMetamodel();
		emm.setName("AndroidAppMM.ecore");
		List<String> tags = Arrays.asList("DB, DataBase, Data Base, Relational".split(","));
		emm.setTags(tags);
		emm.setDescription("Describes the basic structure of a general Relational DB");
		emm.setAuthors("Metamodels Authors");
		emm.setOpen(false);	
		List<Workspace> worspaces = workspaceService.getWorkspaces();
		for (Workspace project : worspaces) {
			emm.getWorkspaces().add(project);
		}
		ecoreMetamodelService.addEcoreMetamodel(emm,"temp/AndroidAppMM.ecore");	
	}
	
	@Ignore
	@Test
	public void testAddProjectToWorkspace() {
		try {
			Workspace w = workspaceService.getWorkspace("5514aa53d4c67eee3e2c1b12");
			Project p = new Project();
			p.setName("Test bascio");
			p.getWorkspaces().add(w);
			projectService.addProject(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void testArtifactToWorkspace() {
		try {
			Workspace w = workspaceService.getWorkspace("5514aa53d4c67eee3e2c1b12");
			ETLTransformation p = new ETLTransformation();
			p.setName("Android2Web");
			p.getWorkspaces().add(w);
			etlTransformationService.addETLTransformation(p, "temp/Android2Web.etl");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void addATLTransformation() throws Exception {
		ATLTransformation emm = new ATLTransformation();
		emm.setName("BibTeX2DocBook");
		emm.setOpen(true);	
		atlTransformationService.addATLTransformation(emm,"temp/BibTeX2DocBook.atl");
	}
}
