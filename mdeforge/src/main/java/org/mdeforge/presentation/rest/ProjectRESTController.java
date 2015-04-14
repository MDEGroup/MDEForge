package org.mdeforge.presentation.rest;

import java.util.List;

import org.mdeforge.business.ArtifactService;
import org.mdeforge.business.BusinessException;
import org.mdeforge.business.MetamodelService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.TransformationService;
import org.mdeforge.business.WorkspaceService;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

@Controller
@RestController
@RequestMapping("/api/project")
public class ProjectRESTController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private WorkspaceService workspaceService;
	@Autowired
	private User user;
	@Autowired
	private MetamodelService metamodelService;
	@Autowired
	@Qualifier("Artifact")
	private ArtifactService artifactService;
	
	@Autowired
	private TransformationService transformationService;
	
	@RequestMapping(value = "/workspaces/{id_workspace}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<List<Project>> getProjectsByWorkspace(
			@PathVariable("id_workspace") String idWorkspace) {
		List<Project> list = projectService.findByIdWorkspace(idWorkspace, user);
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/schema", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<JsonSchema> getJsonSchema() {
		ObjectMapper MAPPER = new ObjectMapper();
		JsonSchemaGenerator generator = new JsonSchemaGenerator(MAPPER);
        try {
			JsonSchema jsonSchema = generator.generateSchema(Project.class);
			return new ResponseEntity<JsonSchema>(jsonSchema, HttpStatus.OK);
		} catch (JsonMappingException e) {
			return new ResponseEntity<JsonSchema>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@RequestMapping(value = "/shared", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<List<Project>> getProjectsByUsername() {
		List<Project> list = projectService.findByIdUser(user);
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<Project> getProject(@PathVariable("id") String id) {
		Project p = projectService.findById(id, user);
		return new ResponseEntity<Project>(p,HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}/Model/", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> findModelsInProject(
			@PathVariable("id") String idProject) {
		try {
			ArtifactList project = new ArtifactList(artifactService.findArtifactInProject(idProject, user, Model.class));
			
			return new ResponseEntity<ArtifactList>(project, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<ArtifactList>(
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	@RequestMapping(value = "/{id}/EcoreMetamodel/", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> findMetamodelsInProject(
			@PathVariable("id") String idProject) {
		try {
			ArtifactList project = new ArtifactList(artifactService.findArtifactInProject(idProject, user, EcoreMetamodel.class));
			
			return new ResponseEntity<ArtifactList>(project, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<ArtifactList>(
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	@RequestMapping(value = "/{id}/ATLTransformation/", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> findATLTransformationsInProject(
			@PathVariable("id") String idProject) {
		try {
			ArtifactList project = new ArtifactList(artifactService.findArtifactInProject(idProject, user, ATLTransformation.class));
			return new ResponseEntity<ArtifactList>(project, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<ArtifactList>(
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	@RequestMapping(value = "/{id}/ETLTransformation/", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> findETLTransformationsInProject(
			@PathVariable("id") String idProject) {
		try {
			ArtifactList project = new ArtifactList(artifactService.findArtifactInProject(idProject, user, ETLTransformation.class));
			return new ResponseEntity<ArtifactList>(project, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<ArtifactList>(
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	@RequestMapping(value = "/{id}/artifact/", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> findArtifactsInProject(
			@PathVariable("id") String idProject) {
		try {
			ArtifactList project = new ArtifactList(artifactService.findArtifactInProject(idProject, user, Artifact.class));
			return new ResponseEntity<ArtifactList>(project, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<ArtifactList>(
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	// dovrebbe sparire
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<List<Project>> getProjects() {
		List<Project> list = projectService.findAll();
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}

	@RequestMapping( method = RequestMethod.GET)
	public @ResponseBody HttpEntity<List<Project>> getProjectsByUser() {
		List<Project> list = projectService.findByIdUser(user);
		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody HttpEntity<String> create(
			@RequestBody Project project) {
		try {
			project.getUsers().add(user);
				projectService.create(project, user);
				return new ResponseEntity<String>("Project inserted.",
						HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erron: Project not inserted.",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, consumes="application/json")
	public @ResponseBody HttpEntity<String> update(
			@RequestBody Project project) {
		try {
			project.getUsers().add(user);
			projectService.update(project, user);
			return new ResponseEntity<String>("Project updated.",
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Erron: Project not updated.",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
