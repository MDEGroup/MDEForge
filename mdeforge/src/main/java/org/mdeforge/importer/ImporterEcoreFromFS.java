package org.mdeforge.importer;

import java.io.File;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class ImporterEcoreFromFS {
	
	private static String folderString = "GLOBAL";
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		GridFileMediaService gfms = context.getBean(GridFileMediaService.class);
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
		User usr = new User();
		usr.setId("5514b943d4c6c379396fe8b7");
		File folder = new File(folderString);
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
		        	p.setValue("COMLAN EVALUATION");
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
