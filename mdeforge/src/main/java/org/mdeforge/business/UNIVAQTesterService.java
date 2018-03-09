package org.mdeforge.business;

import java.util.List;
import java.util.concurrent.Future;

import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ATLTransformationTestServiceError;
import org.mdeforge.business.model.Model;

import transML.exceptions.transException;
import anatlyzer.evaluation.models.ModelGenerationStrategy;

public interface UNIVAQTesterService {
	Future<List<Model>> generateModel(EMFModel atlEMFModel, ATLTransformation trafo, ModelGenerationStrategy.STRATEGY modelGenerationStrategy) throws transException;
	public List<ATLTransformationTestServiceError> executeTransformation (EMFModel atlEMFModel, ATLTransformation transformation, List<Model> models, boolean exhaustive) throws ATLTransformationCompilationError;
}
