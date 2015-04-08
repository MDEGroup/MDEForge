package org.mdeforge.presentation.rest;

import java.util.List;

import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.EcoreMetamodelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/artifact")
public class ArtifactRESTController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	@Qualifier("Artifact")
	private ArtifactService artifactService;

	@Autowired
	private User user;

	// Get specified artifact
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody HttpEntity<List<Artifact>> getArtifacts() {
		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		// String name = auth.getName(); //get logged in username
		// User user = userService.findOneByUsername(name);

		List<Artifact> result = artifactService.findAllWithPublicByUser(user);
		return new ResponseEntity<List<Artifact>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/schema", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<JsonSchema> getJsonSchema() {
		try {
			
			ObjectMapper MAPPER = new ObjectMapper();
			HyperSchemaFactoryWrapper visitor = new HyperSchemaFactoryWrapper();
	        MAPPER.acceptJsonFormatVisitor(MAPPER.constructType(Artifact.class), visitor);
	        JsonSchema jsonSchema = visitor.finalSchema();
	        try {
				MAPPER.writeValueAsString(jsonSchema);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			return new ResponseEntity<JsonSchema>(jsonSchema, HttpStatus.OK);
		} catch (JsonMappingException e) {
			return new ResponseEntity<JsonSchema>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/public", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<List<Artifact>> getPublicArtifacts() {
		List<Artifact> list = artifactService.findAllPublic();
		return new ResponseEntity<List<Artifact>>(list, HttpStatus.OK);

	}

	// get shared artifact
	@RequestMapping(value = "/shared", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<List<Artifact>> getArtifactsByUser() {
		List<Artifact> list = artifactService.findAllWithPublicByUser(user);
		return new ResponseEntity<List<Artifact>>(list, HttpStatus.OK);

	}

	// get single artifact
	@RequestMapping(value = "/{id_artifact}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<Artifact> getArtifact(@PathVariable("id_artifact") String idArtifact) {
		try {
			Artifact artifact = artifactService.findOneById(idArtifact, user);
			return new ResponseEntity<Artifact>(artifact, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Artifact>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}



}
