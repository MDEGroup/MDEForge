package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface EcoreMetamodelService extends ArtifactService {
	
	List<EcoreMetamodel> findAllEcore();
//	EcoreMetamodel findOne(String id) throws BusinessException;
	EcoreMetamodel findOneBySharedUserEcore(String idMetamodel, User user);
//	List<EcoreMetamodel> findAllWithPublicEcore(User user) throws BusinessException;
//	List<EcoreMetamodel> findAllPublicEcore() throws BusinessException;
	List<EcoreMetamodel> findEcoreMetamodelInWorkspace(String idWorkspace, User user);
	List<EcoreMetamodel> findEcoreMetamodelInProject(String idProject, User user) throws BusinessException;
	EcoreMetamodel findEcoreByName(String name);
	EcoreMetamodel findByOwnerEcore(String idEcoreMetamodel, User user) throws BusinessException;
	
	List<EcoreMetamodel> findEcoreMetamodelByURI(String URI);
	List<EcoreMetamodel> findAllEcoreMetamodelsByUserId(User user) throws BusinessException;
	
	ResponseGrid<EcoreMetamodel> findAllEcorePaginated(RequestGrid requestGrid)  throws BusinessException;
	void registerMetamodel (EcoreMetamodel ecoreMetamodel) throws BusinessException;
}
