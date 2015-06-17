package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.uml2.uml.internal.operations.TypeOperations;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ValuedRelationService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.search.jsonMongoUtils.EmfjsonMongo;
import org.mdeforge.integration.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.Mongo;


@Service
public class ModelServiceImpl extends CRUDArtifactServiceImpl<Model> implements ModelService {

	@Autowired
	private Mongo mongo;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private ModelRepository modelRepository;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	@Value("#{cfgproperties[mongoPrefix]}")
	private String mongoPrefix;
	@Value("#{cfgproperties[jsonArtifactCollection]}")
	private String jsonArtifactCollection;
	
	@Override
	public List<Model> findModelsByMetamodel(Metamodel metamodel) {
		List<Model> result = new ArrayList<Model>();
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("toArtifact.$id").is(new ObjectId(metamodel.getId()));
		
		Criteria c1 = Criteria.where("_class").is(ConformToRelation.class.getCanonicalName());
		query.addCriteria(new Criteria().andOperator(c1, c2));
		List<ConformToRelation> dcts =  n.find(query, ConformToRelation.class);
		for (ConformToRelation domainConformToRelation : dcts) {
			if(domainConformToRelation.getFromArtifact() instanceof Model)
			result.add((Model)domainConformToRelation.getFromArtifact());
		}
		return result;
	}
	@Override
	public Model create(Model artifact) throws BusinessException {
		EcoreMetamodel emm = null;
		for (Relation rel : artifact.getRelations()) {
			if (rel instanceof ConformToRelation) {
				Artifact temm = rel.getToArtifact();
				emm = ecoreMetamodelService.findOne(temm.getId());
			}
		}
		if (emm == null)
			throw new BusinessException();
		artifact.setValid(isValid(artifact));
		String path = gridFileMediaService.getFilePath(artifact);
		Model result = super.create(artifact);
		String jsonMongoUriBase = mongoPrefix + mongo.getAddress().toString() + "/" + mongoDbFactory.getDb().getName() + "/" + jsonArtifactCollection + "/";
		
		List<Relation> relations = artifact.getRelations();
		Boolean relationFound = false;
		for (Relation relation : relations)
			if (relation instanceof ConformToRelation){
				relationFound = true;
				String mmID = ((ConformToRelation) relation).getToArtifact().getId();
				artifact.setExtractedContents( EmfjsonMongo.getInstance().saveModel(jsonMongoUriBase+mmID, path, jsonMongoUriBase+artifact.getId()));
			}
		if (!relationFound)
			throw new BusinessException();
		
		return result;
	}
	@Override
	public boolean isValid(Artifact art)throws BusinessException {
		EcoreMetamodel emm = null;
		for (Relation rel : art.getRelations()) {
			if (rel instanceof ConformToRelation) {
				Artifact temm = rel.getToArtifact();
				emm = ecoreMetamodelService.findOne(temm.getId());
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
	public double calculateSimilarity(Artifact art1, Artifact art2) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double[][] getProximityMatrix(
			ValuedRelationService valuedRelationService)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Model> findByTransformation(ATLTransformation atlTransformation) {
		List<Model> result = new ArrayList<Model>();
		for (Relation rel : atlTransformation.getRelations()) {
			if(rel instanceof DomainConformToRelation)
				result.addAll(findModelsByMetamodel((EcoreMetamodel)rel.getToArtifact()));
		}
		return result;
	}
}
