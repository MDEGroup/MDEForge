package org.mdeforge.business.model.deserialize.json;

import java.io.IOException;

import org.mdeforge.business.model.Artifact;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ArtifactDeserializer extends JsonDeserializer<Artifact>{

	 
	@Override
	public Artifact deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode node = jp.getCodec().readTree(jp);

        String id = node.get("id").textValue();
        String name = node.get("name").textValue();
        String href = node.get("href").textValue();
        String className = node.get("_class").textValue();
        try {
			Class<?> cls = Class.forName(className);
			Object clsInstance = (Object) cls.newInstance();
			Artifact art = (Artifact) clsInstance;
	        art.setId(id);
	        art.setName(name);
	        art.setHref(href);
	        return art;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (InstantiationException e) {
			e.printStackTrace();
			return null;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
