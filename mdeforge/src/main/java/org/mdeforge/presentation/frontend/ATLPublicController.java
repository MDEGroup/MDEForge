package org.mdeforge.presentation.frontend;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mdeforge.business.ATLTransformationService;
import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.UserService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class ATLPublicController {

	@Autowired
	private ATLTransformationService aTLTransformationService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	
	@RequestMapping(value = "/browse/transformations_list", method = { RequestMethod.GET })
	public String transformationsList(Model model) {

		List<ATLTransformation> transformationsList = aTLTransformationService.findAll();
		model.addAttribute("transformationsList", transformationsList);

		return "public.browse.transformations_list";
	}
	
	
	@RequestMapping(value = "/browse/transformation_details", method = { RequestMethod.GET })
	public String transformationDetails(Model model, @RequestParam String transformation_id) {

		ATLTransformation atlTransformation = aTLTransformationService.findOnePublic(transformation_id);
		
		model.addAttribute("atlTransformation", atlTransformation);
		
		String pathToDownload = gridFileMediaService.getFilePath(atlTransformation);
		File atlTransformationFile = new File(pathToDownload);
		model.addAttribute("atlTransformationFile", atlTransformationFile);

		return "public.browse.transformation_details";
	}
	@RequestMapping(value = "/browse/transformation_share", method = { RequestMethod.GET })
	public String transformationSharaDetails(Model model, @RequestParam String transformation_id) {
		
		ATLTransformation atlTransformation = aTLTransformationService.findOnePublic(transformation_id);
		aTLTransformationService.addUserInArtifact(user.getId(), transformation_id, user);
		model.addAttribute("atlTransformation", atlTransformation);
		
		String pathToDownload = gridFileMediaService.getFilePath(atlTransformation);
		File atlTransformationFile = new File(pathToDownload);
		model.addAttribute("atlTransformationFile", atlTransformationFile);
		
		return "private.use.metamodel_details";
	}
	
	@RequestMapping(value = "/browse/transformation_download", method = RequestMethod.GET)
	public void downloadMetamodel(@RequestParam String transformation_id,
			HttpServletResponse response) throws IOException {

		ATLTransformation atlMetamodel = aTLTransformationService.findOne(transformation_id);
		InputStream is = gridFileMediaService.getFileInputStream(atlMetamodel);

		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename=" + atlMetamodel.getName());
		// copy it to response's OutputStream
		org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}

	
}
