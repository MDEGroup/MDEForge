package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;

public interface ATLTransformationService extends ArtifactService{
	
	void execute(ATLTransformation transformation);
	List<ATLTransformation> findTransformationsBySourceMetamodels(ATLTransformation metamodel);
	List<ATLTransformation> findTransformationsByTargetMetamodels(ATLTransformation metamodel);
//	List<ATLTransformation> findAll();
//	ATLTransformation findOne(String id) throws BusinessException;
//	ATLTransformation findOneBySharedUser(String idMetamodel, User user) throws BusinessException;
//	ArtifactList findAllWithPublic(String user) throws BusinessException;
//	ArtifactList findAllPublic() throws BusinessException;
	List<Artifact> findtTransformationInWorkspace(String idWorkspace, User user) throws BusinessException;
	List<Artifact> findtTransformationInProject(String idProject, User user) throws BusinessException;
	ATLTransformation findByName(String name);	
	ATLTransformation findByOwner(String idTransformation, String idUser) throws BusinessException;
	List<ATLTransformation> findAllTransformations() throws BusinessException;
	//List<Artifact> findAllTransformationsByUserId(String user) throws BusinessException;
	
	ResponseGrid<ATLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
}
