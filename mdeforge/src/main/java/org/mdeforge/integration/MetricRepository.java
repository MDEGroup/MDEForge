package org.mdeforge.integration;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.model.Metric;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MetricRepository extends MongoRepository<Metric, String> {
	
	@Query("{\"artifact.$id\" : ?0}}")
	List<Metric> findByArtifactId(ObjectId objectId);
	@Query("{name : ?0, \"artifact.$id\" : ?1}}")
	Metric findOneByNameAndArtifactId(String name, ObjectId objectId);
	Metric findOneByName(String name, ObjectId objectId);
}
