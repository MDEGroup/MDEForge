package org.mdeforge.models2015;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.client.ATLTransformationService;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ModelService;

public class LaunchUploadModel {

	private static ATLTransformationService atlTransformationService; 
	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ModelService modelService; 

	@BeforeClass
	public static void setup() throws Exception {
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "Admin", "test123");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin", "test123");
		modelService = new ModelService("http://localhost:8080/mdeforge/", "Admin", "test123");
	}
	/*
	 * Load metamodel and transformations
	 */
//	@Ignore
	@Test
	public void loadDataATLTransformationFamilies2Person () throws Exception {
		//Metamodel name
		EcoreMetamodel families = ecoreMetamodelService.getEcoreMetamodelByName("Families");
		
		Model simpleFamilyModel = new Model();
		simpleFamilyModel.setName("Simple families model");
		simpleFamilyModel.setOpen(true);
		simpleFamilyModel.setDescription("For use in models tool demostration 2015");
		simpleFamilyModel.setFile(ModelService.setGridFileMedia("temp/models2015/Families2Persons/sample-Families.xmi"));
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(simpleFamilyModel);
		ctr.setToArtifact(families );
		simpleFamilyModel.getRelations().add(ctr);
		
		modelService.addModel(simpleFamilyModel);
	}
}
