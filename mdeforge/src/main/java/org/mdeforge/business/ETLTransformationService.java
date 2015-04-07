package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;

public interface ETLTransformationService extends ArtifactService{
//	List<ETLTransformation> findAll();
//	ETLTransformation findOne(String id) throws BusinessException;
	ETLTransformation findOneBySharedUser(String idMetamodel, User user) throws BusinessException;
//	List<ETLTransformation> findAllWithPublic(String user) throws BusinessException;
//	List<ETLTransformation> findAllPublic() throws BusinessException;
	ArtifactList findtTransformationInWorkspace(String idWorkspace, User user) throws BusinessException;
	ArtifactList findtTransformationInProject(String idProject, User user) throws BusinessException;
//	ETLTransformation findByName(String name);
//	ETLTransformation findByOwner(String idTransformation, String idUser) throws BusinessException;

	List<ETLTransformation> findAllTransformations() throws BusinessException;
	List<ETLTransformation> findAllTransformationsByUserId(String user) throws BusinessException;
	
	ResponseGrid<ETLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;

	void execute(ETLTransformation transformation) throws BusinessException;
	List<ETLTransformation> findTransformationsBySourceMetamodels(ETLTransformation metamodel);
	List<ETLTransformation> findTransformationsByTargetMetamodels(ETLTransformation metamodel);
	
}
