package org.mdeforge.models2015;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.client.ATLTransformationService;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ModelService;

public class LaunchUploadModel {

	private static ATLTransformationService atlTransformationService; 
	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ModelService modelService; 

	@BeforeClass
	public static void setup() throws Exception {
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "francesco", "test123");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "francesco", "test123");
		modelService = new ModelService("http://localhost:8080/mdeforge/", "francesco", "test123");
	}
	/*
	 * Load metamodel and transformations
	 */
//	@Ignore
	@Test
	public void loadDataATLTransformationFamilies2Person () throws Exception {
		//Metamodel name
		EcoreMetamodel families = ecoreMetamodelService.getEcoreMetamodelByName("KM3");
		
		Model simpleFamilyModel = new Model();
		simpleFamilyModel.setName("euro2004KM3_3");
		simpleFamilyModel.setOpen(true);
		simpleFamilyModel.setDescription("For use in models tool demostration 2015");
		simpleFamilyModel.setFile(ModelService.setGridFileMedia("temp/models2015/KM32XML/euro2004-KM3.xmi"));
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(simpleFamilyModel);
		ctr.setToArtifact(families );
		simpleFamilyModel.getRelations().add(ctr);
		
		modelService.addModel(simpleFamilyModel);
	}
}
