package org.mdeforge.business.model;

import org.springframework.data.mongodb.core.mapping.Document;


/**
 * A representation of the model object '<em><b>Property</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
@Document(collection="Properties")
public class Property implements java.io.Serializable{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6898252457838561310L;

	private String name = null;

	private String value = null;

	
	public String getName() {
		return name;
	}

	/**
	 * Sets the '{@link Property#getName() <em>name</em>}' feature.
	 * 
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param newName
	 *            the new value of the '{@link Property#getName() name}'
	 *            feature.
	 * @generated
	 */
	public void setName(String newName) {
		name = newName;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String newValue) {
		value = newValue;
	}




	@Override
	public String toString() {
		return "Property " + " [name: " + getName() + "]" + " [value: "
				+ getValue() + "]";
	}
}
