package org.mdeforge.common.spring.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
	
	private String role;

	public GrantedAuthorityImpl(String role) {
		super();
		this.role = role;
	}


	@Override
	public String getAuthority() {
		return role;
	}

	@Override
	public String toString() {
		return "[autority=" + role + "]";
	}
}