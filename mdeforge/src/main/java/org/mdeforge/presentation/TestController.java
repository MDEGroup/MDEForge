package org.mdeforge.presentation;


import org.mdeforge.business.EcoreMetamodelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private EcoreMetamodelService ecoreMetamodelService;
	
	
	
	
	
	
	@RequestMapping(value = "/cluster", method = { RequestMethod.GET })
	public String cluster(org.springframework.ui.Model model, @RequestParam Double threshold ) {
		
		
		String graph = ecoreMetamodelService.getSimilarityGraph(threshold);
		
		model.addAttribute("graph", graph);
		
		return "test.cluster";
	}

}
