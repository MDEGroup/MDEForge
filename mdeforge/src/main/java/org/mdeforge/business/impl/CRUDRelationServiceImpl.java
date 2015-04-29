package org.mdeforge.business.impl;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDRelationService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Relation;
import org.mdeforge.integration.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
		if(persistentClass!=Relation.class) {
			Query query = new Query();
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c);
			return n.find(query, persistentClass);
		}
		else 
			return n.findAll(persistentClass);
	}
	@Override
	public List<T> findByArtifacts(Artifact fromArt, Artifact toArt) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c;
		Criteria c2 = Criteria.where("toArtifact.$id").is(new ObjectId(toArt.getId()));
		Criteria c4 = Criteria.where("fromArtifact.$id").is(new ObjectId(fromArt.getId()));
		if(persistentClass!=Relation.class){
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			c = new Criteria().andOperator(c1,c2,c4);
		}
		else 
			c = new Criteria().andOperator(c2,c4);
		query.addCriteria(c);
		return n.find(query, persistentClass);
	}
	@Override
	public T findOneByArtifacts(Artifact fromArt, Artifact toArt) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c;
		Criteria c2 = Criteria.where("toArtifact.$id").is(new ObjectId(toArt.getId()));
		Criteria c4 = Criteria.where("fromArtifact.$id").is(new ObjectId(fromArt.getId()));
		if(persistentClass!=Relation.class){
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			c = new Criteria().andOperator(c1,c2,c4);
		}
		else 
			c = new Criteria().andOperator(c2,c4);
		query.addCriteria(c);
		return n.findOne(query, persistentClass);
	}
}
