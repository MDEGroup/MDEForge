package org.mdeforge.business.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * A representation of the model object '<em><b>Transformation</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class ETLTransformation extends Transformation {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1922378797988851573L;
	protected String modules;
	protected List<Model> model_in;
	@JsonIgnore
	protected List<Model> targetModel;
	
	
	/* GETTERS */
	public String getModules() {
		return modules;
	}

	public List<Model> getModels_in() {
		return model_in;
	}

	public List<Model> getTargetModel() {
		return targetModel;
	}

	/* SETTERS */

	public void setModules(String modules) {
		this.modules = modules;
	}

	public void setModels_in(List<Model> model_in) {
		this.model_in = model_in;
	}

	public void setTargeModel(List<Model> outTag) {
		this.targetModel = outTag;
	}
}
