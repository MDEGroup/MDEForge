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
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.ValuedRelationService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.search.jsonMongoUtils.EmfjsonMongo;
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
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import com.mongodb.Mongo;


@Service
public class ModelServiceImpl extends CRUDArtifactServiceImpl<Model> implements ModelService {
	

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
	@Value("#{cfgproperties[mongoPrefix]}")
	private String mongoPrefix;
	@Value("#{cfgproperties[jsonArtifactCollection]}")
	private String jsonArtifactCollection;

	
	@Override
	public Model create(Model model) {
		String jsonMongoUriBase = mongoPrefix + mongo.getAddress().toString() + 
				"/" + mongoDbFactory.getDb().getName() + "/" + jsonArtifactCollection + "/";
		//TODO Ciclare sulle relazione e trovare quella di conformanceTo...
		// nel caso non la trovi solleva eccezione.
		//Se la relazione è con un artefatto diverso da un ecore metamodel o non esiste sollevare eccezione.
		String mmID = ((ConformToRelation) model.getRelations().get(0)).getToArtifact().getId();
		model.setExtractedContents( EmfjsonMongo.getInstance()
				.saveModel(jsonMongoUriBase+mmID, model.getNsuri(), 
						jsonMongoUriBase+model.getId()));
		return super.create(model);
	}
	
	@Override
	public List<Model> findModelsByMetamodel(Metamodel metamodel) {
		// TODO Auto-generated method stub
		return null;
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
	public List<Model> findAll() {
		return modelRepository.findAll();
	}
	
	@Override
	public List<Artifact> search(String text){
		MongoOperations operations = new MongoTemplate(mongoDbFactory);
		
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(text);
		List<Artifact> artifacts = operations.find(Query.query(criteria), Artifact.class);
		
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
}
