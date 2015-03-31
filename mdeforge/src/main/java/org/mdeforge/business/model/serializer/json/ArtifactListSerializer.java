package org.mdeforge.business.model.serializer.json;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.model.Artifact;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ArtifactListSerializer extends JsonSerializer<List<Artifact>> {

	@Override
	public void serialize(List<Artifact> arg0, JsonGenerator jgen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		jgen.writeStartArray();
		for (Artifact artifact : arg0) {
			jgen.writeStartObject();
			jgen.writeStringField("href","/api/artifact/" + artifact.getId());
	        jgen.writeStringField("id", artifact.getId());
	        jgen.writeStringField("name", artifact.getName() );
	        jgen.writeStringField("_class", artifact.getClass().getCanonicalName() );
	        jgen.writeEndObject();
		}
		jgen.writeEndArray();
		
	}

	
}