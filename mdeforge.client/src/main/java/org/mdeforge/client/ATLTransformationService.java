package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.wrapper.json.ArtifactList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ATLTransformationService extends MDEForgeClient {

	public ATLTransformationService(String connectionUrl, String username,
			String password) throws Exception {
		super(connectionUrl, username, password);
	}
	public void addATLTransformation(ATLTransformation transformation, String file) throws Exception {
		GridFileMedia gfm = new GridFileMedia();
		gfm.setContent(MDEForgeClient.readFile(file));
		transformation.setFile(gfm);
		ObjectNode on = mapper.valueToTree(transformation);
		doPostRequest(connectionUrl + "api/ATLTransformation/", on);
	}

	public void addATLTransformatio(ATLTransformation transofrmation) throws Exception {
		ObjectNode on = mapper.valueToTree(transofrmation);
		transofrmation.setId(doPostRequest(connectionUrl + "api/ATLTransformation/", on));
		
	}
	
	public List<ATLTransformation> getATLTransformations() throws Exception {
		String result = doGetRequest(connectionUrl + "api/ATLTransformation/shared");
		return mapper.readValue(result, new TypeReference<List<ATLTransformation>>() {});
	}
	
	public List<Model> executeATLTransformation(String transformation, ArtifactList models) throws Exception {
		ArrayNode obj = mapper.valueToTree(models);
		String result = doPostRequest(connectionUrl + "api/ATLTransformation/execute/" + transformation, obj);
		return mapper.readValue(result, new TypeReference<List<Model>>() {});
	}
	
	
}
