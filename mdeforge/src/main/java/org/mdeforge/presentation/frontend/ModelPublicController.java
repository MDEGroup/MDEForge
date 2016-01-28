package org.mdeforge.presentation.frontend;

import org.mdeforge.business.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/public/Model")
public class ModelPublicController extends ArtifactPublicController<Model> {
	public String details(org.springframework.ui.Model model, @RequestParam String artifact_id) {
		super.details(model, artifact_id);
		return "public.browse.model_details";
	}

}
