package org.mdeforge.business;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.form.Statistic;

import anatlyzer.atlext.OCL.OclExpression;

public interface EcoreMetamodelService extends CRUDArtifactService<EcoreMetamodel>,
		MetricProvider, SimilarityService, ValidateService, ClusterService {
	
	List<EcoreMetamodel> findEcoreMetamodelByURI(String URI);
	//ResponseGrid<EcoreMetamodel> findAllEcorePaginated(RequestGrid requestGrid)  throws BusinessException;
	List<String> getNSUris(EcoreMetamodel ecoreMetamodel)throws BusinessException;
	
	List<EcoreMetamodel> searchByExample(EcoreMetamodel searchSample) throws BusinessException;
	List<EcoreMetamodel> searchByExample(EcoreMetamodel searchSample, double score) throws BusinessException;
	double calculateContainment(EcoreMetamodel art1, EcoreMetamodel art2);
	
	Resource loadArtifact(EcoreMetamodel id);
	@Deprecated
	void registerMetamodel(String ecoreMetamodel) throws BusinessException;
	@Deprecated
	void registerMetamodel (EcoreMetamodel ecoreMetamodel) throws BusinessException;
	String serializeContent(EcoreMetamodel emm) throws BusinessException;
	
	List<EPackage> getEPackageList(EcoreMetamodel ecoreMetamodel)
			throws BusinessException;
	
	
	boolean checkConstraint(EPackage atlModel, List<OclExpression> expr) throws BusinessException;
	boolean checkConstraint(EPackage atlModel, OclExpression expr) throws BusinessException;
	
	String getJsonFormatFromResource(Resource metamodel)
			throws BusinessException;
	String getMetamodelInJsonFormat(EcoreMetamodel id) throws BusinessException;
	void extractedContent(EcoreMetamodel art) throws BusinessException;
	List<Statistic> numberOfMCdistribution();
}
