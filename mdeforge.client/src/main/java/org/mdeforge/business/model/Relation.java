package org.mdeforge.business.model;


import org.mdeforge.business.model.serializer.json.ArtifactSerializer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A representation of the model object '<em><b>Relation</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@JsonTypeInfo (use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS,
	property = "_class")

public abstract class Relation implements java.io.Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2298710946943068240L;

	@JsonIgnoreProperties({"name", "description", "relations", "projects", "workspaces"
		, "shared", "metrics", "author", "" })
	private Artifact toArtifact;
	@JsonIgnoreProperties({"name", "description", "relations", "projects", "workspaces"
		, "shared", "metrics", "author", "" })
	private Artifact fromArtifact;
	public Artifact getToArtifact() {
		return toArtifact;
	}


	public void setToArtifact(Artifact toArtifact) {
		this.toArtifact = toArtifact;
	}


	public Artifact getFromArtifact() {
		return fromArtifact;
	}


	public void setFromArtifact(Artifact fromArtifact) {
		this.fromArtifact = fromArtifact;
	}

	private String name = null;

	private String id = null;

	
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
		return "Relation " + " [name: " + getName() + "]" + " [id: " + getId()
				+ "]";
	}
}
