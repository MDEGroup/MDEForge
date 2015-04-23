package org.mdeforge.presentation.frontend;

import java.util.List;

import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/public")
public class PublicController {
	

	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;

	
	
	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {			
		return "public.index";
	}
	
	
	
	
	
	@RequestMapping(value = "/browse/dashboard", method = { RequestMethod.GET })
	public String dashboard() {			
		return "public.browse.dashboard";
	}
	
	@RequestMapping(value = "/browse/metamodels_list", method = { RequestMethod.GET })
	public String metamodelsList(Model model) {					
		
		List<EcoreMetamodel> ecoreMetamodelsList = ecoreMetamodelService.findAll();		
		model.addAttribute("ecoreMetamodelsList", ecoreMetamodelsList);
		
		return "public.browse.metamodels_list";
	}
	
	@RequestMapping(value = "/browse/cluster", method = { RequestMethod.GET })
	public String browsePage() {					
		return "public.browse.cluster";
	}
	
	

}
