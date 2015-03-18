package org.mdeforge.integration.impl;

import java.util.List;

import org.mdeforge.business.model.Transformation;
import org.mdeforge.integration.TransformationRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;

@Controller
public class TransformationRepositoryImpl implements TransformationRepositoryCustom {
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	
	@Override
	public List<Transformation> findAllTransformations() {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Criteria c = new Criteria("_class").is(Transformation.class.getCanonicalName());
		Query q = Query.query(c);
		List<Transformation> p = operations.find(q, Transformation.class);
		return p;
		
	}


}
