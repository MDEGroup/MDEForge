package org.mdeforge.importer;

import org.mdeforge.business.EcoreMetamodelService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CreateIndex {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService ec = context
				.getBean(EcoreMetamodelService.class);
		ec.createIndex();
		((ConfigurableApplicationContext)context).close();
	}
}
