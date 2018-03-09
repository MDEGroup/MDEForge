package org.mdeforge.business.model.deserialize.json;

import java.io.IOException;

import org.mdeforge.business.model.Project;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ProjectDeserializer extends JsonDeserializer<Project>{

	@Override
	public Project deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);

        String id = node.get("id").textValue();
        String name = node.get("name").textValue();
        
 
        return new Project();
	}

}
