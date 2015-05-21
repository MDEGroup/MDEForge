package org.mdeforge.presentation.rest;

import org.mdeforge.business.ModelService;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/model")
public class ModelsRESTController {

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private User user;

	// Create model
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HttpEntity<Model> createArtifact(@RequestBody Model model) {
		try {
			// SetAuthor
			model.setAuthor(user);
			// add author to shared
			// model create
			modelService.create(model);
			// Response success
			return new ResponseEntity<Model>(model, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Model>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
