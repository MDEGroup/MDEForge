package org.mdeforge.client;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.EcoreMetamodel;
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
		modelService = new ModelService("http://localhost:8080/mdeforge/", "Admin", "test123");
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "Admin", "test123");
		etlTransformationService = new ETLTransformationService("http://localhost:8080/mdeforge/", "Admin", "test123");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin", "test123");
		projectService = new ProjectService("http://localhost:8080/mdeforge/", "Admin", "test123");
		workspaceService = new WorkspaceService("http://localhost:8080/mdeforge/", "Admin", "test123");
	}
	
	@Ignore
	@Test
	public void updateWorkspace(){
		Workspace w = new Workspace();
		w.setId("5514aa53d4c67eee3e2c1b12");
		w.setName("asd");
	}
	@Test
	public void updateEcore() throws Exception{
		EcoreMetamodel emm = ecoreMetamodelService.getEcoreMetamodel("557837bbd4c6571542e8a9a8");
		emm.setName("ACME_JURI");
		emm = ecoreMetamodelService.updateEcoreMetamodel(emm);
		System.out.println("FINITO" + emm.getName());
	}
}
