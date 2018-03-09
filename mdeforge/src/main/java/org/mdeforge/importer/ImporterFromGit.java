package org.mdeforge.importer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.egit.github.core.RepositoryContents;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.User;
import org.mdeforge.integration.RepositoryContentsRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class ImporterFromGit {
	
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
		RepositoryContentsRepository repositoryContentsRepository = context.getBean(RepositoryContentsRepository.class);
		User usr = new User();
		usr.setId("5514b943d4c6c379396fe8b7");
		
		List<RepositoryContents> repositoryContents = repositoryContentsRepository.findAll();
		System.out.println(repositoryContents.size());
		int i = 0;
		for (RepositoryContents repositoryContent : repositoryContents) {
			EcoreMetamodel emm = new EcoreMetamodel();
			emm.setName(repositoryContent.getName());
			
			GridFileMedia gfm = new GridFileMedia();
			gfm.setContent(repositoryContent.getContent());
			gfm.setFileName(repositoryContent.getName());
			emm.setFile(gfm);
			emm.setAuthor(usr);
			emm.setTags(new ArrayList<String>());
			emm.getTags().add("GIT");
			System.out.println("Iteration: " + i + " name: " + emm.getName());
			i++;
			try{
				ecoreMetamodelService.create(emm);
			} catch (Exception e){
				System.out.println();
			}
			
		}
		((ConfigurableApplicationContext)context).close();
	}
}
