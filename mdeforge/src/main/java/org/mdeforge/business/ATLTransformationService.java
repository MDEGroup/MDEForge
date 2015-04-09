package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;

public interface ATLTransformationService extends ArtifactService{
	
	void execute(ATLTransformation transformation);
	List<ATLTransformation> findTransformationsBySourceMetamodels(ATLTransformation metamodel);
	List<ATLTransformation> findTransformationsByTargetMetamodels(ATLTransformation metamodel);
//	ATLTransformation findByName(String name);	
//	ATLTransformation findByOwner(String idTransformation, String idUser) throws BusinessException;
	List<ATLTransformation> findAllTransformations() throws BusinessException;
	ResponseGrid<ATLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
}
