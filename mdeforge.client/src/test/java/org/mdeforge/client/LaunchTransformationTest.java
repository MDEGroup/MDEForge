package org.mdeforge.client;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.wrapper.json.ArtifactList;

public class LaunchTransformationTest {

	private static ATLTransformationService atlTransformationService; 
	private static EcoreMetamodelService ecoreMetamodelService; 

	@BeforeClass
	public static void setup() throws Exception {
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "Admin", "test123");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin", "test123");
	}
	
	@Test
	public void addMetamodel () throws Exception {
//		EcoreMetamodel emm = new EcoreMetamodel();
//		emm.setName("Families");
//		emm.setDescription("Test planned");
//		emm.setOpen(true);
//		ecoreMetamodelService.addEcoreMetamodel(emm, "temp/Families.ecore");
		EcoreMetamodel emm2 = new EcoreMetamodel();
		emm2.setName("Person");
		emm2.setDescription("Test planned");
		emm2.setOpen(true);
		emm2 = ecoreMetamodelService.addEcoreMetamodel(emm2, "temp/Persons.ecore");
		System.out.println("JURI " + emm2.getId());
		
	}
	
	
	@Ignore
	@Test
	public void getModelsTest() throws Exception {
		
		
		ArrayList<Model> models = new ArrayList<Model>();
		
		Model model = new Model();
		model.setName("ComposedModel");
		
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
		List<Model> modelli = atlTransformationService.executeATLTransformation("5565a826456809f9bc5b6a28", artifactList);
		for (Model model2 : modelli) {
			System.out.println(model2.getName());
		}
	}
	@Ignore
	@Test
	public void getModelsTest2() throws Exception {
			
		ArrayList<Model> models = new ArrayList<Model>();
		
		Model model = new Model();
		model.setName("sample-Families");
		
		GridFileMedia gfm = new GridFileMedia();
		gfm.setFileName("sample-Families.xmi");
		gfm.setContent(MDEForgeClient.readFile("temp/sample-Families.xmi"));
		model.setFile(gfm);
		
		EcoreMetamodel eMM = new EcoreMetamodel();
		eMM.setId("557057524568f71adcb1701c");
		
		
		ConformToRelation mElement = new ConformToRelation();
		
		mElement.setName("Francesco");
		mElement.setFromArtifact(model);
		mElement.setToArtifact(eMM);
		
		model.getRelations().add(mElement);
		
		models.add(model);
		
		ArtifactList artifactList = new ArtifactList(models);
		//ObjectId("5565a826456809f9bc5b6a28")
		List<Model> modelli = atlTransformationService.executeATLTransformation("557057524568f71adcb17024", artifactList);
		for (Model model2 : modelli) {
			System.out.println(model2.getName());
		}
	}
	
}
