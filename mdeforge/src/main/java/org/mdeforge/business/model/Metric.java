package org.mdeforge.business.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
@Document(collection="Metric")
@JsonTypeInfo (use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS,
property = "_class")
public class Metric {

	private String name;
	private String id;
	@DBRef
	@JsonIgnore
	private Artifact artifact;
	
	public Artifact getArtifact() {
		return artifact;
	}

	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}

	private String description;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
