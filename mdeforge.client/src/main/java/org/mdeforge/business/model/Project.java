package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.serializer.json.ArtifactListSerializer;
import org.mdeforge.business.model.serializer.json.UserListSerializer;
import org.mdeforge.business.model.serializer.json.UserSerializer;
import org.mdeforge.business.model.serializer.json.WorkspaceListSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A representation of the model object '<em><b>Project</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Project implements java.io.Serializable{

	
	private static final long serialVersionUID = -717518242205317774L;

	@JsonSerialize(using = ArtifactListSerializer.class)
	private List<Artifact> artifacts = new ArrayList<Artifact>();

	@JsonSerialize(using = UserSerializer.class)
	private User owner;
	
	@JsonSerialize(using = UserListSerializer.class)
	private List<User> users = new ArrayList<User>();

	@JsonSerialize(using = WorkspaceListSerializer.class)
	private List<Workspace> workspaces = new ArrayList<Workspace>();

	private String name = null;

	private String id = null;

	public List<Artifact> getArtifacts() {
		return artifacts;
	}

	public void setArtifacts(List<Artifact> newArtifacts) {
		artifacts = newArtifacts;
	}

	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> newShared) {
		users = newShared;
	}

	public List<Workspace> getWorkspaces() {
		return workspaces;
	}

	public void setWorkspaces(List<Workspace> newWorkspaces) {
		workspaces = newWorkspaces;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getId() {
		return id;
	}

	
	public void setId(String newId) {
		id = newId;
	}

	@Override
	public String toString() {
		return "Project " + " [name: " + getName() + "]" + " [id: " + getId()
				+ "]";
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
}
