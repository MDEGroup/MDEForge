package org.mdeforge.integration;

import org.mdeforge.business.model.Jsfiddle;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JsfiddleRepository extends MongoRepository<Jsfiddle,String>{
	Jsfiddle findByName(String name);
	Jsfiddle findById(String id);
}
