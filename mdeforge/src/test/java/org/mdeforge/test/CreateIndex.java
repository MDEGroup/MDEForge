package org.mdeforge.test;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.importer.EcoreMetamodelImporterSevice;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.integration.RepositoryContentsRepository;
import org.mdeforge.integration.RepositoryRepository;
import org.mdeforge.integration.SearchCodeResultRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})


public class CreateIndex {

	@Autowired
	private EcoreMetamodelImporterSevice ecoreMetamodelImporterService;
	@Autowired
	private SearchCodeResultRepository searchCodeResultRepository;
	@Autowired
	private RepositoryContentsRepository repositoryContentsRepository;
	@Autowired
	private RepositoryRepository repositoryRepository;
	Logger logger = LoggerFactory.getLogger(GitHubImporterTest.class);
	@Autowired
	
	private CRUDArtifactService<Artifact> crudArtifactService;
	

 
	
	
	@Test
	public void run() throws IOException, InterruptedException {
		crudArtifactService.createIndex();
	}
}
