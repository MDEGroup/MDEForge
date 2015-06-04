package org.mdeforge.business.model;


/**
 * A representation of the model object '<em><b>Model</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Model extends Artifact {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2527216408130316002L;
	private String uri;
	private boolean valid;
	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "Model ";
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
