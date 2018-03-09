package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Project;
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

	void update(User user) throws BusinessException;

	void changePassword(User us, String password_old, String password_new, String password_new_r) throws BusinessException;

	User findOneByUsername(String username) throws BusinessException;

	User findOneByEmail(String email) throws BusinessException;

	List<User> findByUsernameContaining(String name);
	
	void removeSharedProjectInUsers(Project project) throws BusinessException;
}