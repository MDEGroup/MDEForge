package org.mdeforge.business.model;

public class AggregatedRealMetric extends Metric {

	private float minimum;
	private float maximum;
	private float median;
	private float average;
	private float standardDeviation;
	public float getMinimum() {
		return minimum;
	}
	public void setMinimum(float minimum) {
		this.minimum = minimum;
	}
	public float getMaximum() {
		return maximum;
	}
	public void setMaximum(float maximum) {
		this.maximum = maximum;
	}
	public float getMedian() {
		return median;
	}
	public void setMedian(float median) {
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
