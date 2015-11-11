package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.List;

public class Clusterizzation {
	private String id;
	private List<Cluster> clusters = new ArrayList<Cluster>();;
	private String algoritmhs;
	private double threshold;
	private int singleton;
	public List<Cluster> getClusters() {
		return clusters;
	}
	public void setClusters(List<Cluster> clusters) {
		this.clusters = clusters;
	}
	public String getAlgoritmhs() {
		return algoritmhs;
	}
	public void setAlgoritmhs(String algoritmhs) {
		this.algoritmhs = algoritmhs;
	}
	public double getThreshold() {
		return threshold;
	}
	public void setThreshold(double threshold) {
		this.threshold = threshold;
	}
	public int getSingleton() {
		return singleton;
	}
	public void setSingleton(int singleton) {
		this.singleton = singleton;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	}
