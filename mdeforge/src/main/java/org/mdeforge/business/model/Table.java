package org.mdeforge.business.model;

import org.mdeforge.business.IContentType;

public class Table implements IContentType{

	private int numberCols;
	private int numberTh;
	
	public int getNumberCols() {
		return numberCols;
	}
	public void setNumberCols(int numberCols) {
		this.numberCols = numberCols;
	}
	public int getNumberTh() {
		return numberTh;
	}
	public void setNumberTh(int numberTh) {
		this.numberTh = numberTh;
	}
	
}
