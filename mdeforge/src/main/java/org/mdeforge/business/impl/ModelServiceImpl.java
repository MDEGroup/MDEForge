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
import org.mdeforge.business.model.wrapper.json.ArtifactList;
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

	@Override
	public List<Artifact> findAllWithPublicByUser(User user) throws BusinessException {
		return findAllWithPublicByUser(user, Model.class);
	}


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
	}
	
	@Override
	public List<Artifact> findArtifactInWorkspace(String idWorkspace, User user) throws BusinessException{
		workspaceService.findById(idWorkspace, user);
		ArtifactList aList = new ArtifactList( findArtifactInWorkspace(idWorkspace, user, Model.class));
		return aList;
	}
	@Override
	public List<Artifact> findArtifactInProject(String idProject, User user) throws BusinessException{
		projectService.findById(idProject, user);
		return  findArtifactInWorkspace(idProject, user, Model.class);
	}
}
