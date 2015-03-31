package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.web.multipart.MultipartFile;

public interface ETLTransformationService {
	void upload(Transformation transformation);
	
	void execute(ETLTransformation transformation) throws BusinessException;
	List<ETLTransformation> findTransformationsBySourceMetamodels(ETLTransformation metamodel);
	List<ETLTransformation> findTransformationsByTargetMetamodels(ETLTransformation metamodel);
		
	void upload(ETLTransformation metamodel, MultipartFile file);
	
	void download(ETLTransformation metamodel);
	
	void delete(ETLTransformation metamodel);

	void update(ETLTransformation metamodel);
	
	void create(ETLTransformation metamodel) throws BusinessException;
	
	
	List<ETLTransformation> findAll();
	
	List<ETLTransformation> findAllTransformations() throws BusinessException;
	
	List<ETLTransformation> findAllTransformationsByUserId(String user) throws BusinessException;
	
	List<ETLTransformation> findAllWithPublic(String user) throws BusinessException;
	
	List<ETLTransformation> findAllPublic() throws BusinessException;
	
	ETLTransformation findByName(String name);
	
	ETLTransformation findByOwner(String idTransformation, String idUser) throws BusinessException;
	
	ETLTransformation findOne(String id) throws BusinessException;
	
	ResponseGrid<ETLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;

	void deleteTransformation(String idMetamodel, User user) throws BusinessException;

	ArtifactList findtTransformationInWorkspace(String idWorkspace, User user) throws BusinessException;

	ArtifactList findtTransformationInProject(String idProject, User user) throws BusinessException;

	ETLTransformation findOneBySharedUser(String idMetamodel, User user) throws BusinessException;
	
	
}
