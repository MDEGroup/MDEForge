package test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.client.MDEForgeClient;
import org.mdeforge.client.ModelService;
import org.mdeforge.client.ProjectService;
import org.mdeforge.client.WorkspaceService;

public class testArtifact {

	@Test
	public void test() {
		WorkspaceService ws;
		ProjectService ps;
		try {
			ws = new WorkspaceService("http://localhost:8080/mdeforge/", "Admin",
					"test123");
			
			Workspace w = new Workspace();
			w.setDescription("Fabio Workspace");
			w.setName("Fabio Workspace");
		 
			
			User u = new User();
			
			u.setUsername("ciao");
			w.setOwner(u);
			
			
			
			ws.addWorkspace(w);
			
			
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
