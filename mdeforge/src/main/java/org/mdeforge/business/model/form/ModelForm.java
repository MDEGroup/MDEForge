package org.mdeforge.business.model.form;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;

public class ModelForm extends Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2803124445006382442L;
	private EcoreMetamodel conformToRelation = new EcoreMetamodel();
	
	public EcoreMetamodel getConformToRelation() {
		return conformToRelation;
	}
	public void setConformToRelation(EcoreMetamodel conformToRelation) {
		this.conformToRelation = conformToRelation;
	}
	
}
