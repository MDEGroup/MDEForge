package org.mdeforge.business.model;

import java.util.List;

import org.mdeforge.business.IContentType;


public class EditorJ implements IContentType{

	private String type;
	private List<String> editorTypeList;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getEditorTypeList() {
		return editorTypeList;
	}

	public void setEditorTypeList(List<String> editorTypeList) {
		this.editorTypeList = editorTypeList;
	}

}
