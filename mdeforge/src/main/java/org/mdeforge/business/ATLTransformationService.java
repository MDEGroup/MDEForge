package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ATLTransformation;

public interface ATLTransformationService extends CRUDArtifactService<ATLTransformation>, MetricProvider{	
	void execute(ATLTransformation transformation);
	List<ATLTransformation> findTransformationsBySourceMetamodels(ATLTransformation metamodel);
	List<ATLTransformation> findTransformationsByTargetMetamodels(ATLTransformation metamodel);
	ResponseGrid<ATLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	String inject(ATLTransformation atlTransformation) throws BusinessException;
}
