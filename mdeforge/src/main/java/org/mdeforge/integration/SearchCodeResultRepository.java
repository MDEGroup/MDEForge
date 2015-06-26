package org.mdeforge.integration;


import org.eclipse.egit.github.core.Repository;
import org.mdeforge.business.importer.SearchCodeResult;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SearchCodeResultRepository extends MongoRepository<SearchCodeResult, String>{

}
	
