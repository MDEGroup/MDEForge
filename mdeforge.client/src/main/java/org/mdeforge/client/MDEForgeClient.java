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

import org.apache.commons.codec.binary.Base64;
import org.mdeforge.business.model.GridFileMedia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class MDEForgeClient {

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
	
	protected String doGetRequest(String urlString) throws Exception {
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

	protected String doPostRequest(String urlString, JsonNode json) throws Exception {
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
	protected String doPutRequest(String urlString, JsonNode json) throws Exception {
		urlString += auth;
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("PUT");
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
	
	protected String doDeleteRequest(String urlString) throws Exception {
		urlString += auth;
		URL url = new URL(urlString);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("DELETE");
		conn.setDoOutput(true);
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

	
	public static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(Base64.encodeBase64(encoded));
		
	}
	public static GridFileMedia setGridFileMedia(String path) throws IOException {
		GridFileMedia gfm = new GridFileMedia();
		int i =(path.lastIndexOf("/")==-1)?0:path.lastIndexOf("/");
		gfm.setFileName(path.substring(i));
		gfm.setContent(readFile(path));
		return gfm;
		
	}
	public String createIndex() throws Exception{
		String result = doGetRequest(connectionUrl+"api/Artifact/createIndex");
		return result;
	}
}
