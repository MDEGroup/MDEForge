package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.bson.types.ObjectId;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
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
import org.mdeforge.business.model.Property;
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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import com.mongodb.Mongo;

@Service
public class ModelServiceImpl extends CRUDArtifactServiceImpl<Model> implements
		ModelService {
	
	private IndexWriter writer;

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
	
	private static final int TIKA_CHARACTERS_LIMIT = 5000000; // characters
	
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
	public void extractedContent(Model art) {
		EcoreMetamodel mmID = (EcoreMetamodel) art.getMetamodel().getToArtifact();
		Resource mm = ecoreMetamodelService.loadArtifact(mmID);
		EPackage mmePackage = null;

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



		WeightedContents ws = WeightedResourceSerializer.serialize(load_resource);
		art.setNameForIndex(Tokenizer.tokenizeString(art.getName()));
		art.setDescriptionForIndex(Tokenizer.tokenizeString(art.getDescription()));
		art.setWeightedContentsThree(ws.getWeightedContentsThree());
		art.setWeightedContentsTwo(ws.getWeightedContentsTwo());
		art.setWeightedContentsOne(ws.getWeightedContentsOne());
		art.setDefaultWeightedContents(ws.getDefaultContents());


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
	
	
	@Override
	public void createIndex(Model is) {
		File indexDirFile = new File(basePathLucene);
		// Imposta la directory in cue verra' creato l'indice
		Directory indexDir;
		try {
			indexDir = FSDirectory.open(indexDirFile);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
			IndexWriterConfig conf = new IndexWriterConfig(Version.LUCENE_35, analyzer);
			// Create a new index in the directory, removing any
			// previously indexed documents:
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// create the indexer
			this.writer = new IndexWriter(indexDir, conf);
			long duration = 0;
			int numIndexedDocs = 0;
			long startTime = System.nanoTime();
			// indicizza tutti i documenti contenuti in documentsPath

			Document document = parseArtifactForIndex(is);
			try {
				// writer.updateDocument(new Term("path", file.getPath()),
				// document);
				writer.addDocument(document);
			} catch (CorruptIndexException e) {
				throw new BusinessException(e.getMessage());
			} catch (IOException e) {
				throw new BusinessException(e.getMessage());
			}
			long endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000; // milliseconds(1000000)
														// - seconds
														// (1000000000)
			numIndexedDocs = writer.numDocs();
			writer.close();
			System.out.println("Index of " + numIndexedDocs + " documents done in " + duration + " milliseconds.");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			throw new BusinessException(e1.getMessage());
		}

	}
	
	/**
	 * Perform the effective Lucene index.
	 * @param ecoreMetamodel
	 * @return
	 */
	public Document parseArtifactForIndex(Model model) {
		
		Metadata metadata = new Metadata();
		//By using the BodyContentHandler, you can request that Tika return only the content of the document's body as a plain-text string.
		ContentHandler handler = new BodyContentHandler(TIKA_CHARACTERS_LIMIT); //Parsing to Plain Text
		ParseContext context = new ParseContext();
		Parser parser = new AutoDetectParser();
		InputStream stream = gridFileMediaService.getFileInputStream(model);
		try {
			parser.parse(stream, handler, metadata, context);
		}
		catch (TikaException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String text = handler.toString();
		Field textField = new Field("text", text, Store.YES, Index.ANALYZED);
//		textField.setBoost(2.0f);
		
//		System.out.println(identifyLanguage(text));
		
		String artifactName = model.getName();
	 	Field artName = new Field("name", artifactName, Store.YES, Index.ANALYZED);
//		filenameField.setBoost(0.5f);
		
	 	String author = model.getAuthor().getUsername();
	 	Field authorField = new Field("author", author, Store.YES, Index.ANALYZED);
	 	
	 	Date lastUpdate = model.getModified();
	 	Field lastUpdateField = new Field("lastUpdate", lastUpdate.toString(), Store.YES, Index.ANALYZED);
//		filetypeField.setBoost(1.4f);
		
		Document doc = new Document();
	 	for (Property prop : model.getProperties()) {
			String propName = prop.getName();
			String propValue = prop.getValue();
			Field propField = new Field(propName, propValue, Store.YES, Index.ANALYZED);
			doc.add(propField);
		}
	 	Field idField = new Field("id", model.getId(), Store.YES, Index.ANALYZED);
	 	
	 	doc.add(textField);
	 	doc.add(artName);
	 	doc.add(authorField);
	 	doc.add(lastUpdateField);
		doc.add(idField);
		
//		for (String key : metadata.names()) {
//			String name = key.toLowerCase();
//			String value = metadata.get(key);
////			System.out.println("["+name + " = " + value+"]");
//			/*	Example:
//			    [date = 2013-08-27T13:00:00Z]
//				[total-time = 287]
//				[creator = Utente Windows]
//				[last-printed = 2013-11-05T10:41:00Z]
//				[creation-date = 2013-08-27T13:00:00Z]
//				[xmptpg:npages = 33]
//				[word-count = 8892]
//				[character-count-with-spaces = 61430]
//				[last-author = massimo]
//				[last-modified = 2013-11-13T07:38:00Z]
//				[character count = 52660]
//				[page-count = 33]
//				[template = Normal]
//				[revision-number = 51]
//				[line-count = 438]
//				[application-version = 12.0000]
//				[paragraph-count = 122]
//				[application-name = Microsoft Office Word]
//				[author = Utente Windows]
//				[publisher = ]
//				[content-type = application/vnd.openxmlformats-officedocument.wordprocessingml.document]
//				
//				[keywords = ]
//			 */
//			
//			if (StringUtils.isBlank(value)) {
//				continue;
//			}
//			
//			if ("last-modified".equalsIgnoreCase(key)) {
//					doc.add(new Field("update", value, Store.YES, Index.NOT_ANALYZED));
//			}
//			else if ("title".equalsIgnoreCase(key)) {
//				doc.add(new Field(name, value, Store.YES, Index.ANALYZED));
//			}
//			else {
//				doc.add(new Field(name, artifactName, Store.YES, Index.NOT_ANALYZED));
//			}
//		}
//		doc.add(textField);
		
	
        return doc;
	}

}
