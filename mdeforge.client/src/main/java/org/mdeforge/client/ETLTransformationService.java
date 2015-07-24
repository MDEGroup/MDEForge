package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.wrapper.json.ArtifactList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ETLTransformationService extends ArtifactService {

	public ETLTransformationService(String connectionUrl, String username,
			String password) throws Exception {
		super(connectionUrl, username, password);
	}
	
	public void addETLTransformation(ETLTransformation transformation, String file) throws Exception {
		GridFileMedia gfm = new GridFileMedia();
		String[] temp = file.split("/");
		String fileName = temp[temp.length -1];
		gfm.setContent(MDEForgeClient.readFile(fileName));
		gfm.setFileName(file);
		transformation.setFile(gfm);
		ObjectNode on = mapper.valueToTree(transformation);
		doPostRequest(connectionUrl + "api/ETLTransformation/", on);
	}

	public void addETLTransformatio(ETLTransformation transofrmation) throws Exception {
		ObjectNode on = mapper.valueToTree(transofrmation);
		transofrmation.setId(doPostRequest(connectionUrl + "api/ETLTransformation/", on));
		
	}
	
	public List<ETLTransformation> getETLTransformations() throws Exception {
		String result = doGetRequest(connectionUrl + "api/ETLTransformation/shared");
		return mapper.readValue(result, new TypeReference<List<ETLTransformation>>() {});
	}
	
	public void executeETLTransformation(String id, List<Model> models) throws Exception {
		ArrayNode on = mapper.valueToTree(new ArtifactList(models));
		doPostRequest(connectionUrl + "/api/ETLTransformation/execute/" + id, on);
	}
	
	public ETLTransformation getETLTransformation(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/ETLTransformation/" + id);
		return mapper.readValue(result, ETLTransformation.class);
	}
	

}
