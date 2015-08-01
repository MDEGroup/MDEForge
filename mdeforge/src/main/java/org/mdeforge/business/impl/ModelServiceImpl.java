package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.ValuedRelationService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.search.ResourceSerializer;
import org.mdeforge.business.search.jsonMongoUtils.EmfjsonMongo;
import org.mdeforge.business.search.jsonMongoUtils.JsonMongoResourceSet;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.EcoreMetamodelRepository;
import org.mdeforge.integration.ModelRepository;
import org.mdeforge.integration.ProjectRepository;
import org.mdeforge.integration.RelationRepository;
import org.mdeforge.integration.UserRepository;
import org.mdeforge.integration.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import com.mongodb.Mongo;


@Service
public class ModelServiceImpl extends CRUDArtifactServiceImpl<Model> implements ModelService {

	@Autowired
	private JsonMongoResourceSet jsonMongoResourceSet;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private ModelRepository modelRepository;
	@Autowired
	private Mongo mongo;
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private EcoreMetamodelRepository ecoreMetamodelRepository;
	@Autowired
	private RelationRepository relationRepository;
	@Autowired
	private ArtifactRepository artifactRepository;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private WorkspaceRepository workspaceRepository;
	@Autowired
	private GridFileMediaService gridFileMediaService; 
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	@Value("#{cfgproperties[mongoPrefix]}")
	private String mongoPrefix;
	@Value("#{cfgproperties[jsonArtifactCollection]}")
	private String jsonArtifactCollection;

	
//	@Override
//	public Model create(Model model) {
//		String jsonMongoUriBase = mongoPrefix + mongo.getAddress().toString() + 
//				"/" + mongoDbFactory.getDb().getName() + "/" + jsonArtifactCollection + "/";
//		//TODO Ciclare sulle relazione e trovare quella di conformanceTo...
//		// nel caso non la trovi solleva eccezione.
//		//Se la relazione è con un artefatto diverso da un ecore metamodel o non esiste sollevare eccezione.
//		String mmID = ((ConformToRelation) model.getRelations().get(0)).getToArtifact().getId();
//		model.setExtractedContents( EmfjsonMongo.getInstance()
//				.saveModel(jsonMongoUriBase+mmID, model.getNsuri(), 
//						jsonMongoUriBase+model.getId()));
//		return super.create(model);
//	}
	
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
	public Model create(Model artifact) {
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
//		String path = gridFileMediaService.getFilePath(artifact);
		Model result = super.create(artifact);
//		String jsonMongoUriBase = mongoPrefix + mongo.getAddress().toString() + "/" + mongoDbFactory.getDb().getName() + "/" + jsonArtifactCollection + "/";
//		
//		artifact.setExtractedContents(EmfjsonMongo.getInstance().saveModel(emm.getId(), path, jsonMongoUriBase+artifact.getId()));
//		
//		artifactRepository.save(artifact);
		return result;
	}
	
	public String saveModel(String mmID, String sourceURI, String mongoURI){
		Resource mm = ecoreMetamodelService.loadArtifacrt(mmID);
		EPackage mmePackage = null;
		
		ResourceSet load_resourceSet = new ResourceSetImpl();
		
		for (EObject eObject : mm.getContents()) {
			if (eObject instanceof EPackage){
				mmePackage = (EPackage) eObject;
				load_resourceSet.getPackageRegistry().put(mmePackage.getNsURI(), mmePackage);
			}
        }
		
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource load_resource = load_resourceSet.getResource(URI.createURI(sourceURI),true);

		Resource res = jsonMongoResourceSet.getResourceSet().createResource(URI.createURI(mongoURI));
		
		EList<EObject> cs = load_resource.getContents();

		res.getContents().addAll(cs);
		
		String contents = ResourceSerializer.serialize(res);

		try {
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
		
		return contents;
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
	public List<Model> search(String text){
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
		List<Model> artifacts = operations.find(Query.query(criteria), Model.class);
		
		return artifacts;
	}
	
	@Override
	public List<Artifact> orederedSearch(String text){
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);

		TextQuery query = new TextQuery(criteria);
		query.setScoreFieldName("score");
		query.sortByScore();

		List<Artifact> artifacts = operations.find(query, Artifact.class);
		
		return artifacts;
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
