package org.mdeforge.integration;


import org.mdeforge.business.model.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VerificationTokenRepository extends MongoRepository<VerificationToken, String>{
	VerificationToken findByToken(String token);
}
