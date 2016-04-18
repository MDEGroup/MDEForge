package org.mdeforge.integration;


import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.ToBeAnalyse;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ToBeAnalyseRepository extends MongoRepository<ToBeAnalyse, String> {

}
