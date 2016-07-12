package org.mdeforge.business.impl;


import java.lang.reflect.ParameterizedType;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDRelationService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
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
	public Set<T> findByUser(User user) throws BusinessException {
		Set<T> result = new HashSet<T>();
		for (Artifact artifact : user.getSharedArtifact()) {
			result.addAll(findRelationsByArtifact(artifact));
		}
		return result;
	}
	@Override
	public List<T> findRelationsByArtifact(Artifact artifact) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Criteria from = Criteria.where("fromArtifact.$id").is(new ObjectId(artifact.getId()));
		Criteria to = Criteria.where("toArtifact.$id").is(new ObjectId(artifact.getId()));
		Query query = new Query();
		if(persistentClass!=Relation.class) {
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c.orOperator(from, to));
		}
		else {
			query.addCriteria(new Criteria().orOperator(from, to));
		}
		return n.find(query, persistentClass);
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
	public long countAll() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		if(persistentClass!=Relation.class) {
			Query query = new Query();
			Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c);
			return n.count(query, persistentClass);
		}
		else 
			return n.count(null, persistentClass);
	}
	@Override
	public List<T> findAllPaginated(int start, int lenght) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		if(persistentClass!=Relation.class) {
			Query query = new Query();
			query.skip(start*lenght);
			query.limit(lenght);
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
		Criteria c2 = Criteria.where("toArtifact.$id").is(new ObjectId(toArt.getId()));
		Criteria c4 = Criteria.where("fromArtifact.$id").is(new ObjectId(fromArt.getId()));
		if(persistentClass!=Relation.class){
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
			query.addCriteria(c4);
		}
		else {
			query.addCriteria(c2);
			query.addCriteria(c4);
		}
		return n.find(query, persistentClass);
	}
	@Override
	public List<T> findRelationsByFromArtifact(Artifact fromArt) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c4 = Criteria.where("fromArtifact.$id").is(new ObjectId(fromArt.getId()));
		if(persistentClass!=Relation.class){
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c4);
		}
		else {
			query.addCriteria(c4);
		}
		return n.find(query, persistentClass);
	}
	@Override
	public T findOneByArtifacts(Artifact fromArt, Artifact toArt) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("toArtifact.$id").is(new ObjectId(toArt.getId()));
		Criteria c4 = Criteria.where("fromArtifact.$id").is(new ObjectId(fromArt.getId()));
		if(persistentClass!=Relation.class){
			Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
			query.addCriteria(c1);
			query.addCriteria(c2);
			query.addCriteria(c4);
		}
		else {
			query.addCriteria(c2);
			query.addCriteria(c4);			
		}
		return n.findOne(query, persistentClass);
	}
}
