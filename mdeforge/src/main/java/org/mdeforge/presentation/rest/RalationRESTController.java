package org.mdeforge.presentation.rest;

import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.CRUDRelationService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Relation;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class RalationRESTController {
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;
	@Autowired
	private CRUDRelationService<Relation> relationService;
	@Autowired
	private User user;
	
//	@RequestMapping( method = RequestMethod.GET)
//	public @ResponseBody HttpEntity<List<Relation>> getMyRelations() {
//		List<Relation> list = relationService.findByUser(user);
//		return new ResponseEntity<List<Relation>>(list, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value = "/workspaces/{id_workspace}", method = RequestMethod.GET)
//	public @ResponseBody HttpEntity<List<Project>> getProjectsByWorkspace(
//			@PathVariable("id_workspace") String idWorkspace) {
//		List<Project> list = projectService.findByIdWorkspace(idWorkspace, user);
//		return new ResponseEntity<List<Project>>(list, HttpStatus.OK);
//	}
//	
//	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
//	public @ResponseBody HttpEntity<String> create(
//			@RequestBody Project project) {
//		try {
//			project.getUsers().add(user);
//				projectService.create(project, user);
//				return new ResponseEntity<String>("Project inserted.",
//						HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("Erron: Project not inserted.",
//					HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT, consumes="application/json")
//	public @ResponseBody HttpEntity<String> update(
//			@RequestBody Project project) {
//		try {
//			project.getUsers().add(user);
//			projectService.update(project, user);
//			return new ResponseEntity<String>("Project updated.",
//					HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<String>("Erron: Project not updated.",
//					HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
}
