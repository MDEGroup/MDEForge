package org.mdeforge.business.model.form;

import org.mdeforge.business.model.Artifact;

public class SearchResult {
	
	private int id;
	private String[] fragments;
	private float score;
	private Artifact artifact;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String[] getFragments() {
		return fragments;
	}
	public void setFragments(String[] fragments) {
		this.fragments = fragments;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public Artifact getArtifact() {
		return artifact;
	}
	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}

}
