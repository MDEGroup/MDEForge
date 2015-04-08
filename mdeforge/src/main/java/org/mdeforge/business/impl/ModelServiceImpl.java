package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ValidateService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service(value="Model")
public class ModelServiceImpl extends ArtifactServiceImpl implements ModelService, ValidateService {
	@Autowired
	@Qualifier("EcoreMetamodel")
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private ModelRepository modelRepository;
	@Override
	public List<Model> findModelsByMetamodel(Metamodel metamodel) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public ResponseGrid<Model> findAllPaginated(RequestGrid requestGrid) throws BusinessException {
//		Page<Model>  rows = null;
//		if (requestGrid.getSortDir().compareTo("asc")==0){
//			rows = modelRepository.findAll(new PageRequest(requestGrid.getiDisplayStart(), requestGrid.getiDisplayLength(),Direction.ASC, requestGrid.getSortCol()));
//		}else{
//			rows = modelRepository.findAll(new PageRequest(requestGrid.getiDisplayStart(), requestGrid.getiDisplayLength(),Direction.DESC, requestGrid.getSortCol()));
//		}
//		return new ResponseGrid<Model>(requestGrid.getsEcho(), rows.getNumberOfElements(), rows.getTotalElements(), rows.getContent());
//	}
//	
//	@Override
//	public Model findByName(String name) throws BusinessException {
//		return modelRepository.findByName(name);
//	}

//	@Override
//	public List<Model> findAll() {
//		return modelRepository.findAll();
//	}

//	@Override
//	public boolean isValid(EmfModel model) {
//		
//	}

//	@Override
//	public List<String> getMetamodelsURIs() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public List<URI> getMetamodelFileUris(EmfModel model) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
//	@Override
//	public Model findOne(String id) throws BusinessException {
//		Model model = modelRepository.findOne(id);
//		if (model != null)
//			model.setFile(gridFileMediaService.getGridFileMedia(model.getFile()));
//		else
//			throw new BusinessException();
//		return model;
//	}
//	@Override
//	public List<Model> findAllModelsByUser(User user)
//			throws BusinessException {
//		MongoOperations operations = new MongoTemplate(mongoDbFactory);
//		Query query = new Query();
//		query.addCriteria(Criteria
//				.where("shared")
//				.in(user.getId())
//				.andOperator(
//						Criteria.where("_class").is(
//								Model.class.getCanonicalName())));
//		List<Model> models = operations.find(query,
//				Model.class);
//		return models;
//	}
	@Override
	public List<Artifact> findAllWithPublicByUser(User user) throws BusinessException {
		return findAllWithPublicByUser(user, Model.class);
	}
//
//	@Override
//	public void deleteModel(String idEcoreMetamodel, User user) {
//		artifactService.delete(idEcoreMetamodel, user);
//	}
//	@Override
//	public Model findOneBySharedUser(String idEcoreMetamodel, User user)
//			throws BusinessException {
//		Model mm = modelRepository.findOne(idEcoreMetamodel);
//		for (User us : mm.getShared()) {
//			if (us.getId().equals(user.getId())) {
//				mm.setFile(gridFileMediaService.getGridFileMedia(mm.getFile()));
//				return mm;
//			}
//
//		}
//		throw new BusinessException();
//	}

	@Override
	public boolean isValid(Artifact art)throws BusinessException {
		EcoreMetamodel emm = null;
		for (Relation rel : art.getRelations()) {
			if (rel instanceof ConformToRelation) {
				Artifact temm = rel.getToArtifact();
				emm = (EcoreMetamodel) findOne(temm.getId());
			}
		}
		if (emm == null) throw new BusinessException();
		if (art instanceof Model){
			try {
				ecoreMetamodelService.registerMetamodel(emm);
				XMIResourceImpl resource = new XMIResourceImpl();
				File temp = new File(gridFileMediaService.getFilePath(art));
				 
				resource.load( new FileInputStream(temp), new HashMap<Object,Object>());
				EObject data = resource.getContents().get(0); 


				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(data);
				if (diagnostic.getSeverity() == Diagnostic.ERROR) 
					return false;
				else return true;
				
			} catch (Exception e) {
				return false;
			}
		}
		else return false;
		// TODO Auto-generated method stub
	}




//	@Override
//	public List<Model> findAllPublic() throws BusinessException {
//		MongoOperations n = new MongoTemplate(mongoDbFactory);
//		Query query = new Query();
//		Criteria c2 = Criteria
//				.where("open")
//				.is(true)
//				.orOperator(
//						Criteria.where("_class").is(
//								Model.class.getCanonicalName()));
//		query.addCriteria(c2);
//		List<Model> result = n.find(query, Model.class);
//		return result;
//	}
}
