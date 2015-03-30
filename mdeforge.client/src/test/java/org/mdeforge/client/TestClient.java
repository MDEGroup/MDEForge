package org.mdeforge.client;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Workspace;

public class TestClient {

	private MDEForgeClient c;

	@Ignore
	@Test
	public void createWorkspaceAndProject () {
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "maja", "majacdg");

			Project p = new Project();
			p.setName("Salvi project Test");
			Workspace w = new Workspace();
			w.setName("Salvi workspace Test");
			
			c.addWorkspace(w);
			List<Workspace> ws = c.getWorkspaces();
			
			w = ws.get(0);
			p.getWorkspaces().add(w);
			w.getProjects().add(p);
			c.addProject(p);
			System.out.println("project created");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testAddEcoreMetamodel () {
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "maja", "majacdg");
			Project p = c.getProjects().get(0);
			EcoreMetamodel emm = new EcoreMetamodel();
			emm.setName("Prova Salvi");
			List<String> tags = Arrays.asList("DB, DataBase, Data Base, Relational".split(","));
			emm.setTags(tags);
			emm.setDescription("Describes the basic structure of a general Relational DB");
			emm.setAuthors("Metamodels Authors");
			emm.getProjects().add(p);
			c.addEcoreMetamodel(emm, "temp/Database.ecore");
			System.out.println("Metamodel Saved!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void testAddModel(){
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "maja", "majacdg");
			Project p = c.getProjects().get(0);
			String idMM = p.getArtifacts().get(0).getId();
			Model m = new Model();
			m.setName("ModelSalvi");
			List<String> tags = Arrays.asList("DB, DataBase, Data Base, Relational".split(","));
			m.setTags(tags);
			m.setDescription("Rapresent a model of a general Relational DB");
			m.setAuthors("Models Authors");
			m.getProjects().add(p);
			c.addModel(m, "temp/My.database", idMM);
			System.out.println("Model Saved!!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateIndex(){
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "maja", "majacdg");
			String result = c.createIndex();
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
