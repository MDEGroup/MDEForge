package org.mdeforge.business.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.DiceSimilarityRelationService;
import org.mdeforge.business.model.DiceSimilarityRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
@Service
public class DiceSimilarityRelationServiceImpl extends ValuedRelationServiceImpl<DiceSimilarityRelation> implements DiceSimilarityRelationService {
	@Override
	public List<DiceSimilarityRelation> findAll(double threshold) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("value").gte(threshold);
		Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
		query.addCriteria(c2.andOperator(c1));
		return n.find(query, persistentClass);
	}
//	@Override
//	public List<SimilarityRelation> findAll(double threshold, int computation) {
//		MongoOperations n = new MongoTemplate(mongoDbFactory);
//		Query query = new Query();
//		Criteria c2 = Criteria.where("computation").is(computation);
//		Criteria c1 = Criteria.where("_class").is(SimilarityRelation.class.getCanonicalName());
//		Criteria c3 = Criteria.where("value").gt(threshold);
//		query.addCriteria(c2.andOperator(c1,c3));
//		return n.find(query, persistentClass);
//	}
//	@Override
//	public List<SimilarityRelation> findAll(int computation) {
//		MongoOperations n = new MongoTemplate(mongoDbFactory);
//		Query query = new Query();
//		Criteria c2 = Criteria.where("computation").is(computation);
//		Criteria c1 = Criteria.where("_class").is(SimilarityRelation.class.getCanonicalName());
//		query.addCriteria(c2.andOperator(c1));
//		return n.find(query, persistentClass);
//	}
	@Override
	public List<DiceSimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
		Criteria c2 = Criteria.where("value").gte(threshold);
		Criteria c3 = Criteria.where("toArtifact.$id").is(new ObjectId(emm.getId()));
		Criteria c4 = Criteria.where("fromArtifact.$id").is(new ObjectId(emm.getId()));
		Criteria c5 = c2.orOperator(c4,c3);
		query.addCriteria(c1.andOperator(c5));
		return n.find(query, persistentClass);
	}
	@Override
	public List<DiceSimilarityRelation> findByEcoreMetamodel(EcoreMetamodel emm, double threshold, int computation) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c1 = Criteria.where("_class").is(persistentClass.getCanonicalName());
		Criteria c2 = Criteria.where("value").gte(threshold);
		Criteria c3 = Criteria.where("toArtifact.$id").is(new ObjectId(emm.getId()));
		Criteria c4 = Criteria.where("fromArtifact.$id").is(new ObjectId(emm.getId()));
		Criteria c5 = Criteria.where("computation").is(computation);
		Criteria c6 = c2.orOperator(c4,c3);
		query.addCriteria(c1.andOperator(c6,c5));
		return n.find(query, persistentClass);
	}
}
