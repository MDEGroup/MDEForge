package org.mdeforge.presentation.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public/Model")
public class ModelPublicController extends ArtifactPublicController<org.mdeforge.business.model.Model> {
	public String details(org.springframework.ui.Model model, @RequestParam String artifact_id) {
		super.details(model, artifact_id);
		return "public.browse.model_details";
	}
	
	@Override
	public String artifactList(Model model) {
		model.addAttribute("Title", "Model");
		model.addAttribute("type", org.mdeforge.business.model.Model.class.getSimpleName());
		return super.artifactList(model);
	}

}
