package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.web.multipart.MultipartFile;

public interface ArtifactService {
	Artifact findOneById(String idArtifact, User idUser)
			throws BusinessException;

	void create(Artifact art) throws BusinessException;

	void upload(Artifact artifact, MultipartFile file) throws BusinessException;

	void download(Artifact artifact) throws BusinessException;

	void delete(String idArtifact, User idUser) throws BusinessException;

	void update(Artifact artifact) throws BusinessException;

	List<Artifact> findAll() throws BusinessException;
	
	List<Artifact> findAllWithPublic(User user) throws BusinessException;

	List<Artifact> findAllPublic() throws BusinessException;

	
	Artifact findByOwner(String idArtifact, User user)
			throws BusinessException;

	Artifact findOne(String id) throws BusinessException;

	boolean isArtifactInWorkspace(String idWorkspace, String idArtfact)
			throws BusinessException;

	boolean isArtifactInProject(String idProject, String idArtfact)
			throws BusinessException;

	boolean isArtifactInUser(User idUser, String idArtfact)
			throws BusinessException;

	Artifact findOneForUser(String idArtifact, User idUser)
			throws BusinessException;

	boolean existRelation(String idTo, String idFrom) throws BusinessException;

	ArtifactList findArtifactInProject(String idProject, User user);

	ArtifactList findArtifactInWorkspace(String id, User user);
}
