package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * A representation of the model object '<em><b>Transformation</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class ATLTransformation extends Transformation {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3671337063518065085L;
	private List<ATLTransformationError> atlError = new ArrayList<ATLTransformationError>();
	@JsonIgnore
	private List<ATLTransformationTestServiceError> atlTestError; 
	public List<ATLTransformationError> getAtlError() {
		return atlError;
	}
	public void setAtlError(List<ATLTransformationError> atlError) {
		this.atlError = atlError;
	}
	public List<ATLTransformationTestServiceError> getAtlTestError() {
		return atlTestError;
	}
	public void setAtlTestError(List<ATLTransformationTestServiceError> atlTestError) {
		this.atlTestError = atlTestError;
	}
	/**
	 * A toString method which prints the values of all EAttributes of this
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return "Transformation ";
	}
}
