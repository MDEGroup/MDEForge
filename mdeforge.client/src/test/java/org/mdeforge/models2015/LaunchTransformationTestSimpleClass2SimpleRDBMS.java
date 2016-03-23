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

public class LaunchTransformationTestSimpleClass2SimpleRDBMS {

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
	public void loadDataATLTransformationSimpleClass2SimpleRDBMS () throws Exception {
		
		EcoreMetamodel simpleClassMetamodel = new EcoreMetamodel();
		simpleClassMetamodel.setDescription("Metamodel used as a workbench in the case study for the Workshop Model Transformations in Practice.");
		simpleClassMetamodel.setName("SimpleClass");
		simpleClassMetamodel.setOpen(true);
		simpleClassMetamodel = ecoreMetamodelService.addEcoreMetamodel(simpleClassMetamodel, "temp/models2015/SimpleClass2SimpleRDBMS/SimpleClass.ecore");
		
		EcoreMetamodel simpleRDBMS = new EcoreMetamodel();
		simpleRDBMS.setName("SimpleRDBMS");
		simpleRDBMS.setDescription(" The metamodel used in the example was provided in the last QVT submission.");
		simpleRDBMS.setOpen(true);
		simpleRDBMS = ecoreMetamodelService.addEcoreMetamodel(simpleRDBMS, "temp/models2015/SimpleClass2SimpleRDBMS/SimpleRDBMS.ecore");
		
		Model simpleMySQLModel = new Model();
		simpleMySQLModel.setName("euro2004-MySQL");
		simpleMySQLModel.setOpen(true);
		simpleMySQLModel.setDescription("For use in models tool demostration 2015");
		simpleMySQLModel.setFile(ModelService.setGridFileMedia("temp/models2015/SimpleClass2SimpleRDBMS/Sample-SimpleClass.ecore"));
		
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(simpleMySQLModel);
		ctr.setToArtifact(simpleRDBMS );
		simpleMySQLModel.getRelations().add(ctr);
		
		modelService.addModel(simpleMySQLModel);
		
		ATLTransformation transformation = new ATLTransformation();
		transformation.setName("SimpleClass2SimpleRDBMS");
		transformation.setOpen(true);
		transformation.setDescription("A simple Class into RDBMS");
		CoDomainConformToRelation cdct = new CoDomainConformToRelation();
		cdct.setFromArtifact(transformation);
		cdct.setToArtifact(simpleRDBMS);
		cdct.setReferenceModelName("SimpleRDBMS");
		cdct.setName("OUT");
		
		DomainConformToRelation dct = new DomainConformToRelation();
		dct.setFromArtifact(transformation);
		dct.setToArtifact(simpleClassMetamodel);
		dct.setReferenceModelName("SimpleClass");
		dct.setName("IN");
		transformation.getRelations().add(cdct);
		transformation.getRelations().add(dct);
		
		atlTransformationService.addATLTransformation(transformation, "temp/models2015/SimpleClass2SimpleRDBMS/SimpleClass2SimpleRDBMS.atl");
		
	}
	
	@Ignore
	@Test
	public void executeMySimpleClass2SimpleRDBMS() throws Exception {
		
		EcoreMetamodel mySQLMetamodel = ecoreMetamodelService.getEcoreMetamodelByName("SimpleClass");
		
		Model simpleMySQLModel = new Model();
		simpleMySQLModel.setName("euro2004-MySQL");
		simpleMySQLModel.setOpen(true);
		simpleMySQLModel.setDescription("For use in models tool demostration 2015");
		simpleMySQLModel.setFile(ModelService.setGridFileMedia("temp/models2015/SimpleClass2SimpleRDBMS/Sample-SimpleClass.ecore"));
		
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(simpleMySQLModel);
		ctr.setToArtifact(mySQLMetamodel );
		simpleMySQLModel.getRelations().add(ctr);
		
		ArtifactList models = new ArtifactList();
		models.add(simpleMySQLModel);
		ATLTransformation atl = atlTransformationService.getATLTransformationByName("SimpleClass2SimpleRDBMS");
		List<Model> result = atlTransformationService.executeATLTransformation(atl.getId(), models);
		for (Model model : result) {
			System.out.println(model.getName());
		}
	}
	
}
