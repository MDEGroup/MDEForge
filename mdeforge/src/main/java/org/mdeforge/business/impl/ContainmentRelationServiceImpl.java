package org.mdeforge.business.impl;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.model.ContainmentRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
@Service
public class ContainmentRelationServiceImpl extends ValuedRelationServiceImpl<ContainmentRelation> implements ContainmentRelationService {

	@Override
	public List<ContainmentRelation> findAll(double threshold) throws BusinessException {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("value").gte(threshold);
		Criteria c1 = Criteria.where("_class").is(ContainmentRelation.class.getCanonicalName());
		query.addCriteria(c2);
		query.addCriteria(c1);
		return n.find(query, persistentClass);
	}
	@Override
	public ContainmentRelation findNearest(EcoreMetamodel a, double threshold) throws BusinessException {
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
		return n.findOne(query, persistentClass);
	}
	
}
