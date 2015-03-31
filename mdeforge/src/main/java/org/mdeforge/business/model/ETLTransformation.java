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

	
	protected String modules;
	protected List<Model> model_in;
	@JsonIgnore
	protected List<Model> targetModel;
	//TODO DANIELE: DEVE ESSERE ELIMINATO (VEDERE SE PUO ESSERE DEDOTTO)!!!! COMUNQUE DEVE DIVENTARE UNA LISTA in ipotesi n a m
	@JsonIgnore
	private String targetName;
	//TODO DANIELE: DEVE ESSERE ELIMINATO (VEDERE SE PUO ESSERE DEDOTTO)!!!! COMUNQUE DEVE DIVENTARE UNA LISTA in ipotesi n a m
	@JsonIgnore
	private String sourceName;
	
	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	
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
	public String getTargetName()
	{
		return targetName;
	}
	
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}

}
