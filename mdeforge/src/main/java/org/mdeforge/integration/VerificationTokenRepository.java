package org.mdeforge.integration;


import org.mdeforge.business.model.VerificationToken;
import org.mdeforge.business.model.Workspace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VerificationTokenRepository extends MongoRepository<VerificationToken, String>{
	VerificationToken findByToken(String token);
}
