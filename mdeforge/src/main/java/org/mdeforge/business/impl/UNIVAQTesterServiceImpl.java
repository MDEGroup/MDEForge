package org.mdeforge.business.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Future;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;
import org.eclipse.m2m.atl.engine.compiler.atl2006.Atl2006Compiler;
import org.mdeforge.business.ATLTransformationCompilationError;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.UNIVAQTesterService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ATLTransformationTestServiceError;
import org.mdeforge.business.model.CoDomainConformToRelation;
import org.mdeforge.business.model.ConformToRelation;
import org.mdeforge.business.model.DomainConformToRelation;
import org.mdeforge.business.model.ERROR_KIND;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import anatlyzer.atl.model.ATLModel;
import anatlyzer.atlext.ATL.Module;
import anatlyzer.evaluation.models.FullModelGenerationStrategy;
import anatlyzer.evaluation.models.LiteModelGenerationStrategy;
import anatlyzer.evaluation.models.ModelGenerationStrategy;
import anatlyzer.evaluation.report.Report;
import transML.exceptions.transException;
import transML.utils.transMLProperties;
import transML.utils.modeling.ATLEngine;
import transML.utils.modeling.TrafoEngine;
import transML.utils.solver.FactorySolver;
import transML.utils.solver.SolverWrapper;


