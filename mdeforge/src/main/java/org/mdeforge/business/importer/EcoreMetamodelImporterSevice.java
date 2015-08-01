package org.mdeforge.business.importer;

import java.io.IOException;
import java.util.List;

import org.eclipse.egit.github.core.RepositoryContents;

public interface EcoreMetamodelImporterSevice {

	SearchCodeResult findContentsInRepository(final String query,
			String owner, String repository) throws IOException;
	void findEcoreMetamodelsInGithubSinceRepositoryId(long lastImportId) throws IOException, InterruptedException;
	void findEcoreMetamodelsInGithub() throws IOException, InterruptedException;
	GitHubRate waitApiRate() throws IOException, InterruptedException;
	void importEcoreMetamodelBySearchWebSite() throws InterruptedException, IOException;
	List<RepositoryContents> getContentsFromSearchCodeResult(
			SearchCodeResult searchCodeResult) throws IOException,
			InterruptedException;
	List<RepositoryContents> getContentsFromSearchCodeResultBoost(
			SearchCodeResult searchCodeResult) throws IOException,
			InterruptedException;
	
}
