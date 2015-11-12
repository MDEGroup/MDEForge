package org.mdeforge.business;

import org.mdeforge.business.model.Artifact;



public interface SimilarityService {
	double calculateSimilarity(Artifact art1, Artifact art2) throws BusinessException;
}
