package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * A representation of the model object '<em><b>Tag</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Tag implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5762817541824990520L;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@JsonManagedReference
	private List<Artifact> artifacts = new ArrayList<Artifact>();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	private String name = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private String id = null;

	/**
	 * Returns the value of '<em><b>artifacts</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>artifacts</b></em>' feature
	 * @generated
	 */
	public List<Artifact> getArtifacts() {
		return artifacts;
	}

	/**
	 * Adds to the <em>artifacts</em> feature.
	 * 
	 * @param artifactsValue
	 *            the value to add
	 * @return true if the value is added to the collection (it was not yet
	 *         present in the collection), false otherwise
	 * @generated
	 */
	public boolean addToArtifacts(Artifact artifactsValue) {
		if (!artifacts.contains(artifactsValue)) {
			boolean result = artifacts.add(artifactsValue);
			return result;
		}
		return false;
	}

	/**
	 * Removes from the <em>artifacts</em> feature.
	 * 
	 * @param artifactsValue
	 *            the value to remove
	 * @return true if the value is removed from the collection (it existed in
	 *         the collection before removing), false otherwise
	 * 
	 * @generated
	 */
	public boolean removeFromArtifacts(Artifact artifactsValue) {
		if (artifacts.contains(artifactsValue)) {
			boolean result = artifacts.remove(artifactsValue);
			return result;
		}
		return false;
	}

	/**
	 * Clears the <em>artifacts</em> feature.
	 * 
	 * @generated
	 */
	public void clearArtifacts() {
		while (!artifacts.isEmpty()) {
			removeFromArtifacts(artifacts.iterator().next());
		}
	}

	/**
	 * Sets the '{@link Tag#getArtifacts() <em>artifacts</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newArtifacts
	 *            the new value of the '{@link Tag#getArtifacts() artifacts}'
	 *            feature.
	 * @generated
	 */
	public void setArtifacts(List<Artifact> newArtifacts) {
		artifacts = newArtifacts;
	}

	/**
	 * Returns the value of '<em><b>name</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>name</b></em>' feature
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the '{@link Tag#getName() <em>name</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newName
	 *            the new value of the '{@link Tag#getName() name}' feature.
	 * @generated
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Returns the value of '<em><b>id</b></em>' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the value of '<em><b>id</b></em>' feature
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the '{@link Tag#getId() <em>id</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newId
	 *            the new value of the '{@link Tag#getId() id}' feature.
	 * @generated
	 */
	public void setId(String newId) {
		id = newId;
	}

	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "Tag " + " [name: " + getName() + "]" + " [id: " + getId() + "]";
	}
}
