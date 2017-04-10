package org.mdeforge.presentation.rest;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.ReadmeFileService;
import org.mdeforge.business.model.ReadmeFile;
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
import org.springframework.web.bind.annotation.RestController;

;

@Controller
@RestController
@RequestMapping("/api/ReadmeFile")
public class ReadmeFileRESTController {

	@Autowired
	private ReadmeFileService readmeService;
	//Ci dice l'utente che ha fatto la richiesta rest
	@Autowired
	private User user;

	@RequestMapping(value = "/{id_artifact}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ReadmeFile> getArtifact(@PathVariable("id_artifact") String idArtifact) {
		try {
			ReadmeFile artifact = readmeService.findOneById(idArtifact, user);
			return new ResponseEntity<ReadmeFile>(artifact, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<ReadmeFile>(HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getArtifacts() {
		//http://localhost:8080/mdeforge/api/metamodel/?access_token=40846e42-fc43-46df-ad09-982d466b8955
		ArtifactList result = new ArtifactList(readmeService
				.findAllWithPublicByUser(user));
		return new ResponseEntity<ArtifactList>(result, HttpStatus.OK);
	}

	// create transformation
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HttpEntity<String> createArtifact(
			@RequestBody ReadmeFile readmeFile) {
		try {
			// SetAuthor
			readmeFile.setAuthor(user);
			// transformation save
			readmeService.create(readmeFile);
			return new ResponseEntity<String>("Readme inserted.",
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(
					"Erron: Readme not inserted.",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
	public @ResponseBody HttpEntity<String> updateArtifact(
			@RequestBody ReadmeFile readme,
			@PathVariable("id_user") String idUser) {
		try {
			// GetUser
			// SetAuthor
			readme.setAuthor(user);
			// add author to shared
			readme.getShared().add(user);
			// transformation update
			readmeService.update(readme);
			return new ResponseEntity<String>("ReadmeFile updated.",
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(
					"Erron: transformation not updated",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/{id_transformation}", method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<String> deleteTranformation(
			@PathVariable("id_metamodel") String idArtifact) {
		try {
			ReadmeFile art = readmeService.findOneById(idArtifact, user);
			readmeService.delete(art, user);
			return new ResponseEntity<String>("ReadmeFile deleted",
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("ReadmeFile deleted",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@RequestMapping(value = "/shared", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> getTransformationsByUser() {
		ArtifactList list = new ArtifactList(readmeService
				.findAllWithPublicByUser(user));
		return new ResponseEntity<ArtifactList>(list, HttpStatus.OK);

	}
	
	
}
