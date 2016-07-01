package org.mdeforge.importer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lucene {
	
	private ApplicationContext context;
	
	public Lucene(ApplicationContext context){
		this.context = context;
	}

	
	public void metamodelIndex() {
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		for (EcoreMetamodel ecoreMetamodel : ecoreMMlist) {
				System.out.println("Indexing: " + ecoreMetamodel.getName());
				ecoreMetamodelService.createIndex(ecoreMetamodel);
		}
		System.out.println("------------------------------------------------");
		System.out.println("Index of " + ecoreMMlist.size() + " metamodels done!");
		// ecoreMetamodelService.search("eClass:Family");
	}

	public void atlIndex() {
		ATLTransformationService ecoreMetamodelService = context.getBean(ATLTransformationService.class);
		List<ATLTransformation> ecoreMMlist = ecoreMetamodelService.findAll();
		for (ATLTransformation ecoreMetamodel : ecoreMMlist) {
				System.out.println("Indexing: " + ecoreMetamodel.getName());
				ecoreMetamodelService.createIndex(ecoreMetamodel);
		}
		System.out.println("------------------------------------------------");
		System.out.println("Index of " + ecoreMMlist.size() + " metamodels done!");
		// ecoreMetamodelService.search("eClass:Family");
	}
	
	public void modelIndex(){
		ModelService modelService = context.getBean(ModelService.class);
		List<Model> modelList = modelService.findAll();
		for (Model model : modelList) {
//			if(model.isValid()){
				System.out.println("Indexing: " + model.getName());
				modelService.createIndex(model);
//			}else{
//				System.out.println(model.getName() + " not a valid model!");
//			}
			
		}
		System.out.println("------------------------------------------------");
		System.out.println("Index of " + modelList.size() + " models done!");
	}
	
	
	
	public void printLuceneFieldsName(String indexDirectoryPath){
		
		System.out.println("---------------------------------");
		System.out.println("List of Name Fields in the index:");
		System.out.println("---------------------------------");
		
		HashSet<String> result = new HashSet<String>();
		
		File indexDirFile = new File(indexDirectoryPath);
		try {
			FSDirectory indexDir = FSDirectory.open(indexDirFile);
			IndexReader luceneIndexReader = IndexReader.open(indexDir);
			result = (HashSet<String>) luceneIndexReader.getFieldNames(IndexReader.FieldOption.ALL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<String> sortedList = new ArrayList<String>(result);
		Collections.sort(sortedList);
		
		sortedList.forEach(x -> System.out.println(x));
	}

	
	public static void main(String[] args) {
		
		String indexDirectoryPath = "/Users/juri/development/forgeDir/luceneIndex";
		/*
		 * FANCESCO URL
		 * /Users/francesco/Desktop/newForgeDir/luceneIndex
		 * */
		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");

		Lucene lucene = new Lucene(context);
		
		float duration = 0;
		long startTime = System.nanoTime();
		
		System.out.println("Start Metamodel indexing...");
		lucene.metamodelIndex();
		System.out.println("End Metamodel indexing!");
		System.out.println("Start Model indexing...");
		lucene.atlIndex();
		lucene.modelIndex();
		long endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000; // milliseconds(1000000) - seconds (1000000000)
		
		System.out.println("End Model indexing in " + duration +" ms.");
		
		lucene.printLuceneFieldsName(indexDirectoryPath);

	}
}
