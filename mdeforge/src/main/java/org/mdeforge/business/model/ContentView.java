package org.mdeforge.business.model;

import java.util.List;

import org.mdeforge.business.IContentType;

public class ContentView {

	private String id;
	private String name;
	private String type;
	private IContentType contentType;
	private String artifatcId;
	private String contentViewArtifactId;
	private String artifactType;
	private List<ServiceJsfiddle> services;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IContentType getContentType() {
		return contentType;
	}
	public void setContentType(IContentType contentType) {
		this.contentType = contentType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getArtifatcId() {
		return artifatcId;
	}
	public void setArtifatcId(String artifatcId) {
		this.artifatcId = artifatcId;
	}
	public String getContentViewArtifactId() {
		return contentViewArtifactId;
	}
	public void setContentViewArtifactId(String contentViewArtifactId) {
		this.contentViewArtifactId = contentViewArtifactId;
	}
	public String getArtifactType() {
		return artifactType;
	}
	public void setArtifactType(String artifactType) {
		this.artifactType = artifactType;
	}
	public List<ServiceJsfiddle> getServices() {
		return services;
	}
	public void setServices(List<ServiceJsfiddle> services) {
		this.services = services;
	}
	
}
