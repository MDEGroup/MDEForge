package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;

import com.fasterxml.jackson.core.type.TypeReference;

public class UserService extends MDEForgeClient {

	public UserService(String connectionUrl, String username, String password)
			throws Exception {
		super(connectionUrl, username, password);
	}

	public List<User> getUsers() throws Exception {
		String result = doGetRequest(connectionUrl + "api/user/");
		return mapper.readValue(result, new TypeReference<List<User>>() {
		});
	}
	
	public User getUser() throws Exception{
		List<User> list = this.getUsers();
		for(User u : list){
			if(u.getUsername().equals(username)){
				return u;
			}
		}
		throw new Exception();
	}

	public User getUser(String string) throws Exception {
		String result = doGetRequest(connectionUrl + "api/user/" + string);
		return mapper.readValue(result, User.class);
	}
}
