package org.mdeforge.business.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Fields;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Term;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.LuceneService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.SearchResult;
import org.mdeforge.business.model.form.SearchResultComplete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import anatlyzer.atl.model.ATLModel;
import anatlyzer.atlext.ATL.Helper;
import anatlyzer.atlext.ATL.InPatternElement;
import anatlyzer.atlext.ATL.MatchedRule;
import anatlyzer.atlext.ATL.ModuleElement;
import anatlyzer.atlext.ATL.OutPatternElement;
import anatlyzer.atlext.ATL.Rule;
import anatlyzer.atlext.ATL.SimpleInPatternElement;
import anatlyzer.atlext.ATL.SimpleOutPatternElement;
import anatlyzer.atlext.OCL.Attribute;
import anatlyzer.atlext.OCL.OclFeatureDefinition;
import anatlyzer.atlext.OCL.Operation;

@Service
public class LuceneServiceImpl<T extends Artifact> implements LuceneService{
	
	/*
	 * GENERAL TAGS
	 */
	private static final String TEXT_TAG = "text";
	private static final String TYPE_TAG = "forgeType";
	private static final String NAME_TAG = "name";
	private static final String AUTHOR_TAG = "author";
	private static final String ID_TAG = "id";
	private static final String LAST_UPDATE_TAG = "lastUpdate";
	private static final int TIKA_CHARACTERS_LIMIT = 5000000; // characters
	/*
	 * ECORE METAMODEL TAGS
	 */
	
	private static final String EPACKAGE_INDEX_CODE = "ePackage";
	private static final String NsURI_INDEX_CODE = "nsuri";
	private static final String EANNOTATION_INDEX_CODE = "eAnnotation";
	private static final String ECLASS_INDEX_CODE = "eClass";
	private static final String EATTRIBUTE_INDEX_CODE = "eAttribute";
	private static final String EREFERENCE_INDEX_CODE = "eReference";
	private static final String EENUM_INDEX_CODE = "eEnum";
	private static final String ELITERAL_INDEX_CODE = "eLiteral";
	private static final String EDATATYPE_INDEX_CODE = "eDataType";
	
	private static String[] metamodelLuceneTags = {EPACKAGE_INDEX_CODE,NsURI_INDEX_CODE,EANNOTATION_INDEX_CODE,
			ECLASS_INDEX_CODE,EATTRIBUTE_INDEX_CODE,
			EREFERENCE_INDEX_CODE,EENUM_INDEX_CODE,
			ELITERAL_INDEX_CODE,EDATATYPE_INDEX_CODE};
	
	/*
	 * ATL Transformation TAGS
	 */
	private static final String HELPER_TAG = "helper";
	private static final String FROM_METAMODEL_TAG = "fromMM";
	private static final String TO_METAMODEL_TAG = "toMM";
	private static final String RULE_NAME_TAG = "rule";
	private static final String FROM_METACLASS = "fromMC";
	private static final String FROM_TOCLASS = "toMC";
	
	private static String[] modelLuceneTags = {HELPER_TAG,FROM_METAMODEL_TAG,TO_METAMODEL_TAG,
			RULE_NAME_TAG,FROM_METACLASS,FROM_TOCLASS};
	/*
	 * MODEL TAGS
	 */
	private static final String CUSTOM_LUCENE_INDEX_SEPARATOR_CHARACTER = "_";
	private static final String CONFORM_TO_TAG = "conformToMM";
	private static String[] transformationLuceneTags = {CONFORM_TO_TAG};

	
	
	private IndexWriter writer;
	Logger logger = LoggerFactory.getLogger(CRUDArtifactServiceImpl.class);
	
	@Autowired
	protected GridFileMediaService gridFileMediaService;
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private ATLTransformationService aTLTransformationService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	
	@Value("#{cfgproperties[basePathLucene]}")
	private String basePathLucene;
	
	
	
