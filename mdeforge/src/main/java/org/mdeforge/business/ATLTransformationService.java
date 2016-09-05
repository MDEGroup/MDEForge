package org.mdeforge.business;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.eclipse.m2m.atl.common.ATLExecutionException;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ATLTransformationError;
import org.mdeforge.business.model.ATLTransformationTestServiceError;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.Statistic;

import transML.exceptions.transException;

public interface ATLTransformationService extends CRUDArtifactService<ATLTransformation>, MetricProvider {	
	List<Model> execute(ATLTransformation transformation, List<Model> models, User user) throws ATLExecutionException, ATLCoreException;
	List<ATLTransformation> findTransformationsBySourceMetamodels(ATLTransformation metamodel);
	List<ATLTransformation> findTransformationsByTargetMetamodels(ATLTransformation metamodel);
	ResponseGrid<ATLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	String inject(ATLTransformation atlTransformation) throws BusinessException;
	List<Relation> getModelsInfo(GridFileMedia gfm) throws BusinessException;
	List<ATLTransformationError> anATLyzer(ATLTransformation transformation) throws BusinessException;
	List<ATLTransformationTestServiceError> testServices(String transfString) throws ATLTransformationCompilationError, transException;
	EMFModel injectATLModel(ATLTransformation atlTransformation)
			throws BusinessException;
	double metamodelCoverage(ATLTransformation transforation)
			throws BusinessException;
	List<EcoreMetamodel> getPossibleMetamodel(ATLTransformation atl) throws BusinessException;
	List<ATLTransformationTestServiceError> testServices(
			ATLTransformation transformation)
			throws ATLTransformationCompilationError, transException;
	List<Statistic> numberOfMCdistribution();
}
