package org.mdeforge.business;

import java.util.List;

import org.eclipse.m2m.atl.core.emf.EMFModel;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;

public interface ATLTransformationService extends CRUDArtifactService<ATLTransformation>, MetricProvider{	
	List<Model> execute(ATLTransformation transformation, List<Model> models, User user);
	List<ATLTransformation> findTransformationsBySourceMetamodels(ATLTransformation metamodel);
	List<ATLTransformation> findTransformationsByTargetMetamodels(ATLTransformation metamodel);
	ResponseGrid<ATLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	String inject(ATLTransformation atlTransformation) throws BusinessException;
	List<Relation> getModelsInfo(GridFileMedia gfm) throws BusinessException;
	ATLTransformation anATLyzer(String transformation_id, User user) throws BusinessException;
	void testServices(String transfString, User user);
	EMFModel injectATLModel(ATLTransformation atlTransformation)
			throws BusinessException;
	double metamodelCoverage(ATLTransformation transforation)
			throws BusinessException;
	List<EcoreMetamodel> getPossibleMetamodel(ATLTransformation atl) throws BusinessException;
}
