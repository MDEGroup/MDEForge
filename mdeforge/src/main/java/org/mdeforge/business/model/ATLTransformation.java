package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A representation of the model object '<em><b>Transformation</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class ATLTransformation extends Transformation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3671337063518065085L;
	private List<ATLTransformationError> atlError = new ArrayList<ATLTransformationError>();
	private List<ATLTransformationTestServiceError> atlTestError = new ArrayList<ATLTransformationTestServiceError>(); 
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
	
	public List<ATLTransformationError> getAtlError() {
		return atlError;
	}

	public void setAtlError(List<ATLTransformationError> atlError) {
		this.atlError = atlError;
	}

	@JsonIgnore
	public List<DomainConformToRelation> getDomainConformToRelation() {
		return getRelations().stream()
				.filter(t -> t instanceof DomainConformToRelation)
				.map(c -> (DomainConformToRelation) c).collect(Collectors.toList());
	}
	@JsonIgnore
	public List<CoDomainConformToRelation> getCoDomainConformToRelation() {
		return getRelations().stream()
				.filter(t -> t instanceof CoDomainConformToRelation)
				.map(c -> (CoDomainConformToRelation) c).collect(Collectors.toList());
	}

	public List<ATLTransformationTestServiceError> getAtlTestError() {
		return atlTestError;
	}

	public void setAtlTestError(List<ATLTransformationTestServiceError> atlTestError) {
		this.atlTestError = atlTestError;
	}
}
