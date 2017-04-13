package org.mdeforge.business;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.ToBeAnalyse;
import org.mdeforge.business.model.form.Statistic;

import anatlyzer.atlext.OCL.OclExpression;

public interface EcoreMetamodelService extends CRUDArtifactService<EcoreMetamodel>,
		MetricProvider, SimilarityService, ValidateService, ClusterService {
	
	List<EcoreMetamodel> findByURI(String URI);
	List<String> getNSUris(EcoreMetamodel ecoreMetamodel)throws BusinessException;
	
	List<EcoreMetamodel> searchByExample(EcoreMetamodel searchSample) throws BusinessException;
	List<EcoreMetamodel> searchByExample(EcoreMetamodel searchSample, double score) throws BusinessException;
	double calculateContainment(EcoreMetamodel art1, EcoreMetamodel art2);
	
	void registerMetamodel(String ecoreMetamodel) throws BusinessException;
	Resource registerMetamodel (EcoreMetamodel ecoreMetamodel) throws BusinessException;
	
	List<EPackage> getEPackageList(EcoreMetamodel ecoreMetamodel)
			throws BusinessException;
	boolean checkConstraint(EPackage atlModel, List<OclExpression> expr) throws BusinessException;
	boolean checkConstraint(EPackage atlModel, OclExpression expr) throws BusinessException;
	
	String getJsonFormatFromResource(Resource metamodel)
			throws BusinessException;
	String getJson(EcoreMetamodel id) throws BusinessException;
	List<Statistic> numberOfMCdistribution();
	void calculateSimilarities(ToBeAnalyse toBeAnalyse) throws BusinessException;
}
