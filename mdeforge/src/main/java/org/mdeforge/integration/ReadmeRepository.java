package org.mdeforge.integration;

import org.mdeforge.business.model.ReadmeFile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReadmeRepository extends MongoRepository<ReadmeFile, String>{
	
}
