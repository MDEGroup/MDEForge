package org.mdeforge.test;

import java.io.IOException;
import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.service.ContentsService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.importer.Content;
import org.mdeforge.business.importer.EcoreMetamodelImporterSevice;
import org.mdeforge.business.importer.GitHubRate;
import org.mdeforge.business.importer.SearchCodeResult;
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
public class GitHubImporterTest {

	@Autowired
	private EcoreMetamodelImporterSevice ecoreMetamodelImporterService;
	@Autowired
	private SearchCodeResultRepository searchCodeResultRepository;
	@Autowired
	private RepositoryContentsRepository repositoryContentsRepository;
	@Autowired
	private RepositoryRepository repositoryRepository;
	Logger logger = LoggerFactory.getLogger(GitHubImporterTest.class);

	@Ignore
	@Test
	public void testInjection() throws IOException {
		String m = "q=q=extension:ecore+xml";
		SearchCodeResult rc = ecoreMetamodelImporterService
				.findContentsInRepository(m, "fgalan", "tim-transforms");
		ContentsService cs = new ContentsService();
		for (Content content : rc.getItems()) {
			List<RepositoryContents> rcs = cs.getContents(
					content.getRepository(), content.getPath());
			for (RepositoryContents repositoryContents : rcs) {
				String s = new String(
						org.apache.commons.codec.binary.Base64
								.decodeBase64(repositoryContents.getContent()
										.getBytes()));
				logger.info(s);
			}
		}

	}

	@Ignore
	@Test
	public void testImport() throws IOException, InterruptedException {
		try {
			ecoreMetamodelImporterService
					.findEcoreMetamodelsInGithubSinceRepositoryId(32283515);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Ignore
	@Test
	public void testRepositoryContentsRepositoryFunction(){
		RepositoryContents rcs = (repositoryContentsRepository.findOneByNameAndSize("core.ecore", 8999589));
		if(rcs!=null)
			logger.info(rcs.getName());
		else logger.info("null content");
		Repository repository = repositoryRepository.findOneByNameAndOwner_Login("ubq_wip", "lucascrafooot");
		if(repository!=null)
			logger.info(repository.getName());
		else logger.info("null repo");
	}
	
	
	@Ignore
	@Test
	public void testRepositoryContents() throws IOException,
			InterruptedException {
		List<SearchCodeResult> list = searchCodeResultRepository.findAll();
		int i = 1;
		for (SearchCodeResult searchCodeResult : list) {
			logger.info("Iteration: " + i++);
			logger.info("#Results in a query: "
					+ searchCodeResult.getTotal_count());
			try {
				List<RepositoryContents> repositoryContents = ecoreMetamodelImporterService
						.getContentsFromSearchCodeResultBoost(searchCodeResult);
				logger.info("#repository contents in for a Search code result:"
						+ repositoryContents.size());
				for (RepositoryContents repositoryContent : repositoryContents) {
					RepositoryContents res = repositoryContentsRepository
							.findOneByNameAndSize(repositoryContent.getName(),
									repositoryContent.getSize());
					if (res == null) {
						logger.info("The content is already in DB. Name: "
								+ res.getName() + " size: " + res.getSize());
						repositoryContentsRepository.save(repositoryContents);
					} else {
						logger.info("The content is already in DB. Name: "
								+ res.getName() + " size: " + res.getSize());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		logger.info("end import");
	}

	@Ignore
	@Test
	public void testByWebSearch() throws InterruptedException, IOException {
		ecoreMetamodelImporterService.importEcoreMetamodelBySearchWebSite();
	}

	@Ignore
	@Test
	public void testImportAllMethods() throws IOException, InterruptedException {
		ecoreMetamodelImporterService.findEcoreMetamodelsInGithub();
	}
	
	@Test
	public void testGitRate() throws IOException, InterruptedException {
		GitHubRate gr = ecoreMetamodelImporterService.waitApiRate();
		logger.info("REMAINING: "
				+ gr.getResources().getSearch().getRemaining());
		logger.info("LIMIT: " + gr.getResources().getSearch().getLimit());
	}
}
