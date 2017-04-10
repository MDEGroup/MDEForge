package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.ReadmeFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ReadmeFileService extends ArtifactService {

	public ReadmeFileService(String connectionUrl, String username,
			String password) throws Exception {
		super(connectionUrl, username, password);
	}
	public void addReadmeFile(ReadmeFile transformation, String file) throws Exception {
		GridFileMedia gfm = new GridFileMedia();
		gfm.setContent(MDEForgeClient.readFile(file));
		if (file.lastIndexOf("/") == -1)
			gfm.setFileName(file);
		else
			gfm.setFileName(file.substring(file.lastIndexOf("/")));
		transformation.setFile(gfm);
		ObjectNode on = mapper.valueToTree(transformation);
		doPostRequest(connectionUrl + "api/ReadmeFile/", on);
	}

	public void addReadmeFile(ReadmeFile transofrmation) throws Exception {
		ObjectNode on = mapper.valueToTree(transofrmation);
		transofrmation.setId(doPostRequest(connectionUrl + "api/ReadmeFile/", on));
		
	}

	public ReadmeFile getReadmeFile(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/ReadmeFile/" + id);
		return mapper.readValue(result, ReadmeFile.class);
	}
	
	public List<ReadmeFile> getReadmeFiles() throws Exception {
		String result = doGetRequest(connectionUrl + "api/ReadmeFile/shared");
		return mapper.readValue(result, new TypeReference<List<ReadmeFile>>() {});
	}

}
