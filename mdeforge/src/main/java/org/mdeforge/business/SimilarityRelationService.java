package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Relation;


public interface SimilarityRelationService {

	void save(Relation r);

	List<Relation> findAll();
	List<Relation> findAll(double treshold);

}
