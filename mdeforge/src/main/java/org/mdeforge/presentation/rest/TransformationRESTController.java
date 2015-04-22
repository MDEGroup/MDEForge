package org.mdeforge.presentation.rest;

import java.util.List;

import org.mdeforge.business.ProjectService;
import org.mdeforge.business.TransformationService;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

;

@Controller
@RequestMapping("/api/transformation")
public class TransformationRESTController {

	@Autowired
	private TransformationService transformationService;
	@Autowired
	private ProjectService projectService;

	@Autowired
	private User user;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getTransformations() {
		//http://localhost:8080/mdeforge/api/metamodel/?access_token=40846e42-fc43-46df-ad09-982d466b8955
		List<Transformation> result = transformationService
				.findAllWithPublicByUser(user);
		return new ResponseEntity<ArtifactList>(new ArtifactList(result), HttpStatus.OK);
	}

//	@RequestMapping(value = "/{id_transformation}", method = RequestMethod.GET)
//	public @ResponseBody HttpEntity<Transformation> getMetamodel(@PathVariable("id_transformation") String idtransformation) {
//		try {
//			Transformation metamodel = transformationService.findOneBySharedUser(idtransformation, user);
//			return new ResponseEntity<Transformation>(metamodel, HttpStatus.OK);
//		} catch (BusinessException e) {
//			return new ResponseEntity<Transformation>(HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//
//	}
//	
//	@RequestMapping(value = "/public", method = RequestMethod.GET, produces = "application/json")
//	public @ResponseBody HttpEntity<ArtifactList> getPublicTransformations() {
//		ArtifactList list = transformationService.findAllPublic();
//		return new ResponseEntity<ArtifactList>(list, HttpStatus.OK);
//		
//
//	}
//
//	@RequestMapping(value = "/schema", method = RequestMethod.GET)
//	public @ResponseBody HttpEntity<JsonSchema> getJsonSchema() {
//		ObjectMapper MAPPER = new ObjectMapper();
//		JsonSchemaGenerator generator = new JsonSchemaGenerator(MAPPER);
//        try {
//			JsonSchema jsonSchema = generator.generateSchema(Transformation.class);
//			return new ResponseEntity<JsonSchema>(jsonSchema, HttpStatus.OK);
//		} catch (JsonMappingException e) {
//			return new ResponseEntity<JsonSchema>(HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
//
//	@RequestMapping(value = "/shared", method = RequestMethod.GET)
//	public @ResponseBody HttpEntity<ArtifactList> getTransformationsByUser() {
//		ArtifactList list = transformationService
//				.findAllTransformationsByUserId(user.getId());
//		return new ResponseEntity<ArtifactList>(list, HttpStatus.OK);
//
//	}
//
//	@RequestMapping(value = "OLD/workspace/{id_workspace}", method = RequestMethod.POST)
//	public @ResponseBody HttpEntity<String> createArtifactInWorkspace(
//			@ModelAttribute Transformation transformation,
//			@PathVariable("id_workspace") String idWorkspace,
//			@RequestParam("_file") MultipartFile file) {
//		try {
//			transformation.setWorkspaces(new ArrayList<Workspace>());
//			Workspace workspace = new Workspace();
//			workspace.setId(idWorkspace);
//			transformation.getWorkspaces().add(workspace);
//			transformation.setAuthor(user);
//			transformation.getShared().add(user);
//
//			GridFileMedia fileMedia = new GridFileMedia();
//			fileMedia.setFileName(file.getName());
//			fileMedia.setByteArray(file.getBytes());
//			transformation.setFile(fileMedia);
//
//			transformationService.create(transformation);
//			return new ResponseEntity<String>("Transformation inserted.",
//					HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("Erron: Project not inserted.",
//					HttpStatus.OK);
//		}
//	}
//
//	@RequestMapping(value = "OLD/project/{id_project}", method = RequestMethod.POST)
//	public @ResponseBody HttpEntity<String> createArtifactInPoject(
//			@ModelAttribute Transformation transformation,
//			@PathVariable("id_project") String idProject,
//			@RequestParam("_file") MultipartFile file) {
//		try {
//			transformation.setWorkspaces(new ArrayList<Workspace>());
//			Project project = projectService.findById(idProject, user);
//			transformation.getProjects().add(project);
//			transformation.setAuthor(user);
//			transformation.getShared().add(user);
//
//			GridFileMedia fileMedia = new GridFileMedia();
//			fileMedia.setFileName(file.getName());
//			fileMedia.setByteArray(file.getBytes());
//			transformation.setFile(fileMedia);
//
//			transformationService.create(transformation);
//			return new ResponseEntity<String>("Transformation inserted.",
//					HttpStatus.OK);
//
//		} catch (Exception e) {
//			return new ResponseEntity<String>(
//					"Erron: Transformation not inserted.",
//					HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
//
//	// create transformation
//	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
//	public @ResponseBody HttpEntity<String> createArtifact(
//			@RequestBody Transformation transformation) {
//		try {
//			// SetAuthor
//			transformation.setAuthor(user);
//
//			// transformation save
//			transformationService.create(transformation);
//			return new ResponseEntity<String>("Transformation inserted.",
//					HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(
//					"Erron: Transformation not inserted.",
//					HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
//
//	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
//	public @ResponseBody HttpEntity<String> updateArtifact(
//			@RequestBody Transformation transformation,
//			@PathVariable("id_user") String idUser) {
//		try {
//			// GetUser
//			// SetAuthor
//			transformation.setAuthor(user);
//			// add author to shared
//			transformation.getShared().add(user);
//			// transformation update
//			transformationService.update(transformation);
//			return new ResponseEntity<String>("Transformation updated.",
//					HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(
//					"Erron: transformation not updated",
//					HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
//
//	@RequestMapping(value = "/{id_transformation}", method = RequestMethod.DELETE)
//	public @ResponseBody HttpEntity<String> deleteTranformation(
//			@PathVariable("id_metamodel") String idTranformation) {
//		try {
//			transformationService.deleteTransformation(idTranformation, user);
//			return new ResponseEntity<String>("Transformation deleted",
//					HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("Transformation deleted",
//					HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
}
