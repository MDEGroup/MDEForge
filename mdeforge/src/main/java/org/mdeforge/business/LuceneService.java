package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;
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
	SearchResultComplete searchForm(String searchString) throws BusinessException;
	SearchResultComplete searchWithPagination(String queryString, int hitsPerPage, int pageNumber) throws BusinessException;
	List<T> search(String searchString, int maxSearchResult) throws BusinessException;
	
	/*
	 * Others
	 */
	List<String> getIndexTagsByArtifactType(Artifact artifact);
	List<String> indexFieldNamesForMM();
	List<String> indexFieldNamesForT();
	List<String> indexFieldNamesForM();
	List<String> getAllIndexTags();
	boolean deleteTermFromIndex(String fieldName, String filePath);

}
