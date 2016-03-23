package org.mdeforge.client;

import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Workspace;

import java.io.File;

public class TestClient {

	private static ModelService modelService;


	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ProjectService projectService; 
	private static WorkspaceService workspaceService; 
	@BeforeClass
	public static void setup() throws Exception {
		modelService = new ModelService("http://localhost:8080/mdeforge/", "Admin", "test123");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin", "test123");
		projectService = new ProjectService("http://localhost:8080/mdeforge/", "Admin", "test123");
		workspaceService = new WorkspaceService("http://localhost:8080/mdeforge/", "Admin", "test123");
	}

	@Ignore
	@Test
	public void testAddModelAndroid () {
		try {
			Model model = new Model();
			model.setName("android2.model");
			model.setOpen(true);
			Project p = new Project();
			p.setId("5514b9a6d4c6c379396fe8b9");
			//p.getArtifacts().add(emm);
			EcoreMetamodel emm = new EcoreMetamodel();
			emm.setId("551baa6545686c2b30f1351f");
			ConformToRelation c2 = new ConformToRelation();
			c2.setFromArtifact(model);
			c2.setToArtifact(emm);
			model.getRelations().add(c2);
			model.getProjects().add(p);
			modelService.addModel(model, "temp/android.model");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	@Test	
	public void testSimilarityEcoreMetamodel () {
		try {
			System.out.println(ecoreMetamodelService.getEcoreMetamodelSimilarity("552657f44568f64e28214b2d", "552657f44568f64e28214b31"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	@Test	
	public void testMetricEcoreMetamodel () {
		try {
			System.out.println(ecoreMetamodelService.getEcoreMetamodelMetrics("552bbd07d4c659da8e19ec99"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	@Test	
	public void testValidateEcoreMetamodel () {
		try {
			System.out.println(ecoreMetamodelService.validateEcoreMetamodels("551d16574568e6d8551fc5af"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void createWorkspaceAndProject () {
		try {

			Project p = new Project();
			p.setName("Salvi project Test");
			Workspace w = new Workspace();
			w.setName("Salvi workspace Test");
			
			workspaceService.addWorkspace(w);
			List<Workspace> ws = workspaceService.getWorkspaces();
			
			w = ws.get(0);
			p.getWorkspaces().add(w);
			w.getProjects().add(p);
			projectService.addProject(p);
			System.out.println("project created");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAddEcoreMetamodel () {
		try {
			EcoreMetamodel emm = new EcoreMetamodel();
			emm.setName("BookStore2");
//			List<String> tags = Arrays.asList("DB, DataBase, Relational".split(","));
//			emm.setTags(tags);
			emm.setDescription("Describes the basic structure of a book store");
			emm.setAuthors("Antonio Salvi");
			ecoreMetamodelService.addEcoreMetamodel(emm, "temp/trashTemp/bookStore.ecore");
			System.out.println("Metamodel Saved!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testAddModel(){
		try {
			EcoreMetamodel mm = ecoreMetamodelService.getEcoreMetamodel("56e40913e4b044537d4d50bd");
			Model m = new Model();
			m.setName("FirstLibrary");
//			List<String> tags = Arrays.asList("DB, Data, DataBase, Data Base, Relational".split(","));
//			m.setTags(tags);
//			m.setDescription("Rapresent a model of a general Relational DB");
			m.setAuthors("Antonio Salvi");
			ConformToRelation rel = new ConformToRelation();
			rel.setFromArtifact(m);
			rel.setToArtifact(mm);
			m.getRelations().add(rel);
			modelService.addModel(m, "temp/trashTemp/bookStore.xml");
			System.out.println("Model Saved!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testAddModels(){
		try {
			EcoreMetamodel mm = ecoreMetamodelService.getEcoreMetamodel("56e404f3e4b044537d4d4f76");
			
			File modelsDirectory = new File("/home/majacdg/git/MDEForge/mdeforge.client/temp/ReVO");
			if (modelsDirectory.isDirectory())
				for (File file : modelsDirectory.listFiles()){
					String fileName = file.getName();
					String[] array1 = fileName.split("_");
					String name1 = array1[2];
					String[] array2 = name1.split("\\$");
					String name = array2[0];

					Model m = new Model();
					m.setName(name);
					m.setAuthors("Fabiano Izzo");
					ConformToRelation rel = new ConformToRelation();
					rel.setFromArtifact(m);
					rel.setToArtifact(mm);
					m.getRelations().add(rel);
					modelService.addModel(m, file.getAbsolutePath());
					System.out.println(name + " Saved!!!");
				}
			System.out.println("THE END");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testLoadJsonMetamodel(){
		try {
			String json = ecoreMetamodelService.getEcoreMetamodelJsonFormat("56b98728e4b0a5cd5984305b");
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testSearch(){
		try {
			List<Artifact> artifacts = ecoreMetamodelService.orderedSearch("context");
			if (artifacts.size()>0)
				printArtifacts(artifacts);
			else
				System.out.println("No Results");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testCreateIndex(){
		try {
			String result = ecoreMetamodelService.createIndex();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printArtifacts(List<Artifact> artifacts){
		for (Artifact artifact : artifacts) {
			System.out.println(artifact.getName());
			System.out.println(artifact.getDescription());
			System.out.println(artifact.getTags());
			System.out.println(artifact.getAuthors());
			System.out.println();
		}
	}
//
//	@Ignore
//	@Test
//	public void testSearch(){
//		try {
//			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "maja", "majacdg");
//			List<Artifact> artifacts = c.orderedSearch("data");
//			printArtifacts(artifacts);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private void printArtifacts(List<Artifact> artifacts){
//		for (Artifact artifact : artifacts) {
//			System.out.println(artifact.getName());
//			System.out.println(artifact.getDescription());
//			System.out.println(artifact.getTags());
//			System.out.println(artifact.getAuthors());
//			System.out.println();
//		}
//	}

}