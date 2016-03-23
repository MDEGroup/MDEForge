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

public class LaunchTransformationTestKM32SimpleClass {

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
	
	@Test
	public void loadDataATLTransformationKM32SimpleClass () throws Exception {
		
		EcoreMetamodel simpleKM3Metamoden = ecoreMetamodelService.getEcoreMetamodelByName("KM3");
		
		EcoreMetamodel simpleClassMetamodel = ecoreMetamodelService.getEcoreMetamodelByName("SimpleClass");
		
		Model simpleKM3Model = new Model();
		simpleKM3Model.setName("simpleKM3");
		simpleKM3Model.setOpen(true);
		simpleKM3Model.setDescription("For use in models tool demostration 2015");
		simpleKM3Model.setFile(ModelService.setGridFileMedia("temp/models2015/SimpleClass2SimpleRDBMS/Sample-KM3.ecore"));
		
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(simpleKM3Model);
		ctr.setToArtifact(simpleKM3Metamoden );
		simpleKM3Model.getRelations().add(ctr);
		
		modelService.addModel(simpleKM3Model);
		
		ATLTransformation transformation = new ATLTransformation();
		transformation.setName("KM32SimpleClass");
		transformation.setOpen(true);
		
		CoDomainConformToRelation cdct = new CoDomainConformToRelation();
		cdct.setFromArtifact(transformation);
		cdct.setToArtifact(simpleClassMetamodel);
		cdct.setReferenceModelName("SimpleClass");
		cdct.setName("OUT");
		
		DomainConformToRelation dct = new DomainConformToRelation();
		dct.setFromArtifact(transformation);
		dct.setToArtifact(simpleKM3Metamoden);
		dct.setReferenceModelName("KM3");
		dct.setName("IN");
		transformation.getRelations().add(cdct);
		transformation.getRelations().add(dct);
		
		atlTransformationService.addATLTransformation(transformation, "temp/models2015/SimpleClass2SimpleRDBMS/KM32SimpleClass.atl");
		
	}
	
	@Ignore
	@Test
	public void executeMySimpleClass2SimpleRDBMS() throws Exception {
		
		EcoreMetamodel mySQLMetamodel = ecoreMetamodelService.getEcoreMetamodelByName("KM3");
		
		Model simpleMySQLModel = new Model();
		simpleMySQLModel.setName("simpleKM3");
		simpleMySQLModel.setOpen(true);
		simpleMySQLModel.setDescription("For use in models tool demostration 2015");
		simpleMySQLModel.setFile(ModelService.setGridFileMedia("temp/models2015/SimpleClass2SimpleRDBMS/Sample-KM3.ecore"));
		
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(simpleMySQLModel);
		ctr.setToArtifact(mySQLMetamodel );
		simpleMySQLModel.getRelations().add(ctr);
		
		ArtifactList models = new ArtifactList();
		models.add(simpleMySQLModel);
		ATLTransformation atl = atlTransformationService.getATLTransformationByName("KM32SimpleClass");
		List<Model> result = atlTransformationService.executeATLTransformation(atl.getId(), models);
		for (Model model : result) {
			System.out.println(model.getName());
		}
	}
	
}
