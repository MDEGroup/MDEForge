package org.mdeforge.business.model.wrapper.json;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.Metric;

public class MetricList extends ArrayList<Metric> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5244619054798324887L;

	public MetricList(List<? extends Metric> list) {
		super(list); // may need a cast
	}
}
