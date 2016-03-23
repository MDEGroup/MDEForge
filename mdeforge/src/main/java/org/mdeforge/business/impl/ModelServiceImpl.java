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
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.search.Tokenizer;
import org.mdeforge.business.search.WeightedContents;
import org.mdeforge.business.search.WeightedResourceSerializer;
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
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.Mongo;

@Service
public class ModelServiceImpl extends CRUDArtifactServiceImpl<Model> implements
		ModelService {

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



	@Override
	public List<Model> findModelsByMetamodel(Metamodel metamodel) {
		List<Model> result = new ArrayList<Model>();
		MongoOperations n = new MongoTemplate(mongoDbFactory);
		Query query = new Query();
		Criteria c2 = Criteria.where("toArtifact.$id").is(
				new ObjectId(metamodel.getId()));

		Criteria c1 = Criteria.where("_class").is(
				ConformToRelation.class.getCanonicalName());
		query.addCriteria(c1);
		query.addCriteria(c2);
		List<ConformToRelation> dcts = n.find(query, ConformToRelation.class);
		for (ConformToRelation domainConformToRelation : dcts) {
			if (domainConformToRelation.getFromArtifact() instanceof Model)
				result.add((Model) domainConformToRelation.getFromArtifact());
		}
		return result;
	}

	@Override
	public Model create(Model artifact) {
		EcoreMetamodel emm = (EcoreMetamodel)artifact.getMetamodel().getToArtifact();
		if (emm == null)
			throw new BusinessException();
		artifact.setValid(isValid(artifact));
		

		EcoreMetamodel mmID = emm;
		Model result = super.create(artifact);
		try {
			this.extractedContent(result);
			modelRepository.save(result);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	@Override
	public void createIndex(TextIndexDefinition textIndex) {
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		operations.indexOps(Artifact.class).ensureIndex(textIndex);
	}
	@Override
	public void extractedContent(Model art) {
		//EcoreMetamodel mmID, 
//		String sourceURI,
		//	String mongoURI
//		###
//		mmID, 
//		gridFileMediaService.getFilePath(result), 
//		jsonMongoUriBase + artifact.getId())
		EcoreMetamodel mmID = (EcoreMetamodel) art.getMetamodel().getToArtifact();
		Resource mm = ecoreMetamodelService.loadArtifact(mmID);
		EPackage mmePackage = null;
		String jsonMongoUriBase = mongoPrefix + mongo.getAddress().toString()
				+ "/" + mongoDbFactory.getDb().getName() + "/"
				+ jsonArtifactCollection + "/";
		ResourceSet load_resourceSet = new ResourceSetImpl();

		for (EObject eObject : mm.getContents()) {
			if (eObject instanceof EPackage) {
				mmePackage = (EPackage) eObject;
				load_resourceSet.getPackageRegistry().put(
						mmePackage.getNsURI(), mmePackage);
			}
		}

		load_resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("*", new XMIResourceFactoryImpl());
		Resource load_resource = load_resourceSet.getResource(
				URI.createURI(gridFileMediaService.getFilePath(art)), true);

		Resource res = jsonMongoResourceSet.getResourceSet().createResource(
				URI.createURI(jsonMongoUriBase + art.getId()));

		EList<EObject> cs = load_resource.getContents();

		res.getContents().addAll(cs);

		WeightedContents ws = WeightedResourceSerializer.serialize(load_resource);
		art.setNameForIndex(Tokenizer.tokenizeString(art.getName()));
		art.setDescriptionForIndex(Tokenizer.tokenizeString(art.getDescription()));
		art.setWeightedContentsThree(ws.getWeightedContentsThree());
		art.setWeightedContentsTwo(ws.getWeightedContentsTwo());
		art.setWeightedContentsOne(ws.getWeightedContentsOne());
		art.setDefaultWeightedContents(ws.getDefaultContents());

		try {
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			throw new BusinessException();
		}
	}

	@Override
	public boolean isValid(Artifact art) throws BusinessException {
		EcoreMetamodel emm = null;
		for (Relation rel : art.getRelations()) {
			if (rel instanceof ConformToRelation) {
				Artifact temm = rel.getToArtifact();
				emm = ecoreMetamodelService.findOne(temm.getId());
			}
		}
		if (emm == null)
			throw new BusinessException();
		if (art instanceof Model) {
			try {
				ecoreMetamodelService.loadArtifact(emm);
//				ecoreMetamodelService.registerMetamodel(emm);
				XMIResourceImpl resource = new XMIResourceImpl();
				File temp = new File(gridFileMediaService.getFilePath(art));
				resource.load(new FileInputStream(temp),
						new HashMap<Object, Object>());
				EObject data = resource.getContents().get(0);
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(data);
				if (diagnostic.getSeverity() == Diagnostic.ERROR)
					return false;
				else
					return true;

			} catch (Exception e) {
				return false;
			}
		} else
			return false;
	}

	@Override
	public double calculateSimilarity(Artifact art1, Artifact art2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Model> findByTransformation(ATLTransformation atlTransformation) {
		List<Model> result = new ArrayList<Model>();
		for (DomainConformToRelation rel : atlTransformation
				.getDomainConformToRelation())
			result.addAll(findModelsByMetamodel((EcoreMetamodel) rel
					.getToArtifact()));
		return result;
	}

}
