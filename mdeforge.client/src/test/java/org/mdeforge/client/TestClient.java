package org.mdeforge.client;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.EcoreMetamodel;
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
			c.addProject(p);
			System.out.println("project created");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAddEcoreMetamodel () {
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "maja", "majacdg");
			
			Project p = new Project();
			p.setId("551414e26dd0d289c2e2b990");
			EcoreMetamodel emm = new EcoreMetamodel();
			emm.setName("ProvaSalvi");
			emm.setUri("temp/Database.ecore");
			emm.getProjects().add(p);
			//p.getArtifacts().add(emm);
			c.addEcoreMetamodel(emm);
			System.out.println("Fatto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
