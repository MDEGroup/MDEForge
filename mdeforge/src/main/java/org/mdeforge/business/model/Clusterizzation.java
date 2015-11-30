package org.mdeforge.business.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection="Clusterizzation")
public class Clusterizzation {
	private String id;
	private List<Cluster> clusters = new ArrayList<Cluster>();;
	private String algoritmhs;
	private double threshold;
	private double thresholdRecluster;
	private int singleton;
	private int numberOfCluster;
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
	public double getThresholdRecluster() {
		return thresholdRecluster;
	}
	public void setThresholdRecluster(double thresholdRecluster) {
		this.thresholdRecluster = thresholdRecluster;
	}
	public int getNumberOfCluster() {
		return numberOfCluster;
	}
	public void setNumberOfCluster(int numberOfCluster) {
		this.numberOfCluster = numberOfCluster;
	}
	}
