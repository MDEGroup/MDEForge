package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Role;

public interface RoleService {

	public List<Role> findAll();
	public Role findById(String id);
	
}
