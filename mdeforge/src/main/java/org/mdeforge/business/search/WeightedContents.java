package org.mdeforge.business.search;

public class WeightedContents {

	private String weightedContentsOne = "";
	private String weightedContentsTwo = "";
	private String weightedContentsThree = "";
	private String defaultContents = "";
	
	public WeightedContents(){
	}

	public String getWeightedContentsOne() {
		return weightedContentsOne;
	}

	public void setWeightedContentsOne(String weightedContentsOne) {
		this.weightedContentsOne = weightedContentsOne;
	}

	public String getWeightedContentsTwo() {
		return weightedContentsTwo;
	}

	public void setWeightedContentsTwo(String weightedContentsTwo) {
		this.weightedContentsTwo = weightedContentsTwo;
	}

	public String getWeightedContentsThree() {
		return weightedContentsThree;
	}

	public void setWeightedContentsThree(String weightedContentsThree) {
		this.weightedContentsThree = weightedContentsThree;
	}

	public String getDefaultContents() {
		return defaultContents;
	}

	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}
	
	public void addContent(String content, String weight) {
		if (weight == null)
			this.defaultContents += " " + content;
		else if (weight.equals("1"))
			this.weightedContentsOne += " " + content;
		else if (weight.equals("2"))
			this.weightedContentsTwo += " " + content;
		else if (weight.equals("3"))
			this.weightedContentsThree += " " + content;
		else
			this.defaultContents += " " + content;
	}
	
}
