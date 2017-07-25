package org.mdeforge.business.model;

import java.util.List;

import org.mdeforge.business.IContentType;


public class ArtifactList implements IContentType{

	private List<EcoreMetamodel> ecoreMetamodelList= null;
	private List<Model> modelList= null;
	private List<ATLTransformation> atlTransformationList = null;
	private List<Artifact> artifactList = null;
	
	private boolean isSearch;
	private String idEditorContent;
	
	public List<EcoreMetamodel> getEcoreMetamodelList() {
		return ecoreMetamodelList;
	}
	public void setEcoreMetamodelList(List<EcoreMetamodel> ecoreMetamodelList) {
		this.ecoreMetamodelList = ecoreMetamodelList;
	}
	public List<Model> getModelList() {
		return modelList;
	}
	public void setModelList(List<Model> modelList) {
		this.modelList = modelList;
	}
	public List<ATLTransformation> getAtlTransformationList() {
		return atlTransformationList;
	}
	public void setAtlTransformationList(List<ATLTransformation> atlTransformationList) {
		this.atlTransformationList = atlTransformationList;
	}
	public boolean isSearch() {
		return isSearch;
	}
	public void setSearch(boolean isSearch) {
		this.isSearch = isSearch;
	}
	public String getIdEditorContent() {
		return idEditorContent;
	}
	public void setIdEditorContent(String idEditorContent) {
		this.idEditorContent = idEditorContent;
	}
	public List<Artifact> getArtifactList() {
		return artifactList;
	}
	public void setArtifactList(List<Artifact> artifactList) {
		this.artifactList = artifactList;
	}	
}
