package org.mdeforge.importer;

import java.util.List;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.ATLTransformationRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnalizeTransformation {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		ATLTransformationService atlTransformationService = context
				.getBean(ATLTransformationService.class);
		ATLTransformationRepository atlRepo = context
				.getBean(ATLTransformationRepository.class);
		
		List<ATLTransformation> atlList = atlTransformationService.findAll();
		User usr = new User();
		usr.setId("5514b943d4c6c379396fe8b7");
		
		for (ATLTransformation atlTransformation : atlList) {
			try {
				atlTransformation.getAtlError().addAll(atlTransformationService.anATLyzer(atlTransformation, usr));
				atlRepo.save(atlTransformation);
				System.out.println(atlTransformation.getName());
				
			}catch (Exception e) {
				System.err.println(atlTransformation.getName());
			}
		}
	}
}
