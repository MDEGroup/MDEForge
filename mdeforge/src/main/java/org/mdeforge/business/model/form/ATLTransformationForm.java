package org.mdeforge.business.model.form;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;

public class ATLTransformationForm extends ATLTransformation{
	private List<DomainConformToRelation> domainConformToRelation = new ArrayList<DomainConformToRelation>();
	private List<CoDomainConformToRelation> coDomainConformToRelation = new ArrayList<CoDomainConformToRelation>();
	public List<CoDomainConformToRelation> getCoDomainConformToRelation() {
		return coDomainConformToRelation;
	}
	public void setCoDomainConformToRelation(List<CoDomainConformToRelation> coDomainConformToRelation) {
		this.coDomainConformToRelation = coDomainConformToRelation;
	}
	public List<DomainConformToRelation> getDomainConformToRelation() {
		return domainConformToRelation;
	}
	public void setDomainConformToRelation(List<DomainConformToRelation> domainConformToRelation) {
		this.domainConformToRelation = domainConformToRelation;
	}
	
}
