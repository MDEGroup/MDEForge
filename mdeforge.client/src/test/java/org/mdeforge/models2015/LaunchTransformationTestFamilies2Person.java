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

public class LaunchTransformationTestFamilies2Person {

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
		
		EcoreMetamodel families = new EcoreMetamodel();
		families.setName("Families");
		families.setDescription("This basic metamodel allows to represent families. A family, "
						 + "which has a name, is composed of several persons identified by their firstname. ");
		families.setOpen(true);
		families = ecoreMetamodelService.addEcoreMetamodel(families, "temp/models2015/Families2Persons/Families.ecore");

		EcoreMetamodel person = new EcoreMetamodel();
		person.setName("Persons");
		person.setDescription("This simple metamodel describes a person (firstname, surname). It is used for illustration purposes.");
		person.setOpen(true);
		person = ecoreMetamodelService.addEcoreMetamodel(person, "temp/models2015/Families2Persons/Persons.ecore");
		
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
		
		ATLTransformation transformation = new ATLTransformation();
		transformation.setName("Families2Preson");
		transformation.setDescription("The goal is to present a use case of a model to model transformation written in ATL." +
										"This use case is named: Families to Persons" +
										" Initially we have a text describing a list of families." +
										"We want to transform this into another text describing a list of persons.);");
		
		transformation.setOpen(true);
		CoDomainConformToRelation cdct = new CoDomainConformToRelation();
		cdct.setFromArtifact(transformation);
		cdct.setToArtifact(person);
		cdct.setReferenceModelName("Persons");
		cdct.setName("OUT");

		DomainConformToRelation dct = new DomainConformToRelation();
		dct.setFromArtifact(transformation);
		dct.setToArtifact(families);
		dct.setReferenceModelName("Families");
		dct.setName("IN");
		transformation.getRelations().add(cdct);
		transformation.getRelations().add(dct);
		transformation.setOpen(true);
		atlTransformationService.addATLTransformation(transformation, "temp/models2015/Families2Persons/Families2Persons.atl");

	}
	
	@Ignore
	@Test
	public void executeFamilies2Persons() throws Exception {
		
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
		
		ArtifactList models = new ArtifactList();
		models.add(simpleFamilyModel);
		
		ATLTransformation atl = atlTransformationService.getATLTransformationByName("Families2Preson");
		List<Model> result = atlTransformationService.executeATLTransformation(atl.getId(), models);
		for (Model model : result) {
			System.out.println(model.getName());
		}
	}
}