	@Override
	public void createLuceneIndex(Artifact artifact) {
		if(artifact instanceof EcoreMetamodel){
			 createEcoreMetamodelIndex((EcoreMetamodel) artifact);
		}else if (artifact instanceof Model) {
			createModelIndex((Model) artifact);
		}else if(artifact instanceof ATLTransformation){
			createATLTransformationIndex((ATLTransformation) artifact);
		}
		
	}
	
	
	@Override
	public List<String> getIndexTagsByArtifactType(Artifact artifact) {
		String[] result = null;
		if(artifact instanceof EcoreMetamodel){
			result = metamodelLuceneTags;
		}else if (artifact instanceof Model) {
			result = modelLuceneTags;
		}else if(artifact instanceof ATLTransformation){
			result = transformationLuceneTags;
		}
		
		return Arrays.asList(result);
	}
	
	
	@Override
	public List<String> getAllIndexTags() {
		System.out.println("---------------------------------");
		System.out.println("List of Name Fields in the index:");
		System.out.println("---------------------------------");
		
		Collection<String> result = new HashSet<String>();
		try {
			IndexReader luceneIndexReader = DirectoryReader.open(FSDirectory.open(Paths.get(basePathLucene)));
			result = MultiFields.getIndexedFields(luceneIndexReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> sortedList = new ArrayList<String>(result);
		Collections.sort(sortedList);
		
		sortedList.forEach(x -> System.out.println(x));
		return sortedList;
	}
	
	
	
	
	
	/*
	 * *********************************
	 * ECORE METAMODEL INDEX
	 * *********************************
	 */
	
	private void createEcoreMetamodelIndex(EcoreMetamodel is) {
		
		try {
			Directory indexDir = FSDirectory.open(Paths.get(basePathLucene));
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig conf = new IndexWriterConfig(analyzer);
			// Create an index in the directory, appending new index over previously indexed documents:
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND); //or CREATE
			// create the indexer
			Document document = parseMetamodelForIndex(is);
			writer = new IndexWriter(indexDir, conf);

			// writer.updateDocument(new Term("path", file.getPath()), document);
			writer.addDocument(document);
				
			writer.close();
		} catch (CorruptIndexException e) {
			throw new BusinessException(e.getMessage());
		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		}
			
		

	}
	
	/**
	 * Parse Metamodel artifact file in order to extrapolate and index the file to Lucene Index
	 * @param ecoreMetamodel
	 * @return Document
	 */
	private Document parseMetamodelForIndex(EcoreMetamodel ecoreMetamodel) {
		Document doc = new Document();
		
//		String textOfTheInputStream = getTextFromInputStream(gridFileMediaService.getFileInputStream(ecoreMetamodel));
		
//		InputStream is = null;
//		try {
//			is = new FileInputStream(gridFileMediaService.getFilePath(ecoreMetamodel));
//		} catch (FileNotFoundException | BusinessException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		/*
//		 * FILE METADATA
//		 */
//		Metadata metadata = new Metadata();
//		// By using the BodyContentHandler, you can request that Tika return
//		// only the content of the document's body as a plain-text string.
//		ContentHandler handler = new BodyContentHandler(TIKA_CHARACTERS_LIMIT); // Parsing to
//																	// Plain
//																	// Text
//		ParseContext context = new ParseContext();
//		Parser parser = new AutoDetectParser();
//		try {
//			parser.parse(is, handler, metadata, context);
//		} catch (TikaException e) {
//			throw new BusinessException(e.getMessage());
//		} catch (SAXException e) {
//			throw new BusinessException(e.getMessage());
//		} catch (IOException e) {
//			throw new BusinessException(e.getMessage());
//		} finally {
//			try {
//				is.close();
//			} catch (IOException e) {
//				throw new BusinessException(e.getMessage());
//			}
//		}
		
		//Register Metamodel
		String artifactFilePath = "";
		try{
			artifactFilePath = gridFileMediaService.getFilePath(ecoreMetamodel);
		}catch (Exception e) {
			 System.err.println("File not exists!");
		}
		URI fileURI = URI.createFileURI(artifactFilePath);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		try{
			Resource resource = resourceSet.getResource(fileURI, true);
//			
//			Reader reader = new InputStreamReader(gridFileMediaService.getFileInputStream(ecoreMetamodel));
////			BufferedReader br = new BufferedReader(reader);
//			Resource resource2 = resourceSet.createResource(URI.createURI("resource.extension")); 
//			resource2.load(new URIConverter.ReadableInputStream(reader), null); 
		
		if (resource.isLoaded() && resource.getErrors() != null) {
			TreeIterator<EObject> eAllContents = resource.getAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				if (next instanceof EPackage) {
					EPackage ePackage = (EPackage) next;
					doc = ePackageIndex(ePackage, doc);
				} else if (next instanceof EClass) {
					EClass eClass = (EClass) next;
					doc = eClassIndex(eClass, doc);
				} else if (next instanceof EEnum) {
					EEnum eEnum = (EEnum) next;
					doc = eEnumIndex(eEnum, doc);
				} else if (next instanceof EDataType) {
					EDataType eDataType = (EDataType) next;
					doc = eDataTypeIndex(eDataType, doc);
				} else if (next instanceof EAnnotation) {
					// GET all the EAnnotations
					EList<EAnnotation> annotations = ((EModelElement) next).getEAnnotations();
					doc = indexAnnotations(annotations, doc);
				}

			}
		}
		
		//ID
		Field idField = new TextField(ID_TAG, ecoreMetamodel.getId(), Field.Store.YES);
	 	doc.add(idField);
		
		//Artifact TYPE: "EcoreMetamodel"
		Field artifactType = new TextField(TYPE_TAG, ecoreMetamodel.getClass().getSimpleName(), Field.Store.YES);
		doc.add(artifactType);
		
//		String text = handler.toString();
		String text = getTextFromInputStream(gridFileMediaService.getFileInputStream(ecoreMetamodel));
		Field textField = new TextField(TEXT_TAG, text, Field.Store.YES);
		doc.add(textField);

		
		
		Field artName = new TextField(NAME_TAG, ecoreMetamodel.getName(), Field.Store.YES);
	 	doc.add(artName);
	 	
	 	Field authorField = new TextField(AUTHOR_TAG, ecoreMetamodel.getAuthor().getUsername(), Field.Store.YES);
	 	doc.add(authorField);
	 	
	 	Field lastUpdateField = new TextField(LAST_UPDATE_TAG, ecoreMetamodel.getModified().toString(), Field.Store.YES);
	 	doc.add(lastUpdateField);
	 	
	 	for (Property prop : ecoreMetamodel.getProperties()) {
			String propName = prop.getName();
			String propValue = prop.getValue();
			if(propName != null && propValue != null) {
				Field propField = new TextField(propName, propValue, Field.Store.YES);
				doc.add(propField);
			}
		}
	 	
		}catch (Exception e) {
			System.out.println("ERROR");
		}
//		System.out.println(handler.toString());	 	

	 	return doc;
	}
	
	
	private String getTextFromInputStream(InputStream is){      
        String str = "";
        StringBuffer buf = new StringBuffer();            
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            if (is != null) {                            
                while ((str = reader.readLine()) != null) {    
                    buf.append(str + "\n" );
                }                
            }
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            try { is.close(); } catch (Throwable ignore) {}
        }
        return buf.toString();
    }
	
	private Document ePackageIndex(EPackage ePackage, Document doc){
		Field ePackageField = new TextField(EPACKAGE_INDEX_CODE, ePackage.getName(), Field.Store.YES);
		doc.add(ePackageField);
		// GET NsURI
		if (ePackage.getNsURI() != null && !ePackage.getNsURI().isEmpty()) {
			Field EPackageNsURIField = new TextField(NsURI_INDEX_CODE, ePackage.getNsURI(), Field.Store.YES);
//			System.out.println("NsURI : " + ePackage.getNsURI());
			doc.add(EPackageNsURIField);
		}
		// GET EAnnotation
		EList<EAnnotation> annotations = ePackage.getEAnnotations();
		if (annotations != null && !annotations.isEmpty()) {
			doc = indexAnnotations(annotations, doc);
		}
		
		return doc;
	}
	

	
	private Document eClassIndex(EClass eClass, Document doc){
		try {
			Field eClassField = new TextField(ECLASS_INDEX_CODE, eClass.getName(), Field.Store.YES);
			// System.out.println("Class: " + eClass.getName());
			doc.add(eClassField);

			// GET EAnnotation
			EList<EAnnotation> annotations = eClass.getEAnnotations();
			if (annotations != null && !annotations.isEmpty()) {
				doc = indexAnnotations(annotations, doc);
			}

			// Index EClass Attributes
			for (EAttribute attribute : eClass.getEAttributes()) {
				Field eClassAttributeField = new TextField(EATTRIBUTE_INDEX_CODE, attribute.getName(), Field.Store.YES);
				// System.out.println("Attribute: " + attribute.getName());
				doc.add(eClassAttributeField);
			}
			// Index EClass References
			for (EReference reference : eClass.getEReferences()) {
				Field eClassReferenceField = new TextField(EREFERENCE_INDEX_CODE, reference.getName(), Field.Store.YES);
				// System.out.println("Reference: " + reference.getName());
				doc.add(eClassReferenceField);
			}
		
		} catch (Exception e) {
			System.err.println("ERROR");
		}
		
		return doc;
	}
	
	
	private Document eEnumIndex(EEnum eEnum, Document doc){
		Field eEnumField = new TextField(EENUM_INDEX_CODE, eEnum.getName(), Field.Store.YES);
		doc.add(eEnumField);
		return doc;
	}
	
	private Document eDataTypeIndex(EDataType eDataType, Document doc){
		Field eDataTypeField = new TextField(EDATATYPE_INDEX_CODE, eDataType.getName(), Field.Store.YES);
		doc.add(eDataTypeField);
		return doc;
	}
	
	
	/**
	 * Index the annotation list provided as input.
	 * @param annotations
	 * @param doc
	 * @return Document
	 */
	private Document indexAnnotations(List<EAnnotation> annotations, Document doc){
		if (annotations != null && !annotations.isEmpty()) {
			for (EAnnotation eAnnotation : annotations) {
				if(getAnnotationKey(eAnnotation) != null && getAnnotationKey(eAnnotation).equals("weight")){
					if(getAnnotationValue(eAnnotation) != null){
						Field EPackageEAnnotationField = new TextField(EANNOTATION_INDEX_CODE, getAnnotationValue(eAnnotation), Field.Store.YES);
						doc.add(EPackageEAnnotationField);
					}
				}
			}
		}
		return doc;
	}
	
	
	/**
	 * Get the annotation key from an EAnnotation
	 * @param eAnnotation
	 * @return String
	 */
	private String getAnnotationKey(EAnnotation eAnnotation){
		String result = null;
		if (eAnnotation != null) {
				EMap<String, String> annotationDetails = eAnnotation.getDetails();
				for (Entry<String, String> entry : annotationDetails) {
					if(entry.getKey() != null && entry.getValue() != null){
						result = entry.getKey();
				}
			}
		}
		return result;
	}
	
	/**
	 * Get the annotation value from an EAnnotation
	 * @param eAnnotation
	 * @return String
	 */
	private String getAnnotationValue(EAnnotation eAnnotation){
		String result = null;
		if (eAnnotation != null) {
			EMap<String, String> annotationDetails = eAnnotation.getDetails();
			for (Entry<String, String> entry : annotationDetails) {
				if(entry.getKey() != null && entry.getValue() != null){
					result = entry.getValue();
				}
			}
		}
		return result;
	}


	
	
	
	/*
	 * *********************************
	 * ATL TRANSFORMATION INDEX
	 * *********************************
	 */

	private void createATLTransformationIndex(ATLTransformation art) {
		Document doc = new Document();
		AtlParser atlParser = new AtlParser();
		ModelFactory modelFactory = new EMFModelFactory();
		IReferenceModel atlMetamodel;
		try {
			Directory indexDir = FSDirectory.open(Paths.get(basePathLucene));
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig conf = new IndexWriterConfig(analyzer);
			// Set the directory in which will be created the index.
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND); //or CREATE
			IndexWriter writer = new IndexWriter(indexDir, conf);
			try {
			atlMetamodel = modelFactory.getBuiltInResource("ATL.ecore");
			String filePath = gridFileMediaService.getFilePath(art);
			EMFModel atlDynModel = (EMFModel) modelFactory
					.newModel(atlMetamodel);
			atlParser.inject(atlDynModel, filePath);
			Resource originalTrafo = atlDynModel.getResource();
			ATLModel atlModel = new ATLModel(originalTrafo, originalTrafo
					.getURI().toFileString(), true);
//			atlModel.getModule().get
			EList<ModuleElement> eAllContents = atlModel.getModule().getElements();
			for (ModuleElement moduleElement : eAllContents) {
				if (moduleElement instanceof Helper) {
					Helper h = (Helper) moduleElement;
					if (h.getDefinition()!=null) {
						OclFeatureDefinition def = h.getDefinition();
						if(def.getFeature()!= null && def.getFeature() instanceof Attribute) {
							Attribute attr = (Attribute) def.getFeature();
							Field attribute = new TextField(HELPER_TAG, attr.getName(), Field.Store.YES);
							Field text = new TextField(TEXT_TAG, attr.getName(), Field.Store.YES);
							doc.add(text);
							doc.add(attribute);
						}
						if(def.getFeature()!= null && def.getFeature() instanceof Operation) {
							Operation attr = (Operation) def.getFeature();
							Field attribute = new TextField(HELPER_TAG, attr.getName(), Field.Store.YES);
							Field text = new TextField(TEXT_TAG, attr.getName(), Field.Store.YES);
							doc.add(text);
							doc.add(attribute);
						}
					}
				}
				if (moduleElement instanceof Rule)
				{
					Rule r = (Rule) moduleElement;
					Field ruleName = new TextField(RULE_NAME_TAG,r.getName(), Field.Store.YES);
					if(r instanceof MatchedRule) {
						MatchedRule mr = (MatchedRule) r;
						EList<InPatternElement> si = mr.getInPattern().getElements();
						for (InPatternElement inPatternElement : si) {
							if(inPatternElement instanceof SimpleInPatternElement) {
								SimpleInPatternElement sipe = (SimpleInPatternElement) inPatternElement;
								Field fromMC = new TextField(FROM_METACLASS, sipe.getType().getName(), Field.Store.YES);
								doc.add(fromMC);
								Field text = new TextField(TEXT_TAG, sipe.getType().getName(), Field.Store.YES);
								doc.add(text);
								
							}
							
						}
						EList<OutPatternElement> so = mr.getOutPattern().getElements();
						for (OutPatternElement outPatternElement : so) {
							if(outPatternElement instanceof SimpleOutPatternElement) {
								SimpleOutPatternElement sope = (SimpleOutPatternElement) outPatternElement;
								Field toMC = new TextField(FROM_TOCLASS, sope.getType().getName(), Field.Store.YES);
								doc.add(toMC);
								Field text = new TextField(TEXT_TAG, sope.getType().getName(), Field.Store.YES);
								doc.add(text);
							}
							
						}
					}
					doc.add(ruleName);
				}
				
			}
			Field type = new TextField(TYPE_TAG, art.getClass().getSimpleName(), 
					Field.Store.YES);
			doc.add(type);
			
			String artifactName = art.getName();
		 	Field artName = new TextField(NAME_TAG, artifactName, Field.Store.YES);
		 	
		 	for (DomainConformToRelation dctr : art.getDomainConformToRelation()) {
		 		Artifact temp_art = ecoreMetamodelService.findOne(dctr.getToArtifact().getId());
		 		Field fromMMName = new TextField(FROM_METAMODEL_TAG, temp_art.getName(), 
		 				Field.Store.YES);
		 		Field fromMMID = new TextField(FROM_METAMODEL_TAG, temp_art.getId(), 
		 				Field.Store.YES);
				doc.add(fromMMID);
				doc.add(fromMMName);
			}
		 	for (CoDomainConformToRelation dctr : art.getCoDomainConformToRelation()) {
		 		Artifact temp_art = ecoreMetamodelService.findOne(dctr.getToArtifact().getId());
		 		Field fromMMName = new TextField(TO_METAMODEL_TAG, temp_art.getName(), 
		 				Field.Store.YES);
		 		Field fromMMID = new TextField(TO_METAMODEL_TAG, temp_art.getId(), 
		 				Field.Store.YES);
				doc.add(fromMMID);
				doc.add(fromMMName);
			}
		 	String author = art.getAuthor().getUsername();
		 	Field authorField = new TextField(AUTHOR_TAG, author, Field.Store.YES);
		 	Date lastUpdate = art.getModified();
		 	Field lastUpdateField = new TextField(LAST_UPDATE_TAG, lastUpdate.toString(), 
		 			Field.Store.YES);
		 	for (Property prop : art.getProperties()) {
		 		
				String propName = prop.getName();
				String propValue = prop.getValue();
				if(propName != null && propValue != null){
					Field propField = new TextField(propName, propValue, 
						Field.Store.YES);
					doc.add(propField);
				}
			}
		 	Field idField = new TextField(ID_TAG, art.getId(), 
		 			Field.Store.YES);
		 	doc.add(artName);
		 	doc.add(authorField);
		 	doc.add(lastUpdateField);
			doc.add(idField);
			writer.addDocument(doc);
			}catch (Exception e) {
				logger.error(e.getMessage());e.printStackTrace();
			}
			writer.close();
		}
		  catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	/*
	 * *********************************
	 * MODEL INDEX
	 * *********************************
	 */
	
	private void createModelIndex(Model is) {
		
		try {
			// set the directory for the index
			Directory indexDir = FSDirectory.open(Paths.get(basePathLucene));
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig conf = new IndexWriterConfig(analyzer);
			// Create a new index in the directory, removing any
			// previously indexed documents:
			conf.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
			// create the indexer
			this.writer = new IndexWriter(indexDir, conf);

			Document document = parseModelForIndex(is);
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
	private Document parseModelForIndex(Model model) {
		
//		LuceneTag luceneTag = new LuceneTag(); 
		
		Document doc = new Document();
//		Metadata metadata = new Metadata();
//		//By using the BodyContentHandler, you can request that Tika return only the content of the document's body as a plain-text string.
//		ContentHandler handler = new BodyContentHandler(TIKA_CHARACTERS_LIMIT); //Parsing to Plain Text
//		ParseContext context = new ParseContext();
//		Parser parser = new AutoDetectParser();
//		InputStream stream = gridFileMediaService.getFileInputStream(model);
//		try {
//			parser.parse(stream, handler, metadata, context);
//		}
//		catch (TikaException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				stream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try{
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		EcoreMetamodel emm = ((EcoreMetamodel)model.getMetamodel().getToArtifact());
		ecoreMetamodelService.loadArtifact(emm);
		ResourceSet load_resourceSet = new ResourceSetImpl();

		load_resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource load_resource = load_resourceSet.getResource(URI.createURI(gridFileMediaService.getFilePath(model)), true);
		
		TreeIterator<EObject> eAllContents = load_resource.getAllContents();
		while (eAllContents.hasNext()) {
			EObject next = eAllContents.next();
			
			EClass eClass = next.eClass();
			if(eClass instanceof EClass)  {
				//CLASS ANNOTATIONS
				EList<EAnnotation> annotations = next.eClass().getEAnnotations();
				//TODO index also the annotations
				
				//CLASS ATTRIBUTES
				for (EAttribute attribute : eClass.getEAllAttributes()) {
					// EAnnotation ann = attribute.getEAnnotation("searchindex");
					// String key = eClass.getName() + "#" +attribute.getName();
					// System.out.println(key);
					// Object value = next.eGet(attribute);
					String attributeValue = next.eGet(eClass.getEStructuralFeature(attribute.getName())).toString();

					/*
					 * Index className:classAttributeValue
					 */
					Field eClassWithAttributeField = new TextField(eClass.getName(), attributeValue, Field.Store.YES);
					// eClassWithAttributeField(1.5f);
					doc.add(eClassWithAttributeField);

					/*
					 * Index className::classAttribute:attributeValue
					 */
					Field eClassWithAttributeAndAttributeValueField = new TextField(eClass.getName() + CUSTOM_LUCENE_INDEX_SEPARATOR_CHARACTER + attribute.getName(), attributeValue, Field.Store.YES);
					// eClassWithAttributeAndAttributeValueField(1.5f);
					doc.add(eClassWithAttributeAndAttributeValueField);
				}
				
				// EClass References
				for (EReference reference : eClass.getEAllReferences()) {
					EObject value = (EObject) next.eGet(reference);
					String key = reference.getName();
					EClass referenceTo = (EClass) value.eClass();
					Field eClassReferenceField = new TextField(key, referenceTo.getName(), Field.Store.YES);
					// eClassReferenceField.setBoost(1.5f);
					doc.add(eClassReferenceField);
					}
			}
			
		}
		}catch(Exception e) { 
			logger.error("Some error when try to parse EMF index");
		}
		//Artifact TYPE: "Model"
		Field artifactType = new TextField(TYPE_TAG, model.getClass().getSimpleName(), Field.Store.YES);
		doc.add(artifactType);

//		String text = handler.toString();
		String text = getTextFromInputStream(gridFileMediaService.getFileInputStream(model));
		Field textField = new TextField(TEXT_TAG, text, Field.Store.YES);
//		textField.setBoost(2.0f);
		
//		System.out.println(identifyLanguage(text));
		
		String artifactName = model.getName();
	 	Field artName = new TextField(NAME_TAG, artifactName, Field.Store.YES);
//		filenameField.setBoost(0.5f);
		
	 	String author = model.getAuthor().getUsername();
	 	Field authorField = new TextField(AUTHOR_TAG, author, Field.Store.YES);
	 	
	 	Date lastUpdate = model.getModified();
	 	Field lastUpdateField = new TextField(LAST_UPDATE_TAG, lastUpdate.toString(), Field.Store.YES);
//		filetypeField.setBoost(1.4f);
		
	 	for (Property prop : model.getProperties()) {
			String propName = prop.getName();
			String propValue = prop.getValue();
			Field propField = new TextField(propName, propValue, Field.Store.YES);
			doc.add(propField);
		}
	 	Field idField = new TextField(ID_TAG, model.getId(), Field.Store.YES);
	 	
	 	
	 	Field conformToFieldName = new TextField(CONFORM_TO_TAG, model.getMetamodel().getToArtifact().getName(), Field.Store.YES);
	 	doc.add(conformToFieldName);
	 	Field conformToFieldId = new TextField(CONFORM_TO_TAG, model.getMetamodel().getToArtifact().getId(), Field.Store.YES);
	 	doc.add(conformToFieldId);
	 	doc.add(textField);
	 	doc.add(artName);
	 	doc.add(authorField);
	 	doc.add(lastUpdateField);
		doc.add(idField);
		
	
		return doc;
	}



	@Override
	public void createLuceneIndexFromConfigurationPath() {
		File directoryToIndex = new File(basePathLucene);
		if (directoryToIndex.isDirectory() && directoryToIndex.exists()) {
		
			float duration = 0;
			long startTime = System.nanoTime();
			
			System.out.println("Start Metamodel indexing...");
			metamodelIndex();
			System.out.println("End Metamodel indexing!");
			System.out.println("Start ATL Transformation indexing...");
			atlIndex();
			System.out.println("End ATL Transformation indexing.");
			System.out.println("Start Model indexing...");
			modelIndex();
			System.out.println("End Model indexing.");
			long endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000; // milliseconds(1000000) - seconds (1000000000)
			
			System.out.println("End Overall indexing in " + duration +" ms.");
		}else{
			System.out.println("The provided folder doesn't exists. Check the configuration file.");
		}
	}
	
	private void metamodelIndex() {
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		for (EcoreMetamodel ecoreMetamodel : ecoreMMlist) {
				System.out.println("Indexing: " + ecoreMetamodel.getName());
//				ecoreMetamodelService.createIndex(ecoreMetamodel);
				createLuceneIndex(ecoreMetamodel);
		}
		System.out.println("------------------------------------------------");
		System.out.println("Index of " + ecoreMMlist.size() + " metamodels done!");
		// ecoreMetamodelService.search("eClass:Family");
	}

	
	private void atlIndex() {
		List<ATLTransformation> atlTList = aTLTransformationService.findAll();
		for (ATLTransformation atl : atlTList) {
				System.out.println("Indexing: " + atl.getName());
				createLuceneIndex(atl);
		}
		System.out.println("------------------------------------------------");
		System.out.println("Index of " + atlTList.size() + " metamodels done!");
		// ecoreMetamodelService.search("eClass:Family");
	}
	
	private void modelIndex(){
		List<Model> modelList = modelService.findAll();
		for (Model model : modelList) {
//			if(model.isValid()){
				System.out.println("Indexing: " + model.getName());
				createLuceneIndex(model);
//			}else{
//				System.out.println(model.getName() + " not a valid model!");
//			}
			
		}
		System.out.println("------------------------------------------------");
		System.out.println("Index of " + modelList.size() + " models done!");
	}
	
	
	
	
	/*
	 * SEARCHING
	 */
	@Override
	public SearchResultComplete searchForm(User user, String queryString) throws BusinessException {
		
		SearchResultComplete searchResultComplete = new SearchResultComplete();
		List<SearchResult> searchResults = new ArrayList<SearchResult>();
		
		long duration = 0;
		long startTime = System.nanoTime();
		try {
			IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(basePathLucene)));
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer();
		
		
			//Get all indexed fields
			String[] fields = getAllIndexTags().toArray(new String[0]);
			//Query Parse over multiple Indexed Fields
			
			MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, analyzer);
			org.apache.lucene.search.Query query = queryParser.parse(queryString);
			TopDocs results = searcher.search(query, Integer.MAX_VALUE);
