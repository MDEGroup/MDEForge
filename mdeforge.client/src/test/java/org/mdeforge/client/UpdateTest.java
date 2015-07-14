package org.mdeforge.client;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.Workspace;

public class UpdateTest {

	private static ModelService modelService;
	private static ATLTransformationService atlTransformationService; 
	private static ETLTransformationService etlTransformationService; 
	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ProjectService projectService; 
	private static WorkspaceService workspaceService; 
	@BeforeClass
	public static void setup() throws Exception {
		modelService = new ModelService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		etlTransformationService = new ETLTransformationService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		projectService = new ProjectService("http://localhost:8080/mdeforge/", "maja", "majacdg");
		workspaceService = new WorkspaceService("http://localhost:8080/mdeforge/", "maja", "majacdg");
	}
	
	@Ignore
	@Test
	public void updateWorkspace(){
		Workspace w = new Workspace();
		w.setId("5514aa53d4c67eee3e2c1b12");
		w.setName("asd");
	}
}
