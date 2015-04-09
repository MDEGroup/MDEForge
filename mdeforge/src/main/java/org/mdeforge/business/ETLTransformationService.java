package org.mdeforge.business;

import java.util.List;

import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;

public interface ETLTransformationService extends ArtifactService{
	ETLTransformation findOneBySharedUser(String idMetamodel, User user) throws BusinessException;
	List<ETLTransformation> findAllTransformations() throws BusinessException;
	List<ETLTransformation> findAllTransformationsByUserId(String user) throws BusinessException;
	ResponseGrid<ETLTransformation> findAllPaginated(RequestGrid requestGrid)  throws BusinessException;
	void execute(ETLTransformation transformation) throws BusinessException;
	List<ETLTransformation> findTransformationsBySourceMetamodels(ETLTransformation metamodel);
	List<ETLTransformation> findTransformationsByTargetMetamodels(ETLTransformation metamodel);
}
