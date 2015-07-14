package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.Workspace;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class WorkspaceService extends MDEForgeClient {

	public WorkspaceService(String connectionUrl, String username,
			String password) throws Exception {
		super(connectionUrl, username, password);
	}
	public List<Project> getProjectsInWorkspace(String idWorkspace) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/shared");
		return mapper.readValue(result, new TypeReference<List<Project>>() {
		});
	}
	
	public List<Workspace> getWorkspaces() throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/");
		return mapper.readValue(result, new TypeReference<List<Workspace>>() {
		});
	}

	public Workspace getWorkspace(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/" + id);
		return mapper.readValue(result, Workspace.class);
	}

	public List<Metamodel> getMetamodelsInWorkspace(String idWorkspace) throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/" + idWorkspace + "/metamodel/");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	
	public List<EcoreMetamodel> getEcoreMetamodelsInWorkspace(String idWorkspace) throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/" + idWorkspace + "/EcoreMetamodel/");
		return mapper.readValue(result, new TypeReference<List<EcoreMetamodel>>() {});
	}
	

	public List<Transformation> getTransformationsInWorkspace(String idWorkspace) throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/" + idWorkspace + "/transformation/");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	
	
	public List<Artifact> getArtifactsInWorkspace(String idWorkspace) throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/" + idWorkspace + "/artifact/");
		return mapper.readValue(result, new TypeReference<List<Artifact>>() {});
	}
	
public void addWorkspace(Workspace workspace) throws Exception {
		
		ObjectNode on = mapper.valueToTree(workspace);
		workspace.setId(doPostRequest(connectionUrl + "api/workspace/", on));
	}

}
