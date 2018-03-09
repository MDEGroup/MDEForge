package org.mdeforge.integration;


import org.mdeforge.business.model.GridFileMedia;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GridFileMediaRepository extends MongoRepository<GridFileMedia, String> {

}