@Service
public class UNIVAQTesterServiceImpl implements UNIVAQTesterService {
	@Autowired
	EcoreMetamodelService ecoreMetamodelService;
	@Value("#{cfgproperties[basePath]}")
	protected String basePath;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	public List<ATLTransformationTestServiceError> executeTransformation(EMFModel atlModel, ATLTransformation transformation, List<Model> models,
			boolean exhaustive) throws ATLTransformationCompilationError {
		List<ATLTransformationTestServiceError> result = new ArrayList<ATLTransformationTestServiceError>();
		ResourceSetImpl rs = new ResourceSetImpl();
		Report report = new Report();
		List<DomainConformToRelation> inputMetamodelRelations = new ArrayList<DomainConformToRelation>();
		List<CoDomainConformToRelation> outputMetamodels = new ArrayList<CoDomainConformToRelation>();
		
		inputMetamodelRelations.addAll(transformation.getDomainConformToRelation());
		outputMetamodels.addAll(transformation.getCoDomainConformToRelation());

		
		String folderTemp = basePath + "anatlyze/temp" + File.separator;
		boolean error = false;

		// name of input/output metamodels of the transformation
		// TODO: there may be several input/output metamodels
		
		String aux = URI.createFileURI(basePath + transformation.getName())
				.lastSegment();
		String oFolder = "";
		if(aux.contains("."))
			oFolder = aux.substring(0, aux.lastIndexOf("."));
		else
			oFolder = aux;
		
		// compilation is performed when the mutant is generated, but just in
		// case...
		if (compileTransformation(transformation) == false)
			throw new ATLTransformationCompilationError();

		try {
			// load transformation
			String atlTransformationFile = gridFileMediaService.getFilePath(transformation);
			String transformation_asm = atlTransformationFile.replace(".atl",
					".asm");
			
			String inputMetamodelString = gridFileMediaService
					.getFilePath(inputMetamodelRelations.get(0).getToArtifact());
			String outputMetamodelString = gridFileMediaService
					.getFilePath(outputMetamodels.get(0).getToArtifact());

			
			TrafoEngine engine = new ATLEngine();
			engine.loadTransformation(transformation_asm);

			// obtain input test models
//			File[] inputModels = new File(folderModels)
//					.listFiles(new FilenameFilter() {
//						public boolean accept(File directory, String fileName) {
//							return fileName.endsWith(".model");
//						}
//					});

			// for each input test model
			for (Model inputModel : models) {

				// load input/output model
				String iModel = gridFileMediaService.getFilePath(inputModel);
				String oModel = folderTemp + oFolder + File.separator
						+ inputModel.getName(); // generate output model in
												// temporal folder, because it
												// will be deleted

				// TODO
				engine.loadSourcemodel(inputMetamodelRelations.get(0).getReferenceModelName(), iModel, inputMetamodelString );
				engine.loadTargetmodel(outputMetamodels.get(0).getReferenceModelName(), oModel, outputMetamodelString);
				// execute transformation
				try {
					// check whether the transformation does not crash
					if (engine.execute()) {
						// check whether the output model is conformant to the
						// output metamodel
						// TODO: check OCL constraints of the meta-model as well
						URI uri = URI.createFileURI(oModel);
						Resource resource = rs.getResource(uri, true);
						for (EObject eObject : resource.getContents()) {
							Diagnostic diagnostic = Diagnostician.INSTANCE
									.validate(eObject);
							if (diagnostic.getSeverity() != Diagnostic.OK) {
								ATLTransformationTestServiceError errorForge = new ATLTransformationTestServiceError();
								errorForge.setModel(inputModel);
								errorForge.setErrorMessage(((BasicDiagnostic) diagnostic
												.getChildren().get(0))
												.getMessage());
								errorForge.setErrorKind(ERROR_KIND.EXECUTION_YIELDS_ILL_TARGET);
								result.add(errorForge);
								error = report.setOutputError(
										atlTransformationFile,
										((BasicDiagnostic) diagnostic
												.getChildren().get(0))
												.getMessage(), inputModel
												.getName());
							}
						}
					} else {
						ATLTransformationTestServiceError errorForge = new ATLTransformationTestServiceError();
						errorForge.setModel(inputModel);
						errorForge.setErrorMessage("EXECUTION_ERROR");
						errorForge.setErrorKind(ERROR_KIND.EXECUTION_RAISES_EXCEPTION);
						result.add(errorForge);
						error = report.setExecutionError(atlTransformationFile,
								"EXECUTION_ERROR", inputModel.getName());
					}
				} catch (transException e) {
					ATLTransformationTestServiceError errorForge = new ATLTransformationTestServiceError();
					errorForge.setModel(inputModel);
					errorForge.setErrorMessage(e.getDetails().length > 0 ? e.getDetails()[0] : e
							.getMessage());
					errorForge.setErrorKind(ERROR_KIND.EXECUTION_RAISES_EXCEPTION);
					result.add(errorForge);
					report.setExecutionError(
							atlTransformationFile,
							e.getDetails().length > 0 ? e.getDetails()[0] : e
									.getMessage(), inputModel.getName());
				} catch (Exception e) {
					ATLTransformationTestServiceError errorForge = new ATLTransformationTestServiceError();
					errorForge.setModel(inputModel);
					errorForge.setErrorMessage("Unable TO determine");
					errorForge.setErrorKind(ERROR_KIND.EXECUTION_RAISES_EXCEPTION);
					result.add(errorForge);
					report.setExecutionError(
							atlTransformationFile,
							"Unable to determine", inputModel.getName());
				}

				if (error && !exhaustive)
					break;
			}
		} catch (transException e) {
			System.out.println("******** REVISE: EXECUTION_ERROR ("
					+ transformation + ")");
		} finally {
			deleteDirectory(oFolder, true);
		}

		return result;
	}
	@Async
	public Future<List<Model>> generateModel(EMFModel atlModel, ATLTransformation trafo, ModelGenerationStrategy.STRATEGY modelGenerationStrategyBoolean) throws transException {
		List<Model> result = new ArrayList<Model>();
		List<DomainConformToRelation> inputMetamodels = new ArrayList<DomainConformToRelation>();
		List<CoDomainConformToRelation> outputMetamodels = new ArrayList<CoDomainConformToRelation>();
		inputMetamodels.addAll(trafo.getDomainConformToRelation());
		outputMetamodels.addAll(trafo.getCoDomainConformToRelation());

		String folderModels = basePath + "anatlyzer/testmodels" + File.separator;
		String folderTemp = basePath + "anatlyzer/temp" + File.separator;
		EcoreMetamodel first = (EcoreMetamodel) inputMetamodels.get(0)
				.getToArtifact();
		EPackage metamodel = null;
		Resource resource = ecoreMetamodelService.registerMetamodel(first);
		for (EObject obj : resource.getContents()) {
			if (obj instanceof EPackage
					&& ((EPackage) obj).getName().equals(
							inputMetamodels.get(0).getReferenceModelName())) {
				metamodel = (EPackage) obj;
				break;
			}
		}

		if (metamodel == null)
			metamodel = (EPackage) resource.getContents().get(0); // TODO: fix
		if (metamodel.getNsURI() == null)
			metamodel.setNsURI(inputMetamodels.get(0).getReferenceModelName());
		deleteDirectory(folderTemp, true);
		deleteDirectory(folderModels, true);
		createDirectory(folderTemp);
		List<String> classes = new ArrayList<String>();
		List<String> references = new ArrayList<String>();
		List<EReference> auxref = new ArrayList<EReference>();
		for (EClassifier classifier : metamodel.getEClassifiers()) {
			if (classifier instanceof EClass) {
				if (!((EClass) classifier).isAbstract())
					classes.add(classifier.getName());
				for (EReference ref : ((EClass) classifier).getEReferences()) {
					// optimization: do not consider opposite
					if (!auxref.contains(ref.getEOpposite()))
						references.add(((EClass) classifier).getName() + "."
								+ ref.getName());
					auxref.add(ref);
				}
			}
		}

		// initialize parameters for model generation
		Properties properties = new Properties();
		saveTransMLProperties(properties, folderTemp);

		// load transformation preconditions (defined as comments annotated by
		// @pre)
		Module module = new ATLModel(atlModel.getResource()).getModule();
		List<String> preconditions = new ArrayList<String>();
		for (String s : module.getCommentsBefore()) {
			if (s.contains("@pre"))
				preconditions.add(s.substring(s.indexOf("@pre") + 4).trim());
		}
		// generate models
		
		SolverWrapper solver = FactorySolver.getInstance().createSolverWrapper();
		ModelGenerationStrategy modelGenerationStrategy = 
						modelGenerationStrategyBoolean == ModelGenerationStrategy.STRATEGY.Full?
						new FullModelGenerationStrategy(classes, references) :
						new LiteModelGenerationStrategy(classes, references) ;
		for (Properties propertiesUse : modelGenerationStrategy) {
			try {
				saveTransMLProperties(propertiesUse, folderTemp);
				String model = solver.find(metamodel, preconditions); // Collections.<String>emptyList());
				System.out.println("generated model: "
						+ (model != null ? model : "NONE"));
				if (model != null) {
					Model m = new Model();
					String [] modelName = model.split("/");
					Date ss1 = new Date();
					SimpleDateFormat formatter5 = new SimpleDateFormat("yyyyMMddHHmmss");
					String formats1 = formatter5.format(ss1);
					m.setOpen(true);
					m.setName(formats1 + modelName[modelName.length-1]);
					m.setFile(gridFileMediaService.createObjectFromFile(model, modelName[modelName.length-1]));
					ConformToRelation ctr = new ConformToRelation();
					ctr.setFromArtifact(m);
					ctr.setToArtifact(inputMetamodels.get(0).getToArtifact());
					m.getRelations().add(ctr);
					result.add(m);
				}
			} catch (transException e) {
				String error = e.getDetails().length > 0 ? e.getDetails()[0]
						: e.getMessage();
				if (error.endsWith("\n"))
					error = error.substring(0, error.lastIndexOf("\n"));
				System.out.println("[ERROR] " + error);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// move generated models to output folder
		try {
			moveDirectory(folderTemp + "models", folderModels);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resource.unload();
		
		return new AsyncResult<List<Model>>(result);
	}

	private void moveDirectory(String sourceDirectory, String targetDirectory)
			throws IOException {
		File source = new File(sourceDirectory);
		File target = new File(targetDirectory);
		Files.move(source.toPath(), target.toPath(),
				StandardCopyOption.ATOMIC_MOVE);
	}

	private void createDirectory(String directory) {
		File folder = new File(directory);
		while (!folder.exists())
			folder.mkdir();
	}

	private void deleteDirectory(String directory, boolean recursive) {
		File folder = new File(directory);
		if (folder.exists())
			for (File file : folder.listFiles()) {
				if (file.isDirectory())
					deleteDirectory(file.getPath(), recursive);
				file.delete();
			}
		folder.delete();
	}

	private void saveTransMLProperties(Properties properties, String folderTemp)
			throws transException {
		try {
			File file = new File(folderTemp, "transml.properties");
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.put("solver", "use");
			properties.put("solver.scope", "10");
			properties.put("temp", new File(folderTemp).getAbsolutePath());
			properties.store(fileOut, "--");
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		transMLProperties.loadPropertiesFile(folderTemp);
	}

	private boolean compileTransformation(
			ATLTransformation atlTransformationFile) {
		return compileTransformation(atlTransformationFile, false);
	}

	private boolean compileTransformation(ATLTransformation atlTransformation,
			boolean forceCompilation) {
		String atlTransformationFile = gridFileMediaService
				.getFilePath(atlTransformation);
		CompileTimeError[] compileErrors = {};
		String asmTransformationFile = atlTransformationFile.replace(".atl",
				".asm");

		if (!new File(asmTransformationFile).exists() || forceCompilation) {
			Atl2006Compiler compiler = new Atl2006Compiler();
			FileInputStream trafoFile;
			try {
				trafoFile = new FileInputStream(new File(atlTransformationFile));
				compileErrors = compiler.compile(trafoFile,
						asmTransformationFile);
				trafoFile.close();
			} catch (FileNotFoundException e) {
				return false;
			} catch (IOException e) {
				return false;
			}
		}

		return !(compileErrors != null && compileErrors.length > 0);
	}

}
