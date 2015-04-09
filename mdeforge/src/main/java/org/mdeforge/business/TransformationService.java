package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.web.multipart.MultipartFile;

public interface TransformationService extends ArtifactService {
	void upload(Transformation transformation);
	void execute(Transformation transformation);
	List<Transformation> findTransformationsBySourceMetamodels(Transformation metamodel);
	List<Transformation> findTransformationsByTargetMetamodels(Transformation metamodel);	
	void create(Transformation metamodel) throws BusinessException;
	List<Transformation> findAllTransformations() throws BusinessException;
	ArtifactList findAllTransformationsByUserId(String user) throws BusinessException;
	ArtifactList findAllWithPublic(String user) throws BusinessException;
	ArtifactList findAllPublic() throws BusinessException;
	Transformation findByName(String name);
	Transformation findByOwner(String idTransformation, String idUser) throws BusinessException;
	Transformation findOne(String id) throws BusinessException;
	ResponseGrid<Transformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	void deleteTransformation(String idMetamodel, User user) throws BusinessException;
	ArtifactList findtTransformationInWorkspace(String idWorkspace, User user) throws BusinessException;
	ArtifactList findtTransformationInProject(String idProject, User user) throws BusinessException;
	Transformation findOneBySharedUser(String idMetamodel, User user) throws BusinessException;
}
