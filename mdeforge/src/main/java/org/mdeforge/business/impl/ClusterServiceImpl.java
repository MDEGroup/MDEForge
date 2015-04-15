package org.mdeforge.business.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ClusterService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.SimilarityRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ClusterServiceImpl implements ClusterService {

	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Autowired 
	private EcoreMetamodelService ecoreMetamodelService; 
	@Override
	public List<Cluster> getClusters(double threshold) throws BusinessException {
		List<Cluster> clusterList = new ArrayList<Cluster>();
		List<SimilarityRelation> similarityRelations = similarityRelationService.findAll(threshold);
		Map<String,Cluster> tempHash = new HashMap<String,Cluster>();
		for (SimilarityRelation similarityRelation : similarityRelations) {
			if(!tempHash.containsKey(similarityRelation.getFromArtifact().getId()) && !tempHash.containsKey(similarityRelation.getToArtifact().getId())) {
				Cluster c = new Cluster();
				c.getArtifacts().add(similarityRelation.getFromArtifact());
				c.getArtifacts().add(similarityRelation.getToArtifact());
				List<Property> propertyList = similarityRelation.getFromArtifact().getProperties();
				propertyList.addAll(similarityRelation.getToArtifact().getProperties());
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				tempHash.put(similarityRelation.getFromArtifact().getId(), c);
				tempHash.put(similarityRelation.getToArtifact().getId(), c);
				clusterList.add(c);
			}
			if(tempHash.containsKey(similarityRelation.getFromArtifact().getId()) && !tempHash.containsKey(similarityRelation.getToArtifact().getId())) {
				Cluster c = tempHash.get(similarityRelation.getFromArtifact().getId());
				c.getArtifacts().add(similarityRelation.getToArtifact());
				List<Property> propertyList = similarityRelation.getToArtifact().getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				
				tempHash.put(similarityRelation.getToArtifact().getId(), c);
			}
			if(!tempHash.containsKey(similarityRelation.getFromArtifact().getId()) && tempHash.containsKey(similarityRelation.getToArtifact().getId())) {
				Cluster c = tempHash.get(similarityRelation.getToArtifact().getId());
				c.getArtifacts().add(similarityRelation.getFromArtifact());
				List<Property> propertyList = similarityRelation.getFromArtifact().getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				tempHash.put(similarityRelation.getFromArtifact().getId(), c);
			}
		}
		List<EcoreMetamodel> ecoreMetamodels = ecoreMetamodelService.findAllPublic(EcoreMetamodel.class);
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodels) {
			if(tempHash.get(ecoreMetamodel.getId())==null) {
				Cluster c = new Cluster();
				c.getArtifacts().add(ecoreMetamodel);
				List<Property> propertyList = ecoreMetamodel.getProperties();
				for (Property property : propertyList)
					if (property.getName().toLowerCase().contains("domain") || property.getName().toLowerCase().contains("domains"))
						c.getDomains().add(property.getValue());
				clusterList.add(c);
			}
				
		}
		return clusterList;
	}

}
