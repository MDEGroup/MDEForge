package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Relation;


public interface CRUDRelationService<T extends Relation> {

	void save(Relation r);
	List<T> findAll() throws BusinessException;
	
	

}
