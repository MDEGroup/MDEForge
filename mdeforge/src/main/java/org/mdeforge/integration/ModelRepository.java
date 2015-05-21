package org.mdeforge.integration;


import org.mdeforge.business.model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ModelRepository extends MongoRepository<Model, String> {
	Model findByName(String name);
	//Model findByNsuri(String nsuri);
}
