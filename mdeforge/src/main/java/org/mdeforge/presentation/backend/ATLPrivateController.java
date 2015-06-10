package org.mdeforge.presentation.backend;

import java.io.File;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/private")
public class ATLPrivateController {

	@Autowired
	private ATLTransformationService aTLTransformationService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private UserService userService;

	

	@RequestMapping(value = "/use/execute_transformation", method = { RequestMethod.GET })
	public String transformationDetails(Model model, @RequestParam String transformation_id) {
		
		//TODO ancora da implementare!

		ATLTransformation atlTransformation = aTLTransformationService.findOne(transformation_id);
		
		model.addAttribute("atlTransformation", atlTransformation);
		
		String pathToDownload = gridFileMediaService.getFilePath(atlTransformation);
		File atlTransformationFile = new File(pathToDownload);
		model.addAttribute("atlTransformationFile", atlTransformationFile);

		return "private.use.transformation_execution";
	}
	
	

	
}
