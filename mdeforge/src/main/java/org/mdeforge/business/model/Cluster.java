package org.mdeforge.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cluster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2956823730164268028L;
	
	private List<Artifact> artifacts = new ArrayList<Artifact>();
	private List<String> domains = new ArrayList<String>();
	public List<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(List<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	public List<String> getDomains() {
		return domains;
	}
	public void setDomains(List<String> domains) {
		this.domains = domains;
	}
}
