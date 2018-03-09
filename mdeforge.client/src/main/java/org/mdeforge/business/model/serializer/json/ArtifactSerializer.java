package org.mdeforge.business.model.serializer.json;

import java.io.IOException;

import org.mdeforge.business.model.Artifact;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ArtifactSerializer extends JsonSerializer<Artifact> {

	@Override
	public void serialize(Artifact artifact, JsonGenerator jgen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
			jgen.writeStartObject();
	        jgen.writeStringField("id", artifact.getId());
	        jgen.writeStringField("name", artifact.getName() );
	        jgen.writeStringField("_class", artifact.getClass().getCanonicalName() );
	        jgen.writeEndObject();
		;
		
	}

	
}