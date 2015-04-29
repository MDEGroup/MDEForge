package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Cluster;

public interface ClusterService {

	List<Cluster> getSimilarityClusters(double threshold) throws BusinessException;
	List<Cluster> getContainmentClusters(double threshold) throws BusinessException;
//	List<Cluster> getClusters(double threshold, int computation) throws BusinessException;
//	String getSimilarityGraph(double threshold, int computation) throws BusinessException;
	String getSimilarityGraph(double treshold) throws BusinessException;
//	String getHierarchicalClusterGraph(double[] height);
	void plotHierarchicalCluster();
}
