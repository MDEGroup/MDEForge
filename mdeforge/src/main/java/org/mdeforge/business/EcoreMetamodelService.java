package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;

public interface EcoreMetamodelService extends CRUDArtifactService<EcoreMetamodel>,
		MetricProvider, SearchProvider, SimilarityService, ValidateService, ClusterService {
	List<EcoreMetamodel> findEcoreMetamodelByURI(String URI);
	ResponseGrid<EcoreMetamodel> findAllEcorePaginated(RequestGrid requestGrid)  throws BusinessException;
	void registerMetamodel (EcoreMetamodel ecoreMetamodel) throws BusinessException;
	
}
