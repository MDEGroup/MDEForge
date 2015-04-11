package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;


public interface ArtifactService <T extends Artifact> {
	T create(T art, Class<T> c) throws BusinessException;
	void delete(String idArtifact, User idUser, Class<T> c) throws BusinessException;
	void update(T artifact, Class<T> c) throws BusinessException;
	List<T> findAll(Class<T> c) throws BusinessException;
	T findOne(String id, Class<T> c) throws BusinessException;	
	List<T> findAllWithPublicByUser(User user, Class<T> t) throws BusinessException;
	List<T> findAllPublic(Class<T> type) throws BusinessException;
	List<T> findArtifactInProject(String idProject, User user, Class<T> c);
	List<T> findArtifactInWorkspace(String id, User user, Class<T> c);
	boolean isArtifactInWorkspace(String idWorkspace, String idArtfact, Class<T> c)	throws BusinessException;
	boolean isArtifactInProject(String idProject, String idArtfact, Class<T> c) throws BusinessException;
	boolean isArtifactInUser(User idUser, String idArtfact, Class<T> c)	throws BusinessException;
	boolean existRelation(String idTo, String idFrom, Class<T> c) throws BusinessException;
	void delete(T artifact, User user, Class<T> c) throws BusinessException;
	T findOneByOwner(String idArtifact, User idUser, Class<T> c);
	T findOneById(String idArtifact, User idUser, Class<T> c)
			throws BusinessException;
}
