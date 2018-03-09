package org.mdeforge.business.model;

public class AggregatedRealMetric extends Metric {

	private int minimum;
	private int maximum;
	private int median;
	private float average;
	private float standardDeviation;
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public int getMedian() {
		return median;
	}
	public void setMedian(int median) {
		this.median = median;
	}
	public float getAverage() {
		return average;
	}
	public void setAverage(float average) {
		this.average = average;
	}
	public float getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(float standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
}
