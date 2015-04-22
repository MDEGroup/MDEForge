package org.mdeforge.business.model;


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
	public String getNsuri() {
		return nsuri;
	}
	public void setNsuri(String nsuri) {
		this.nsuri = nsuri;
	}
	
	
}
