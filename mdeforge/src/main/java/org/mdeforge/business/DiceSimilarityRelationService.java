package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.DiceSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;

public interface DiceSimilarityRelationService extends CRUDRelationService<DiceSimilarityRelation>{
	List<DiceSimilarityRelation> findAll(double threshold) throws BusinessException;
	
	List<DiceSimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold) throws BusinessException;
	List<DiceSimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold, int computation);
	
}
