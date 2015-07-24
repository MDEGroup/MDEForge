package org.mdeforge.client;

import java.util.List;

import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metamodel;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EcoreMetamodelService extends ArtifactService {

	public EcoreMetamodelService(String connectionUrl, String username,
			String password) throws Exception {
		super(connectionUrl, username, password);
		// TODO Auto-generated constructor stub
	}
	
	public List<EcoreMetamodel> getEcoreMetamodels() throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/shared");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	
	public List<EcoreMetamodel> getEcoreMetamodelsPublic() throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/public");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	
	public String validateEcoreMetamodels(String idMetamodel) throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/validate/" + idMetamodel);
		return result;
	}
	
	public EcoreMetamodel getEcoreMetamodel(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/" + id);
		return mapper.readValue(result, EcoreMetamodel.class);
	}

	public void addEcoreMetamodel(EcoreMetamodel metamodel) throws Exception {
		ObjectNode on = mapper.valueToTree(metamodel);
		metamodel.setId(doPostRequest(connectionUrl + "api/EcoreMetamodel/", on));
		
	}
	
	public void addEcoreMetamodel(EcoreMetamodel metamodel, String file) throws Exception {
		GridFileMedia gfm = new GridFileMedia();
		String[] temp = file.split("/");
		String fileName = temp[temp.length -1];
		String s = MDEForgeClient.readFile(file);		
		gfm.setContent(s);
		gfm.setFileName(fileName);
		metamodel.setFile(gfm);
		ObjectNode on = mapper.valueToTree(metamodel);
		String app = doPostRequest(connectionUrl + "api/EcoreMetamodel/", on);
		EcoreMetamodel emm = mapper.readValue(app, new TypeReference<EcoreMetamodel>() {});
		metamodel.setId(emm.getId());
	}
	
	public List<EcoreMetamodel> searchEcoreMetamodelByExample(EcoreMetamodel emm) throws Exception {
		ObjectNode on = mapper.valueToTree(emm);
		String result = doPostRequest(connectionUrl + "api/EcoreMetamodel/search_by_example", on);
		return mapper.readValue(result, new TypeReference<List<EcoreMetamodel>>() {});
	}
	
	public String getEcoreMetamodelSimilarity(String idMetamodel1, String idMetamodel2) throws Exception{
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/similarity/" + idMetamodel1 + "/" + idMetamodel2);
		return result;
	}
	
	public List<Cluster> getEcoreMetamodelCluster(int computation, double threshold) throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/cluster/" + threshold + "/" + computation);
		return mapper.readValue(result, new TypeReference<List<Cluster>>() {});
	}
	
	
}
