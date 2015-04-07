package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;
import org.springframework.web.multipart.MultipartFile;


public interface ArtifactService{
	void upload(Artifact artifact, MultipartFile file) throws BusinessException;
	Artifact create(Artifact art) throws BusinessException;
	void delete(String idArtifact, User idUser) throws BusinessException;
	void update(Artifact artifact) throws BusinessException;
	
	List<Artifact> findAll() throws BusinessException;
	Artifact findOne(String id) throws BusinessException;	
	Artifact findOneForUser(String idArtifact, User idUser)	throws BusinessException;
	List<Artifact> findAllWithPublic(User user) throws BusinessException;
	List<Artifact> findAllPublic() throws BusinessException;
	List<Artifact> findArtifactInProject(String idProject, User user);
	List<Artifact> findArtifactInWorkspace(String id, User user);
	Artifact findByName(String artifactId, User id);
	Artifact findByOwnerEcore(String idArtifact, User user)
			throws BusinessException;
	Artifact findOneById(String idArtifact, User idUser)
			throws BusinessException;
	
	boolean isArtifactInWorkspace(String idWorkspace, String idArtfact)
			throws BusinessException;

	boolean isArtifactInProject(String idProject, String idArtfact)
			throws BusinessException;

	boolean isArtifactInUser(User idUser, String idArtfact)
			throws BusinessException;

	boolean existRelation(String idTo, String idFrom) throws BusinessException;
	void delete(Artifact artifact, User user) throws BusinessException;



}
