package org.mdeforge.business;

public class ExtractContentEngineException extends BusinessException {

	String artifactId;
	
	public ExtractContentEngineException(String string, String id) {
		super(string);
		artifactId = id;
	}	
	public String getArtifatcId() {
		return artifactId;
	}
	public void setArtifatcId(String artifactId) {
		this.artifactId = artifactId;
	}


}
