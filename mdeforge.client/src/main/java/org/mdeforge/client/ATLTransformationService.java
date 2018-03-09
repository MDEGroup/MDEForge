package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.ATLTransformationError;
import org.mdeforge.business.model.ATLTransformationTestServiceError;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.wrapper.json.ArtifactList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ATLTransformationService extends ArtifactService {

	public ATLTransformationService(String connectionUrl, String username,
			String password) throws Exception {
		super(connectionUrl, username, password);
	}
	public void addATLTransformation(ATLTransformation transformation, String file) throws Exception {
		GridFileMedia gfm = new GridFileMedia();
		gfm.setContent(MDEForgeClient.readFile(file));
		if (file.lastIndexOf("/") == -1)
			gfm.setFileName(file);
		else
			gfm.setFileName(file.substring(file.lastIndexOf("/")));
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
	public List<Model> executeATLTransformation(ATLTransformation transformation, ArtifactList models) throws Exception {
		ArrayNode obj = mapper.valueToTree(models);
		String result = doPostRequest(connectionUrl + "api/ATLTransformation/execute/" + transformation.getId(), obj);
		return mapper.readValue(result, new TypeReference<List<Model>>() {});
	}
	public ATLTransformation getATLTransformation(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/ATLTransformation/" + id);
		return mapper.readValue(result, ATLTransformation.class);
	}
	public ATLTransformation getATLTransformationByName(String name) throws Exception {
		String result = doGetRequest(connectionUrl + "api/ATLTransformation/byname/" + name);
		return mapper.readValue(result, ATLTransformation.class);
	}
	public List<ATLTransformationError> anATLyze(ATLTransformation trafo) throws Exception {
		String result = doGetRequest(connectionUrl + "api/ATLTransformation/anatlyzer/" + trafo.getId());
		return mapper.readValue(result, new TypeReference<List<ATLTransformationError>>() {});
	}
	public List<ATLTransformationTestServiceError> testerService(ATLTransformation name) throws Exception {
		String result = doGetRequest(connectionUrl + "api/ATLTransformation/testerService/" + name.getId());
		return mapper.readValue(result,  new TypeReference<List<ATLTransformationTestServiceError>>() {});
	}
}
