package org.mdeforge.business.impl;

import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ETLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.RequestGrid;
import org.mdeforge.business.ResponseGrid;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.ETLTransformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class ETLTransformationServiceImpl extends CRUDArtifactServiceImpl<ETLTransformation> implements ETLTransformationService {

	

	@Autowired
	private ETLTransformationRepository ETLTransformationRepository;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	
	@Override
	public ETLTransformation findOneBySharedUser(String idMetamodel, User user)
			throws BusinessException {
		ETLTransformation mm = ETLTransformationRepository.findOne(idMetamodel);
		for (User us : mm.getShared()) {
			if (us.getId().equals(user.getId()))
			{
				mm.setFile(gridFileMediaService.getGridFileMedia(mm.getFile()));
				return mm;
			}
				
		}
		throw new BusinessException();
	}
	@Override
	public List<ETLTransformation> findAllTransformations()
			throws BusinessException {
		return ETLTransformationRepository.find();
	}

	@Override
	public List<ETLTransformation> findAllTransformationsByUserId(String username)
			throws BusinessException {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		query.addCriteria(Criteria
				.where("shared")
				.in(username));
		
		query.addCriteria(Criteria.where("_class").is(
								ETLTransformation.class.getCanonicalName()));
		List<ETLTransformation> metamodels = operations.find(query,
				ETLTransformation.class);
		return metamodels;
	}

	@Override
	public ResponseGrid<ETLTransformation> findAllPaginated(RequestGrid requestGrid)
			throws BusinessException {
		Page<ETLTransformation> rows = null;
		if (requestGrid.getSortDir().compareTo("asc") == 0) {
			rows = ETLTransformationRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.ASC, requestGrid
							.getSortCol()));
		} else {
			rows = ETLTransformationRepository.findAll(new PageRequest(requestGrid
					.getiDisplayStart() / requestGrid.getiDisplayLength(),
					requestGrid.getiDisplayLength(), Direction.DESC,
					requestGrid.getSortCol()));
		}
		return new ResponseGrid<ETLTransformation>(requestGrid.getsEcho(),
				rows.getNumberOfElements(), rows.getTotalElements(),
				rows.getContent());
	}
	
	@Override
	public void execute(ETLTransformation transformation) {
		List<String> sourceMetamodel = new ArrayList<String>();
		List<String> targetMetamodel = new ArrayList<String>();
		for(Relation rel : transformation.getRelations()) {
			if (rel instanceof DomainConformToRelation)
				if(rel.getToArtifact() instanceof EcoreMetamodel) {
					ecoreMetamodelService.registerMetamodel((EcoreMetamodel) rel.getToArtifact());
					rel.setToArtifact(ecoreMetamodelService.findOne(rel.getToArtifact().getId()));
					sourceMetamodel.add(gridFileMediaService.getFilePath(rel.getToArtifact()));
				}
			if (rel instanceof CoDomainConformToRelation)
				if(rel.getToArtifact() instanceof EcoreMetamodel) {
					ecoreMetamodelService.registerMetamodel((EcoreMetamodel) rel.getToArtifact());
					rel.setToArtifact(ecoreMetamodelService.findOne(rel.getToArtifact().getId()));
					targetMetamodel.add(gridFileMediaService.getFilePath(rel.getToArtifact()));
				}		
		}
		String transformationPath = gridFileMediaService.getFilePath(transformation);
		EtlModule module = new EtlModule();
		//TODO DANIELE DEVE ESSERE SETTATO DINAMICAMENTE E NON 
		//STATICAMENTE
		//transformation.setTargetName("Target");
		Random randomGenerator = new Random();
		String outputPath = basePath + randomGenerator.nextInt(100);
		
		try {
			module.parse(new File(transformationPath));
			
			List<IModel> models = new ArrayList<IModel>();
			
			//TODO DANIELE Dovrebbe fare forEach sui models_in 
			//OCCHIO AD ASSOCIARE IL GIUSTO METAMODELLO AL MODELLO
			for (Model model : transformation.getModels_in()) {
				String path = gridFileMediaService.getFilePath(model);
				//TODO DANIELE vedi commento nel data model
				models.add(createEmfModel("",
					path, sourceMetamodel,
					true, false));
			}
			//TODO DANIELE Anche qui dovrebbe diventare una lista di modelli in output
			//con foreach sui modelli in output
			models.add(loadEmptyModel("",
					targetMetamodel, outputPath));
	
			// to register the emf models into models repository
			for (IModel model : models) {
				((EtlModule) module).getContext().getModelRepository()
						.addModel(model);
			}
			((EtlModule) module).execute();
			((EtlModule) module).getContext().getModelRepository().dispose();
		} catch (URISyntaxException e) {
			throw new BusinessException();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException();
		}
	}

	
	private EmfModel createEmfModel(String name, String model, List<String> metamodel,
			boolean readOnLoad, boolean storeOnDisposal)
			throws EolModelLoadingException, URISyntaxException,
			EolModelElementTypeNotFoundException {

		EmfModel emfModel = new EmfModel();
		
		emfModel.setMetamodelFiles(metamodel);
		emfModel.setModelFileUri(URI.createFileURI(new File(model).getAbsolutePath()));
		emfModel.setStoredOnDisposal(true);
		emfModel.setReadOnLoad(false);
		emfModel.setName(name);

		return emfModel;
	}
	
	@SuppressWarnings("unused")
	private EmfModel createEmfModel(String name, Model model, List<String> metamodel,
			boolean readOnLoad, boolean storeOnDisposal)
			throws EolModelLoadingException, URISyntaxException,
			EolModelElementTypeNotFoundException {

		EmfModel emfModel = new EmfModel();
		
		emfModel.setMetamodelFiles(metamodel);
		emfModel.setModelFileUri(URI.createFileURI(new File("temp/").getAbsolutePath()));
		emfModel.setStoredOnDisposal(true);
		emfModel.setReadOnLoad(false);
		emfModel.setName(name);

		return emfModel;
	}
	
	private EmfModel loadEmptyModel(String name, List<String> metamodelPath,
			String outPath) throws EolModelLoadingException, URISyntaxException {

		EmfModel emfModel = new EmfModel();

//		StringProperties properties = new StringProperties();
//		properties.put(EmfModel.PROPERTY_NAME, name);
//		properties.put(EmfModel.PROPERTY_FILE_BASED_METAMODEL_URI,getFile(path).toURI().toString());
//		properties.put(EmfModel.PROPERTY_MODEL_URI, URI.createFileURI(new File(outPath).getAbsolutePath()));
//		properties.put(EmfModel.PROPERTY_READONLOAD, false + "");
//		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, true + "");	
//		emfModel.load(properties, (IRelativePathResolver) null);
		
		ArrayList<URI> metamodelFiles = new ArrayList<URI>();
		for (String path : metamodelPath) {
			metamodelFiles.add(
					URI.createFileURI(new File(path).getAbsolutePath())
					);
		}
		
		emfModel.setMetamodelFileUris(metamodelFiles);
		emfModel.setModelFileUri(URI.createFileURI(new File(outPath).getAbsolutePath()));
		emfModel.setStoredOnDisposal(true);
		emfModel.setReadOnLoad(false);
		emfModel.setName(name);
		emfModel.load();
		return emfModel;
	}
	
	@Override
	public List<ETLTransformation> findTransformationsBySourceMetamodels(
			ETLTransformation metamodel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ETLTransformation> findTransformationsByTargetMetamodels(
			ETLTransformation metamodel) {
		// TODO Auto-generated method stub
		return null;
	}
}


