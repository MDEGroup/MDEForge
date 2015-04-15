package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Cluster;

public interface ClusterService {

	List<Cluster> getClusters(double threshold) throws BusinessException;
}
