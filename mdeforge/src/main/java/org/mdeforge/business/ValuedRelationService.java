package org.mdeforge.business;

import java.util.List;
import java.util.Set;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ValuedRelation;

public interface ValuedRelationService <T extends ValuedRelation> extends CRUDRelationService<T>{
	List<T> findAll(double threshold) throws BusinessException;
	List<T> findTopProximity(Artifact a, int i) throws BusinessException;
	List<T> findByArtifact(Artifact emm, double threshold) throws BusinessException;
	List<T> findByArtifact(Artifact emm, double threshold, int computation);
	T findNearest(Artifact a, double threshold) throws BusinessException;
	List<T> findRelationsByArtifactInList(Artifact art,
			Set<Artifact> artifacts);
}
