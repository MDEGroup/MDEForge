package org.mdeforge.client;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class DeleteTest {

	private static ModelService modelService;
	private static ATLTransformationService atlTransformationService; 
	private static ETLTransformationService etlTransformationService; 
	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ProjectService projectService; 
	private static WorkspaceService workspaceService; 
	private static ArtifactService artifactService; 
	@BeforeClass
	public static void setup() throws Exception {
		modelService = new ModelService("http://localhost:8080/mdeforge/", "Admin", "test123");
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "Admin", "test123");
		etlTransformationService = new ETLTransformationService("http://localhost:8080/mdeforge/", "Admin", "test123");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin", "test123");
		projectService = new ProjectService("http://localhost:8080/mdeforge/", "Admin", "test123");
		workspaceService = new WorkspaceService("http://localhost:8080/mdeforge/", "Admin", "test123");
		artifactService = new ArtifactService("http://localhost:8080/mdeforge/", "Admin", "test123");
	}
	@Ignore
	@Test
	public void testDelete() throws Exception{
		artifactService.deleteArtifact("557837cbd4c6571542e8aad8");
	}
}
