package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.model.serializer.json.ProjectListSerializer;
import org.mdeforge.business.model.serializer.json.RelationListSerializer;
import org.mdeforge.business.model.serializer.json.UserListSerializer;
import org.mdeforge.business.model.serializer.json.UserSerializer;
import org.mdeforge.business.model.serializer.json.WorkspaceListSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A representation of the model object '<em><b>Artifact</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Document(collection="Artifacts")
@JsonTypeInfo (use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS,
property = "_class")

public class Artifact implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3383957950864305719L;
	@Id
	private String id = null;
	private Date created = null;
	private Date modified = null;
	private GridFileMedia file = null;
	private boolean open = false;
	private String name = null;
	@Transient
	private List<Metric> metrics;
	private String description = null;
	private List<String> tags = null;
	private String authors = null;
	private String version = null;
	private String extractedContents = null;
	@DBRef(lazy = true)
	@JsonSerialize(using = RelationListSerializer.class)
	private List<Relation> relations = new ArrayList<Relation>();
	@DBRef(lazy = true)
	@JsonSerialize(using = ProjectListSerializer.class)
	private List<Project> projects = new ArrayList<Project>();
	@DBRef(lazy = true)
	@JsonSerialize(using = UserListSerializer.class)
	private List<User> shared = new ArrayList<User>();
	@DBRef(lazy = true)
	@JsonSerialize(using = WorkspaceListSerializer.class)
	private List<Workspace> workspaces = new ArrayList<Workspace>();
	@DBRef(lazy = true)
	@JsonSerialize(using = UserSerializer.class)
	private User author = new User();	
	private List<Property> properties = new ArrayList<Property>();

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
//	private @TextIndexed(weight=20) String name = null;
//	private @TextIndexed(weight=10) String description = null;
//	private @TextIndexed(weight=5) String authors = null;
//	private @TextIndexed(weight=7) List<String> tags = null;
//	private String version = null;
//	private @TextIndexed(weight=1) String extractedContents = null;
//	private @TextScore Float score;
	
	public List<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	public List<Relation> getRelations() {
		return relations;
	}
	
	public void setRelations(List<Relation> newRelations) {
		relations = newRelations;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> newProperties) {
		properties = newProperties;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public boolean addToProjects(Project projectsValue) {
		if (!projects.contains(projectsValue)) {
			boolean result = projects.add(projectsValue);
			return result;
		}
		return false;
	}

	public boolean removeFromProjects(Project projectsValue) {
		if (projects.contains(projectsValue)) {
			boolean result = projects.remove(projectsValue);
			return result;
		}
		return false;
	}

	
	public void clearProjects() {
		while (!projects.isEmpty()) {
			removeFromProjects(projects.iterator().next());
		}
	}

	
	public void setProjects(List<Project> newProjects) {
		projects = newProjects;
	}

	
	public List<User> getShared() {
		return shared;
	}

	
	
	public void setShared(List<User> newShared) {
		shared = newShared;
	}

	
	public List<Workspace> getWorkspaces() {
		return workspaces;
	}

	
	public void setWorkspaces(List<Workspace> newWorkspaces) {
		workspaces = newWorkspaces;
	}

	
	public User getAuthor() {
		return author;
	}

	
	public void setAuthor(User newAuthor) {
		author = newAuthor;
	}


	public Date getCreated() {
		return created;
	}

	public void setCreated(Date newUpload) {
		created = newUpload;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date newModified) {
		modified = newModified;
	}

	public GridFileMedia getFile() {
		return file;
	}

	public void setFile(GridFileMedia newFile) {
		file = newFile;
	}

	public boolean isOpen() {
		return open;
	}
	public boolean getOpen() {
		return open;
	}
	public void setOpen(boolean newPublic_) {
		open = newPublic_;
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
		return "Artifact " + " [upload: " + getCreated() + "]" + " [modified: "
				+ getModified() + "]" + " [file: " + getFile() + "]"
				+ " [open: " + isOpen() + "]" + " [name: " + getName()
				+ "]" + " [id: " + getId() + "]";
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthors() {
		return authors;
	}
	
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	public List<String> getTags() {
		return tags;
	}
	
	public void setTags(List<String> tags) {
		this.tags = tags;
	}



	public String getExtractedContents() {
		return extractedContents;
	}

	public void setExtractedContents(String extractedContents) {
		this.extractedContents = extractedContents;
	}
}
