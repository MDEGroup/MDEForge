package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.DiceSimilarityRelation;

public interface DiceSimilarityRelationService extends ValuedRelationService<DiceSimilarityRelation>{
	List<DiceSimilarityRelation> findAll(double threshold) throws BusinessException;
	

	
}
