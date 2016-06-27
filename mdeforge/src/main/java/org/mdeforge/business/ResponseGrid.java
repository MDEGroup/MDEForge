package org.mdeforge.business;

import java.util.List;

public class ResponseGrid<R> implements java.io.Serializable {

	private String draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<R> data;

	public ResponseGrid(String draw, long recordsTotal, long recordsFiltered, List<R> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<R> getData() {
		return data;
	}

	public void setData(List<R> data) {
		this.data = data;
	}

}
