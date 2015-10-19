package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ContainmentRelationService;
import org.mdeforge.business.model.ContainmentRelation;
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
	
}
