package org.mdeforge.business.model;

import java.util.List;


/**
 * A representation of the model object '<em><b>Transformation</b></em>'. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */

public class ETLTransformation extends Transformation {

	
	protected String modules;
	protected List<Model> models_in;
	
	protected String sourceName;
	protected String targetName;
	protected String targetPath;

	/* GETTERS */
	public String getModules() {
		return modules;
	}

	public List<Model> getModels_in() {
		return models_in;
	}

	public String getSourceName() {
		return sourceName;
	}

	public String getTargetName() {
		return targetName;
	}

	public String getTargetPath() {
		return targetPath;
	}
	/* SETTERS */

	public void setModules(String modules) {
		this.modules = modules;
	}

	public void setModels_in(List<Model> models_in) {
		this.models_in = models_in;
	}

	
	public void setSourceName(String inTag) {
		this.sourceName = inTag;
	}

	public void setTargetName(String outTag) {
		this.targetName = outTag;
	}

	public void setTargetPath(String outPath) {
		this.targetPath = outPath;
	}
}
