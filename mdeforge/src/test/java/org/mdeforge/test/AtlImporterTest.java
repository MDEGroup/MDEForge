package org.mdeforge.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.IExtractor;
import org.eclipse.m2m.atl.core.emf.EMFExtractor;
import org.eclipse.m2m.atl.core.emf.EMFInjector;
import org.eclipse.m2m.atl.core.IInjector;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.CoDomainConformToRelation;
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

	@Test
	public void testInjection() {
		ATLTransformation atl = atlTransformationService.findOne("555df94945689b88d1fd6fbe");
		atlTransformationService.getMetrics(atl);	
	}
	
//	@Test
//	public void importAtl() {
//		
//
//		int ii = 1;
//		File d = new File("Repository/");
//		String a[] = d.list();
//
//		for (int i = 0; i < a.length; i++) {
//			// System.out.println(ii + ". " + a[i]);
//			File f = new File("Repository/" + a[i] + "/transformations");
//			if (f.isDirectory() && !a[i].startsWith(".")) {
//				String[] f1 = f.list();
//
//				for (int j = 0; j < f1.length; j++) {
//					if (!f1[j].startsWith("."))
//						try {
//
//							File f2 = new File(f1[j]);
//							//
//							ATLTransformation trasformation = generateArtifact(
//									"Repository/" + a[i] + "/transformations/"
//											+ f2.getPath(), f2.getPath(), true);
//							BufferedReader br;
//							String path2 = "imported/" + "Trans/"
//									+ f2.getPath();
//							File trgXmi = new File(path2);
//							br = new BufferedReader(new FileReader(trgXmi));
//							String sCurrentLine;
//							while ((sCurrentLine = br.readLine()) != null) {
//								if (sCurrentLine.startsWith("create")
//										&& !sCurrentLine.contains(";")) {
//									boolean guard = false;
//									String appoggio;
//									while (((appoggio = br.readLine()) != null)
//											&& !guard) {
//										if (appoggio.contains(";"))
//											guard = true;
//										sCurrentLine += appoggio;
//									}
//								}
//
//								if (sCurrentLine.startsWith("create")
//										&& sCurrentLine.contains(";")) {
//									if (sCurrentLine.contains("from")) {
//										String sources = sCurrentLine
//												.split("from")[0];
//										String targets = sCurrentLine
//												.split("from")[1];
//										sources = sources.substring(6,
//												sources.length() - 1);
//										String sourcesArray[] = sources
//												.split(",");
//										String targetArray[] = targets
//												.split(",");
//
//										for (int indiceSource = 0; indiceSource < sourcesArray.length; indiceSource++) {
//											String metamodelName = sourcesArray[indiceSource]
//													.split(":")[1];
//
//											metamodelName = metamodelName
//													.replaceAll(" ", "");
//											metamodelName = metamodelName
//													.replaceAll("\t", "");
//											metamodelName += ".ecore";
//											String metamodelPath = "Repository/"
//													+ a[i]
//													+ "/metamodels/"
//													+ metamodelName;
//											
//											IImporter importerEcore = new EcoreArtifactManager();
//											EcoreMetamodel metamodelTemp;
//											try {
//												metamodelTemp = importerEcore
//														.generateArtifact(
//																metamodelPath,
//																metamodelName,
//																true);
//												it.univaq.disim.mdeforge.mdeforgeEMF.RelationType rT = RelationTypeManager
//														.getInstance()
//														.selectOne(
//																"domainConformTo");
//												if (rT == null) {
//													rT = it.univaq.disim.mdeforge.mdeforgeEMF.MdeforgeEMFFactory.eINSTANCE
//															.createRelationType();
//													rT.setName("domainConformTo");
//												}
//												it.univaq.disim.mdeforge.mdeforgeEMF.Relation relation = it.univaq.disim.mdeforge.mdeforgeEMF.MdeforgeEMFFactory.eINSTANCE
//														.createRelation();
//												relation.setType(rT);
//												relation.setName(trasformation
//														.getName()
//														+ "DomainConformTo"
//														+ metamodelTemp
//																.getName());
//												relation.setArtifactLeft(metamodelTemp);
//												relation.setArtifactRight(trasformation);
//												trasformation
//														.getRelationOwnerL()
//														.add(relation);
//												metamodelTemp
//														.getRelationOwnerR()
//														.add(relation);
//												RelationManager.getInstance()
//														.addWithArtifact(
//																relation);
//
//											} catch (ATLCoreException e) {
//												// TODO Auto-generated catch
//												// block
//												System.out
//														.println("Ecore metric calcolation exception");
//												e.printStackTrace();
//											}
//										}
//
//										for (int indiceSource = 0; indiceSource < targetArray.length; indiceSource++) {
//											String metamodelName = targetArray[indiceSource]
//													.split(":")[1];
//
//											metamodelName = metamodelName
//													.replaceAll(" ", "");
//											metamodelName = metamodelName
//													.replaceAll(";", "");
//											metamodelName = metamodelName
//													.replaceAll("\t", "");
//											metamodelName += ".ecore";
//											String metamodelPath = "Repository/"
//													+ a[i]
//													+ "/metamodels/"
//													+ metamodelName;
//											IImporter importerEcore = new EcoreArtifactManager();
//											Artifact metamodelTemp;
//											try {
//												metamodelTemp = importerEcore
//														.generateArtifact(
//																metamodelPath,
//																metamodelName,
//																true);
//												it.univaq.disim.mdeforge.mdeforgeEMF.RelationType rT = RelationTypeManager
//														.getInstance()
//														.selectOne(
//																"co-domainConformTo");
//												if (rT == null) {
//													rT = it.univaq.disim.mdeforge.mdeforgeEMF.MdeforgeEMFFactory.eINSTANCE
//															.createRelationType();
//													rT.setName("co-domainConformTo");
//												}
//												CoDomainConformToRelation relation = new CoDomainConformToRelation();
//												relation.setType(rT);
//												relation.setName(trasformation
//														.getName()
//														+ "coDomainConformTo"
//														+ metamodelTemp
//																.getName());
//												relation.setToArtifact(metamodelTemp);
//												relation.setFromArtifact(trasformation);
//												trasformation
//														.getRelationOwnerR()
//														.add(relation);
//												metamodelTemp
//														.getRelationOwnerL()
//														.add(relation);
//												RelationManager.getInstance()
//														.addWithArtifact(
//																relation);
//
//											} catch (ATLCoreException e) {
//												// TODO Auto-generated catch
//												// block
//												System.out
//														.println("Ecore metric calcolation exception");
//												e.printStackTrace();
//											}
//										}
//									}
//									if (sCurrentLine.contains("refining")) {
//										System.out.println("");
//
//									}
//								}
//								ii++;
//							}
//							br.close();
//
//						} catch (IOException e) {
//							e.printStackTrace();
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							System.out.println("Transformation Error");
//							e.printStackTrace();
//						}
//
//				}
//				System.out.println("FINE");
//			}
//
//		}
//	}
//	
//	public ATLTransformation generateArtifact(
//			String path, String name, boolean calculateMetric) throws IOException  {
//		IInjector processor = new EMFInjector();
//		IExtractor extractor = new EMFExtractor();
//		String xmi;
//		try {
//			xmi = processor.injectATLTransformation(new File(path));
//			if(calculateMetric)
//			{
//				String target = getPath() + path.substring(path.lastIndexOf("/"));
//				xmi.toString();
//				File src = new File(path);
//				File trg = new File(target);
//				File srcXmi = new File(xmi);
//				File trgXmi = new File(target+".xmi");
//				if (!trg.exists())
//					Files.copy(src.toPath(), trg.toPath(), REPLACE_EXISTING);
//				if(!trgXmi.exists())
//					Files.copy(srcXmi.toPath(), trgXmi.toPath(), REPLACE_EXISTING);
//				srcXmi.delete();
//				
//				ATLMetricCalculator app = new ATLMetricCalculator();
//				
//				Artifact artifact = MdeforgeEMFFactoryImpl.eINSTANCE.createArtifact();
//				artifact.setName(name);
//				artifact.setUri(target+".xmi");
//				ArtifactType artifactType = MdeforgeEMFFactoryImpl.eINSTANCE.createArtifactType();
//				artifactType.setName("ATL Transformation");
//				artifact.setType(artifactType);
//				artifact.getMetrics().addAll(app.calculateAll(artifact));
//				
//				
//				return artifact;
//			}
//			else return generateArtifact(path, name);
//		} catch (InjectorException e) {
//			System.out.println("ATL Injector Exception");
//			e.printStackTrace();
//			return null;
//		}
//		
//	}
//	
//	
//	private String getPath(){
//		try {
//    		Properties forgeProperties = new Properties();
//			forgeProperties.load(new FileReader("forge.properties"));
//			return forgeProperties.getProperty("repository");
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			return null;
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//	}

}
