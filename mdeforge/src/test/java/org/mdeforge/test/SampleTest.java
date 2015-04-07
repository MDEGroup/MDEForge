package org.mdeforge.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.SimilarityService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.impl.SimilarityServiceImpl;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.beans.factory.annotation.Autowired;
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
//	@Autowired
//	private ValidateService validationService;
	@Autowired
	private SimilarityService similarityService;
//	@Test
//	public void testSimilarityNoIoc() {
//		SimilarityServiceImpl si = new SimilarityServiceImpl();
//		EcoreMetamodel a = ecoreMetamodelService.findOne("54d099b48252e88f947f9c7e");
//		EcoreMetamodel b = ecoreMetamodelService.findOne("54d099d18252e88f947f9d86");
//		si.calculateSimilarity(a, b);
//	}
	

//	@Test
//	public void test() {
//		final String a1InFileName = new String("a1.ecore");
//		final String a1OutFileName = new String("a1/temp_out/out_net1_01.xmi");
//		final String b1InFileName = new String("b1.ecore");
//		final String b1OutFileName = new String("b1/temp_out/out_net1_01.xmi");
//		final String c1OutFileName = new String("c1/temp_out/out_net1_01.xmi");
//		final String c1OutTextFileName = new String("c1/temp_out/out.txt");
//		
//		EcoreMetamodel a = ecoreMetamodelService.findOne("54d099b48252e88f947f9c7e");
//		EcoreMetamodel b = ecoreMetamodelService.findOne("54d099d18252e88f947f9d86");
//		System.out.println(a.getFile().getByteArray());
//		File a1 = new File(a1InFileName);
//		File b1 = new File(b1InFileName);
//
//		try {
//			//Generate directGraph
//			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("digraphMM", new DigraphMMFactoryImpl());
//			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//			Files.write(a.getFile().getByteArray(),a1);
//			Files.write(b.getFile().getByteArray(),b1);
//			String [] arrayA1 = {a1InFileName,a1OutFileName};
//			Ecore2directgraph.main(arrayA1);
//			String [] arrayB1 = {b1InFileName,b1OutFileName};
//			Ecore2directgraph.main(arrayB1);
//			
//			//
//
//			String [] cArray = {a1OutFileName,b1OutFileName,c1OutFileName};
//			Digraphs2weightedbipartitegraph.main(cArray);
//			
//			String [] dArray = {c1OutFileName,	c1OutTextFileName};
//			HungarianAlgorithm.main(dArray);
//			//runSimilarityComputation(c1OutFileName,	"c1/temp_out/out.txt"));
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	@Test
//	public void testEMF() {
//		try {
//			EcoreFactory factory = EcoreFactory.eINSTANCE;
//			ResourceSet resourceSet = new ResourceSetImpl();
//			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
//			File temp = new File("metamodels_unified/Ecore.ecore");
//			Resource resource = resourceSet.createResource(URI.createFileURI(temp.getAbsolutePath()));
//
//			resource.load(null);
//			EcoreUtil.resolveAll(resourceSet);
//			EObject eo = resource.getContents().get(0);
//			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(eo);
//			if (diagnostic.getSeverity() == Diagnostic.ERROR) {
//				System.err.println(diagnostic);
//			} else {
//				System.out.println("success creation: " + diagnostic);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//	@Test
//	public void testValidationNoIoc() {
//		ValidateEcoreService va = new ValidateEcoreService();
//		boolean b = va.isValid(null);
//
//	}

	@Test
	public void testSimilarityNoIoc() {
		SimilarityServiceImpl si = new SimilarityServiceImpl();
		Artifact a = ecoreMetamodelService.findOne("54d0997b8252e88f947f9a76");
		Artifact b = ecoreMetamodelService.findOne("54d0997c8252e88f947f9a7a");
		si.calculateSimilarity(a, b);
	}
	
