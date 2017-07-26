package org.mdeforge.business;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.SearchResultComplete;

public interface LuceneService{

	void createLuceneIndexFromConfigurationPath();

	String getMaxFrequencyTerms() throws IOException;
	
	SearchResultComplete search(User user, String queryString) throws BusinessException;
	SearchResultComplete search(User user, String queryString, int hitsPerPage, int pageNumber) throws BusinessException;
	List<Artifact> search(User user, String queryString, int maxSearchResult) throws BusinessException;

}
