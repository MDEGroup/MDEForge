package org.mdeforge.integration;

import org.mdeforge.business.model.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkspaceRepository extends MongoRepository<Workspace, String>{
	Workspace findByName(String name);
	
	Workspace findById(String id);
	
}
