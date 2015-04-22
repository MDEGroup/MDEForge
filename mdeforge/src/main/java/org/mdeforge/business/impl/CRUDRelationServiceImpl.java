package org.mdeforge.business.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.CRUDRelationService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.SimilarityRelation;
import org.mdeforge.integration.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

public abstract class CRUDRelationServiceImpl<T extends Relation> implements CRUDRelationService<T> {

	@Autowired
	private RelationRepository relationRepository;
	@Autowired
	protected SimpleMongoDbFactory mongoDbFactory;
	protected Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public CRUDRelationServiceImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
	@Override
	public void save (Relation r) {
		relationRepository.save(r);
	}
	
	@Override
	public List<T> findAll() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		return n.findAll(persistentClass);
	}
}
