package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.CosineSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;

public interface CosineSimilarityRelationService extends CRUDRelationService<CosineSimilarityRelation>{
	List<CosineSimilarityRelation> findAll(double threshold) throws BusinessException;
	
	List<CosineSimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold) throws BusinessException;
	List<CosineSimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold, int computation);
	
}