//	@Test
//	public void testSimilarityCalculation() {
//		SimilarityServiceImpl si = new SimilarityServiceImpl();
//		String resutl = new String(";");
//		StringBuilder sb = new StringBuilder(resutl);
//		List<EcoreMetamodel> ecoreMetamodelsList = ecoreMetamodelService.findAll();
//		EcoreMetamodel [] ecoreMetamodelsArray = new EcoreMetamodel[ecoreMetamodelsList.size()]; 
//		ecoreMetamodelsArray = ecoreMetamodelsList.toArray(ecoreMetamodelsArray);
//		int i = 10, j = 0;
//		for (i=0; i<ecoreMetamodelsArray.length;i++)
//			sb.append(ecoreMetamodelsArray[i].getName()).append(";");
//		sb.append("\n");
//		for (i=6; i<ecoreMetamodelsArray.length;i++) {
//			sb.append(ecoreMetamodelsArray[i].getName()).append(";");
//			EcoreMetamodel artI = ecoreMetamodelService.findOne(ecoreMetamodelsArray[i].getId());
//			for (j=i+1; i< ecoreMetamodelsArray.length -1;j++) {
//				EcoreMetamodel artJ = ecoreMetamodelService.findOne(ecoreMetamodelsArray[j].getId());
//				System.err.println(new Date().toString());
//				System.err.println(artI.getName() + "___" + artJ.getName());
//				System.err.println(artI.getId() + "___" + artJ.getId());
//				try {
//					String simValue = si.calculateSimilarity(artI, artJ);
//					simValue = simValue.replace("Score (structural): ", "").replace("\\n","");
//					
//					simValue = simValue.replaceAll(",", ".");
//					
//					SimilarityRelation similarityRelation = new SimilarityRelation();
//					try {
//						similarityRelation.setValue(Double.parseDouble(simValue));
//						similarityRelation.setFromArtifact(artI);
//						similarityRelation.setToArtifact(artJ);
//						
//						System.err.println("QUI1" + simValue);
//						similarityRelationService.save(similarityRelation);
//					}
//					catch (Exception e ){
//						similarityRelation.setValue(0);
//					}
//					sb.append(simValue).append(";");
//				} catch (Exception e) {
//					sb.append("ERROR").append(";");
//				}
//				
//			}
//			sb.append("\n");
//		}
//		PrintWriter out;
//		try {
//			out = new PrintWriter("filename.txt");
//			out.write(resutl);
//			System.out.println(resutl);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	
//	@Test
//	public void testValidationIoc() {
//		boolean b = validationService.isValid(null);
//
//	}
//
	@Test
	public void testSimilarityIoc() {
		Artifact a = ecoreMetamodelService.findOne("54d099b48252e88f947f9c7e");
		Artifact b = ecoreMetamodelService.findOne("54d099d18252e88f947f9d86");
		similarityService.calculateSimilarity(a, b);
	}
	
	
//	@Test
//	public void testSchema() throws JsonProcessingException{
////		HyperSchemaFactoryWrapper personVisitor = new HyperSchemaFactoryWrapper();
////        personVisitor.setIgnoreDefaults(false);
////        ObjectMapper mapper = new ObjectMapper();
////
////        mapper.acceptJsonFormatVisitor(Person.class, personVisitor);
////        JsonSchema personSchema = personVisitor.finalSchema();
////
////        HyperSchemaFactoryWrapper petVisitor = new HyperSchemaFactoryWrapper();
////        mapper.acceptJsonFormatVisitor(Pet.class, petVisitor);
////        JsonSchema petSchema = petVisitor.finalSchema();
////        String json1 = petVisitor.toString();
////		String json2 = petSchema.toString();
////		
//		
//		ObjectMapper m = new ObjectMapper();
//	    SchemaFactoryWrapper visitor = new SchemaFactoryWrapper();
//	    m.acceptJsonFormatVisitor(m.constructType(Artifact.class), visitor);
//	    JsonSchema jsonSchema = visitor.finalSchema();
//	    String json1 = m.writeValueAsString(jsonSchema);
//	    
//	    ObjectMapper m2 = new ObjectMapper();
//	    SchemaFactoryWrapper visitor2 = new SchemaFactoryWrapper();
//	    m2.acceptJsonFormatVisitor(m.constructType(Artifact.class), visitor2);
//	    JsonSchema jsonSchema2 = visitor2.finalSchema();
//	    String json2 = m2.writeValueAsString(jsonSchema2);
//	    
//	    
//		
////        ObjectMapper MAPPER = new ObjectMapper();
////		TitleSchemaFactoryWrapper visitor = new TitleSchemaFactoryWrapper();
////		MAPPER.acceptJsonFormatVisitor(Metamodel.class, visitor);
////		JsonSchema jsonSchema = visitor.finalSchema();
//		System.out.println(json1);
//		System.out.println(json2);
//		
//	}
//	public void testSayHello() {
//		File d = new File("metamodels_unified/");
//		String a[] = d.list(); // creo un array di stringhe e lo riempio con la
//								// lista dei files presenti nella directory
//		User user = userService.findOne("547338e7d4c6f3cd4b6ebded");
//
//		for (int i = 0; i < a.length; i++) {
//
//			try {
//
//				Metamodel p = new Metamodel();
//				p.setAuthor(user);
//				List<User> ul = new ArrayList<>();
//				ul.add(user);
//				p.setShared(ul);
//				p.setName(a[i]);
//				p.setCreated(new Date());
//				File file = new File("metamodels_unified/" + a[i]);
//				FileInputStream fileInputStream = new FileInputStream(file);
//				GridFileMedia gfm = new GridFileMedia();
//				gfm.setByteArray(IOUtils.toByteArray(fileInputStream));
//				gfm.setFileName(a[i]);
//				p.setFile(gfm);
//				metamodelService.create(p);
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}

//	}
}
