package org.mdeforge.integration.impl;

import java.util.List;

import org.mdeforge.business.model.Metamodel;
import org.mdeforge.integration.MetamodelRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;

@Controller
public class MetamodelRepositoryImpl implements MetamodelRepositoryCustom {
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	
	@Override
	public List<Metamodel> findAllMetamodels() {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Criteria c = new Criteria("_class").is(Metamodel.class.getCanonicalName());
		Query q = Query.query(c);
		List<Metamodel> p = operations.find(q, Metamodel.class);
		return p;
		
	}


}
