package org.mdeforge.integration;

import org.mdeforge.business.model.Relation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelationRepository extends MongoRepository<Relation, String>{

}
