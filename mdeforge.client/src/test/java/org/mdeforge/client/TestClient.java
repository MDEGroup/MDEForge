package org.mdeforge.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Port;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.Workspace;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class TestClient extends TestCase {

	private MDEForgeClient c;

//	@Test
//	public void testProject() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		Project p = c.getProject("548027c34568f737aba2e680");
//		assertNotNull(p);
//	}
//
//	@Test
//	public void testProjects() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Project> p = c.getProjects();
//		assertNotNull(p);
//	}
//
//	@Test
//	public void testWorkspaces() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Workspace> p = c.getWorkspaces();
//		assertNotNull(p);
//	}
//
//	@Test
//	public void testWorkspace() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		Workspace p = c.getWorkspace("548024ba45688b6052584c89");
//		assertNotNull(p);
//	}
//
//	@Test
//	public void testMetamodels() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Metamodel> p = c.getMetamodels();
//		assertNotNull(p);
//	}
//
//	@Test
//	public void testTransformations() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Transformation> p = c.getTransformations();
//		assertNotNull(p);
//	}
//	
//	@Test
//	public void testMetamodel() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		Metamodel p = c.getMetamodel("54817c624568a595ae16415c");
//		assertNotNull(p);
//	}
//	@Test
//	public void testEcoreMetamodel() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		EcoreMetamodel p = c.getEcoreMetamodel("54817c624568a595ae16415c");
//		assertNotNull(p);
//	}
//	@Test
//	public void testTransformation() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		Transformation p = c.getTransformation("548175dd456828c9b18f65c5");
//		assertNotNull(p);
//	}
//	
//	@Test
//	public void testMetamodelInWorkspace() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Metamodel> workspace = c.getMetamodelsInWorkspace("5480344145682bec82bb7184");
//		assertEquals(workspace.size(), 1);
//		assertNotNull(workspace);
//	}
//	@Test
//	public void testMetamodelInProject() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Metamodel> workspace = c.getMetamodelsInProject("547c7c99d4c6ea1a0bc750f5");
//		assertNotNull(workspace);
//	}
//	@Test
//	public void testTransformationInWorkspace() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Transformation> workspace = c.getTransformationsInWorkspace("5480344145682bec82bb7184");
//		assertNotNull(workspace);
//		assertEquals(0, workspace.size());
//	}
//	@Test
//	public void testTransformationInProject() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Transformation> workspace = c.getTransformationsInProject("547c7c99d4c6ea1a0bc750f5");
//		System.out.println(workspace.size());
//		assertNotNull(workspace);
//	}
//	
//	@Test
//	public void testArtifactInProject() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Artifact> workspace = c.getArtifactsInProject("547c7c99d4c6ea1a0bc750f5");
//		for (Artifact transformation : workspace) {
//			System.out.println(transformation.getClass().getCanonicalName());
//		}
//		System.out.println(workspace.size());
//		assertNotNull(workspace);
//	}
//	@Test
//	public void testArtifactInWorkspace() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Artifact> workspace = c.getArtifactsInWorkspace("5480344145682bec82bb7184");
//		for (Artifact transformation : workspace) {
//			System.out.println(transformation.getClass().getCanonicalName());
//		}
//		System.out.println(workspace.size());
//		assertNotNull(workspace);
//	}
//	@Test
//	public void testTransformationPublic() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Transformation> workspace = c.getTransformationsPublic();
//		assertNotNull(workspace);
//	}
//	@Ignore
//	@Test
//	public void testaddMetamodel() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		List<Metric> lm = c.getEcoreMetamodelMetrics("5502f0b5e568510368e0d073");
//		for (Metric metric : lm) 
//			System.out.println(metric.getName());
//	}
//	@Test
//	public void testSimilarity() throws Exception {
//	c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//	String string = c.getEcoreMetamodelSimilarity("54d099b48252e88f947f9c7e", "54d099d18252e88f947f9d86");
//	assertNotNull(string);
//	}
	
//	@Test
//	public void testaddProject() throws Exception {
//		Workspace workspace = new Workspace();
//		workspace.setName("Antonio");
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		c.addWorkspace(workspace);
//		workspace.setId("54d1ea84dbb086289ac1ecc2");
//		Project project = new Project();
//		project.setName("Test");
//		project.setWorkspaces(new ArrayList<Workspace>());
//		project.getWorkspaces().add(workspace);
//		c.addProject(project);
//	}
//	@Test
//	public void testaddMetamodel() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		EcoreMetamodel m = new EcoreMetamodel();
//		m.setOpen(true);
//		m.setName("ATOM");
//		EcoreMetamodel m2 = new EcoreMetamodel();
//		m2.setOpen(true);
//		m2.setName("RSS");
//		ATLTransformation t = new ATLTransformation();
//		t.setOpen(true);
//		Relation dct = new DomainConformToRelation();
//		Relation cct = new CoDomainConformToRelation();
//		dct.setToArtifact(m);
//		dct.setFromArtifact(t);
//		t.getRelations().add(dct);
//		cct.setToArtifact(m2);
//		cct.setFromArtifact(t);
//		t.getRelations().add(cct);
//		c.addEcoreMetamodel(m, "ATOM.ecore");
//		c.addEcoreMetamodel(m2, "RSS.ecore");
//		c.addATLTransformation(t, "ATOM2RSS.atl");
//		
//		
//	}
//	@Test
//	public void testaddMetamodel() throws Exception {
//		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//		EcoreMetamodel m = new EcoreMetamodel();
//		m.setOpen(true);
//		m.setName("ATOM");
//		EcoreMetamodel m2 = new EcoreMetamodel();
//		m2.setOpen(true);
//		m2.setName("RSS");
//		ETLTransformation t = new ETLTransformation();
//		t.setOpen(true);
//		Relation dct = new DomainConformToRelation();
//		Relation cct = new CoDomainConformToRelation();
//		dct.setToArtifact(m);
//		dct.setFromArtifact(t);
//		t.getRelations().add(dct);
//		cct.setToArtifact(m2);
//		cct.setFromArtifact(t);
//		t.getRelations().add(cct);
//		c.addEcoreMetamodel(m, "ATOM.ecore");
//		c.addEcoreMetamodel(m2, "RSS.ecore");
//		c.addETLTransformation(t, "ATOM2RSS.atl");		
//	}	
	
	@Test
	public void testETLTransformation () {
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		ETLTransformation transformation = new ETLTransformation();
//		transformation.setName("Android2Web");
//		try {
//			String s = MDEForgeClient.readFile("temp/android2web.etl");
//			GridFileMedia gfmMmIn= new GridFileMedia();
//			gfmMmIn.setContent(s);
//			transformation.setFile(gfmMmIn);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		// model in
//		transformation.setSourceName("Source");
//		EcoreMetamodel mmIn = new EcoreMetamodel();
//		EcoreMetamodel mmOut = new EcoreMetamodel();
//		
//		
//		mmIn.setId("5502f050e568510368e0d06f");		
//		GridFileMedia gfmMmOut = new GridFileMedia();
//		
//		mmOut.setId("5502f0b5e568510368e0d073");		
//		
//		DomainConformToRelation domainConformToRelation = new DomainConformToRelation();
//		domainConformToRelation.setFromArtifact(transformation);
//		domainConformToRelation.setToArtifact(mmIn);
//		CoDomainConformToRelation coDomainConformToRelation = new CoDomainConformToRelation();
//		coDomainConformToRelation.setFromArtifact(transformation);
//		coDomainConformToRelation.setToArtifact(mmOut);
//		transformation.getRelations().add(coDomainConformToRelation);
//		transformation.getRelations().add(domainConformToRelation);
		List<Model> models = new ArrayList<Model>();
		Model model = new Model();
		model.setName("nome");
		GridFileMedia gfm = new GridFileMedia();
		String s;
		try {
			s = MDEForgeClient.readFile("temp/android.model");
			gfm.setContent(s);
			model.setFile(gfm);
			models.add(model);
			c.executeETLTransformation("55114a0e7d84340010bbb538",models);
		}catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	@Test
//	public void testAddEcoreMetamodel () {
//		try {
//			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//			EcoreMetamodel mmIn = new EcoreMetamodel();
//			mmIn.setName("WebAppMM");
//			c.addEcoreMetamodel(mmIn,"temp/WebAppMM.ecore");
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} 		
//	}
}
