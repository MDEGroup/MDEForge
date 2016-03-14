package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.User;

public interface UserService {

	User authenticate(String username) throws BusinessException;
	
	void create(User user) throws BusinessException;
	
	User findOne(String id) throws BusinessException;
	
	List<User> findAll() throws BusinessException;
	
	void delete(String id) throws BusinessException;

	User findOneByUsername(String name) throws BusinessException;

	long countUsers() throws BusinessException;
}