package org.mdeforge.business.model;

public class SemanticSimilarityRelation extends ValuedRelation {

	private long compationTime;
	private int fromMC;
	private int toMC;
	public long getCompationTime() {
		return compationTime;
	}
	public void setCompationTime(long compationTime) {
		this.compationTime = compationTime;
	}
	public int getFromMC() {
		return fromMC;
	}
	public void setFromMC(int fromMC) {
		this.fromMC = fromMC;
	}
	public int getToMC() {
		return toMC;
	}
	public void setToMC(int toMC) {
		this.toMC = toMC;
	}
	private static final long serialVersionUID = 6762318590742820589L;

}
