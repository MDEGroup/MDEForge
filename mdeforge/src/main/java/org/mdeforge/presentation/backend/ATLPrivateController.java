package org.mdeforge.presentation.backend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
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
@RequestMapping("/private/ATLTransformation")
public class ATLPrivateController {

	@Autowired
	private ATLTransformationService aTLTransformationService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private User user;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private UserService userService;

	
	@RequestMapping(value = "/list", method=RequestMethod.GET, 
            produces= MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<ATLTransformation> getEcoreMetamodel () {
		List<ATLTransformation> list = aTLTransformationService.findAllWithPublicByUser(user);
		return list;
	}
	

	@RequestMapping(value = "/use/execute_transformation", method = { RequestMethod.GET })
	public String transformationDetails(Model model, @RequestParam String transformation_id) {
		
		//TODO ancora da implementare!

		ATLTransformation atlTransformation = aTLTransformationService.findOne(transformation_id);
		
		model.addAttribute("atlTransformation", atlTransformation);
		String pathToDownload = gridFileMediaService.getFilePath(atlTransformation);
		File atlTransformationFile = new File(pathToDownload);
		List<org.mdeforge.business.model.Model> models = modelService.findByTransformation(atlTransformation);
		model.addAttribute("atlTransformationFile", atlTransformationFile);
		model.addAttribute("models", models);
		return "private.use.transformation_execution";
	}
	@RequestMapping(value = "/use/result_transformation", method = { RequestMethod.POST })
	public String transformationResult(Model model, @RequestParam String transformation_id, @RequestParam List<String> models_in) {
		List<org.mdeforge.business.model.Model> models = new ArrayList<org.mdeforge.business.model.Model>();
		for (String modelId : models_in) {
			models.add(modelService.findOne(modelId));
		}
		ATLTransformation atl = aTLTransformationService.findOne(transformation_id);
		List<org.mdeforge.business.model.Model> result = aTLTransformationService.execute(atl, models, user);
		model.addAttribute("models", result );
		return "private.use.result_transformation";
	}
	
	

	
}
