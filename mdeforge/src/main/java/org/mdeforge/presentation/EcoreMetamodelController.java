package org.mdeforge.presentation;

import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/private/EcoreMetamodel")
public class EcoreMetamodelController {
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	
	@Autowired
	private User user;
	
	
	@RequestMapping(method = { RequestMethod.GET })
	public String clusterGraph(Model model, @RequestParam String id) {
		
		EcoreMetamodel ecoreMM = ecoreMetamodelService.findOneById(id, user, EcoreMetamodel.class);		
		
		model.addAttribute("ecoreMM", ecoreMM);
		return "ecore_metamodel.details";
	}
	
	
	

}
