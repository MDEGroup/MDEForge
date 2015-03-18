package org.mdeforge.integration;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.model.Transformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TransformationRepository extends MongoRepository<Transformation, String>,
		TransformationRepositoryCustom {
	Transformation findByName(String name);

	@Query("{_class : \"org.mdeforge.business.model.Transformation\","
			+ " workspaces :  {$elemMatch : {\"$id\" : ?0}}}")
	List<Transformation> findByWorkspaceId(ObjectId id);

	@Query("{_class : \"org.mdeforge.business.model.Transformation\","
			+ " projects :  {$elemMatch : {\"$id\" : ?0}}}")
	List<Transformation> findByProjectId(ObjectId id);
}
