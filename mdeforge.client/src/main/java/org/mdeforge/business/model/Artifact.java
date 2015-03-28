package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.model.serializer.json.ProjectListSerializer;
import org.mdeforge.business.model.serializer.json.RelationListSerializer;
import org.mdeforge.business.model.serializer.json.UserListSerializer;
import org.mdeforge.business.model.serializer.json.UserSerializer;
import org.mdeforge.business.model.serializer.json.WorkspaceListSerializer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A representation of the model object '<em><b>Artifact</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@JsonTypeInfo (use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS,
property = "_class")
public class Artifact implements java.io.Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -3383957950864305719L;
	private String id = null;
	private Date created = null;
	private Date modified = null;
	private GridFileMedia file = null;
	private boolean open = false;
	private String name = null;
	private String description = null;
	private List<String> tags = null;
	private String version = null;
	private String extractedContents = null;
	@JsonIgnore
	private String _class;
	
	@JsonSerialize(using = RelationListSerializer.class)
	private List<Relation> relations = new ArrayList<Relation>();


	@JsonSerialize(using = ProjectListSerializer.class)
	private List<Project> projects = new ArrayList<Project>();
	
	@JsonSerialize(using = UserListSerializer.class)
	//@JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
	private List<User> shared = new ArrayList<User>();
	
	@JsonSerialize(using = WorkspaceListSerializer.class)
	private List<Workspace> workspaces = new ArrayList<Workspace>();
	
	@JsonSerialize(using = UserSerializer.class)
	private User author = new User();
	private List<Property> properties = new ArrayList<Property>();
//	
	//	@DBRef(lazy=true)
//	@JsonBackReference
//	private Set<Tag> tags = new HashSet<Tag>();	

//	public Set<Tag> getTags() {
//		return tags;
//	}
//
//	
//	public void setTags(Set<Tag> newTags) {
//		tags = newTags;
//	}
//
//	
//
	public List<Relation> getRelations() {
		return relations;
	}
	
	public void setRelations(List<Relation> newRelations) {
		relations = newRelations;
	}
//
//	
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

	public String get_class() {
		return _class;
	}

	public void set_class(String _class) {
		this._class = _class;
	}

	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getExtractedContents() {
		return extractedContents;
	}

	public void setExtractedContents(String extractedContents) {
		this.extractedContents = extractedContents;
	}
}
