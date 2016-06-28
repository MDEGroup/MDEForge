package org.mdeforge.importer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SemanticSimilarityRelationService;
//import org.mdeforge.business.SemanticSimilarityRelationServiceV1;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.SemanticSimilarityRelation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ExportEcoreSimilarityRelationMatrix {
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		EcoreMetamodelService ecoreMetamodelService = context.getBean(EcoreMetamodelService.class);
//		MetricRepository mr = context.getBean(MetricRepository.class);
		// RelationRepository rr = context.getBean(RelationRepository.class);
		SemanticSimilarityRelationService sr = context.getBean(SemanticSimilarityRelationService.class);
		File f = new File("C:\\Users\\juri\\development\\forgeDir\\AAA.txt");
		FileWriter fw = new FileWriter(f);
		List<EcoreMetamodel> ecoreMMlist = ecoreMetamodelService.findAll();
		EcoreMetamodel[] ecoreMMArray = ecoreMMlist.toArray(new EcoreMetamodel[ecoreMMlist.size()]);
		System.out.println("start time: " + new Date());
		for (int i = 0; i < ecoreMMArray.length - 1; i++) {
			fw.write(ecoreMMArray[i].getName() + ";");
		}
		fw.write(System.lineSeparator());
		for (int i = 0; i < ecoreMMArray.length - 1; i++) {
			System.out.println(ecoreMMArray[i].getName() + " " + i + " of " + (ecoreMMlist.size() - i) + " start time: "
					+ new Date());
			for (int j = 0; j < ecoreMMArray.length; j++) {

				if (ecoreMMArray[i].equals(ecoreMMArray[j])) {
					fw.write("1.0;");
				} else {
					SemanticSimilarityRelation smv = sr.findOneByArtifacts(ecoreMMArray[i], ecoreMMArray[j]);
					if (smv == null) {
						smv = sr.findOneByArtifacts(ecoreMMArray[j], ecoreMMArray[i]);
						if (smv == null)
							fw.write("NAN;");
						else
							fw.write(smv.getValue() + ";");
					} else
						fw.write(smv.getValue() + ";");
				}

			}
			fw.write(System.lineSeparator());
		}
		fw.close();
		System.out.println("end time: " + new Date());
		((ConfigurableApplicationContext) context).close();
	}
}
