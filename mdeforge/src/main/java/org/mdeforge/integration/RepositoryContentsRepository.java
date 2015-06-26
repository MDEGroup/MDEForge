package org.mdeforge.integration;


import org.eclipse.egit.github.core.RepositoryContents;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryContentsRepository extends MongoRepository<RepositoryContents, String>{
	RepositoryContents findOneByNameAndSize(String name, long size);
}
	
