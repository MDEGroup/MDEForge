package org.mdeforge.integration;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.model.ETLTransformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ETLTransformationRepository extends MongoRepository<ETLTransformation, String> {
	ETLTransformation findByName(String name);

	@Query("{_class : \"org.mdeforge.business.model.ATLTransformation\","
			+ " workspaces :  {$elemMatch : {\"$id\" : ?0}}}")
	List<ETLTransformation> findByWorkspaceId(ObjectId id);
	@Query("{_class : \"org.mdeforge.business.model.ATLTransformation\"}")
	List<ETLTransformation> find();
	@Query("{_class : \"org.mdeforge.business.model.ATLTransformation\","
			+ " projects :  {$elemMatch : {\"$id\" : ?0}}}")
	List<ETLTransformation> findByProjectId(ObjectId id);
}
