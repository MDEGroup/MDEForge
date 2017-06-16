package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;

public interface LuceneService {
	
	void createLuceneIndex(Artifact artifact);
	void createLuceneIndexFromConfigurationPath();
	List<String> getIndexTagsByArtifactType(Artifact artifact);
	List<String> getAllIndexTags();
	

}
