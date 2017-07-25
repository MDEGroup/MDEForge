package org.mdeforge.business.model;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.mdeforge.business.model.serializer.json.ArtifactListSerializer;
import org.mdeforge.business.model.serializer.json.JsfiddleListSerializer;
import org.mdeforge.business.model.serializer.json.ProjectListSerializer;
import org.mdeforge.business.model.serializer.json.UserSerializer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * A representation of the model object '<em><b>Workspace</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Document(collection="Workspaces")
public class Workspace implements java.io.Serializable{

	@Id
	private String id = null;
	private String description;
	private String name = null;
	private static final long serialVersionUID = -1160824262476675640L;
	@DBRef(lazy=true)
	@JsonSerialize(using = ProjectListSerializer.class)
	private List<Project> projects = new ArrayList<Project>();
	
	@DBRef(lazy=true)
	@JsonSerialize(using = JsfiddleListSerializer.class)
	private List<Jsfiddle> jsfiddles = new ArrayList<Jsfiddle>();
	
	@DBRef(lazy=true)
	@JsonSerialize(using = ArtifactListSerializer.class)
	private List<Artifact> artifacts = new ArrayList<Artifact>();
	@DBRef
	@JsonSerialize(using = UserSerializer.class)
	private User owner;
	
	
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> newProjects) {
		projects = newProjects;
	}
	
	public List<Jsfiddle> getJsfiddles() {
		return jsfiddles;
	}
	public void setJsfiddles(List<Jsfiddle> jsfiddles) {
		this.jsfiddles = jsfiddles;
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
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Workspace) 
			return this.id.equals(((Workspace)obj).getId());
		else return false;
	}
	
	
}