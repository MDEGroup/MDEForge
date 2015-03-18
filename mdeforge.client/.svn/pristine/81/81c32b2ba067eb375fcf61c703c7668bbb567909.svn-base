package org.mdeforge.business.model;
import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.serializer.json.ArtifactListSerializer;
import org.mdeforge.business.model.serializer.json.ProjectListSerializer;
import org.mdeforge.business.model.serializer.json.UserSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * A representation of the model object '<em><b>Workspace</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Workspace implements java.io.Serializable{

	private String id = null;
	private String description;
	private String name = null;
	private static final long serialVersionUID = -1160824262476675640L;
	@JsonSerialize(using = ProjectListSerializer.class)
	private List<Project> projects = new ArrayList<Project>();
	@JsonSerialize(using = ArtifactListSerializer.class)
	private List<Artifact> artifacts = new ArrayList<Artifact>();
	@JsonSerialize(using = UserSerializer.class)
	private User owner;
	
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> newProjects) {
		projects = newProjects;
	}
	public List<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<Artifact> newArtifacts) {
		artifacts = newArtifacts;
	}
	public User getOwner() {
		return owner;
	}

	public void setOwner(User newOwner) {
		owner = newOwner;
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
		return "Workspace " + " [name: " + getName() + "]" + " [id: " + getId()
				+ "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}