//			ScoreDoc[] hits = results.scoreDocs;
			int numTotalHits = results.totalHits;
			System.out.println(numTotalHits + " total matching documents");

			for (int i = 0; i < numTotalHits; i++) {
				int id = results.scoreDocs[i].doc;
				Document doc = searcher.doc(id);

				T art = (T) artifactService.findOne(doc.get(ID_TAG));
				if(isArtifactAvailableForUser(art, user)){
					SearchResult sr = new SearchResult();
					sr.setArtifact(art);
					sr.setScore(results.scoreDocs[i].score);
					searchResults.add(sr);
				}
			}
			
			reader.close();
			
		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		} catch (ParseException e) {
			throw new BusinessException(e.getMessage());
		} 
		
		
		long endTime = System.nanoTime();
		duration = (endTime - startTime)/1000000; //milliseconds(1000000) - seconds (1000000000)
//		System.out.println("Search done in " + duration + " milliseconds");
		
		searchResultComplete.setResults(searchResults);
		searchResultComplete.setSearchTime(duration);
		
		return searchResultComplete;
	}
	
	@Override
	public List<T> search(User user, String queryString, int maxSearchResult) throws BusinessException {
		List<T> listArtifact = new ArrayList<T>();
		try {
			IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(basePathLucene)));
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer();
			//Get all indexed fields
			String[] fields = getAllIndexTags().toArray(new String[0]);
			//Query Parse over multiple Indexed Fields
			MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, analyzer);
			org.apache.lucene.search.Query query = queryParser.parse(queryString);
			TopDocs hits = searcher.search(query, maxSearchResult);
			int max = (maxSearchResult > hits.totalHits)?hits.totalHits:maxSearchResult;
			for (int i = 0; i < max; i++) {
//				try {
					int id = hits.scoreDocs[i].doc;
					Document doc = searcher.doc(id);
					T art = (T) artifactService.findOne(doc.get(ID_TAG));
					if(isArtifactAvailableForUser(art, user)){
						listArtifact.add(art);
					}
//				} catch (Exception e){}
			}
			reader.close();
		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		} catch (ParseException e1) {
			throw new BusinessException(e1.getMessage());
		} 

		return listArtifact;
	}
	
	
	@Override
	public SearchResultComplete searchWithPagination(User user, String queryString, int hitsPerPage, int pageNumber) throws BusinessException {
		long duration = 0;
		long startTime = System.nanoTime();
		
		int numTotalHits;
		
		SearchResultComplete searchResultComplete = new SearchResultComplete();
		List<SearchResult> searchResults = new ArrayList<SearchResult>();
		try {
			IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(basePathLucene)));
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer();
			
			//Get all indexed fields
			String[] fields = getAllIndexTags().toArray(new String[0]);
			//Query Parse over multiple Indexed Fields
			MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, analyzer);
			org.apache.lucene.search.Query query = queryParser.parse(queryString);
			
			// Collect enough docs to show x (pageNumber) pages
		    TopDocs results = searcher.search(query, pageNumber * hitsPerPage);
		    ScoreDoc[] hits = results.scoreDocs;
			
		    numTotalHits = results.totalHits;
		    System.out.println(numTotalHits + " total matching documents");
		    
