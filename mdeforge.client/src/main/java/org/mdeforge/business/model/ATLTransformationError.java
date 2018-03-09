package org.mdeforge.business.model;

import java.io.Serializable;

public class ATLTransformationError implements Serializable{

	private boolean localProblem;
	private String element;
	private String fileLocation;
	private String location;
	private String status;
	private int problemId;
	private String description;
	private String severity;
	public boolean isLocalProblem() {
		return localProblem;
	}
	public void setLocalProblem(boolean localProblem) {
		this.localProblem = localProblem;
	}
	public String getElement() {
		return element;
	}
	public void setElement(String element) {
		this.element = element;
	}
	public String getFileLocation() {
		return fileLocation;
	}
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProblemId() {
		return problemId;
	}
	public void setProblemId(int problemId) {
		this.problemId = problemId;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
