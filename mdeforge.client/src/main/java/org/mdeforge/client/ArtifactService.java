package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.EcoreMetamodel;

import com.fasterxml.jackson.core.type.TypeReference;


public class ArtifactService extends MDEForgeClient {


	
	public ArtifactService(String connectionUrl, String username,
			String password) throws Exception {
		super(connectionUrl, username, password);
	}
	
	public boolean deleteArtifact(String idArtifact) throws Exception {
		String result = doDeleteRequest(connectionUrl + "/api/Artifact/" + idArtifact);
		return mapper.readValue(result, boolean.class);
	}
	
	public Artifact getArtifact(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/Artifact/" + id);
		return mapper.readValue(result, Artifact.class);
	}
	
	public List<Artifact> searchArtifacts(String terms) throws Exception {
		String result = doGetRequest(connectionUrl + "api/Artifact/search/" + terms);
		return mapper.readValue(result, new TypeReference<List<Artifact>>(){});
	}
	
}