//		    int start = 0;
		    int start = (pageNumber-1) * hitsPerPage;;
		    int end = Math.min(numTotalHits, hitsPerPage);
		    
		    if(end > hits.length){
		    	hits = searcher.search(query, numTotalHits).scoreDocs;
		    }
			
		    end = Math.min(hits.length, start + hitsPerPage);
		    
		    for (int i = start; i < end; i++) {
		    	Document doc = searcher.doc(hits[i].doc);
				T art = (T) artifactService.findOne(doc.get(ID_TAG));
				//it search only public artifacts or private or shared with user logged in
				if(isArtifactAvailableForUser(art, user)){
					SearchResult sr = new SearchResult();
					sr.setArtifact(art);
					sr.setScore(hits[i].score);
					searchResults.add(sr);
				}
				
		    }
		    
		    long endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000; //milliseconds(1000000) - seconds (1000000000)
		    
		    reader.close();
		    
		    
//			TopScoreDocCollector collector = TopScoreDocCollector.create(3000, true);  // maxSearchResult is just an int limiting the total number of hits 

//			int startIndex = (pageNumber-1) * hitsPerPage;  // our page is 1 based - so we need to convert to zero based
			
//	        searcher.search(query, numTotalHits);
//
////	        numTotalHits = collector.getTotalHits();
//
//	        TopDocs hits = collector.topDocs(start, hitsPerPage);
//			
//			SimpleHTMLFormatter htmlFormatter = new SimpleHTMLFormatter(TAG_HIGHLIGHT_OPEN, TAG_HIGHLIGHT_CLOSE);
//			Highlighter highlighter = new Highlighter(htmlFormatter, new QueryScorer(query));
////			int max = (maxSearchResult > hits.totalHits)?hits.totalHits:maxSearchResult;
//			int iterator = (hitsPerPage > hits.scoreDocs.length)?hits.scoreDocs.length:hitsPerPage;
//			for (int i = 0; i < iterator; i++) {
//				int id = hits.scoreDocs[i].doc;
//				Document doc = searcher.doc(id);
//				T art = (T) artifactService.findOne(doc.get(ID_TAG));
//				
//				//TODO fare ricerca solo di artefatti PUBBLCI o SOLO PRIVATI o SOLO SHARATI CON ME
//				SearchResult sr = new SearchResult();
//				sr.setArtifact(art);
//				sr.setScore(hits.scoreDocs[i].doc);
//				
//				searchResults.add(sr);
//			}
//			reader.close();
		} catch (IOException e) {
			throw new BusinessException(e.getMessage());
		} catch (ParseException e) {
			throw new BusinessException(e.getMessage());
		} 
		
		searchResultComplete.setResults(searchResults);
		searchResultComplete.setSearchTime(duration);
		searchResultComplete.setTotalHits(numTotalHits);
		searchResultComplete.setHitsPerPage(hitsPerPage);
		searchResultComplete.setPageNumber(pageNumber);
		searchResultComplete.setQueryString(queryString);
		int numberOfPages = 0;
		if(numTotalHits % hitsPerPage == 0){
			numberOfPages = numTotalHits/hitsPerPage;
		}else{
			numberOfPages = (numTotalHits/hitsPerPage) + 1;
		}
		searchResultComplete.setPages(numberOfPages);
		
		return searchResultComplete;
	}
	
	
	@Override
	/**
	 * Delete a Term from Lucene index. It take as input the FIELD_NAME and the FILE_PATH of the file we want to delete.
	 */
	public boolean deleteTermFromIndex(String fieldName, String filePath){
		long numberDeleteTerms = 0;
		boolean result = false;
		
		Term termToDelete = new Term(fieldName, filePath); 
		try {
			numberDeleteTerms = writer.deleteDocuments(termToDelete);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		 BooleanQuery.Builder builder = new BooleanQuery.Builder();
//
//		//note year is stored as int , not as string when document is craeted.
//		//if you use Term here which will need 2016 as String, that will not match with documents stored with year as int.
//		 Query yearQuery = IntPoint.newExactQuery("year", 2016);
//		 Query stateQuery = new TermQuery(new Term("STATE", "TX"));
//		 Query cityQuery = new TermQuery(new Term("CITY", "CITY NAME"));
//
//		 builder.add(yearQuery, BooleanClause.Occur.MUST);
//		 builder.add(stateQuery, BooleanClause.Occur.MUST);
//		 builder.add(cityQuery, BooleanClause.Occur.MUST);
//
//		 writer.deleteDocuments(builder.build());
		
		if(numberDeleteTerms > 0){
			result = true;
		}
		
		return result;
	}


	@Override
	public List<String> indexFieldNamesForMM() {
		return Arrays.asList(metamodelLuceneTags);
	}


	@Override
	public List<String> indexFieldNamesForT() {
		return Arrays.asList(transformationLuceneTags);
	}


	@Override
	public List<String> indexFieldNamesForM() {
		return Arrays.asList(modelLuceneTags);
	}
	
	@Override
	public String getMaxFrequencyTerms() throws IOException{
		 IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(basePathLucene)));
	      final Fields fields = MultiFields.getFields(reader);
	      final Iterator<String> iterator = fields.iterator();

	      long maxFreq = Long.MIN_VALUE;
	      String freqTerm = "";
	      while(iterator.hasNext()) {
	          final String field = iterator.next();
	          final Terms terms = MultiFields.getTerms(reader, field);
	          final TermsEnum it = terms.iterator();
	          BytesRef term = it.next();
	         
	          while (term != null) {
	              final long freq = it.totalTermFreq();
	              if (freq > maxFreq) {
	                  maxFreq = freq;
	                  freqTerm = term.utf8ToString();
	              }
//	              if(freq > 1 && term.utf8ToString().length() > 1){
//	            	  System.out.println(freq +"; "+ term.utf8ToString());
//	              }
	              term = it.next();
	          }
	      }

	      System.out.println(freqTerm + " ["+ maxFreq+" occurrencies]");
	      return freqTerm;
	  }
	
	
	/**
	 * Check if artifact is available (searcheable) for the user logged in. Search public or shared with user artifact. 
	 * @param artifact, user
	 * @return
	 */
	private boolean isArtifactAvailableForUser(Artifact artifact, User user){
		boolean result = false;
		if(user != null){
			//If we are searching in the private area (a User is logged into the system)
			if(artifact.isOpen() || artifact.getAuthor().equals(user) || artifact.getShared().contains(user)){
				result = true;
			}
		}else{
			//We are searching in the public area (only public artifact have to be shown)
			if(artifact.isOpen()){
				result = true;
			}
		}
		
		
		return result;
	}


}
