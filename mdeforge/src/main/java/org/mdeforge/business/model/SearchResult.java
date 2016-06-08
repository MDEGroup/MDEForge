package org.mdeforge.business.model;

import java.io.File;
import java.util.Date;

public class SearchResult {
	
	private int id;
	private String path;
	private String[] fragments;
	private float score;
	private Date lastUpdate;
	private File file;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
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
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	

}
