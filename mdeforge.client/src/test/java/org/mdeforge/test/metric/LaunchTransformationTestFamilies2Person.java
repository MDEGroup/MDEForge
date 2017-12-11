package org.mdeforge.test.metric;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.client.ATLTransformationService;
import org.mdeforge.client.ArtifactService;
import org.mdeforge.client.EcoreMetamodelService;
import org.mdeforge.client.ModelService;

public class LaunchTransformationTestFamilies2Person {

	private static ArtifactService artifactService; 


	@BeforeClass
	public static void setup() throws Exception {
//		artifactService = new ArtifactService("http://localhost:8080/mdeforge/", "Admin", "test123");
	}
	
//	@Ignore
	@Test
	public void loadDataATLTransformationFamilies2Person () throws Exception  {
		artifactService = new ArtifactService("http://localhost:8080/mdeforge/", "Admin", "juri");
		List<Metric> lm = artifactService.getArtifactMetrics("570b626c11200c9281009818");
		for (Metric metric : lm) {
			System.out.println(metric.getClass());
		}
		lm.forEach(x -> System.out.println(x.getName()));
		Artifact art = artifactService.getArtifact("57ecce640f0c487db7b173af");
		art.getMetrics().forEach(x->System.out.println(x.getName()));
	}
}
