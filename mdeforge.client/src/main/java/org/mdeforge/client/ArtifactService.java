package org.mdeforge.client;

import org.mdeforge.business.model.Artifact;


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
	
}
