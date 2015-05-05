package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.SimilarityRelation;
import org.mdeforge.business.model.ValuedRelation;

public interface ValuedRelationService <T extends ValuedRelation> extends CRUDRelationService<T>{
	List<T> findAll(double threshold) throws BusinessException;
	
	List<T> findByEcoreMetamodel(EcoreMetamodel emm, double threshold) throws BusinessException;
	List<T> findByEcoreMetamodel(EcoreMetamodel emm, double threshold, int computation);
	
}
