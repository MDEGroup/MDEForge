package org.mdeforge.business;

import java.util.List;

import org.apache.lucene.document.Document;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.User;

public interface ModelService extends CRUDArtifactService<Model>, ValidateService, SimilarityService {
	List<Model> findModelsByMetamodel(Metamodel metamodel);

	List<org.mdeforge.business.model.Model> findByTransformation(ATLTransformation atlTransformation);

	void createAll(List<Model> artifacts, EcoreMetamodel metamodel, User user) throws BusinessException;

	String getJson(Model model);

	void collectReferences(EObject eo, EReference reference, Document doc);

}
