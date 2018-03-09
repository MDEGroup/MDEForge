package org.mdeforge.business;

import java.util.List;
import java.util.Set;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;


public interface CRUDRelationService<T extends Relation> {

	void save(Relation r);
	List<T> findAll() throws BusinessException;
	List<T> findByArtifacts(Artifact fromArt, Artifact toArt) throws BusinessException;
	T findOneByArtifacts(Artifact fromArt, Artifact toArt) throws BusinessException;
	Set<T> findByUser(User user) throws BusinessException;
	List<T> findRelationsByArtifact(Artifact artifact)
			throws BusinessException;
	List<T> findRelationsByFromArtifact(Artifact artifact)
			throws BusinessException;
	long countAll();
	List<T> findAllPaginated(int start, int lenght);
	

}
