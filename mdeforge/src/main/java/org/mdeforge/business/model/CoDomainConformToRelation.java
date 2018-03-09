package org.mdeforge.business.model;



public class CoDomainConformToRelation extends Relation {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2814644381324876658L;
	private String referenceModelName;

	public CoDomainConformToRelation(){
	}
	public String getReferenceModelName() {
		return referenceModelName;
	}

	public void setReferenceModelName(String referenceModelName) {
		this.referenceModelName = referenceModelName;
	}

}
