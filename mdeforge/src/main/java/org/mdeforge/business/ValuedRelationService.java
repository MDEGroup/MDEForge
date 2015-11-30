package org.mdeforge.business;

import java.util.List;
import java.util.Set;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ContainmentRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.ValuedRelation;

public interface ValuedRelationService <T extends ValuedRelation> extends CRUDRelationService<T>{
	List<T> findAll(double threshold) throws BusinessException;
	List<T> findTopProximity(EcoreMetamodel a, int i) throws BusinessException;
	List<T> findByEcoreMetamodel(EcoreMetamodel emm, double threshold) throws BusinessException;
	List<T> findByEcoreMetamodel(EcoreMetamodel emm, double threshold, int computation);
	T findNearest(EcoreMetamodel a, double threshold) throws BusinessException;
	List<T> findRelationsByArtifactInList(Artifact art,
			Set<Artifact> artifacts);
}
