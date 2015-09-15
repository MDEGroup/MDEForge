package org.mdeforge.importer.main;

import java.io.File;
import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class ImporterMain {
	public static void main(String[] args) {
		File f = new File("src/main/webapp/WEB-INF/spring/root-context.xml");
		System.out.println(f.exists());
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		System.out.println("asd");
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
		
		System.out.println("###START");
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		EcoreMetamodel [] ecoreMMArray = ecoreMMlist.toArray(new EcoreMetamodel[ecoreMMlist.size()]);
		for (int i =0; i < ecoreMMArray.length-1; i++) 
			for (int j = i+1; j <ecoreMMArray.length; j++) {
				System.out.println(ecoreMMArray[i].getName() + "_" + ecoreMMArray[j].getName());
				ecoreMetamodelService.calculateSimilarity(ecoreMMArray[i], ecoreMMArray[j]);
			}
		System.out.println("Stop");
	}
}
