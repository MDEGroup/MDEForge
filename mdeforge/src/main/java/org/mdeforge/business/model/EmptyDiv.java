package org.mdeforge.business.model;

import org.mdeforge.business.IContentType;

public class EmptyDiv implements IContentType{

	private String htmlDiv;

	public String getHtmlDiv() {
		return htmlDiv;
	}

	public void setHtmlDiv(String htmlDiv) {
		this.htmlDiv = htmlDiv;
	}
	
}
