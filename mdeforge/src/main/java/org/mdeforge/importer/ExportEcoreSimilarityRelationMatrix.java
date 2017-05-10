package org.mdeforge.importer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SimilarityRelationService;
//import org.mdeforge.business.SemanticSimilarityRelationServiceV1;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.SimilarityRelation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class ExportEcoreSimilarityRelationMatrix {
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
//		MetricRepository mr = context.getBean(MetricRepository.class);
		// RelationRepository rr = context.getBean(RelationRepository.class);
		SimilarityRelationService sr = context.getBean(SimilarityRelationService.class);
		
		//CHECK FILE
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		EcoreMetamodel[] ecoreMMArray = ecoreMMlist.toArray(new EcoreMetamodel[ecoreMMlist.size()]);
		System.out.println("start time: " + new Date());
		String s = "";
		for (int i = 0; i < ecoreMMArray.length - 1; i++) {
			s = s + ecoreMMArray[i].getName() + ";";
		}
		write(s);
		s = "";
		for (int i = 0; i < ecoreMMArray.length - 1; i++) {
			System.out.println(ecoreMMArray[i].getName() + " " + i + " of " + (ecoreMMlist.size() - i) + " start time: "
					+ new Date());
			for (int j = 0; j < ecoreMMArray.length; j++) {

				if (ecoreMMArray[i].equals(ecoreMMArray[j])) {
					s += "1.0;";
				} else {
					SimilarityRelation smv = sr.findOneByArtifacts(ecoreMMArray[i], ecoreMMArray[j]);
					if (smv == null) {
						smv = sr.findOneByArtifacts(ecoreMMArray[j], ecoreMMArray[i]);
						if (smv == null)
							s += "NAN;";
						else
							s += smv.getValue() + ";";
					} else
						s += smv.getValue() + ";";
				}
			}
			s += System.lineSeparator();
		}
		
		System.out.println("end time: " + new Date());
		((ConfigurableApplicationContext) context).close();
	}
	public static void write(String s) {
		String basePath = "/home/mdeforge/";
		FileSystemResource resource = new FileSystemResource(basePath + "report.txt");
		File f = resource.getFile();
		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			fw = new FileWriter(f.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(s);
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
