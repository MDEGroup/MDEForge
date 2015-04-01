package org.mdeforge.client;

import junit.framework.TestCase;

public class TestClient extends TestCase {

	private MDEForgeClient c;

//	@Test
//	public void testAddEcoreMetamodel () {
//		try {
//			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//			EcoreMetamodel emm = new EcoreMetamodel();
//			emm.setName("compare.ecore");
//			emm.setOpen(true);
//			Project p = new Project();
//			p.setId("5514b9a6d4c6c379396fe8b9");
//			//p.getArtifacts().add(emm);
//			emm.getProjects().add(p);
//			c.addEcoreMetamodel(emm, "temp/WebAppMM.ecore");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		
	public void testSimilarityEcoreMetamodel () {
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
			System.out.println(c.getEcoreMetamodelSimilarity("551baa6545686c2b30f1351f", "551baa6545686c2b30f1351f"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
