package org.mdeforge.integration;


import org.eclipse.egit.github.core.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryRepository extends MongoRepository<Repository, String>{
	Repository findTopByOrderByIdDesc();
	Repository findOneByNameAndOwner_Login(String name, String owner);
}
	
