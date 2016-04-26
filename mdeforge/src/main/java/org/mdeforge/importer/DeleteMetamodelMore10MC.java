package org.mdeforge.importer;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.SimpleMetric;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.MetricRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DeleteMetamodelMore10MC {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
//		ecoreMetamodelService.createIndex();
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		MetricRepository mr = context.getBean(MetricRepository.class);
		User usr = new User();
		usr.setId("5514b943d4c6c379396fe8b7");
		
		for (EcoreMetamodel ecoreMetamodel : ecoreMMlist) {
			
			SimpleMetric sm = (SimpleMetric) mr.findOneByNameAndArtifactId("Number of MetaClass", new ObjectId(ecoreMetamodel.getId()));
			
			int value = 100;
			try {
				value = Integer.parseInt(sm.getValue());
			} catch (Exception e) {	}
			if (value >= 10){
				System.out.println("Deleting mm: " + ecoreMetamodel.getName());
				try {
					ecoreMetamodelService.delete(ecoreMetamodel, usr);
					System.out.println("Deleted");
				} catch (Exception e) {System.out.println("Error deleting");}
			}
		}
	}
}
