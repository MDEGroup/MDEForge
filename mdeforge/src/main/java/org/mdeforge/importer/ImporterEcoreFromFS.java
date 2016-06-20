package org.mdeforge.importer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.eclipse.core.resources.mapping.ModelStatus;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.emf.ecore.resource.Resource;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.impl.ModelServiceImpl;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.RepositoryContentsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class ImporterEcoreFromFS {

	public static Model createTestModel(EcoreMetamodel emm, GridFileMediaService gfms) throws IOException{
		
		User usr = new User();
		usr.setId("5514b943d4c6c379396fe8b7");
		
		//Creo modello
    	Model m = new Model();
    	m.setAuthor(usr);
    	m.setCreated(new Date());
    	m.setDescription("Basciani model test.");
    	
    	String modelFilePath = "/Users/francesco/Desktop/luceneMDEExample/composed.xmi";
    	String modelName = "Composed2Bascio";
    	
    	/**
    	 * Tutto quello che serve
    	 */
    	m.setFile(gfms.createObjectFromFile(modelFilePath, modelName));
	    m.setOpen(true);
	    m.setName("bascio");
    	/**
    	 * 
    	 */
    	ConformToRelation ctr = new ConformToRelation();
    	ctr.setFromArtifact(m);
    	ctr.setToArtifact(emm);
    	m.getRelations().add(ctr);
    	
    	return m;
	}
	
	
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService modelService = context.getBean(EcoreMetamodelService.class);
		ModelService mmodelService = context.getBean(ModelService.class);
		EcoreMetamodel emm = modelService.findOne("575ecc30d4c6c76c196888d8");
		Resource r = modelService.loadArtifact(emm);
		r.getContents().forEach(x->System.out.println("JURI "+x));
		
		
		
		Model testModel = mmodelService.findOne("575eb7fdd4c60e5eef616060");
		mmodelService.createIndex(testModel);
		
	}
}
