package org.mdeforge.business.model;

import org.mdeforge.business.model.serializer.json.UserSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Comment {
	@Id
	private String id;
	private String comment;
	private int star;
	
	@DBRef
	@JsonSerialize(using = UserSerializer.class)
	private User user;
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this == null)
			return false;
		if (!Comment.class.isInstance(obj))
			return false;
		if (((Comment) obj).getId()==null)
			return false;
		if (id == null)
			return false;
		if (((Comment)obj).getId().equals(id))
			return true;
		else return false;
	}
	
}
