package org.mdeforge.presentation.backend;

import java.io.File;
import java.util.List;

import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/private/Model")
public class ModelController {
	
	@Autowired
	private ModelService modelService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private User user;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Model> getEcoreMetamodel () {
		List<org.mdeforge.business.model.Model> list = modelService.findAllWithPublicByUser(user);
		return list;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
	public String ecoreMetamodel(org.springframework.ui.Model model, @RequestParam String id) {
		
		Model ecoreMM = modelService.findOneById(id, user);		
		
		model.addAttribute("ecoreMM", ecoreMM);
		return "ecore_metamodel.details";
	}
	@RequestMapping(value = "/model_details", method = { RequestMethod.GET })
	public String modelDetails(org.springframework.ui.Model model, @RequestParam String model_id) {

		Model modelEMF = modelService.findOneById(model_id, user);
		model.addAttribute("model", modelEMF);
		
		String pathToDownload = gridFileMediaService.getFilePath(modelEMF);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("modelFile", ecoreMetamodelFile);

		return "private.use.model_details";
	}
	
	

}
