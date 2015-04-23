package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ContainmentRelation;

public interface ContainmentRelationService extends CRUDRelationService<ContainmentRelation>{
//	List<SimilarityRelation> findAll(int computation) throws BusinessException;
	List<ContainmentRelation> findAll(double threshold) throws BusinessException;
//	List<SimilarityRelation> findAll(double threshold, int computation) throws BusinessException;
//
//	List<SimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold) throws BusinessException;
//	List<SimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold, int computation);
	
}
