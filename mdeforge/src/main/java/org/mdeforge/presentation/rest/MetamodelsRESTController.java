package org.mdeforge.presentation.rest;

import java.util.ArrayList;

import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.customProperties.HyperSchemaFactoryWrapper;

@Controller
@RestController
@RequestMapping("/api/metamodel")
public class MetamodelsRESTController {

	@Autowired
	private MetamodelService metamodelService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ArtifactService artifactService;

	@Autowired
	private User user;

	// Get specified metamodel
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getMetamodels() {
		// Authentication auth =
		// SecurityContextHolder.getContext().getAuthentication();
		// String name = auth.getName(); //get logged in username
		// User user = userService.findOneByUsername(name);

		ArtifactList result = metamodelService.findAllWithPublic(user);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/schema", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<JsonSchema> getJsonSchema() {
		try {
			
			ObjectMapper MAPPER = new ObjectMapper();
			HyperSchemaFactoryWrapper visitor = new HyperSchemaFactoryWrapper();
	        MAPPER.acceptJsonFormatVisitor(MAPPER.constructType(Metamodel.class), visitor);
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
	public @ResponseBody HttpEntity<ArtifactList> getPublicMetamodels() {
		ArtifactList list = metamodelService.findAllPublic();
		return new ResponseEntity<ArtifactList>(list, HttpStatus.OK);
	}

	// get shared metamodel
	@RequestMapping(value = "/shared", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getMetamodelsByUser() {
		ArtifactList list = metamodelService.findAllMetamodelsByUserId(user);
		return new ResponseEntity<ArtifactList>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "OLD/workspace/{id_workspace}", method = RequestMethod.POST)
	public @ResponseBody HttpEntity<String> createArtifactInWorkspace(@ModelAttribute Metamodel metamodel, @PathVariable("id_workspace") String idWorkspace, @RequestParam("_file") MultipartFile file) {
		try {

			metamodel.setWorkspaces(new ArrayList<Workspace>());
			Workspace workspace = new Workspace();
			workspace.setId(idWorkspace);
			metamodel.getWorkspaces().add(workspace);
			metamodel.setAuthor(user);
			metamodel.getShared().add(user);

			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName(file.getName());
			fileMedia.setByteArray(file.getBytes());
			metamodel.setFile(fileMedia);
			metamodelService.create(metamodel);
			return new ResponseEntity<String>("Metamodel inserted.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erron: Project not inserted.", HttpStatus.OK);
		}
	}

	@RequestMapping(value = "OLD/project/{id_project}", method = RequestMethod.POST)
	public @ResponseBody HttpEntity<String> createArtifactInPoject(@ModelAttribute Metamodel metamodel, @PathVariable("id_project") String idProject, @RequestParam("_file") MultipartFile file) {
		try {

			metamodel.setWorkspaces(new ArrayList<Workspace>());
			Project project = projectService.findById(idProject, user);
			metamodel.getProjects().add(project);
			metamodel.setAuthor(user);
			metamodel.getShared().add(user);

			GridFileMedia fileMedia = new GridFileMedia();
			fileMedia.setFileName(file.getName());
			fileMedia.setByteArray(file.getBytes());
			metamodel.setFile(fileMedia);

			metamodelService.create(metamodel);
			return new ResponseEntity<String>("Metamodel inserted.", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Erron: Metamodel not inserted.", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	// Create metamodel
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HttpEntity<String> createArtifact(@RequestBody Metamodel metamodel) {
		try {
			// SetAuthor
			metamodel.setAuthor(user);
			// add author to shared
			// metamodel create
			metamodelService.create(metamodel);
			// Response success
			return new ResponseEntity<String>("Metamodel inserted.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erron: Metamodel not inserted.", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	// update metamodel
	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody HttpEntity<String> updateArtifact(@RequestBody Metamodel metamodel) {
		try {
			// SetAuthor
			metamodel.setAuthor(user);
			// add author to shared
			metamodel.getShared().add(user);
			// metamodel save
			metamodelService.update(metamodel);
			return new ResponseEntity<String>("Metamodel updated.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erron: metamodel not updated", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	// get single metamodel
	@RequestMapping(value = "/{id_metamodel}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<Metamodel> getMetamodel(@PathVariable("id_metamodel") String idMetamodel) {
		try {
			Metamodel metamodel = metamodelService.findOneBySharedUser(idMetamodel, user);
			return new ResponseEntity<Metamodel>(metamodel, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Metamodel>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/{id_metamodel}", method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<String> deleteMetamodel(@PathVariable("id_metamodel") String idMetamodel) {
		try {
			metamodelService.deleteMetamodel(idMetamodel, user);
			return new ResponseEntity<String>("Metamodel deleted", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Metamodel not deleted", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
