package org.mdeforge.integration;

import org.mdeforge.business.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String>{

}
