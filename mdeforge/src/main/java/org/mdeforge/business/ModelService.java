package org.mdeforge.business;

import java.util.List;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;

public interface ModelService extends ArtifactService<Model>, ValidateService, SimilarityService {
	List<Model> findModelsByMetamodel(Metamodel metamodel);
}
