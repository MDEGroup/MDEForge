package org.mdeforge.importer.main;

import org.mdeforge.business.importer.impl.EcoreMetamodelImporterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class ImporterMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		ImporterMain p = context.getBean(ImporterMain.class);
		p.start(args);
	}

	@Autowired
	private EcoreMetamodelImporterServiceImpl myBean;

	private void start(String[] args) {
		System.out.println("my beans method: ");
	}
}
