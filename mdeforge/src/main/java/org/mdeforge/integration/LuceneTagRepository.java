package org.mdeforge.integration;

import org.mdeforge.business.model.LuceneTag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LuceneTagRepository extends MongoRepository<LuceneTag, String>{

}
