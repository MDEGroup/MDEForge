package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.web.multipart.MultipartFile;

public interface ATLTransformationService {
	void upload(Transformation transformation);
	
	void execute(ATLTransformation transformation);
	List<ATLTransformation> findTransformationsBySourceMetamodels(ATLTransformation metamodel);
	List<ATLTransformation> findTransformationsByTargetMetamodels(ATLTransformation metamodel);
		
	void upload(ATLTransformation metamodel, MultipartFile file);
	
	void download(ATLTransformation metamodel);
	
	void delete(ATLTransformation metamodel);

	void update(ATLTransformation metamodel);
	
	void create(ATLTransformation metamodel) throws BusinessException;
	
	
	List<ATLTransformation> findAll();
	
	List<ATLTransformation> findAllTransformations() throws BusinessException;
	
	ArtifactList findAllTransformationsByUserId(String user) throws BusinessException;
	
	ArtifactList findAllWithPublic(String user) throws BusinessException;
	
	ArtifactList findAllPublic() throws BusinessException;
	
	ATLTransformation findByName(String name);
	
	ATLTransformation findByOwner(String idTransformation, String idUser) throws BusinessException;
	
	ATLTransformation findOne(String id) throws BusinessException;
	
	ResponseGrid<ATLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;

	void deleteTransformation(String idMetamodel, User user) throws BusinessException;

	ArtifactList findtTransformationInWorkspace(String idWorkspace, User user) throws BusinessException;

	ArtifactList findtTransformationInProject(String idProject, User user) throws BusinessException;

	ATLTransformation findOneBySharedUser(String idMetamodel, User user) throws BusinessException;
	
	
}
