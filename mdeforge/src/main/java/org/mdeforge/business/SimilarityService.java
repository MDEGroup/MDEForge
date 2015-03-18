package org.mdeforge.business;

import org.mdeforge.business.model.Artifact;



public interface SimilarityService {
	
	String calculateSimilarity(Artifact art1, Artifact art2);
}
