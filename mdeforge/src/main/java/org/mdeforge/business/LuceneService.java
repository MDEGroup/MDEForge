package org.mdeforge.business;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.index.IndexReader;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.SearchResultComplete;

public interface LuceneService <T extends Artifact>{
	
	/*
	 * Lucene Indexing
	 */
	void createLuceneIndex(Artifact artifact);
	void createLuceneIndexFromConfigurationPath();
	
	/*
	 * Lucene Searching
	 */
	SearchResultComplete searchForm(User user, String searchString) throws BusinessException;
	SearchResultComplete searchWithPagination(User user, String queryString, int hitsPerPage, int pageNumber) throws BusinessException;
	List<T> search(User user, String searchString, int maxSearchResult) throws BusinessException;
	
	/*
	 * Others
	 */
	List<String> getIndexTagsByArtifactType(Artifact artifact);
	List<String> indexFieldNamesForMM();
	List<String> indexFieldNamesForT();
	List<String> indexFieldNamesForM();
	List<String> getAllIndexTags();
	boolean deleteTermFromIndex(String fieldName, String filePath);
	String getMaxFrequencyTerms() throws IOException;

}
