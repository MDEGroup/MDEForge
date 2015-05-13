package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;

public interface MetricProvider {

	List<org.mdeforge.business.model.Metric> calculateMetrics(Artifact emm) throws BusinessException;
	List<org.mdeforge.business.model.Metric> getMetrics(Artifact emm) throws BusinessException;
	
}
