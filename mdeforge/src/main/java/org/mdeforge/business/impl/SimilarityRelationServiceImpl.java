package org.mdeforge.business.impl;


import java.util.List;

import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Relation;
import org.mdeforge.integration.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
@Service
public class SimilarityRelationServiceImpl implements SimilarityRelationService {

	@Autowired
	private RelationRepository relationRepository;
	@Autowired
	protected SimpleMongoDbFactory mongoDbFactory;
	@Override
	public void save (Relation r) {
		relationRepository.save(r);
	}
	@Override
	public List<Relation> findAll(double treshold) {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("value").gt(treshold);
		query.addCriteria(c2);
		return n.find(query, Relation.class);
	}
	@Override
	public List<Relation> findAll() {
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		return n.findAll(Relation.class);
	}
}
