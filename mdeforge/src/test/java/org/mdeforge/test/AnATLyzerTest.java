package org.mdeforge.test;

import java.util.List;

import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.m2m.atl.core.IReferenceModel;
import org.eclipse.m2m.atl.core.ModelFactory;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.core.emf.EMFModelFactory;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.SimilarityRelationService;
import org.mdeforge.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import anatlyzer.atl.analyser.AnalysisResult;
import anatlyzer.atl.errors.Problem;
import anatlyzer.atl.errors.ProblemStatus;
import anatlyzer.atl.errors.atl_error.LocalProblem;
import anatlyzer.atl.model.ATLModel;
import anatlyzer.atl.tests.api.AnalysisLoader;
import anatlyzer.atl.util.ATLUtils;
import anatlyzer.atl.util.AnalyserUtils;
import anatlyzer.atl.util.ATLUtils.ModelInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class AnATLyzerTest {

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
	public void anATLyzerTest() throws ATLCoreException {
		//Extract Preliminar information
		AtlParser atlParser = new AtlParser();
		ModelFactory modelFactory = new EMFModelFactory();
		IReferenceModel atlMetamodel = modelFactory
				.getBuiltInResource("ATL.ecore");
		EMFModel atlDynModel = (EMFModel) modelFactory.newModel(atlMetamodel);
		atlParser.inject(atlDynModel, "transformation/Families2Persons.atl");
		Resource originalTrafo = atlDynModel.getResource();
		ATLModel atlModel = new ATLModel(originalTrafo, originalTrafo.getURI().toFileString(), true);
		List<ModelInfo> info = ATLUtils.getModelInfo(atlModel);
		// Resource[] resources = new Resource[info.size()];
		String[] files = new String[info.size()];
		String[] names = new String[info.size()];
		
		int i = 0;
		for (ModelInfo modelInfo : info) {
			names[i] = modelInfo.getMetamodelName();
			files[i] = modelInfo.getURIorPath();
			i++;
			System.out.println(modelInfo.getModelName());
			System.out.println(modelInfo.getMetamodelName());
			System.out.println(modelInfo.getURIorPath());
			System.out.println(modelInfo.isInput());
			System.out.println(modelInfo.isOutput());
		}
		
		
		
		// submit...
		/*
		Resource r1 = null; // get r1 from mdeforge 
		Resource r2 = null; // get r2 from mdeforge 
		*/
		AnalysisLoader loader = AnalysisLoader.fromATLModel(atlModel, files, names);
		AnalysisResult result = loader.analyse();
		
		for (Problem problem : result.getProblems()) {
			if ( problem instanceof LocalProblem ) {
				LocalProblem lp = (LocalProblem) problem;
			
				
				System.out.println( lp.getElement() );				
			}
			
			if ( problem.getStatus() == ProblemStatus.WITNESS_REQUIRED ) {
				// launch constraint solver
				
			}
			
			
			System.out.println( AnalyserUtils.getProblemId(problem) );
			System.out.println( AnalyserUtils.getProblemDescription(problem) );
		}
	}
}
