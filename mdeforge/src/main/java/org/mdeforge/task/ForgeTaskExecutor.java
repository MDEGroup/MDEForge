package org.mdeforge.task;

import java.util.Iterator;
import java.util.List;

import org.mdeforge.business.ATLTransformationCompilationError;
import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.ToBeAnalyse;
import org.mdeforge.integration.ToBeAnalyseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import transML.exceptions.transException;

public class ForgeTaskExecutor {
	
	@Autowired
	ATLTransformationService atlTransformationService;
	@Autowired
	ToBeAnalyseRepository toBeAnalyseRepository;
	public void analyseATLTransformation(){
		List<ToBeAnalyse> toAnalyse = toBeAnalyseRepository.findAll(); 
		Iterator<ToBeAnalyse> iterator = toAnalyse.iterator(); 
		while(iterator.hasNext()) {
			
			ToBeAnalyse toBeAnalyse = iterator.next();
			System.out.println(toBeAnalyse);
			if (toBeAnalyse.getArtifact() instanceof ATLTransformation){
				
				try {
					atlTransformationService.anATLyzer((ATLTransformation) toBeAnalyse.getArtifact());
					atlTransformationService.testServices((ATLTransformation)toBeAnalyse.getArtifact());
				} catch (ATLTransformationCompilationError e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (transException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e ) {
					e.printStackTrace();
				}
				finally {
					toBeAnalyseRepository.delete(toBeAnalyse);
				}
			}
			if (toBeAnalyse.getArtifact() instanceof Model){
				System.out.println(toBeAnalyse);
				toBeAnalyseRepository.delete(toBeAnalyse);
			}
				
		}
		
	}
}
