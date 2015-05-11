package org.mdeforge.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/rest-dispatcher-servlet-security.xml" })
public class MetricTest {

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
	@Ignore
	@Test
	public void calculateAllMetrics() {
		List<EcoreMetamodel> ecoreMetamodelList = ecoreMetamodelService
				.findAllPublic();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodelList) {

			try {
				System.out.print(ecoreMetamodel.getName());
				System.out.println(": "
						+ ecoreMetamodelService
								.calculateMetrics(ecoreMetamodel).size());
			} catch (Exception e) {
				System.err.println(ecoreMetamodel.getName());

			}
		}
	}
	@Ignore
	@Test
	public void getNSUri() {
		List<EcoreMetamodel> ecoreMetamodelList = ecoreMetamodelService
				.findAllPublic();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodelList) {

			try {
				System.out.print(ecoreMetamodel.getName());
				List<String> ls = ecoreMetamodelService.getNSUris(ecoreMetamodel);
				for (String string : ls) 
					System.out.print(ls);
				System.out.println();
				ecoreMetamodel.getUri().addAll(ls);
				ecoreMetamodelService.updateSimple(ecoreMetamodel);
			} catch (Exception e) {
				System.err.println(ecoreMetamodel.getName());

			}
		}
	}
	@Ignore
	@Test
	public void addCopyRight() {
		List<EcoreMetamodel> ecoreMetamodelList = ecoreMetamodelService
				.findAllPublic();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodelList) {
			Property prop = new Property();
			prop.setName("Imported from");
			prop.setValue("EMFZoo: http://www.emn.fr/z-info/atlanmod/index.php/Ecore");
			ecoreMetamodel.getProperties().add(prop);
			ecoreMetamodelService.updateSimple(ecoreMetamodel);
		}
	}
	@Test
	public void addSerializedContent() {
		List<EcoreMetamodel> ecoreMetamodelList = ecoreMetamodelService
				.findAllPublic();
		for (EcoreMetamodel ecoreMetamodel : ecoreMetamodelList) {
			String serializedContext = ecoreMetamodelService.serializeContent(ecoreMetamodel);		
			ecoreMetamodel.setExtractedContents(serializedContext);
			ecoreMetamodelService.updateSimple(ecoreMetamodel);
			System.out.println(ecoreMetamodel.getName());
		}
	}
}
