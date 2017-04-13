package org.mdeforge.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Property;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
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
	
	private static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(Base64.encode(encoded));

	}
	@Ignore
	@Test
	public void addATLTransformation() {
		User user = userService.findOne("5514b943d4c6c379396fe8b7");
		EcoreMetamodel emm = new EcoreMetamodel();
		emm.setName("ATL");
		emm.setAuthor(user);
		emm.setDescription("ATL (ATLAS Transformation Language) is a model-to-model transformation language.");
		emm.setCreated(new Date());
		emm.setModified(new Date());
		emm.setAuthor(user);
		emm.setOpen(true);
		Property p = new Property();
		p.setName("Domain");
		p.setValue("MDE/Model Transformation");
		emm.getProperties().add(p);
		p = new Property();
		p.setName("Imported from");
		p.setValue("EMFZoo: http:/ / www.emn.fr/ z-info/ atlanmod/ index.php/ Ecore");
		GridFileMedia gfm = new GridFileMedia();
		String s = null;
		try {
			s = readFile("temppp/ATL.ecore");
		} catch (IOException e) {
			
		}
		
		gfm.setContent(s);
		emm.setFile(gfm);
		emm.getProperties().add(p);
		ecoreMetamodelService.create(emm);
		List<String> uris = ecoreMetamodelService.getNSUris(emm);
		emm.getUri().addAll(uris);
		ecoreMetamodelService.update(emm);
	}
}
