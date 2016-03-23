package org.mdeforge.presentation.frontend;

import org.mdeforge.business.model.ATLTransformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public/ATLTransformation")
public class ATLPublicController extends ArtifactPublicController<ATLTransformation>{

	@Override
	public String artifactList(Model model) {
		model.addAttribute("Title", "ATL Transformations");
		return super.artifactList(model);
	}
	@Override
	public String details(Model model, @RequestParam String artifact_id) {
		super.details(model, artifact_id);
		return "public.browse.transformation_details";
	}
}
