package org.mdeforge.importer;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.integration.MetricRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CountByMetric {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
//		ecoreMetamodelService.createIndex();
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		MetricRepository mr = context.getBean(MetricRepository.class);
		int count10 = 0;
		int count15 = 0;
		int count20 = 0;
		int count25 = 0;
		for (EcoreMetamodel ecoreMetamodel : ecoreMMlist) {
			
			SimpleMetric sm = (SimpleMetric) mr.findOneByNameAndArtifactId("Number of MetaClass", new ObjectId(ecoreMetamodel.getId()));
			
			int value = 0;
			try {
				value = Integer.parseInt(sm.getValue());
			} catch (Exception e) {
				
			}
			if (value < 10)
				count10 ++;
			if (value < 15)
				count15 ++;
			if (value < 20)
				count20 ++;
			if (value < 25)
				count25 ++;
		}
		System.out.println("<10: " + count10 );
		System.out.println("<15: " + count15 );
		System.out.println("<20: " + count20 );
		System.out.println("<25: " + count25 );
	}
}
