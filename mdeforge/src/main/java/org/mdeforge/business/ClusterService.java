package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.Clusterizzation;
import org.mdeforge.business.model.EcoreMetamodel;

public interface ClusterService {

	Clusterizzation getSimilarityClusters(double threshold, ValuedRelationService valuedRelationService) throws BusinessException;
	double[][] getProximityMatrix(ValuedRelationService valuedRelationService) throws BusinessException;
	String getSimilarityGraph(double treshold, ValuedRelationService valuedRelationService) throws BusinessException;
	com.apporiented.algorithm.clustering.Cluster getHierarchicalCluster(ValuedRelationService valuedRelationService) throws BusinessException;
	void printHierarchicalCluster(com.apporiented.algorithm.clustering.Cluster cluster, ValuedRelationService valuedRelationService) throws BusinessException;
	List<com.apporiented.algorithm.clustering.Cluster> getClustersWithThreshold(com.apporiented.algorithm.clustering.Cluster c, double threshold, ValuedRelationService valuedRelationService) throws BusinessException;
	List<Cluster> getRealClustersFromHierarchicalCluster(List<com.apporiented.algorithm.clustering.Cluster> clusterList, ValuedRelationService valuedRelationService);
	Clusterizzation recluster(Clusterizzation clusterizzation, double threshold);
	Cluster getCluster(EcoreMetamodel ecore, Clusterizzation clusterizzation) throws BusinessException;
	Clusterizzation joinCluster(Clusterizzation c, Cluster from, Cluster to);
}
