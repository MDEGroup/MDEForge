package org.mdeforge.business.model.wrapper.json;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Metric;

public class MetricList extends ArrayList<Metric> {
	public MetricList(List<? extends Metric> list) {
		super(list); // may need a cast
	}
}
