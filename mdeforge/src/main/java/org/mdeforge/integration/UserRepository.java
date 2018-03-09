package org.mdeforge.integration;

import java.util.List;

import org.mdeforge.business.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>{
	User findByUsernameAndEnabled(String username, boolean enabled);
	User findByUsername(String username);
	User findByEmail(String email);
	List<User> findByUsernameContaining(String name);

}
