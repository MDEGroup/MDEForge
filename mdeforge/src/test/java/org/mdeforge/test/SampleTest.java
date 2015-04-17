package org.mdeforge.test;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.SimilarityRelation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
								   "file:src/main/webapp/WEB-INF/spring/rest-dispatcher-servlet-security.xml"})

public class SampleTest {

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private MetamodelService metamodelService;
	@Autowired
	private UserService userService;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	@Test
	public void getListSimilarity() {
		try {
			List<SimilarityRelation> similarityRelationList = similarityRelationService.findAll();
			PrintWriter p = new PrintWriter("/Users/juridirocco/Desktop/result.txt");
			for (SimilarityRelation similarityRelation : similarityRelationList) {
				p.println(similarityRelation.getValue());
			}
			p.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
