package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreEList;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.emfjson.jackson.resource.JsonResourceFactory;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.InvalidArtifactException;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.ArtifactRepository;
import org.mdeforge.integration.RelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ModelServiceImpl extends CRUDArtifactServiceImpl<Model> implements ModelService {
	
	
	private static final String CUSTOM_LUCENE_INDEX_SEPARATOR_CHARACTER = "_";
//	private static final int TIKA_CHARACTERS_LIMIT = 5000000; // characters
	private static final String CONFORM_TO_TAG = "conformToMM";
	
	private IndexWriter writer;

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private SimpleMongoDbFactory mongoDbFactory;
	@Autowired
	private RelationRepository relationRepository;
	@Autowired
	private ArtifactRepository artifactRepository;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	@Value("#{cfgproperties[basePathLucene]}")
	protected String basePathLucene;
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
		System.out.println(artifact.getName());
		Model result = super.create(artifact);
		try{
			ecoreMetamodelService.registerMetamodel(emm);
			ResourceSet resSet = new ResourceSetImpl();
			Resource resource = resSet.getResource(
					URI.createURI(gridFileMediaService.getFilePath(artifact)),
					true);
			EObject rootObject = resource.getContents().get(0);
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(rootObject);
			if (diagnostic.getSeverity() == Diagnostic.ERROR)
				artifact.setValid(false);
			else 
				artifact.setValid(true);
		} catch (Exception e) {
			logger.error("Validation Exception");
		}
		return result;
	}
	@Override
	public void createAll(List<Model> artifacts, EcoreMetamodel metamodel, User user) throws BusinessException {
		metamodel = (EcoreMetamodel) artifactRepository.findOne(metamodel.getId());
		List<Relation> relList = new ArrayList<Relation>();
		try {
			for (Model artifact : artifacts) {
				artifact.setAuthor(user);
				GridFileMedia fileMedia = new GridFileMedia();
				fileMedia.setFileName(artifact.getFile().getFileName());
				if (artifact.getFile().getByteArray() != null)
					fileMedia.setByteArray(artifact.getFile().getByteArray());
				else
					fileMedia.setByteArray(Base64.decode(artifact.getFile().getContent().getBytes()));
				artifact.setFile(fileMedia);
				
				if (artifact.getFile() != null) {
					gridFileMediaService.store(artifact.getFile());
				}
				artifact.setCreated(new Date());
				artifact.setModified(new Date());
	
				artifact.setAuthor(user);
				if (artifact.getShared() == null)
					artifact.setShared(new ArrayList<User>());
				artifact.getShared().add(user);
				Relation relationTemp = artifact.getMetamodel();
				artifact.setRelations(new ArrayList<Relation>());
				artifactRepository.save(artifact);
				relationRepository.save(relationTemp);
				artifact.getRelations().add(relationTemp);
				artifactRepository.save(artifact);
				relList.add(relationTemp);
				createIndex(artifact);
			}
			metamodel.getRelations().addAll(relList);
			artifactRepository.save(metamodel);
			user.getSharedArtifact().addAll(artifacts);
		} catch (Exception e) {
			throw new BusinessException();
		}
	}
	
	
	
	


	@Override
	public boolean isValid(Artifact artifact) throws BusinessException {
		Model art = (Model) artifact;
		EcoreMetamodel emm = (EcoreMetamodel) art.getMetamodel().getToArtifact();
		if (!ecoreMetamodelService.isValid(emm))
			throw new InvalidArtifactException();
		try {
			ecoreMetamodelService.registerMetamodel(emm);
			XMIResourceImpl resource = new XMIResourceImpl();
			File temp = new File(gridFileMediaService.getFilePath(art));
			resource.load(new FileInputStream(temp),
					new HashMap<Object, Object>());
			EObject data = resource.getContents().get(0);
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(data);
			if (diagnostic.getSeverity() == Diagnostic.ERROR){
				System.out.println(diagnostic.getMessage());
				return false;}
			else
				return true;

		} catch (Exception e) {
			return false;
		}
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
	
	
	@Override
	public void createIndex(Model is) {
		// set the directory for the index
		Directory indexDir;
		try {
			File indexDirFile = new File(basePathLucene);
			indexDir = FSDirectory.open(indexDirFile);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
			IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_35, analyzer);
			// Create a new index in the directory, removing any
			// previously indexed documents:
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// create the indexer
			this.writer = new IndexWriter(indexDir, conf);

			Document document = parseArtifactForIndex(is);
			writer.addDocument(document);
			
			writer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
			throw new BusinessException(e1.getMessage());
		}

	}
	
	/**
	 * Perform the effective Lucene index.
	 * @param ecoreMetamodel
	 * @return
	 */
	private Document parseArtifactForIndex(Model model) {
		
		Document doc = getMetadataIndex(model);
		try{
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			EcoreMetamodel emm = ((EcoreMetamodel)model.getMetamodel().getToArtifact());
			ecoreMetamodelService.registerMetamodel(emm);
			ResourceSet load_resourceSet = new ResourceSetImpl();
			/**/
			Field idField = new Field(ID_TAG, model.getId(), Store.YES, Index.ANALYZED);
		 	doc.add(idField);
			
			Field artifactType = new Field(TYPE_TAG, model.getClass().getSimpleName(), Store.YES, Index.ANALYZED);
			doc.add(artifactType);
			
			Field artName = new Field(NAME_TAG, model.getName(), Store.YES, Index.ANALYZED);
		 	doc.add(artName);
		 	
		 	Field authorField = new Field(AUTHOR_TAG, model.getAuthor().getUsername(), Store.YES, Index.ANALYZED);
		 	doc.add(authorField);
		 	
		 	Field lastUpdateField = new Field(LAST_UPDATE_TAG, model.getModified().toString(), Store.YES, Index.ANALYZED);
		 	doc.add(lastUpdateField);
		 	
		 	for (Property prop : model.getProperties()) {
				String propName = prop.getName();
				String propValue = prop.getValue();
				if(propName != null && propValue != null) {
					Field propField = new Field(propName, propValue, Store.YES, Index.ANALYZED);
					doc.add(propField);
				}
			}
			
			/**/
			
			
			Field conformToName = new Field(CONFORM_TO_TAG, emm.getName(), Store.YES, Index.ANALYZED);
			doc.add(conformToName);
			
			Field conformToId = new Field(CONFORM_TO_TAG, emm.getId(), Store.YES, Index.ANALYZED);
			doc.add(conformToId);
			load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
			Resource load_resource = load_resourceSet.getResource(URI.createURI(gridFileMediaService.getFilePath(model)), true);
			
			
			
			
			
			
			TreeIterator<EObject> eAllContents = load_resource.getAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				
				EClass eClass = next.eClass();
				if(eClass instanceof EClass)  {
					//CLASS ATTRIBUTES
					for (EAttribute attribute : eClass.getEAllAttributes()) {
						if(next.eGet(attribute) != null){
							String attributeValue = next.eGet(attribute).toString();
							Field eClassWithAttributeField = new Field(eClass.getName(), attributeValue, Store.YES, Index.ANALYZED);
							doc.add(eClassWithAttributeField);
							Field eClassWithAttributeAndAttributeValueField = new Field(eClass.getName() + CUSTOM_LUCENE_INDEX_SEPARATOR_CHARACTER + attribute.getName(), attributeValue, Store.YES, Index.ANALYZED);
							doc.add(eClassWithAttributeAndAttributeValueField);
						}
					}
					
					// EClass References
					for (EReference reference : eClass.getEAllReferences()) {
						Object object = next.eGet(reference);
						if(!(object instanceof EcoreEList))
						{
							EObject eo = (EObject) object;
							if (eo!=null && eo.eClass() instanceof EClass){
								EClass value = (EClass) eo.eClass();
								if(value!=null){
									for (EAttribute eattribute : value.getEAttributes()) {
										if(eo.eGet(eattribute)!=null){
											String indexValue = eo.eGet(eattribute).toString();
											String key = reference.getName();
											Field eClassReferenceField = new Field(key, indexValue, Store.YES, Index.ANALYZED);
											doc.add(eClassReferenceField);
										}
									}
								}
							}
						}
						else {
							//TODO
							logger.info("VERIFICARE");
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			logger.error("Some error when try to parse EMF index");
		}
		return doc;
	}
	
	
	

	@Override
	public List<String> getIndexes() {
		//FIXME
		return new ArrayList<String>();
	}

	@Override
	public String getJson(Model model) {
		EcoreMetamodel emm = ((EcoreMetamodel)model.getMetamodel().getToArtifact());
		ecoreMetamodelService.registerMetamodel(emm);
		@SuppressWarnings("unused")
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		ResourceSet load_resourceSet = new ResourceSetImpl();
		JsonResourceFactory factory = new JsonResourceFactory();
		ObjectMapper mapper = factory.getMapper();
		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource load_resource = load_resourceSet.getResource(URI.createURI(gridFileMediaService.getFilePath(model)), true);
		try {
			
			String jsonString = mapper.writeValueAsString(load_resource);
			return jsonString;
		} catch (JsonProcessingException e1) {
			throw new BusinessException();
		} 
	}
}
