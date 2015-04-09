package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.User;

public interface EcoreMetamodelService extends ArtifactService {
	
	List<EcoreMetamodel> findAllEcore();
	EcoreMetamodel findByOwnerEcore(String idEcoreMetamodel, User user) throws BusinessException;
	List<EcoreMetamodel> findEcoreMetamodelByURI(String URI);
	ResponseGrid<EcoreMetamodel> findAllEcorePaginated(RequestGrid requestGrid)  throws BusinessException;
	void registerMetamodel (EcoreMetamodel ecoreMetamodel) throws BusinessException;
}
