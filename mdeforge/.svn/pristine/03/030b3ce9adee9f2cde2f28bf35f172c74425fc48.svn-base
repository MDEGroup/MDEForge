package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.web.multipart.MultipartFile;

public interface MetamodelService {
	void upload(Metamodel metamodel, MultipartFile file);
	
	void download(Metamodel metamodel);
	
	void delete(Metamodel metamodel);

	void update(Metamodel metamodel);
	
	void create(Metamodel metamodel) throws BusinessException;
	
	List<Metamodel> findMetamodelByURI(String URI);
	
	List<Metamodel> findAll();
	
	ArtifactList findAllMetamodels() throws BusinessException;
	
	ArtifactList findAllMetamodelsByUserId(User user) throws BusinessException;
	
	ArtifactList findAllWithPublic(User user) throws BusinessException;
	
	ArtifactList findAllPublic() throws BusinessException;
	
	Metamodel findByName(String name);
	
	Metamodel findByOwner(String idMetamodel, User user) throws BusinessException;
	
	Metamodel findOne(String id) throws BusinessException;
	
	ResponseGrid<Metamodel> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	
	Metamodel findOneBySharedUser(String idMetamodel, User user);

	void deleteMetamodel(String idMetamodel, User user);

	ArtifactList findtMetamodelInWorkspace(String idWorkspace, User user);

	ArtifactList findtMetamodelInProject(String idProject, User user) throws BusinessException;
}
