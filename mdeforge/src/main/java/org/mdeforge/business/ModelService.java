package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.User;



public interface ModelService extends ArtifactService {
//	List<Model> findAll();
//	public Model findOne(String id) throws BusinessException ;
//	public Model findOneBySharedUser(String idEcoreMetamodel, User user);
//	public List<Model> findAllWithPublic(User user) throws BusinessException;
//	public List<Model> findAllPublic() throws BusinessException;
	//public List<Model> findAllModelsByUser(User user);
	
//	Model findByName(String name);
	
//	ResponseGrid<Model> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
//	public void deleteModel(String idEcoreMetamodel, User user);
	List<Model> findModelsByMetamodel(Metamodel metamodel);
	
}
