package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Cluster;

public interface ClusterService {

	List<Cluster> getSimilarityClusters(double threshold, ValuedRelationService valuedRelationService) throws BusinessException;
	List<Cluster> getContainmentClusters(double threshold, ValuedRelationService valuedRelationService) throws BusinessException;
//	List<Cluster> getClusters(double threshold, int computation) throws BusinessException;
//	String getSimilarityGraph(double threshold, int computation) throws BusinessException;
	String getSimilarityGraph(double treshold, ValuedRelationService valuedRelationService) throws BusinessException;
//	String getHierarchicalClusterGraph(double[] height);
	com.apporiented.algorithm.clustering.Cluster getHierarchicalCluster(ValuedRelationService valuedRelationService) throws BusinessException;
	void printHierarchicalCluster(com.apporiented.algorithm.clustering.Cluster cluster, ValuedRelationService valuedRelationService) throws BusinessException;
	List<com.apporiented.algorithm.clustering.Cluster> getClustersWithThreshold(com.apporiented.algorithm.clustering.Cluster c, double threshold, ValuedRelationService valuedRelationService) throws BusinessException;
	List<Cluster> getRealClustersFromHierarchicalCluster(List<com.apporiented.algorithm.clustering.Cluster> clusterList, ValuedRelationService valuedRelationService);
}
