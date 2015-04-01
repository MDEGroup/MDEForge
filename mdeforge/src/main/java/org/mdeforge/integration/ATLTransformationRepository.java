package org.mdeforge.integration;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.model.ATLTransformation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ATLTransformationRepository extends MongoRepository<ATLTransformation, String> {
	ATLTransformation findByName(String name);

	@Query("{_class : \"org.mdeforge.business.model.ATLTransformation\","
			+ " workspaces :  {$elemMatch : {\"$id\" : ?0}}}")
	List<ATLTransformation> findByWorkspaceId(ObjectId id);
	@Query("{_class : \"org.mdeforge.business.model.ATLTransformation\"}")
	List<ATLTransformation> find();
	@Query("{_class : \"org.mdeforge.business.model.ATLTransformation\","
			+ " projects :  {$elemMatch : {\"$id\" : ?0}}}")
	List<ATLTransformation> findByProjectId(ObjectId id);
}
