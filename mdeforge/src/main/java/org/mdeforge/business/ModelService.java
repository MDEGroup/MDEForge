package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;



public interface ModelService {
	void upload(Model model);
	void download(Model model);
	void delete(Model model);
	List<Model> findModelsByMetamodel(Metamodel metamodel);
	
	ResponseGrid<Model> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	Model findByName(String name);
	void update(Model model);
	List<Model> findAll();
	String create(Model model) throws BusinessException ;	
	///
//	public boolean isValid(EmfModel model);
	

//	public List<String> getMetamodelsURIs();
	

//	public List<URI> getMetamodelFileUris(EmfModel model);
}
