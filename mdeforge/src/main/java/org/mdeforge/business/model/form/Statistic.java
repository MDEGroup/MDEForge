package org.mdeforge.business.model.form;

import java.util.Date;

public class Statistic {

	private int created;
	private long total;

	public int getCreated() {
		return created;
	}

	public void setCreated(int created) {
		this.created = created;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "{total:" + total  + ", day:" + created+ "}" ;
	}
}
