package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.model.serializer.json.UserListSerializer;
import org.mdeforge.business.model.serializer.json.UserSerializer;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Document(collection="Jsfiddles")
public class Jsfiddle implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2338717482275907141L;
	
	private String id;
	private String name;
	private List<ContentView> contentViewList = new ArrayList<ContentView>();
	@DBRef
	@JsonSerialize(using = UserSerializer.class)
	private User owner;
	@DBRef
	@JsonSerialize(using = UserListSerializer.class)
	private List<User> users = new ArrayList<User>();
	private Date createdDate;
	private Date modifiedDate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ContentView> getContentViewList() {
		return contentViewList;
	}
	public void setContentViewList(List<ContentView> contentViewList) {
		this.contentViewList = contentViewList;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
}
