package org.mdeforge.business.model.form;

import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.Model;

public class ModelForm extends Model{
	private ConformToRelation conformToRelation = new ConformToRelation();
	
	public ConformToRelation getConformToRelation() {
		return conformToRelation;
	}
	public void setConformToRelation(ConformToRelation conformToRelation) {
		this.conformToRelation = conformToRelation;
	}
	
}
