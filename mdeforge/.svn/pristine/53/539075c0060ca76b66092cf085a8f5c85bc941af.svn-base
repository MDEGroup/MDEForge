package org.mdeforge.integration;

import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EcoreMetamodelRepository extends MongoRepository<EcoreMetamodel, String>{
	EcoreMetamodel findByName(String name);
	@Query("{_class:\"org.mdeforge.business.model.Metamodel\"}")
	Page<EcoreMetamodel> findByOpen(boolean b, Pageable p);
	@Query("{_class : \"org.mdeforge.business.model.Metamodel\","
		  + " workspaces :  {$elemMatch : {\"$id\" : ?0}}}")
	List<EcoreMetamodel> findByWorkspaceId(ObjectId id);
	@Query("{_class : \"org.mdeforge.business.model.Metamodel\","
			  + " projects :  {$elemMatch : {\"$id\" : ?0}}}")
	List<EcoreMetamodel> findByProjectId(ObjectId id);
}
