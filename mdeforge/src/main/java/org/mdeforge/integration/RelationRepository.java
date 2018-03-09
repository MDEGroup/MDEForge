package org.mdeforge.integration;

import java.util.List;

import org.mdeforge.business.model.Relation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelationRepository extends MongoRepository<Relation, String>{
	List<Relation> findByToArtifactId(String id);
	List<Relation> findByFromArtifactId(String id);
	List<Relation> findByFromArtifactIdOrToArtifactId(String idFrom, String idTo);
}
