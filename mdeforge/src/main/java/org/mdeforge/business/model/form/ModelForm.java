package org.mdeforge.business.model.form;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;

public class ModelForm extends Model{
	private EcoreMetamodel conformToRelation = new EcoreMetamodel();
	
	public EcoreMetamodel getConformToRelation() {
		return conformToRelation;
	}
	public void setConformToRelation(EcoreMetamodel conformToRelation) {
		this.conformToRelation = conformToRelation;
	}
	
}
