package org.mdeforge.integration;


import org.mdeforge.business.model.Workspace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface WorkspaceRepository extends MongoRepository<Workspace, String>{
	Workspace findByName(String name);
	@Query("{ owner :  {$elemMatch : {\"$id\" : ?1}}}")
	Page<Workspace> findAll(Pageable p, String id);
	
	Workspace findById(String id);
	
}
