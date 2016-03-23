package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;

public interface SearchProvider <T extends Artifact> {
	void extractedContent(T artifact);
	List<T> search(String text);
	void createIndex(TextIndexDefinition textIndex) throws BusinessException;
}
