package org.mdeforge.client;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.Workspace;

public class UpdateTest {

	private static MDEForgeClient c;

	@BeforeClass
	public static void setup() throws Exception {
		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
	}
	@Ignore
	@Test
	public void updateWorkspace(){
		Workspace w = new Workspace();
		w.setId("5514aa53d4c67eee3e2c1b12");
		w.setName("asd");
	}
}
