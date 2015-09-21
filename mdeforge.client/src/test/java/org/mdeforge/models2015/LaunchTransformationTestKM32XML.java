package org.mdeforge.models2015;

import java.util.ArrayList;
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

public class LaunchTransformationTestKM32XML {

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
	
	@Ignore
	@Test
	public void loadDataATLTransformationKM32XML () throws Exception {
		
		EcoreMetamodel families = new EcoreMetamodel();
		families.setName("KM3");
		families.setDescription("KM3, the Kernel MetaMetaModel, provides "
				+ "a textual concrete syntax that eases the coding of metamodels. "
				+ "Its syntax is simple, straight forward and "
				+ "has some similarities with the Java notation. "
				+ "KM3 resembles Ecore terminology and has the notion "
				+ "of package, class, attribute, reference and primitive datatype.");
		families.setOpen(true);
		families = ecoreMetamodelService.addEcoreMetamodel(families, "temp/models2015/KM32XML/KM3.ecore");
		
		EcoreMetamodel person = new EcoreMetamodel();
		person.setName("XML");
		person.setDescription("This metamodel defines a subset of the Extensible Markup Language (XML). "
				+ "It describes an XML document with one root node. Node is an abstract class having two direct children, "
				+ "namely ElementNode and AttributeNode. ElementNode represents the tags, for example a tag named xml: <xml></xml>. "
				+ "ElementNodes can be composed of many Nodes. AttributeNode represents attributes, which can be found in a tag, "
				+ "for example the attr attribute: <xml attr=value of attr/>. ElementNode has two sub classes, "
				+ "namely RootNode and TextNode. RootNode is the root element. The TextNode is a particular node, "
				+ "which does not look like a tag; it is only a string of characters.");
		person.setOpen(true);
		person = ecoreMetamodelService.addEcoreMetamodel(person, "temp/models2015/KM32XML/XML.ecore");
						
		ATLTransformation transformation = new ATLTransformation();
		transformation.setName("KM32XML");
		
		CoDomainConformToRelation cdct = new CoDomainConformToRelation();
		cdct.setFromArtifact(transformation);
		cdct.setToArtifact(person);
		cdct.setReferenceModelName("XML");
		cdct.setName("OUT");
		
		DomainConformToRelation dct = new DomainConformToRelation();
		dct.setFromArtifact(transformation);
		dct.setToArtifact(families);
		dct.setReferenceModelName("KM3");
		dct.setName("IN");
		transformation.getRelations().add(cdct);
		transformation.getRelations().add(dct);
		atlTransformationService.addATLTransformation(transformation, "temp/models2015/KM32XML/KM32XML.atl");
		
	}
		
	
	@Test
	public void executeKM32XML() throws Exception {
		
		EcoreMetamodel families = ecoreMetamodelService.getEcoreMetamodelByName("KM3");
		
		Model simpleFamilyModel = new Model();
		simpleFamilyModel.setName("euro2004-KM3");
		simpleFamilyModel.setOpen(true);
		simpleFamilyModel.setDescription("For use in models tool demostration 2015");
		simpleFamilyModel.setFile(ModelService.setGridFileMedia("temp/models2015/KM32XML/euro2004-KM3.xmi"));
		
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(simpleFamilyModel);
		ctr.setToArtifact(families );
		simpleFamilyModel.getRelations().add(ctr);
		
		ArtifactList models = new ArtifactList();
		models.add(simpleFamilyModel);
		
		ATLTransformation atl = atlTransformationService.getATLTransformationByName("KM32XML");
		List<Model> result = atlTransformationService.executeATLTransformation(atl.getId(), models);
		for (Model model : result) {
			System.out.println(model.getName());
		}
	}
}
