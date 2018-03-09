package org.mdeforge.presentation.rest;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.ETLTransformationService;
import org.mdeforge.business.ModelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
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

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

;

@Controller
@RequestMapping("/api/ETLTransformation")
public class ETLTransformationRESTController {

	@Autowired
	private ETLTransformationService ETLTransformationService;
	@Autowired
	private ModelService modelService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	
	@Autowired
	private User user;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getTransformations() {
		//http://localhost:8080/mdeforge/api/metamodel/?access_token=40846e42-fc43-46df-ad09-982d466b8955
		List<ETLTransformation> result = ETLTransformationService
				.findAllWithPublicByUser(user);
		return new ResponseEntity<ArtifactList>(new ArtifactList(result), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id_transformation}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ETLTransformation> getETLTransformation(@PathVariable("id_transformation") String idtransformation) {
		try {
			ETLTransformation metamodel = ETLTransformationService.findOneById(idtransformation, user);
			return new ResponseEntity<ETLTransformation>(metamodel, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<ETLTransformation>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}
	
	@RequestMapping(value = "/public", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody HttpEntity<ArtifactList> getPublicTransformations() {
		List<ETLTransformation> list = ETLTransformationService.findAllPublic();
		return new ResponseEntity<ArtifactList>(new ArtifactList(list), HttpStatus.OK);
		

	}

	@RequestMapping(value = "/schema", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<JsonSchema> getJsonSchema() {
		ObjectMapper MAPPER = new ObjectMapper();
		JsonSchemaGenerator generator = new JsonSchemaGenerator(MAPPER);
        try {
			JsonSchema jsonSchema = generator.generateSchema(Transformation.class);
			return new ResponseEntity<JsonSchema>(jsonSchema, HttpStatus.OK);
		} catch (JsonMappingException e) {
			return new ResponseEntity<JsonSchema>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/shared", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getTransformationsByUser() {
		ArtifactList list = new ArtifactList(
				ETLTransformationService.findAll());
		return new ResponseEntity<ArtifactList>(new ArtifactList(list), HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/execute/{id_transformation}", consumes = "application/json")
	public @ResponseBody HttpEntity<String> executeTransformation (
			@PathVariable("id_transformation") String idETLTransformation,
			@RequestBody ArrayList<Model> models) {
		for (Model model : models) {
			model.setAuthor(user);
			model.setOpen(false);
			modelService.create(model);
			
		}
		ETLTransformation transformation =  ETLTransformationService.findOne(idETLTransformation);
		//TODO DANIELE
		//ADESSO E' UNA LISTA DI MODEL
		transformation.setModels_in(models);
		
		
		
		//ETLTransformationService.execute(transformation);
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	// create transformation
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HttpEntity<String> createArtifact(
			@RequestBody ETLTransformation transformation) {
		try {
			// SetAuthor
			transformation.setAuthor(user);

			// transformation save
			ETLTransformationService.create(transformation);
			return new ResponseEntity<String>("Transformation inserted.",
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(
					"Erron: Transformation not inserted.",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody HttpEntity<String> updateArtifact(
			@RequestBody ETLTransformation transformation,
			@PathVariable("id_user") String idUser) {
		try {
			// GetUser
			// SetAuthor
			transformation.setAuthor(user);
			// add author to shared
			transformation.getShared().add(user);
			// transformation update
			ETLTransformationService.update(transformation);
			return new ResponseEntity<String>("Transformation updated.",
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(
					"Erron: transformation not updated",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/{id_transformation}", method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<String> deleteTranformation(
			@PathVariable("id_metamodel") String idTranformation) {
		try {
			ETLTransformation art = ETLTransformationService.findOneById(idTranformation, user);
			ETLTransformationService.delete(art, user);
			return new ResponseEntity<String>("Transformation deleted",
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Transformation deleted",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
