package org.mdeforge.integration;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Metamodel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ArtifactRepository extends MongoRepository<Artifact, String>{
	Metamodel findByName(String name);
	@Query("{ \"name\" : ?0, \"_class\" : ?1}")
	Metamodel findByName(String name, String type);
	@Query("{ projects :  {$elemMatch : {\"$id\" : ?0}}}")
	List<Artifact> findByProjectId(ObjectId objectId);
	@Query("{ workspaces :  {$elemMatch : {\"$id\" : ?0}}}")
	List<Artifact> findByWorkspaceId(ObjectId objectId);
	@Query("{ projects :  {$elemMatch : {\"$id\" : ?0}}, \"_class\" : ?1}")
	List<Artifact> findByProjectId(ObjectId objectId, String c);
	@Query("{ workspaces :  {$elemMatch : {\"$id\" : ?0}}, \"_class\" : ?1}")
	List<Artifact> findByWorkspaceId(ObjectId objectId, String type);
	
	
}
