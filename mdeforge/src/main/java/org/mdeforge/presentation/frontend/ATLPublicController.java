package org.mdeforge.presentation.frontend;

import java.util.List;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/public")
public class ATLPublicController {
	
	


	@Autowired
	private ATLTransformationService aTLTransformationService;
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/browse/transformations_list", method = { RequestMethod.GET })
	public String transformationsList(Model model) {

		List<ATLTransformation> transformationsList = aTLTransformationService.findAll();
		model.addAttribute("transformationsList", transformationsList);

		return "public.browse.transformations_list";
	}
	
}
