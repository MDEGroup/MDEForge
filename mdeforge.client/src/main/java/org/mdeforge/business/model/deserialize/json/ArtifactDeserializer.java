package org.mdeforge.business.model.deserialize.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.mdeforge.business.model.Artifact;
import org.mdeforge.business.model.Metamodel;
import org.mdeforge.business.model.Project;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.IntNode;

public class ArtifactDeserializer extends JsonDeserializer<Artifact>{

	 
	@Override
	public Artifact deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);

        String id = node.get("id").textValue();
        String name = node.get("name").textValue();
        Artifact art = new Artifact();
        art.setId(id);
        art.setName(name);
        //String userId = node.get("createdBy").textValue();

        return art;
	}

}
