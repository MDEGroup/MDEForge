package org.mdeforge.importer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.crypto.codec.Base64;
public class CreareEcoreSimilarityRelation {
	public static void main(String[] args) {
		
		String basePath = "/home/juri/development/forgeDir/";
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
//		RelationRepository rr = context.getBean(RelationRepository.class);
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		EcoreMetamodel [] ecoreMMArray = ecoreMMlist.toArray(new EcoreMetamodel[ecoreMMlist.size()]);
		write("start time: " + new Date());
		for (int i = 0; i < ecoreMMArray.length-1; i++) {
			write(ecoreMMArray[i].getName() + " " + i + " of "+ (ecoreMMlist.size()-i) + " start time: " + new Date());
			for (int j = i+1; j <ecoreMMArray.length; j++) {
				try {
					if(j % 100 == 0)
						write("Coputed " + j + " of " + (ecoreMMlist.size()-i));
					ecoreMetamodelService.calculateSimilarity(ecoreMMArray[i], ecoreMMArray[j]);
				} catch (Exception e) {
					write("ERROR: " + ecoreMMArray[i].getName() + " " + i  + " _ " + ecoreMMArray[j].getName() + " " + j);
				}
			}
		}
		write("end time: " + new Date());
		((ConfigurableApplicationContext)context).close();
	}
	
	public static void write(String s) {
		String basePath = "/home/juri/development/forgeDir/";
		FileSystemResource resource = new FileSystemResource(basePath + "report.txt");
		File f = resource.getFile();
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(f.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(s + "\n");
		}catch (FileNotFoundException e) {} catch (IOException e) {} catch (Exception e) {}
		finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
