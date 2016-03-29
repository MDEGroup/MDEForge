package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.serializer.json.ArtifactListSerializer;
import org.mdeforge.business.model.serializer.json.ProjectListSerializer;
import org.mdeforge.business.model.serializer.json.WorkspaceListSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


@Document(collection="Users")
public class User implements java.io.Serializable{

	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Id
	private String id = null;
	private static final long serialVersionUID = -8418304837964858131L;
	private String firstname;
	private String lastname;
	private String email;
	private String username = null;
	@JsonIgnore
	private String password = null;
	private boolean enabled;
	@DBRef(lazy=true)
	private List<Role> roles = new ArrayList<Role>();

	@DBRef(lazy=true)
	@JsonSerialize(using = ArtifactListSerializer.class)
	private List<Artifact> owner = new ArrayList<Artifact>();

	@DBRef(lazy=true)
	@JsonSerialize(using = ProjectListSerializer.class)
	private List<Project> sharedProject = new ArrayList<Project>();

	@DBRef(lazy=true)
	@JsonSerialize(using = ArtifactListSerializer.class)
	private List<Artifact> sharedArtifact = new ArrayList<Artifact>();
	
	@DBRef(lazy=true)
	@JsonSerialize(using = WorkspaceListSerializer.class)
	private List<Workspace> workspaces = new ArrayList<Workspace>();
	
	public String getUsername() {
		return username;
	}

	
	public void setUsername(String newUsername) {
		username = newUsername;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String newPassword) {
		password = newPassword;
	}

	
	public List<Role> getRoles() {
		return roles;
	}

	
	public boolean addToRoles(Role rolesValue) {
		if (!roles.contains(rolesValue)) {
			boolean result = roles.add(rolesValue);
			return result;
		}
		return false;
	}

	
	public boolean removeFromRoles(Role rolesValue) {
		if (roles.contains(rolesValue)) {
			boolean result = roles.remove(rolesValue);
			return result;
		}
		return false;
	}

	
	public void clearRoles() {
		while (!roles.isEmpty()) {
			removeFromRoles(roles.iterator().next());
		}
	}

	
	public void setRoles(List<Role> newRoles) {
		roles = newRoles;
	}

	
	public List<Artifact> getOwner() {
		return owner;
	}

	public void setOwner(List<Artifact> newOwner) {
		owner = newOwner;
	}

	public List<Project> getSharedProject() {
		return sharedProject;
	}
	
	public void setSharedProject(List<Project> newSharedProject) {
		sharedProject = newSharedProject;
	}

	
	public List<Artifact> getSharedArtifact() {
		return sharedArtifact;
	}

	public void setSharedArtifact(List<Artifact> newSharedArtifact) {
		sharedArtifact = newSharedArtifact;
	}
	public List<Workspace> getWorkspaces() {
		return workspaces;
	}
	public void setWorkspaces(List<Workspace> newWorkspaces) {
		workspaces = newWorkspaces;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String newId) {
		id = newId;
	}

	
	@Override
	public String toString() {
		return "User " + " [username: " + getUsername() + "]" + " [password: "
				+ getPassword() + "]" + " [id: " + getId() + "]";
	}
	public void addRole(Role role) {
		roles.add(role);
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) 
			return this.id.equals(((User)obj).getId());
		else return false;
	}
}
