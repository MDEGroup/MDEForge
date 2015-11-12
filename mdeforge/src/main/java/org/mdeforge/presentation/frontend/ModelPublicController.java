package org.mdeforge.presentation.frontend;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mdeforge.business.GridFileMediaService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public")
public class ModelPublicController {
	@Autowired
	private ModelService modelService;
	@Autowired
	private GridFileMediaService gridFileMediaService;
	
	@RequestMapping(value = "/browse/model_download", method = RequestMethod.GET)
	public void downloadMetamodel(@RequestParam String model_id,
			HttpServletResponse response) throws IOException {

		Model model = modelService.findOne(model_id);
		InputStream is = gridFileMediaService.getFileInputStream(model);

		response.setContentType("application/force-download");
		response.setHeader("Content-Disposition", "attachment; filename=" + model.getName());
		// copy it to response's OutputStream
		org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
		response.flushBuffer();
	}
	
	@RequestMapping(value = "/browse/model_details", method = { RequestMethod.GET })
	public String metamodelDetails(org.springframework.ui.Model model, @RequestParam String model_id) {

		Model modelEMF = modelService.findOnePublic(model_id);
		model.addAttribute("model", modelEMF);
		String pathToDownload = gridFileMediaService.getFilePath(modelEMF);
		File modelFile = new File(pathToDownload);
		model.addAttribute("ecoreMetamodelFile", modelFile);

		return "public.browse.model_details";
	}
	
	@RequestMapping(value = "/browse/models_list", method = { RequestMethod.GET })
	public String metamodelsList(org.springframework.ui.Model model) {

		List<Model> ecoreMetamodelsList = modelService.findAllPublic();
		model.addAttribute("ecoreMetamodelsList", ecoreMetamodelsList);

		return "public.browse.models_list";
	}
}
