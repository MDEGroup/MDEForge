package org.mdeforge.business.impl;

import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.Role;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.RoleRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Override
	public User authenticate(String username) throws BusinessException {
		return userRepository.findByUsername(username);
	}

	@Override
	public void create(User user) throws BusinessException {
		Role role = roleRepository.findOne("546f7ba5ce248eba4487eda5");
		user.getRoles().add(role);
		userRepository.save(user);
	}

	
	
	@Override
	public User findOne(String id) throws BusinessException{
		User u = userRepository.findOne(id);
		if(u == null)
			throw new  BusinessException();
		else return u;
	}

	@Override
	public List<User> findAll() throws BusinessException {
		return userRepository.findAll();
	}

	@Override
	public void delete(String id) throws BusinessException {
		try{
			User user = userRepository.findOne(id);
			userRepository.delete(user);
		}catch(Exception e) {throw new BusinessException();}
	}

	@Override
	public User findOneByUsername(String name) {
		User user = userRepository.findByUsername(name);
		if(user == null)
			throw new BusinessException();
		else return user;
		
	}

}
