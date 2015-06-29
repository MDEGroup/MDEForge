package org.mdeforge.business.importer.impl;

import static org.eclipse.egit.github.core.client.IGitHubConstants.SEGMENT_SEARCH;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.GitHubRequest;
import org.eclipse.egit.github.core.client.PageIterator;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.mdeforge.business.BusinessException;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EcoreMetamodelImporterServiceImpl implements
		EcoreMetamodelImporterSevice {

	@Autowired
	private RepositoryContentsRepository repositoryContentsRepository;
	
	@Autowired
	private RepositoryRepository repositoryRepository;
	
	@Autowired
	private SearchCodeResultRepository searchCodeResultRepository;
	
	String SEGMENT_CODE_SEARCH = "/code"; //$NON-NLS-1$
	String SEGMENT_RATE = "/rate_limit"; //$NON-NLS-1$
	private GitHubClient client;
	
	private RepositoryService repositoryService;
	private ContentsService contentService;
	
	Logger logger = LoggerFactory.getLogger(EcoreMetamodelImporterServiceImpl.class);
	
	private final String QUERY_API = "q=extension:ecore+project";
	private final String QUERY_WEB = "&q=extension%3Aecore+project&ref=searchresults&type=Code";

	// private final String QUERY_API = "q=extension:ecore+web";
	// private final String QUERY_WEB =
	// "&q=extension%3Aecore+web&ref=searchresults&type=Code";
	// private final String QUERY_API = "q=extension:ecore+software";
	// private final String QUERY_WEB =
	// "&q=extension%3Aecore+sofware&ref=searchresults&type=Code";
	// private final String QUERY_API = "q=extension:ecore+performance";
	// private final String QUERY_WEB =
	// "&q=extension%3Aecore+performance&ref=searchresults&type=Code";
	// private final String QUERY_API = "q=extension:ecore+data";
	// private final String QUERY_WEB =
	// "&q=extension%3Aecore+data&ref=searchresults&type=Code";
	// private final String QUERY_API = "q=extension:ecore+sql";
	// private final String QUERY_WEB =
	// "&q=extension%3Aecore+sql&ref=searchresults&type=Code";
	// private final String QUERY_API = "q=extension:ecore+xml";
	// private final String QUERY_WEB =
	// "&q=extension%3Aecore+xml&ref=searchresults&type=Code";
	// private final String QUERY_API = "q=extension:ecore+business";
	// private final String QUERY_WEB =
	// "&q=extension%3Aecore+business&ref=searchresults&type=Code";
	// private final String QUERY_API = "q=extension:ecore+uml";
	// private final String QUERY_WEB =
	// "&q=extension%3Aecore+uml&ref=searchresults&type=Code";
	
	@Autowired
	public EcoreMetamodelImporterServiceImpl(@Value("#{cfgproperties[github_token]}")String github_token) {
		super();
		client = new GitHubClient();
		client.setOAuth2Token(github_token);
		repositoryService = new RepositoryService(client);
		contentService = new ContentsService(client);
	}

	public SearchCodeResult findContentsInRepository(final String query,
			String owner, String repository) throws IOException {
		logger.info("findContentsInRepository: " + owner + "/" + repository);
		SearchCodeResult result = null;
		if (query == null)
			throw new IllegalArgumentException("Query cannot be null"); //$NON-NLS-1$
		if (query.length() == 0)
			throw new IllegalArgumentException("Query cannot be empty"); //$NON-NLS-1$
		StringBuilder uri = new StringBuilder(SEGMENT_SEARCH
				+ SEGMENT_CODE_SEARCH);
		final String encodedQuery = query;
		uri.append('?').append(encodedQuery).append("+repo:").append(owner)
				.append("/").append(repository);
		GitHubRequest gitHubRequest = new GitHubRequest();
		gitHubRequest.setUri(uri);
		gitHubRequest.setType(SearchCodeResult.class);
		result = (SearchCodeResult) client.get(gitHubRequest).getBody();
		return result;
	}

	@Override
	public List<RepositoryContents> getContentsFromSearchCodeResult(
			SearchCodeResult searchCodeResult) throws IOException,
			InterruptedException {
		List<RepositoryContents> result = new ArrayList<RepositoryContents>();
		for (Content content : searchCodeResult.getItems()) {
			List<RepositoryContents> rcs;
			try {
				rcs = contentService.getContents(content.getRepository(),
						content.getPath());
			} catch (IOException e) {
				waitApiRate();
				rcs = contentService.getContents(content.getRepository(),
						content.getPath());
			}
			for (RepositoryContents repositoryContents : rcs) {
				result.add(repositoryContents);
			}
		}
		return result;
	}

	@Override
	public List<RepositoryContents> getContentsFromSearchCodeResultBoost(
			SearchCodeResult searchCodeResult) throws IOException,
			InterruptedException {
		List<RepositoryContents> result = new ArrayList<RepositoryContents>();
		for (Content content : searchCodeResult.getItems()) {
			if (repositoryRepository.findOneByNameAndOwner_Login(content
					.getRepository().getName(), content.getRepository()
					.getOwner().getLogin()) == null) {
				List<RepositoryContents> rcs;
				try {
					rcs = contentService.getContents(content.getRepository(),
							content.getPath());
				} catch (IOException e) {
					waitApiRate();
					rcs = contentService.getContents(content.getRepository(),
							content.getPath());
				}
				for (RepositoryContents repositoryContents : rcs) {
					result.add(repositoryContents);
				}
			} else
				logger.info("Repository has been already parsed: "
						+ content.getRepository().getOwner().getLogin() + "/"
						+ content.getRepository().getName());
		}
		return result;
	}

	public void findEcoreMetamodelsInGithubSinceRepositoryId(long lastImportId)
			throws IOException, InterruptedException {
		logger.info("findEcoreMetamodelsInGithubSinceRepositoryId: "
				+ lastImportId);
		PageIterator<Repository> pageIterator = repositoryService
				.pageAllRepositories(lastImportId);
		for (Repository repository : pageIterator.next()) {
			SearchCodeResult scr = findContentsInRepository(QUERY_API,
					repository.getOwner().getLogin(), repository.getName());
			List<RepositoryContents> repositoryContents = getContentsFromSearchCodeResult(scr);
			repositoryContentsRepository.save(repositoryContents);
			if (scr.getItems().length != 0)
				searchCodeResultRepository.save(scr);
			repositoryRepository.save(repository);
			lastImportId = repository.getId();
		}
	}

	@Override
	public GitHubRate waitApiRate() throws BusinessException {
		StringBuilder uri = new StringBuilder(SEGMENT_RATE);
		GitHubRequest gitHubRequest = new GitHubRequest();
		gitHubRequest.setUri(uri);
		gitHubRequest.setType(GitHubRate.class);
		try {
			GitHubRate ghr = (GitHubRate) client.get(gitHubRequest).getBody();
	
			Long remainingSearch = Long.parseLong(ghr.getResources().getSearch()
					.getRemaining());
			Long resetSearch = Long.parseLong(ghr.getResources().getSearch()
					.getReset());
			Date resetSearchDate = new Date(resetSearch * 1000);
			long waitSearchTime = resetSearchDate.getTime() - new Date().getTime();
			if (remainingSearch <= 0) {
				logger.info("API rate limit successed! Wait: " + waitSearchTime
						+ "ms");
				Thread.sleep(waitSearchTime);
			}
	
			Long remainingAPI = Long.parseLong(ghr.getResources().getCore()
					.getRemaining());
			Long resetAPI = Long.parseLong(ghr.getResources().getCore().getReset());
			Date resetAPIDate = new Date(resetAPI * 1000);
			long waitAPITime = resetAPIDate.getTime() - new Date().getTime();
			if (remainingAPI <= 0) {
				logger.info("API rate limit successed! Wait: " + waitSearchTime
						+ "ms");
				Thread.sleep(waitAPITime);
			}
	
			return (GitHubRate) client.get(gitHubRequest).getBody();
		} catch (IOException e) {
			throw new BusinessException();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			throw new BusinessException();
		}
	}

	@Override
	public void findEcoreMetamodelsInGithub() throws IOException,
			InterruptedException {
		waitApiRate();
		boolean guard = false;
		while (!guard) {
			Repository r = repositoryRepository.findTopByOrderByIdDesc();
			long start = (r == null) ? 1L : r.getId();
			try {
				findEcoreMetamodelsInGithubSinceRepositoryId(start);
				guard = true;
			} catch (IOException e) {
				logger.info("API RATE LIMIT!");
				waitApiRate();
			}
		}
	}

	@Override
	public void importEcoreMetamodelBySearchWebSite()
			throws InterruptedException, IOException {
		int i = 1;
		boolean guard = false;
		while (!guard) {
			Document doc;
			String projectUrl = "https://github.com/search?p=" + i + QUERY_WEB;
			try {
				doc = Jsoup.connect(projectUrl).timeout(10000).get();
				Elements es = doc.getElementsByClass("code-list-item");
				if (es.size() == 0)
					guard = true;
				for (Element element : es) {
					Elements repoResults = element.getElementsByClass("title");
					for (Element repo : repoResults) {
						Element name = repo.getElementsByTag("a").first();
						String nameString = name.text();
						String[] repositoryId = nameString.split("/");
						Repository repository = repositoryRepository
								.findOneByNameAndOwner_Login(repositoryId[1],
										repositoryId[0]);
						if (repository == null) {
							repository = repositoryService.getRepository(
									repositoryId[0], repositoryId[1]);
							repositoryRepository.save(repository);
							SearchCodeResult scr = findContentsInRepository(
									QUERY_API, repositoryId[0], repositoryId[1]);
							if (scr.getItems().length != 0)
								searchCodeResultRepository.save(scr);
						} else {
							logger.info("RepositoryContents is already imported for repositories: "
									+ nameString);
						}
					}
				}
				logger.info("iteration n: " + i);
				i++;
			} catch (IOException e1) {
				waitApiRate();
			}
		}
		logger.info("Finisced for serach query:" + QUERY_API);
	}
}
