package org.mdeforge.importer;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
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

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		GridFileMediaService gfms = context.getBean(GridFileMediaService.class);
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
		RepositoryContentsRepository repositoryContentsRepository = context.getBean(RepositoryContentsRepository.class);
		User usr = new User();
		usr.setId("5514b943d4c6c379396fe8b7");
		File folder = new File("githubmetamodels");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.toString().endsWith(".ecore")) {
		        try {
		        	EcoreMetamodel emm = new EcoreMetamodel();
		        	emm.setName(file.getName());
		        	emm.setAuthor(usr);
		        	emm.setFile(gfms.createObjectFromFile(file.toString(), file.getName().toString()));
		        	emm.setOpen(true);
		        	Property p = new Property();
		        	p.setName("imported");
		        	p.setValue("github");
		        	ecoreMetamodelService.create(emm);
		        	System.out.println(file.getName().toString());
		        } catch (Exception e) {
		        	System.out.println("ERROR: " + file);
		        }
		    }
		}
			
		
		((ConfigurableApplicationContext)context).close();
		
	}
}
