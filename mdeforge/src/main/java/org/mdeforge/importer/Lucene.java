package org.mdeforge.importer;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.LuceneDocumentParser;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.integration.MetricRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Lucene {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		for (EcoreMetamodel ecoreMetamodel : ecoreMMlist) {
			System.out.println(ecoreMetamodel.getName());
			ecoreMetamodelService.createIndex(ecoreMetamodel);
		}
//		ecoreMetamodelService.search("eClass:Family");
	}
}
