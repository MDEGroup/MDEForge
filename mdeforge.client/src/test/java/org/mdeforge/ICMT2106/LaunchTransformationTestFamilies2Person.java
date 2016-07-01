package org.mdeforge.ICMT2106;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ATLTransformationError;
import org.mdeforge.business.model.ATLTransformationTestServiceError;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.client.ATLTransformationService;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ModelService;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LaunchTransformationTestFamilies2Person {

	private static ATLTransformationService atlTransformationService;
	private static EcoreMetamodelService ecoreMetamodelService;
	private static ModelService modelService;
	private static ObjectMapper mapper;
	private static String TEMP_FOLDER = "ICMT16Demo/outputs/";

	@BeforeClass
	public static void setup() throws Exception {
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "Admin", "juri");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin", "juri");
		modelService = new ModelService("http://localhost:8080/mdeforge/", "Admin", "juri");
		mapper = new ObjectMapper();
	}

	@Test
	public void executeTransformationICMTDemo() throws Exception {
		// Load metamodels from server
		System.out.println("############ Load data ############");
		EcoreMetamodel families = ecoreMetamodelService.getEcoreMetamodelByName("FamiliesTC");
		System.out.println("\t" + families.getName() + ": "	+ mapper.valueToTree(families).toString());
		FileUtils.writeByteArrayToFile(new File(TEMP_FOLDER
				+ families.getFile().getFileName()), families.getFile().getByteArray());

		EcoreMetamodel person = ecoreMetamodelService.getEcoreMetamodelByName("PersonTC");
		System.out.println("\t" + person.getName() + ": " + mapper.valueToTree(person).toString());
		FileUtils.writeByteArrayToFile(new File(TEMP_FOLDER	+ person.getFile().getFileName()), person.getFile()
				.getByteArray());

		// Create model to be transform
		Model simpleFamilyModel = new Model();
		simpleFamilyModel.setName("family-model");
		simpleFamilyModel.setFile(ModelService.setGridFileMedia("ICMT16Demo/inputs/sample-Families.xmi"));

		// Create model relation to metamodel
		ConformToRelation ctr = new ConformToRelation();
		ctr.setFromArtifact(simpleFamilyModel);
		ctr.setToArtifact(families);
		simpleFamilyModel.getRelations().add(ctr);

		// Load Transformation
		ATLTransformation atl = atlTransformationService.getATLTransformationByName("families2personTC");
		System.out.println("\tFamilies2Person: " + mapper.valueToTree(families).toString());
		FileUtils.writeByteArrayToFile(new File(TEMP_FOLDER
				+ atl.getFile().getFileName()), atl.getFile().getByteArray());

		// Analyze transformation
		// Metrics are contained in ATL object
		System.out.println("############ anATLyzer Service ############");
		List<ATLTransformationError> anATLyzerError = atlTransformationService.anATLyze(atl);
		for (ATLTransformationError atlTransformationError : anATLyzerError) {
			System.out.println("\tAnatlyzer Error: " + mapper.valueToTree(atlTransformationError));
		}

		System.out.println("############ Test Service ############");
		List<ATLTransformationTestServiceError> testServiceError = atlTransformationService.testerService(atl);
		for (ATLTransformationTestServiceError atlTransformationTestServiceError : testServiceError) {

			System.out.println("\tTest service error" + mapper.valueToTree(atlTransformationTestServiceError).toString());
			Model m = modelService.getModel(atlTransformationTestServiceError.getModel().getId());
			FileUtils.writeByteArrayToFile(new File(TEMP_FOLDER	+ m.getFile().getFileName()), m.getFile().getByteArray());
			System.out.println("\t\t Test model" + mapper.valueToTree(m));
		}
		

		// Execute transformation
		ArtifactList models = new ArtifactList();
		models.add(simpleFamilyModel);
		List<Model> result = atlTransformationService.executeATLTransformation(atl, models);
		System.out.println("############ Transformation results ############");
		for (Model model : result) {
			System.out.println("\t" + model.getName() + mapper.valueToTree(model));
			FileUtils.writeByteArrayToFile(new File(TEMP_FOLDER	+ model.getFile().getFileName()), model.getFile().getByteArray());
		}
	}
}
