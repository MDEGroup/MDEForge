package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.User;
import org.mdeforge.business.model.VerificationToken;

public interface UserService {

	User authenticate(String username) throws BusinessException;
	
	User create(User user) throws BusinessException;
	
	User findOne(String id) throws BusinessException;
	
	List<User> findAll() throws BusinessException;
	
	void delete(String id) throws BusinessException;

	long countUsers() throws BusinessException;

	void saveRegisteredUser(User user);

	VerificationToken getVerificationToken(String token);

	void createVerificationToken(User user, String token);
}