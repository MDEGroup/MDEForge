package org.mdeforge.client;

import static org.junit.Assert.assertNotNull;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.ValuedRelation;
import org.mdeforge.business.model.wrapper.json.ArtifactList;

public class LaunchTransformationTest {

	private static MDEForgeClient c;

	@BeforeClass
	public static void setup() throws Exception {
		c = new MDEForgeClient("http://localhost:8080/mdeforge/", "Admin", "test123");
	}
	
	
	@Test
	public void getModelsTest() throws Exception {
		
		ArrayList<Model> models = new ArrayList<Model>();
		Model model = new Model();
		model.setName("Composed");
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName("composed.xmi");
		gfm.setContent(MDEForgeClient.readFile("temp/composed.xmi"));
		model.setFile(gfm);
		EcoreMetamodel eMM = new EcoreMetamodel();
		eMM.setId("5565a80e456809f9bc5b6a20");
		ConformToRelation mElement = new ConformToRelation();
		mElement.setName("Francesco");
		mElement.setFromArtifact(model);
		mElement.setToArtifact(eMM);
		
		model.getRelations().add(mElement);
		
		models.add(model);
		
		ArtifactList artifactList = new ArtifactList(models);
		//ObjectId("5565a826456809f9bc5b6a28")
		c.executeATLTransformation("5565a826456809f9bc5b6a28", artifactList);
		
	}
	
}
