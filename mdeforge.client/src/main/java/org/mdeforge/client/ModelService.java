package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ModelService extends MDEForgeClient {

	public ModelService(String connectionUrl, String username, String password)
			throws Exception {
		super(connectionUrl, username, password);
	}
	
	public void addModel(Model model) throws Exception {
		ObjectNode on = mapper.valueToTree(model);
		model.setId(doPostRequest(connectionUrl + "api/Model/", on));
		
	}
	
	public void addModel(Model model, String file) throws Exception {
		GridFileMedia gfm = new GridFileMedia();
		String[] temp = file.split("/");
		String fileName = temp[temp.length -1];
		String s = MDEForgeClient.readFile(file);		
		gfm.setContent(s);
		gfm.setFileName(fileName);
		model.setFile(gfm);
		ObjectNode on = mapper.valueToTree(model);
		model.setId(doPostRequest(connectionUrl + "api/Model/", on));
	}
	
	public List<Model> getModels() throws Exception {
		String result = doGetRequest(connectionUrl + "api/Model/shared");
		return mapper.readValue(result, new TypeReference<List<Model>>() {});
	}
	
	
	public String validateModels(String idMetamodel) throws Exception {
		String result = doGetRequest(connectionUrl + "api/Model/validate/" + idMetamodel);
		return result;
	}
}
