package org.mdeforge.business;

public class MetricEngineException extends BusinessException {

	String artifactId;
	
	public MetricEngineException(String string, String id) {
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
