package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.web.multipart.MultipartFile;

public interface EcoreMetamodelService {
	void upload(EcoreMetamodel metamodel, MultipartFile file);
	
	void download(EcoreMetamodel metamodel);
	
	void delete(EcoreMetamodel metamodel);

	void update(EcoreMetamodel metamodel);
	
	String create(EcoreMetamodel metamodel) throws BusinessException;
	
	List<EcoreMetamodel> findEcoreMetamodelByURI(String URI);
	
	List<EcoreMetamodel> findAll();
	
	List<EcoreMetamodel> findAllEcoreMetamodelsByUserId(User user) throws BusinessException;
	
	List<EcoreMetamodel> findAllWithPublic(User user) throws BusinessException;
	
	List<EcoreMetamodel> findAllPublic() throws BusinessException;
	
	EcoreMetamodel findByName(String name);
	
	EcoreMetamodel findByOwner(String idEcoreMetamodel, User user) throws BusinessException;
	
	EcoreMetamodel findOne(String id) throws BusinessException;
	
	ResponseGrid<EcoreMetamodel> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	
	EcoreMetamodel findOneBySharedUser(String idMetamodel, User user);

	void deleteEcoreMetamodel(String idMetamodel, User user);

	List<EcoreMetamodel> findEcoreMetamodelInWorkspace(String idWorkspace, User user);

	List<EcoreMetamodel> findEcoreMetamodelInProject(String idProject, User user) throws BusinessException;
	
	void registerMetamodel (EcoreMetamodel ecoreMetamodel) throws BusinessException;
}
