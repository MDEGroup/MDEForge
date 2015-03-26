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

	@Test
	public void testETLTransformation () {
		try {
			c = new MDEForgeClient("http://localhost:8080/mdeforge/", "test123", "test123");
		
//		ETLTransformation transformation = new ETLTransformation();
//		transformation.setName("Android2Web");
//		try {
//			String s = MDEForgeClient.readFile("temp/android2web.etl");
//			GridFileMedia gfmMmIn= new GridFileMedia();
		//	gmfMmIn.setFileName("android2web.etl");
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
//		mmIn.setId("5502f050e568510368e0d06f");		
//		GridFileMedia gfmMmOut = new GridFileMedia();
//		mmOut.setId("5502f0b5e568510368e0d073");		
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
		s = MDEForgeClient.readFile("temp/android.model");
		gfm.setContent(s);
		model.setFile(gfm);
		models.add(model);
		c.executeETLTransformation("55114a0e7d84340010bbb538",models);
		}catch (IOException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
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
