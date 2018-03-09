package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Transformation;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ProjectService extends MDEForgeClient {

	public ProjectService(String connectionUrl, String username, String password)
			throws Exception {
		super(connectionUrl, username, password);
	}

	public void addProject(Project project) throws Exception {

		ObjectNode on = mapper.valueToTree(project);
		project.setId(doPostRequest(connectionUrl + "api/project/", on));
	}
	
	public List<Metamodel> getMetamodelsInProject(String idProject) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + idProject + "/metamodel/");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	
	public Project getProject(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + id);
		return mapper.readValue(result, Project.class);
	}
	
	public List<EcoreMetamodel> getEcoreMetamodelsInProject(String idProject) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + idProject + "/EcoreMetamodel/");
		return mapper.readValue(result, new TypeReference<List<EcoreMetamodel>>() {});
	}
	
	public List<Project> getProjects() throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/shared");
		return mapper.readValue(result, new TypeReference<List<Project>>() {
		});
	}
	
	public List<Transformation> getTransformationsInProject(String idProject) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + idProject + "/transformation/");
		return mapper.readValue(result, new TypeReference<List<Transformation>>() {});
	}
	
	public List<Artifact> getArtifactsInProject(String idProject) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + idProject + "/artifact/");
		return mapper.readValue(result, new TypeReference<List<Artifact>>() {});
	}
}
