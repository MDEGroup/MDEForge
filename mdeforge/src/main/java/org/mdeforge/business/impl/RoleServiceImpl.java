package org.mdeforge.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.mdeforge.business.RoleService;
import org.mdeforge.business.model.Role;
import org.mdeforge.integration.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(String id) {
		return roleRepository.findOne(id);
	}

}
