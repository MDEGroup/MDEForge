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
import org.mdeforge.business.model.ConformToRelation;
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

	
	
//	@Ignore
//	@Test
//	public void testETLTransformation () {
//		try {
//			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
//			Workspace w =  new Workspace();
//			List<Workspace> ws = c.getWorkspaces();
//			w = ws.get(0);
//			Project p =  new Project();
//			p.setName("Salvi project Test");
//			p.setWorkspaces(new ArrayList<Workspace>());
//			p.getWorkspaces().add(w);
//			c.addProject(p);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testAddEcoreMetamodel () {
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
			EcoreMetamodel emm = new EcoreMetamodel();
			emm.setName("ProvaSalvi");
			Project p = new Project();
			p.setId("55141440456855157ebc5716");
			//p.getArtifacts().add(emm);
			emm.getProjects().add(p);
			c.addEcoreMetamodel(emm, "temp/WebAppMM.ecore");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//	@Test
//	public void addETLTransformation() throws Exception {
//		ETLTransformation etl = new ETLTransformation();
//		EcoreMetamodel emm = new EcoreMetamodel();
//		emm.setName("");
//		c.addEcoreMetamodel(emm, "asdads");
//		c.addETLTransformation(etl, "temp/Android2Web.etl");
//	
//	}
//	
//	public void addModel () throws Exception {
//		Model m = new Model();
//		m.setName("asd");
//		EcoreMetamodel emm = new EcoreMetamodel();
//		emm.setId("<metti id mm>");
//		ConformToRelation cft = new ConformToRelation();
//		cft.setFromArtifact(m);
//		cft.setToArtifact(emm);
//		ArrayList<Model> models = new ArrayList<Model>();
//		models.add(m);
//		m.getRelations().add(cft);
//		c.executeETLTransformation("55114a0e7d84340010bbb538",models);
//		
//	}
	
}
