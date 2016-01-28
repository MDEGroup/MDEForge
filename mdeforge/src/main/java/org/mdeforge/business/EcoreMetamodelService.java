package org.mdeforge.business;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.OCL;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.helper.OCLHelper;
import org.mdeforge.business.model.EcoreMetamodel;

import anatlyzer.atl.util.ATLSerializer;
import anatlyzer.atlext.ATL.ATLPackage;
import anatlyzer.atlext.OCL.OclExpression;

public interface EcoreMetamodelService extends CRUDArtifactService<EcoreMetamodel>,
		MetricProvider, SimilarityService, ValidateService, ClusterService {
	
	List<EcoreMetamodel> findEcoreMetamodelByURI(String URI);
	ResponseGrid<EcoreMetamodel> findAllEcorePaginated(RequestGrid requestGrid)  throws BusinessException;
	void registerMetamodel (EcoreMetamodel ecoreMetamodel) throws BusinessException;
	String serializeContent(EcoreMetamodel emm) throws BusinessException;
	List<String> getNSUris(EcoreMetamodel ecoreMetamodel)
			throws BusinessException;
	List<EcoreMetamodel> searchByExample(EcoreMetamodel searchSample) throws BusinessException;
	void registerMetamodel(String ecoreMetamodel) throws BusinessException;
	List<EcoreMetamodel> searchByExample(EcoreMetamodel searchSample,
			double score) throws BusinessException;
	double calculateContainment(EcoreMetamodel art1, EcoreMetamodel art2);
	Resource loadArtifact(EcoreMetamodel id);
	List<EPackage> getEPackageList(EcoreMetamodel ecoreMetamodel)
			throws BusinessException;
	boolean checkConstraint(EPackage atlModel, List<OclExpression> expr) throws BusinessException;
	boolean checkConstraint(EPackage atlModel, OclExpression expr) throws BusinessException;
	String getJsonFormatFromResource(Resource metamodel)
			throws BusinessException;
	String getMetamodelInJsonFormat(EcoreMetamodel id) throws BusinessException;
}
