package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.List;


/**
 * A representation of the model object '<em><b>Metamodel</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Metamodel extends Artifact {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8514238418981408258L;

	
	private List<String> uri = new ArrayList<String>();

	private String nsuri;
	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "Metamodel ";
	}

	public List<String> getUri() {
		return uri;
	}
	public void setUri(List<String> uri) {
		this.uri = uri;
	}
	//TODO Antonio Eliminare
	public String getNsuri() {
		return nsuri;
	}
	public void setNsuri(String nsuri) {
		this.nsuri = nsuri;
	}
}
