package org.mdeforge.presentation.rest;

import java.util.ArrayList;
import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.CRUDArtifactService;
import org.mdeforge.business.LuceneService;
import org.mdeforge.business.ProjectService;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Comment;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.form.SearchResult;
import org.mdeforge.business.model.form.SearchResultComplete;
import org.mdeforge.business.model.wrapper.json.ArtifactList;
import org.mdeforge.business.model.wrapper.json.MetricList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/api/Artifact")
public class ArtifactRESTController {

	Logger logger = LoggerFactory.getLogger(ArtifactRESTController.class);

	@Autowired
	private ProjectService projectService;
	@Autowired
	private LuceneService luceneService;
	@Autowired
	private CRUDArtifactService<Artifact> artifactService;

	@Autowired
	private User user;

	// Get specified artifact
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody HttpEntity<List<Artifact>> getArtifacts() {
		List<Artifact> result = artifactService.findAllWithPublicByUser(user);
		return new ResponseEntity<List<Artifact>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/byname/{name}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<Artifact> getArtifactByName(@PathVariable("name") String idModel) {
		try {
			Artifact model = artifactService.findOneByName(idModel, user);
			return new ResponseEntity<Artifact>(model, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Artifact>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
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
				logger.error(e.getMessage());
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

	@RequestMapping(value = "/{id_artifact}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<Artifact> getArtifact(@PathVariable("id_artifact") String idArtifact) {
		try {
			Artifact artifact = artifactService.findOneById(idArtifact, user);
			return new ResponseEntity<Artifact>(artifact, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<Artifact>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@RequestMapping(value = "/{id_artifact}/metrics", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<MetricList> getArtifactMetrics(@PathVariable("id_artifact") String idArtifact) {
		try {
			List<Metric> artifact = artifactService.findMetric(idArtifact, user);
			return new ResponseEntity<MetricList>(new MetricList(artifact), HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<MetricList>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}


	// search artifacts ordered by score
	@RequestMapping(value = "/search/{text}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<ArtifactList> search(@PathVariable("text") String text) {
		try {
			SearchResultComplete searchResults = luceneService.search(user,text);
			List<Artifact> artifactList = new ArrayList<Artifact>();
			for (SearchResult result : searchResults.getResults()) {
				artifactList.add(result.getArtifact());
			}
			ArtifactList list = new ArtifactList(artifactList);
			
			return new ResponseEntity<ArtifactList>(list, HttpStatus.OK);
		} catch (BusinessException e) {
			return new ResponseEntity<ArtifactList>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@RequestMapping(value = "/comment/{idArtifact}", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<Comment> postComment(@RequestBody Comment comment, 
			@PathVariable("text") String idArtifact) {
		comment.setUser(user);
		Artifact art = artifactService.findOne(idArtifact);
		artifactService.addComment(comment,idArtifact);
		artifactService.update(art);
		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody HttpEntity<String> delete(
			@PathVariable("id") String idArtifact) {
		try {
			Artifact art = artifactService.findOneById(idArtifact, user);
			artifactService.delete(art, user);
			return new ResponseEntity<String>("true",
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("false",
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
}
