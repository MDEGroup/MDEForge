package org.mdeforge.presentation.rest;

import java.util.List;

import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.MetricProvider;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.SimilarityService;
import org.mdeforge.business.ValidateService;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.business.model.wrapper.json.MetricList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.customProperties.HyperSchemaFactoryWrapper;

@Controller
@RestController
@RequestMapping("/api/Model")
public class ModelRESTController {

	@Autowired
	private ModelService modelService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ArtifactService artifactService;
	@Autowired
	private User user;
	
	
//	@Autowired
//	private ValidateService validateService;
	


	@RequestMapping(value = "/similarity/{id_MM1}/{id_MM2}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<String> getSimilarity(
			@PathVariable("id_MM1") String id_MM1,
			@PathVariable("id_MM2") String id_MM2) {
		
		Model mm1 = (Model) modelService.findOne(id_MM1);
		Model mm2 = (Model) modelService.findOne(id_MM2);
		SimilarityService si = (SimilarityService) modelService;
		si.calculateSimilarity(mm1, mm2);
		return null;
	}
	
	@RequestMapping(value = "/validate/{id_MM1}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<String> isValid(
			@PathVariable("id_MM1") String id_MM1) {
		
		ValidateService va = (ValidateService)modelService;
		Model mm1 = (Model) modelService.findOne(id_MM1);
		boolean v = va.isValid(mm1);
		//boolean v = validationService.isValid(null);
		return new ResponseEntity<String>(((v)?"Is valid":"Not valid"), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id_model}/metrics", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<MetricList> getMetrics(@PathVariable("id_model") String idModel)
	{
		Model emm = (Model) modelService.findOne(idModel);
		MetricProvider mp = (MetricProvider) modelService;
		List<Metric> lm = mp.calculateMetrics(emm);
		return new ResponseEntity<MetricList>(new MetricList(lm), HttpStatus.OK);
	}
	// Get specified metamodel
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getModels() {
		ArtifactList result = new ArtifactList(modelService.findAllWithPublic(user));
		return new ResponseEntity<ArtifactList>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/schema", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<JsonSchema> getJsonSchema() {
		try {
			
			ObjectMapper MAPPER = new ObjectMapper();
			HyperSchemaFactoryWrapper visitor = new HyperSchemaFactoryWrapper();
	        MAPPER.acceptJsonFormatVisitor(MAPPER.constructType(Model.class), visitor);
	        JsonSchema jsonSchema = visitor.finalSchema();
	        try {
				MAPPER.writeValueAsString(jsonSchema);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<JsonSchema>(jsonSchema, HttpStatus.OK);
		} catch (JsonMappingException e) {
			return new ResponseEntity<JsonSchema>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getPublicModels() {
		ArtifactList list = new ArtifactList(modelService.findAllPublic());
		return new ResponseEntity<ArtifactList>(list, HttpStatus.OK);
	}

	// get shared metamodel
	@RequestMapping(value = "/shared", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getModelsByUser() {
		ArtifactList list = new ArtifactList(modelService.findAllModelsByUserId(user));
		return new ResponseEntity<ArtifactList>(new ArtifactList(list), HttpStatus.OK);
	}

	// Create metamodel
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HttpEntity<Model> createArtifact(@RequestBody Model model) {
		try {
			// SetAuthor
			model.setAuthor(user);
			// add author to shared
			// metamodel create
			Model s = (Model) modelService.create(model);
			// Response success
			return new ResponseEntity<Model>(s, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Model>( HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	// update metamodel
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody HttpEntity<String> updateArtifact(@RequestBody Model model) {
		try {
			// SetAuthor
			model.setAuthor(user);
			// add author to shared
			model.getShared().add(user);
			// metamodel save
			modelService.update(model);
			return new ResponseEntity<String>("Model updated.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erron: metamodel not updated", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	// get single metamodel
	@RequestMapping(value = "/{id_model}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<Model> getModel(@PathVariable("id_model") String idModel) {
		try {
			Model model = (Model) modelService.findOneForUser(idModel, user);
			return new ResponseEntity<Model>(model, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Model>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/{id_model}", method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<String> deleteModel(@PathVariable("id_model") String idModel) {
		try {
			modelService.delete(idModel, user);
			return new ResponseEntity<String>("Model deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Model not deleted", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
