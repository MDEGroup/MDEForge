package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Comment;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.User;


public interface CRUDArtifactService <T extends Artifact> extends SearchProvider<T>{
	T create(T art) throws BusinessException;
	//void delete(String idArtifact, User idUser) throws BusinessException;
	void update(T artifact) throws BusinessException;
	List<T> findAll() throws BusinessException;
	List<T> findSharedNoProject(User user) throws BusinessException;
	T findOne(String id) throws BusinessException;	
	List<T> findAllWithPublicByUser(User user) throws BusinessException;
	List<T> findAllPublic() throws BusinessException;
	List<T> findArtifactInProject(String idProject, User user);
	List<T> findArtifactInWorkspace(String idWorkspace, User user);
	boolean isArtifactInWorkspace(String idWorkspace, String idArtfact)	throws BusinessException;
	boolean isArtifactInProject(String idProject, String idArtfact) throws BusinessException;
	boolean isArtifactInUser(User idUser, String idArtfact)	throws BusinessException;
	boolean existRelation(String idTo, String idFrom) throws BusinessException;
	void delete(T artifact, User user) throws BusinessException;
	T findOneByOwner(String idArtifact, User idUser);
	T findOneById(String idArtifact, User idUser)
			throws BusinessException;
	T findOneByName(String artifactName)
			throws BusinessException;
	List<Metric> findMetricForArtifact(Artifact a);
	T findOnePublic(String id) throws BusinessException;
	void updateSimple(T artifact);

	List<T> search(String searchString) throws BusinessException;
	void createIndex();
	T findOneByName(String name, User user) throws BusinessException;
	List<T> findMyArtifacts(User user) throws BusinessException;
	long countAll() throws BusinessException;
	List<T> findRecentArtifacts() throws BusinessException;
	User addUserInArtifact(String idUser, String idArtifact, User user) throws BusinessException;
	void removeUserFromArtifact(String idUser, String idArtifact) throws BusinessException;
	List<T> findAllSharedByUser(User user);
	User addUserInPublicArtifact(String idUser, String idArtifact, User user) throws BusinessException;
	T findOneInProject(String project_id, String artifact_id, User user) throws BusinessException;
	List<Metric> findMetric(String idArtifact, User user) throws BusinessException;
	void addComment(Comment comment, String idArtifat) throws BusinessException;
}
