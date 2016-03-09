
package org.mdeforge.presentation;

import java.util.HashMap;
import java.util.Map;

import org.mdeforge.business.ArtifactNotFoundException;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.MetricEngineException;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;



@Controller
@ControllerAdvice

public class GlobalDefaultExceptionHandler {

	
//	@ExceptionHandler(BusinessException.class)
//	public ModelAndView handleCustomException(BusinessException ex) {
//
//		ModelAndView model = new ModelAndView("generic_error");
//		model.addObject("errCode", ex.getErrCode());
//		model.addObject("errMsg", ex.getErrMsg());
//
//		return model;
//
//	}
	
	@ExceptionHandler(MetricEngineException.class)
	public ModelAndView handleMetricEngineException(MetricEngineException ex) {
		ex.printStackTrace();
		Map<String,String> errorModel = new HashMap<String,String>();
		String errCode = ex.getErrCode();
		errorModel.put("errCode", errCode);
		String errMsg = ex.getErrMsg();
		errorModel.put("errMsg", errMsg);
		errorModel.put("artifatId", ex.getArtifatcId());
		return new ModelAndView("error.custom_generic_exception", "errorModel", errorModel);
	}
	
	@ExceptionHandler(ArtifactNotFoundException.class)
	public ModelAndView handleArtifactNotFoundException(BusinessException ex) {
		ex.printStackTrace();
		Map<String,String> errorModel = new HashMap<String,String>();
		String errCode = ex.getErrCode();
		errorModel.put("errCode", errCode);
		String errMsg = ex.getErrMsg();
		errorModel.put("errMsg", errMsg);
		
		return new ModelAndView("error.custom_generic_exception", "errorModel", errorModel);
	}
	
	@ExceptionHandler(BusinessException.class)
	public ModelAndView handleCustomException(BusinessException ex) {
		ex.printStackTrace();
		Map<String,String> errorModel = new HashMap<String,String>();
		String errCode = ex.getErrCode();
		errorModel.put("errCode", errCode);
		String errMsg = ex.getErrMsg();
		errorModel.put("errMsg", errMsg);
		
		return new ModelAndView("error.custom_generic_exception", "errorModel", errorModel);
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ex.printStackTrace();
		Map<String,String> errorModel = new HashMap<String,String>();
		String errMsg = "this is Exception.class";
		errorModel.put("errMsg", errMsg);
		
		return new ModelAndView("error.custom_generic_exception", "errorModel", errorModel);

	}
}
