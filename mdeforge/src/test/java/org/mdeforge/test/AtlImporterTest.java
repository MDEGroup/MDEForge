package org.mdeforge.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.m2m.atl.emftvm.EmftvmFactory;
import org.eclipse.m2m.atl.emftvm.ExecEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/rest-dispatcher-servlet-security.xml" })
public class AtlImporterTest {

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private ATLTransformationService atlTransformationService;
	@Autowired
	private UserService userService;
	@Autowired
	private SimilarityRelationService similarityRelationService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;

	private static String pathToImportTransformation = "caseStudy/transformations/";

	private static String pathToImportMetamodel = "caseStudy/metamodels/";

	private static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(Base64.encode(encoded));

	}
	@Ignore
	@Test
	public void testInjection() {
		User user = userService.findOne("5514b943d4c6c379396fe8b7");

		File f = new File(pathToImportTransformation);

		String[] f1 = f.list();
		for (int j = 0; j < f1.length; j++) {
			System.out.println("Import transformation: " + f1[j]);
			if (!f1[j].startsWith(".") && !f1[j].endsWith(".xmi") && !f1[j].endsWith(".asm"))
				try {
					ATLTransformation transformation = new ATLTransformation();
					GridFileMedia gfmTransformation = new GridFileMedia();
					gfmTransformation
							.setContent(readFile(pathToImportTransformation
									+ f1[j]));
					String decodedString = new String(Base64.decode(gfmTransformation.getContent().getBytes()));
					transformation.setFile(gfmTransformation);
					transformation.setAuthor(user);
					transformation.setOpen(true);
					transformation.getShared().add(user);
					transformation.setName(f1[j]);

					List<String[]> ecoreMetamodelInTransformationString = getInputMetamodel(decodedString);
					List<String[]> ecoreMetamodelOutTransformationString = getOutputMetamodel(decodedString);

					for (String[] ecoreMetamodelName : ecoreMetamodelInTransformationString) {
						String metamodelName = ecoreMetamodelName[1];
						String metamodelTag = ecoreMetamodelName[0];
						String metamodelPath = pathToImportMetamodel
								+ metamodelName;
						EcoreMetamodel ec = ecoreMetamodelService
								.findOneByName(metamodelName);
						if (ec == null) {
							ec = new EcoreMetamodel();
							ec.setName(metamodelName);
							ec.setAuthor(user);
							ec.getShared().add(user);
							ec.setOpen(true);
							GridFileMedia gfm = new GridFileMedia();
							String s = readFile(metamodelPath + ".ecore");
							gfm.setContent(s);
							gfm.setFileName(metamodelName + ".ecore");
							ec.setFile(gfm);
							ecoreMetamodelService.create(ec);

						}
						DomainConformToRelation dctr = new DomainConformToRelation();
						dctr.setFromArtifact(transformation);
						dctr.setName(metamodelTag);
						dctr.setReferenceModelName(metamodelName);
						dctr.setToArtifact(ec);
						transformation.getRelations().add(dctr);
					}
					for (String[] ecoreMetamodelName : ecoreMetamodelOutTransformationString) {
						String metamodelName = ecoreMetamodelName[1];
						String metamodelTag = ecoreMetamodelName[0];
						String metamodelPath = pathToImportMetamodel
								+ metamodelName;
						EcoreMetamodel ec = ecoreMetamodelService
								.findOneByName(metamodelName);
						if (ec == null) {
							ec = new EcoreMetamodel();
							ec.setName(metamodelName);
							ec.setAuthor(user);
							ec.setOpen(true);
							ec.getShared().add(user);
							GridFileMedia gfm = new GridFileMedia();
							String s = readFile(metamodelPath + ".ecore");
							gfm.setContent(s);
							gfm.setFileName(metamodelName + ".ecore");
							ec.setFile(gfm);
							ecoreMetamodelService.create(ec);
						}
						CoDomainConformToRelation cdctr = new CoDomainConformToRelation();
						cdctr.setFromArtifact(transformation);
						cdctr.setToArtifact(ec);
						cdctr.setName(metamodelTag);
						cdctr.setReferenceModelName(metamodelName);
						transformation.getRelations().add(cdctr);
					}
					atlTransformationService.create(transformation);
				} catch (Exception e) {
					e.printStackTrace();
					System.err.println("Problem importing: " + f1[j]);
					//throw new BusinessException();
				}
		}
		System.out.println("FINE");
	}

	private List<String[]> getOutputMetamodel(String content) {
				List<String[]> result = new ArrayList<String[]>();
				int start = content.indexOf("create ");
				
				String sub = content.substring(start);
				int stop = sub.indexOf(";");
				String realContent= sub.substring(0,stop);
				realContent = realContent.replaceAll("create", "");
				stop =  realContent.indexOf(" from");
				String output = realContent.substring(0,stop);
				output = output.replace(" ", "");
				String[] res = output.split(":");
				for (int i = 0; i<res.length - 1; i++) {
					String[] s = {res[i],res[i+1]};
					result.add(s);
				}
				return result;
	}

	private List<String[]> getInputMetamodel(String content) {
		// TODO Auto-generated method stub
		List<String[]> result = new ArrayList<String[]>();
		int start = content.indexOf("create ");
		
		String sub = content.substring(start);
		int stop = sub.indexOf(";");
		String realContent= sub.substring(0,stop);
		realContent = realContent.replaceAll("create", "");
		start =  realContent.indexOf(" from") + 5;
		String output = realContent.substring(start);
		output = output.replace(" ", "");
		String[] res = output.split(":");
		for (int i = 0; i<res.length - 1; i++) {
			String[] s = {res[i],res[i+1]};
			result.add(s);
		}
		return result;
	}
	
	private void testEMFTVM() {
		ExecEnv env = EmftvmFactory.eINSTANCE.createExecEnv();
	}
}
