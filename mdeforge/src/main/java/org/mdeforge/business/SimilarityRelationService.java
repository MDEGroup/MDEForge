package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.SimilarityRelation;


public interface SimilarityRelationService {

	void save(Relation r);

	List<SimilarityRelation> findAll();
	List<SimilarityRelation> findAll(double threshold);
	List<SimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold);
	

}
