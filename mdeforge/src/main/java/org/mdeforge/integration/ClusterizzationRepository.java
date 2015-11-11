package org.mdeforge.integration;

import org.mdeforge.business.model.Clusterizzation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClusterizzationRepository extends MongoRepository<Clusterizzation, String> {

}
