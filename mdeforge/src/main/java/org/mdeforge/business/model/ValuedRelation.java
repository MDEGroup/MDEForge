package org.mdeforge.business.model;

public abstract class ValuedRelation extends Relation {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6870179417082094207L;
	private double value;

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
