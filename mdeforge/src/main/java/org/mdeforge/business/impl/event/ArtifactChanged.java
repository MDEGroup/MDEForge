package org.mdeforge.business.impl.event;

import org.mdeforge.business.model.Artifact;
import org.springframework.context.ApplicationEvent;

public class ArtifactChanged extends ApplicationEvent {

	private Artifact artifact;
	private String state;
	
	public ArtifactChanged(Artifact artifact, String state) {
		super(artifact);
		this.setArtifact(artifact);
		this.state = state;
	}
	public Artifact getArtifact() {
		return artifact;
	}
	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	


}
