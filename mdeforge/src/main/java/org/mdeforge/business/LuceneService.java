package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;

public interface LuceneService {
	
	void createLuceneIndex(Artifact artifact);
	List<String> getIndexTagsByArtifactType(Artifact artifact);

}
