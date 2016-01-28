package org.mdeforge.importer;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.ATLTransformationRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import anatlyzer.atl.util.ATLSerializer;

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
				ATLTransformation atl = atlTransformationService.anATLyzer(atlTransformation.getId(), usr);
				atlRepo.save(atl);
				System.out.println(atl.getName());
				
			}catch (Exception e) {
				System.err.println(atlTransformation.getName());
			}
		}
	}
}
