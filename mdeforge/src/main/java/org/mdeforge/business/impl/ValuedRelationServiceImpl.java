package org.mdeforge.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ValuedRelationService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ValuedRelation;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public abstract class ValuedRelationServiceImpl<T extends ValuedRelation>
		extends CRUDRelationServiceImpl<T> implements ValuedRelationService<T> {

	@Override
	
	public List<T> findRelationsByArtifactInList(Artifact art,
			Set<Artifact> artifacts) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		
		Criteria c1 = Criteria.where("_class").is(
				persistentClass.getCanonicalName());
		List<ObjectId> ls = new ArrayList<ObjectId>();
		for (Artifact artifact : artifacts) {
			ls.add(new ObjectId(artifact.getId()));
		}
		
		Criteria c2 = Criteria.where("fromArtifact.$id").is(new ObjectId(art.getId()));
		Criteria c3 = Criteria.where("toArtifact.$id").in(ls);
		Criteria c6 = new Criteria();
		c6.andOperator(c2,c3);
		
		Criteria c4 = Criteria.where("toArtifact.$id").is(new ObjectId(art.getId()));
		Criteria c5 = Criteria.where("fromArtifact.$id").in(ls);
		Criteria c7 = new Criteria();
		c7.andOperator(c4,c5);
		
		
		query.addCriteria(c1.orOperator(c6,c7));
		return n.find(query, persistentClass);
	}

	@Override
	public List<T> findTopProximity(Artifact a, int i)
			throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.limit(i);
		query.with(new Sort(Sort.Direction.DESC, "value"));
		
		Criteria c1 = Criteria.where("_class").is(
				persistentClass.getCanonicalName());
		Criteria c2 = Criteria.where("fromArtifact.$id").is(new ObjectId(a.getId()));
		Criteria c3 = Criteria.where("toArtifact.$id").is(new ObjectId(a.getId()));

		query.addCriteria(c1.orOperator(c2, c3));
		return n.find(query, persistentClass);

	}

	@Override
	public List<T> findAll(double threshold) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("value").gte(threshold);
		Criteria c1 = Criteria.where("_class").is(
				persistentClass.getCanonicalName());
		query.addCriteria(c2);
		query.addCriteria(c1);
		return n.find(query, persistentClass);
	}

	// @Override
	// public List<SimilarityRelation> findAll(double threshold, int
	// computation) {
	// MongoOperations n = new MongoTemplate(mongoDbFactory);
	// Query query = new Query();
	// Criteria c2 = Criteria.where("computation").is(computation);
	// Criteria c1 =
	// Criteria.where("_class").is(SimilarityRelation.class.getCanonicalName());
	// Criteria c3 = Criteria.where("value").gt(threshold);
	// query.addCriteria(c2.andOperator(c1,c3));
	// return n.find(query, persistentClass);
	// }
	// @Override
	// public List<SimilarityRelation> findAll(int computation) {
	// MongoOperations n = new MongoTemplate(mongoDbFactory);
	// Query query = new Query();
	// Criteria c2 = Criteria.where("computation").is(computation);
	// Criteria c1 =
	// Criteria.where("_class").is(SimilarityRelation.class.getCanonicalName());
	// query.addCriteria(c2.andOperator(c1));
	// return n.find(query, persistentClass);
	// }
	@Override
	public List<T> findByArtifact(Artifact emm, double threshold) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("_class").is(
				persistentClass.getCanonicalName());
		Criteria c2 = Criteria.where("value").gte(threshold);
		Criteria c3 = Criteria.where("toArtifact.$id").is(
				new ObjectId(emm.getId()));
		Criteria c4 = Criteria.where("fromArtifact.$id").is(
				new ObjectId(emm.getId()));
		Criteria c5 = c2.orOperator(c4, c3);
		query.addCriteria(c1);
		query.addCriteria(c5);
		return n.find(query, persistentClass);
	}

	@Override
	public List<T> findByArtifact(Artifact emm, double threshold,
			int computation) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("_class").is(
				persistentClass.getCanonicalName());
		Criteria c2 = Criteria.where("value").gte(threshold);
		Criteria c3 = Criteria.where("toArtifact.$id").is(
				new ObjectId(emm.getId()));
		Criteria c4 = Criteria.where("fromArtifact.$id").is(
				new ObjectId(emm.getId()));
		Criteria c5 = Criteria.where("computation").is(computation);
		Criteria c6 = c2.orOperator(c4, c3);
		query.addCriteria(c1);
		query.addCriteria(c6);
		query.addCriteria(c5);
		return n.find(query, persistentClass);
	}
	@Override
	public T findNearest(Artifact a, double threshold) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "value"));
		Criteria thresholdC = Criteria.where("value").gte(threshold);
		Criteria c1 = Criteria.where("_class").is(
				persistentClass.getCanonicalName());
		
		Criteria c2 = Criteria.where("fromArtifact.$id").is(new ObjectId(a.getId()));
		Criteria c3 = Criteria.where("toArtifact.$id").is(new ObjectId(a.getId()));
		query.addCriteria(thresholdC);
		query.addCriteria(c1.orOperator(c2, c3));
		//TODO ELIMINARE
//		List<T> al = n.find(query, persistentClass);
//		for (T t : al) {
//			if ((t.getToArtifact().getTags() == null || t.getToArtifact().getTags().size() == 0) &&
//					(t.getFromArtifact().getTags() == null || t.getFromArtifact().getTags().size() == 0))
//				return t;
//		}
//		return null;
		//TODO ELIMINARE
		return n.findOne(query, persistentClass);
	}
}
