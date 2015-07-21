package org.mdeforge.client;


public class ArtifactService extends MDEForgeClient {

	public ArtifactService(String connectionUrl, String username,
			String password) throws Exception {
		super(connectionUrl, username, password);
	}

//	public List<Model> deleteArtifact(Artifact artifact) throws Exception {
//		ObjectNode obj = mapper.valueToTree(artifact);
//		String result = doDeleteRequest(connectionUrl + "/api/artifact", obj);
//		return mapper.readValue(result, new TypeReference<String>() {});
//	}
	public boolean deleteArtifact(String idArtifact) throws Exception {
		String result = doDeleteRequest(connectionUrl + "/api/artifact/" + idArtifact);
		return mapper.readValue(result, boolean.class);
	}
	
	
}
