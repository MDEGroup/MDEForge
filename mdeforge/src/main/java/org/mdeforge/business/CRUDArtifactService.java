package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Comment;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.SearchResultComplete;
import org.mdeforge.business.model.form.Statistic;


public interface CRUDArtifactService <T extends Artifact> {
	T create(T art) throws BusinessException;
	//void delete(String idArtifact, User idUser) throws BusinessException;
	void update(T artifact) throws BusinessException;
	List<T> findAll() throws BusinessException;
	ResponseGrid<T> findAll(RequestGrid pag) throws BusinessException;
	List<T> findSharedNoProject(User user) throws BusinessException;
	ResponseGrid<T> findSharedNoProject(User user, RequestGrid pag) throws BusinessException;
	T findOne(String id) throws BusinessException;	
	List<T> findAllWithPublicByUser(User user) throws BusinessException;
	ResponseGrid<T> findAllWithPublicByUser(User user, RequestGrid pag) throws BusinessException;
	List<T> findAllPublic() throws BusinessException;
	ResponseGrid<T> findAllPublic(RequestGrid pag) throws BusinessException;
	List<T> findArtifactInProject(String idProject, User user);
	ResponseGrid<T> findArtifactInProject(String idProject, User user, RequestGrid pag);
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
	
	T findOneByName(String name, User user) throws BusinessException;
	List<T> findMyArtifacts(User user) throws BusinessException;
	ResponseGrid<T> findMyArtifacts(User user, RequestGrid pag);
	long countAll() throws BusinessException;
	List<T> findRecentArtifacts() throws BusinessException;
	List<T> findRecentArtifactsPublic() throws BusinessException;
	User addUserInArtifact(String idUser, String idArtifact, User user) throws BusinessException;
	void removeUserFromArtifact(String idUser, String idArtifact) throws BusinessException;
	List<T> findAllSharedByUser(User user);
	ResponseGrid<T> findAllSharedByUser(User user, RequestGrid pag);
	User addUserInPublicArtifact(String idUser, String idArtifact, User user) throws BusinessException;
	T findOneInProject(String project_id, String artifact_id, User user) throws BusinessException;
	List<Metric> findMetric(String idArtifact, User user) throws BusinessException;
	void addComment(Comment comment, String idArtifat) throws BusinessException;
	List<Statistic> statistic();
	
	//Search with Lucene
	List<String> indexFieldNames() throws BusinessException;
	List<String> indexFieldNamesForMM() throws BusinessException;
	List<String> indexFieldNamesForT() throws BusinessException;
	SearchResultComplete searchForm(String searchString) throws BusinessException;
	SearchResultComplete searchWithPagination(String queryString, int hitsPerPage, int pageNumber) throws BusinessException;
	List<T> search(String searchString, int maxSearchResult) throws BusinessException;
	void createIndex(T artifact);
	boolean deleteTermFromIndex(String fieldName, String filePath);
	ResponseGrid<T> findMyArtifacts(User user, RequestGrid pag, boolean generated);
	void deleteComment(String idComment, String idArtifact);
}
