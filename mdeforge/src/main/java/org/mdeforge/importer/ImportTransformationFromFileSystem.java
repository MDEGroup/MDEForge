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
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ImportTransformationFromFileSystem {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService ecoreMetamodelService = context
				.getBean(EcoreMetamodelService.class);
		ATLTransformationService atlTransformation = context
				.getBean(ATLTransformationService.class);
		ATLTransformationRepository atlRepo = context
				.getBean(ATLTransformationRepository.class);
		GridFileMediaService gridFileMediaService = context
				.getBean(GridFileMediaService.class);
		User usr = new User();
		usr.setId("5514b943d4c6c379396fe8b7");
		String directoryName = "imported/Trans"; // Directory name entered by
													// the user.
		File directory; // File object referring to the directory.
		String[] files; // Array of file names in the directory.

		directory = new File(directoryName);
		files = directory.list();
		for (String file : files) {
			if (file.endsWith(".atl")) {
				System.out.println("=============== " + file);
				try {
					GridFileMedia gfm;
					gfm = gridFileMediaService.createObjectFromFile(
							"imported/Trans/" + file, file);
					List<Relation> relList = atlTransformation
							.getModelsInfo(gfm);
					if (relList.size() == 2) {
						ATLTransformation atl = new ATLTransformation();
						atl.setName(file);
						atl.setFile(gfm);
						atl.setAuthor(usr);
						atl.setOpen(true);
						
						for (Relation relation : relList) {
							relation.setFromArtifact(atl);
							if (relation instanceof DomainConformToRelation) {

								String mmName = ((DomainConformToRelation) relation)
										.getReferenceModelName();
								File mm = new File(
										"imported/Metamodel/"
												+ mmName
												+ ".ecore");
								if (!mm.exists())
									System.err.println("IN err");
								else {
									EcoreMetamodel ecore = ecoreMetamodelService.findOneByName(mmName);
									if (ecore == null) {
										ecore = new EcoreMetamodel();
										ecore.setOpen(true);
										ecore.setName(mmName);
										ecore.setAuthor(usr);
										GridFileMedia gfme = gridFileMediaService.createObjectFromFile(
											"imported/Metamodel/" + mmName +".ecore", mmName);
										ecore.setFile(gfme);
										ecoreMetamodelService.create(ecore);
									}
									relation.setToArtifact(ecore);
								}
							}
							if (relation instanceof CoDomainConformToRelation) {
								String mmName = ((CoDomainConformToRelation) relation)
												.getReferenceModelName();
								File mm = new File(
										"imported/Metamodel/"
												+ mmName
												+ ".ecore");
								if (!mm.exists())
									System.err.println("OUT err");
								else {
									EcoreMetamodel ecore = ecoreMetamodelService.findOneByName(mmName);
									if (ecore == null) {
										ecore = new EcoreMetamodel();
										ecore.setOpen(true);
										ecore.setName(mmName);
										ecore.setAuthor(usr);
										GridFileMedia gfme = gridFileMediaService.createObjectFromFile(
											"imported/Metamodel/" + mmName +".ecore", mmName);
										ecore.setFile(gfme);
										ecoreMetamodelService.create(ecore);
									}
									relation.setToArtifact(ecore);
								}
								
							}
						}
						atl.getRelations().addAll(relList);
						atl = atlTransformation.create(atl);
//						atl = atlTransformation.anATLyzer(atl.getId(), usr);
//						atlRepo.save(atl);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BusinessException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		((ConfigurableApplicationContext)context).close();
	}
}
