package org.mdeforge.client;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.DocumentalRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.ReadmeFile;

public class DeleteTest {

	private static ModelService modelService;
	private static ATLTransformationService atlTransformationService; 
	private static ETLTransformationService etlTransformationService; 
	private static EcoreMetamodelService ecoreMetamodelService; 
	private static ProjectService projectService; 
	private static WorkspaceService workspaceService; 
	private static ArtifactService artifactService; 
	private static ReadmeFileService readmeFileService;
	@BeforeClass
	public static void setup() throws Exception {
		modelService = new ModelService("http://localhost:8080/mdeforge/", "Admin", "juri");
		atlTransformationService = new ATLTransformationService("http://localhost:8080/mdeforge/", "Admin", "juri");
		etlTransformationService = new ETLTransformationService("http://localhost:8080/mdeforge/", "Admin", "juri");
		ecoreMetamodelService = new EcoreMetamodelService("http://localhost:8080/mdeforge/", "Admin", "juri");
		projectService = new ProjectService("http://localhost:8080/mdeforge/", "Admin", "juri");
		workspaceService = new WorkspaceService("http://localhost:8080/mdeforge/", "Admin", "juri");
		artifactService = new ArtifactService("http://localhost:8080/mdeforge/", "Admin", "juri");
		readmeFileService = new ReadmeFileService("http://localhost:8080/mdeforge/", "Admin", "juri");
	}
	@Test
	public void testCreate() throws Exception{
		
		EcoreMetamodel ec = ecoreMetamodelService.getEcoreMetamodel("58da3b7afd78db87fbe4d555");
		
		ReadmeFile readme = new ReadmeFile();
		readme.setName("pippo45");
		readme.setTextContent("ciao");
		
		DocumentalRelation dc = new DocumentalRelation();
		dc.setFromArtifact(readme);
		dc.setToArtifact(ec);
		
		readme.getRelations().add(dc);
		
		readmeFileService.addReadmeFile(readme, "temp/readmeFile.txt");
	}

	@Ignore
	@Test
	public void testGet() throws Exception{
		readmeFileService.getReadmeFiles().forEach(s -> System.out.println(s));
	}
}
