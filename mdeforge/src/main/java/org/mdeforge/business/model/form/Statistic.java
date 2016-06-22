package org.mdeforge.business.model.form;

import java.util.Date;

public class Statistic {

	private String created;
	private String total;

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "{total:" + total  + ", created:" + created+ "}" ;
	}
}
