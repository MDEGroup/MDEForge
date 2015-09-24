package org.mdeforge.presentation.backend;

import java.io.File;
import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/private/EcoreMetamodel")
public class EcoreMetamodelController {
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private User user;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<EcoreMetamodel> getEcoreMetamodel () {
		List<EcoreMetamodel> list = ecoreMetamodelService.findAllWithPublicByUser(user);
		return list;
	}
	
	@RequestMapping(method = { RequestMethod.GET })
	public String ecoreMetamodel(Model model, @RequestParam String id) {
		
		EcoreMetamodel ecoreMM = ecoreMetamodelService.findOneById(id, user);		
		
		model.addAttribute("ecoreMM", ecoreMM);
		return "ecore_metamodel.details";
	}
	@RequestMapping(value = "/metamodel_details", method = { RequestMethod.GET })
	public String metamodelDetails(Model model, @RequestParam String metamodel_id) {

		EcoreMetamodel ecoreMetamodel = ecoreMetamodelService.findOnePublic(metamodel_id);
		model.addAttribute("ecoreMetamodel", ecoreMetamodel);
		String pathToDownload = gridFileMediaService.getFilePath(ecoreMetamodel);
		File ecoreMetamodelFile = new File(pathToDownload);
		model.addAttribute("ecoreMetamodelFile", ecoreMetamodelFile);

		return "private.use.metamodel_details";
	}
	
	

}
