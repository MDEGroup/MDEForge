package org.mdeforge.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.mdeforge.business.model.ATLTransformation;
import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Cluster;
import org.mdeforge.business.model.ETLTransformation;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.GridFileMedia;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Metric;
import org.mdeforge.business.model.Model;
import org.mdeforge.business.model.Project;
import org.mdeforge.business.model.Transformation;
import org.mdeforge.business.model.Workspace;
import org.mdeforge.business.model.wrapper.json.ArtifactList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class MDEForgeClient {

	final String connectionUrl;
	final ObjectMapper mapper;
	final String username;
	final String password;
	private String accessToken;
	private String auth;
	public MDEForgeClient(String connectionUrl, String username, String password) throws Exception {
		this.connectionUrl = connectionUrl;
		mapper = new ObjectMapper();
		this.username = username;
		this.password = password;
		setToken();
	}

	private void setToken() throws MalformedURLException, IOException {

		URL token = new URL(connectionUrl + "oauth/token?grant_type=password&client_id=my-trusted-client&password=" 
				+ password + "&username=" + username);
		HttpURLConnection conn = (HttpURLConnection) token.openConnection();
		conn.setRequestMethod("GET");
		if (conn.getResponseCode() != 200) {
			conn.disconnect();
			throw new MalformedURLException("Unable to connect to MDEFORGE REST API. Check URL.\n" + conn.getResponseCode() 
				+ "\t" + conn.getResponseMessage());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		JsonNode actualObj = mapper.readTree(sb.toString());
		JsonNode jsonNode = actualObj.get("access_token");
		accessToken = jsonNode.asText();
		auth = "?access_token=" + accessToken;
		conn.disconnect();
	}

	public Project getProject(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + id);
		return mapper.readValue(result, Project.class);
	}

	
	public List<Project> getProjects() throws Exception {
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
	public List<Metamodel> getMetamodelsInProject(String idProject) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + idProject + "/metamodel/");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	public List<EcoreMetamodel> getEcoreMetamodelsInWorkspace(String idWorkspace) throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/" + idWorkspace + "/EcoreMetamodel/");
		return mapper.readValue(result, new TypeReference<List<EcoreMetamodel>>() {});
	}
	public List<EcoreMetamodel> getEcoreMetamodelsInProject(String idProject) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + idProject + "/EcoreMetamodel/");
		return mapper.readValue(result, new TypeReference<List<EcoreMetamodel>>() {});
	}

	public List<Transformation> getTransformationsInWorkspace(String idWorkspace) throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/" + idWorkspace + "/transformation/");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	public List<Transformation> getTransformationsInProject(String idProject) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + idProject + "/transformation/");
		return mapper.readValue(result, new TypeReference<List<Transformation>>() {});
	}
	public List<Artifact> getArtifactsInProject(String idProject) throws Exception {
		String result = doGetRequest(connectionUrl + "api/project/" + idProject + "/artifact/");
		return mapper.readValue(result, new TypeReference<List<Artifact>>() {});
	}
	public List<Artifact> getArtifactsInWorkspace(String idWorkspace) throws Exception {
		String result = doGetRequest(connectionUrl + "api/workspace/" + idWorkspace + "/artifact/");
		return mapper.readValue(result, new TypeReference<List<Artifact>>() {});
	}
	public List<Transformation> getTransformationsPublic() throws Exception {
		String result = doGetRequest(connectionUrl + "api/transformation/");
		return mapper.readValue(result, new TypeReference<List<Transformation>>() {});
	}
	
	public List<Metamodel> getMetamodels() throws Exception {
		String result = doGetRequest(connectionUrl + "api/metamodel/shared");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}

	public List<EcoreMetamodel> getEcoreMetamodels() throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/shared");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	public List<EcoreMetamodel> getEcoreMetamodelsPublic() throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/public");
		return mapper.readValue(result, new TypeReference<List<Metamodel>>() {});
	}
	public List<Model> getModels() throws Exception {
		String result = doGetRequest(connectionUrl + "api/Model/shared");
		return mapper.readValue(result, new TypeReference<List<Model>>() {});
	}
	
	public String validateEcoreMetamodels(String idMetamodel) throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/validate/" + idMetamodel);
		return result;
	}
	public String validateModels(String idMetamodel) throws Exception {
		String result = doGetRequest(connectionUrl + "api/Model/validate/" + idMetamodel);
		return result;
	}
	public List<Transformation> getTransformations() throws Exception {
		String result = doGetRequest(connectionUrl + "api/transformation/shared");
		return mapper.readValue(result, new TypeReference<List<Transformation>>() {});
	}
	
	public Metamodel getMetamodel(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/metamodel/" + id);
		return mapper.readValue(result, Metamodel.class);
	}

	public EcoreMetamodel getEcoreMetamodel(String id) throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/" + id);
		return mapper.readValue(result, EcoreMetamodel.class);
	}
	public Transformation getTransformation(String id) throws Exception{
		String result = doGetRequest(connectionUrl + "api/transformation/" + id);
		return mapper.readValue(result, Transformation.class);
	}
	public List<Metric> getEcoreMetamodelMetrics(String idMetamodel) throws Exception{
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/" + idMetamodel + "/metrics");
		return mapper.readValue(result, new TypeReference<List<Metric>>() {});
	}
	
	public String getEcoreMetamodelSimilarity(String idMetamodel1, String idMetamodel2) throws Exception{
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/similarity/" + idMetamodel1 + "/" + idMetamodel2);
		return result;
	}
		
	public void addMetamodel(Metamodel metamodel) throws Exception {
		ObjectNode on = mapper.valueToTree(metamodel);
		doPostRequest(connectionUrl + "api/metamodel/", on);
	}
	public void executeETLTransformation(String id, List<Model> models) throws Exception {
		ArrayNode on = mapper.valueToTree(new ArtifactList(models));
		doPostRequest(connectionUrl + "/api/ETLTransformation/execute/" + id, on);
	}
	public void addMetamodel(Metamodel metamodel, String file) throws Exception {
		GridFileMedia gfm = new GridFileMedia();
		String s = MDEForgeClient.readFile(file);		
		gfm.setContent(s);
		metamodel.setFile(gfm);
		ObjectNode on = mapper.valueToTree(metamodel);
		doPostRequest(connectionUrl + "api/metamodel/", on);
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
	public void addETLTransformation(ETLTransformation transformation, String file) throws Exception {
		GridFileMedia gfm = new GridFileMedia();
		gfm.setContent(MDEForgeClient.readFile(file));
		transformation.setFile(gfm);
		ObjectNode on = mapper.valueToTree(transformation);
		doPostRequest(connectionUrl + "api/ETLTransformation/", on);
	}

	public void addETLTransformatio(ETLTransformation transofrmation) throws Exception {
		ObjectNode on = mapper.valueToTree(transofrmation);
		transofrmation.setId(doPostRequest(connectionUrl + "api/ETLTransformation/", on));
		
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
	private String doGetRequest(String urlString) throws Exception {
		urlString += auth;
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		conn.connect();
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		conn.disconnect();
		return sb.toString();
	}

	private String doPostRequest(String urlString, JsonNode json) throws Exception {
		urlString += auth;
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);
		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
		wr.write(json.toString());
		wr.flush();
		wr.close();
		conn.connect();
		if (conn.getResponseCode() != 201 && conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuffer sb = new StringBuffer();
		String output;
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		conn.disconnect();
		return sb.toString();
	}
	
	public void addProject(Project project) throws Exception {
		
		ObjectNode on = mapper.valueToTree(project);
		project.setId(doPostRequest(connectionUrl + "api/project/", on));
	}
	public void addWorkspace(Workspace workspace) throws Exception {
		
		ObjectNode on = mapper.valueToTree(workspace);
		workspace.setId(doPostRequest(connectionUrl + "api/workspace/", on));
	}
	public static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(Base64.encodeBase64(encoded));
		
	}

	public List<ETLTransformation> getETLTransformations() throws Exception {
		String result = doGetRequest(connectionUrl + "api/ETLTransformation/shared");
		return mapper.readValue(result, new TypeReference<List<ETLTransformation>>() {});
	}
	
	public List<ATLTransformation> getATLTransformations() throws Exception {
		String result = doGetRequest(connectionUrl + "api/ATLTransformation/shared");
		return mapper.readValue(result, new TypeReference<List<Transformation>>() {});
	}
	public List<Cluster> getEcoreMetamodelCluster(int computation, double threshold) throws Exception {
		String result = doGetRequest(connectionUrl + "api/EcoreMetamodel/cluster/" + threshold + "/" + computation);
		return mapper.readValue(result, new TypeReference<List<Cluster>>() {});
	}
}
