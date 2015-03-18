package org.mdeforge.business;

import java.net.URISyntaxException;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.emc.emf.EmfModel;
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
	
	///
//	public boolean isValid(EmfModel model);
	
	/**
	 * 
	 * @return
	 */
//	public List<String> getMetamodelsURIs();
	
	/**
	 * 
	 * @param model
	 * @return
	 */
//	public List<URI> getMetamodelFileUris(EmfModel model);
}
