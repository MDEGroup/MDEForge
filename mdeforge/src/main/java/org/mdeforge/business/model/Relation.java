package org.mdeforge.business.model;


import org.mdeforge.business.model.serializer.json.ArtifactSerializer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A representation of the model object '<em><b>Relation</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Document(collection="Relations")
@JsonTypeInfo (use = com.fasterxml.jackson.annotation.JsonTypeInfo.Id.CLASS,
	property = "_class")

public abstract class Relation implements java.io.Serializable{

	@Override
	public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Relation)) {
            return false;
        }
        Relation other = (Relation) obj;
        return this.id.equals(other.id);
    }
	@Override
	public int hashCode() {
        return id.hashCode();
    }
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2298710946943068240L;

	@DBRef
	@JsonSerialize(using = ArtifactSerializer.class)
	private Artifact toArtifact;
	@DBRef
	@JsonSerialize(using = ArtifactSerializer.class)
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

	@Id
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
