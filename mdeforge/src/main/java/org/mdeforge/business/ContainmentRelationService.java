package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ContainmentRelation;
import org.mdeforge.business.model.EcoreMetamodel;

public interface ContainmentRelationService extends ValuedRelationService<ContainmentRelation>{
//	List<SimilarityRelation> findAll(int computation) throws BusinessException;
	List<ContainmentRelation> findAll(double threshold) throws BusinessException;
//	List<SimilarityRelation> findAll(double threshold, int computation) throws BusinessException;
	ContainmentRelation findNearest(EcoreMetamodel a, double threshold) throws BusinessException;
	
//	List<SimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold) throws BusinessException;
//	List<SimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold, int computation);
	
}
