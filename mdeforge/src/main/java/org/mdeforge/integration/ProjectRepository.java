package org.mdeforge.integration;

import org.mdeforge.business.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String>{
	Project findByName(String name);
	Project findById(String id);
}
