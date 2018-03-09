package org.mdeforge.task;

import java.util.Iterator;
import java.util.List;

import org.mdeforge.business.ATLTransformationCompilationError;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.ToBeAnalyse;
import org.mdeforge.integration.ToBeAnalyseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import transML.exceptions.transException;

public class ForgeTaskExecutor {
	
	@Autowired
	ATLTransformationService atlTransformationService;
	@Autowired
	EcoreMetamodelService ecoreMetamodelService;
	Logger logger = LoggerFactory.getLogger(ForgeTaskExecutor.class);
	@Autowired
	ToBeAnalyseRepository toBeAnalyseRepository;
	public void analyseATLTransformation(){
		List<ToBeAnalyse> toAnalyse = toBeAnalyseRepository.findAll(); 
		Iterator<ToBeAnalyse> iterator = toAnalyse.iterator(); 
		while(iterator.hasNext()) {
			ToBeAnalyse toBeAnalyse = iterator.next();
			logger.info(toBeAnalyse.toString());
			if (toBeAnalyse.getArtifact() instanceof ATLTransformation){
				try {
					atlTransformationService.anATLyzer((ATLTransformation) toBeAnalyse.getArtifact());
					atlTransformationService.testServices((ATLTransformation)toBeAnalyse.getArtifact());
				} catch (ATLTransformationCompilationError e) {
					logger.error(e.getMessage());
				} catch (transException e) {
					logger.error(e.getMessage());
				} catch (Exception e ) {
					logger.error(e.getMessage());
				}
			}
			if (toBeAnalyse.getArtifact() instanceof EcoreMetamodel){
				try{ ecoreMetamodelService.calculateSimilarities(toBeAnalyse);} catch(Exception e) {}
			}
			toBeAnalyseRepository.delete(toBeAnalyse);
		}		
	}
}
