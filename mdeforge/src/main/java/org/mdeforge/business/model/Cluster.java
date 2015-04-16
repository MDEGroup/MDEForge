package org.mdeforge.business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cluster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2956823730164268028L;
	
	private Set<Artifact> artifacts = new HashSet<Artifact>();
	private Set<String> domains = new HashSet<String>();
	public Set<Artifact> getArtifacts() {
		return artifacts;
	}
	public void setArtifacts(Set<Artifact> artifacts) {
		this.artifacts = artifacts;
	}
	public Set<String> getDomains() {
		return domains;
	}
	public void setDomains(Set<String> domains) {
		this.domains = domains;
	}
}
