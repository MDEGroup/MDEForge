package org.mdeforge.test;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.epsilon.ecl.parse.Ecl_EolParserRules.newExpression_return;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Relation;
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
	public void Graph () {
		PrintWriter p;
		try {
			p = new PrintWriter(basePath + "result.txt");
			
			String result = "nodes = [\n";
			List<EcoreMetamodel> ecoreMetamodels = ecoreMetamodelService.findAllPublic(EcoreMetamodel.class);
			int size = ecoreMetamodels.size();
			HashMap	<String, Integer>  hm = new HashMap<String, Integer>();
			AtomicInteger i = new AtomicInteger();
			for (EcoreMetamodel ecoreMetamodel : ecoreMetamodels) {
				if(!hm.containsKey( ecoreMetamodel.getId())) {
					int unique = i.incrementAndGet();
					hm.put(ecoreMetamodel.getId(), unique);
				}
				result += "\t{id: "+ hm.get(ecoreMetamodel.getId()) +", label:'"+ ecoreMetamodel.getName() +"'}";
				if(--size != 0)
					result +=",\n";
				else result +="\n";
				
			}
			result += "]\n";
			result += "edges = [\n";
			List<Relation> relations = similarityRelationService.findAll(0.3);
			System.out.println(relations.size());
			size = relations.size();
			for (Relation relation : relations) {
				Double d = (((SimilarityRelation)relation).getValue()*10);
				result += "{from:"+ hm.get(relation.getFromArtifact().getId())+", to: " + hm.get(relation.getToArtifact().getId()) + ", value: " + d.intValue() + ", label:" + (((SimilarityRelation)relation).getValue()) + "}";
				if(--size != 0)
					result +=",\n";
				else result +="\n";
			}
			result += "]\n";
			p.println(result);
			p.close();
			System.out.println("FINITO!!!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
