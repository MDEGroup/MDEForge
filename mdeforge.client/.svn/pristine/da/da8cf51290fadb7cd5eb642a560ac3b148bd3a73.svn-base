package org.mdeforge.business.model.serializer.json;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.model.Workspace;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class WorkspaceListSerializer extends JsonSerializer<List<Workspace>> {

	@Override
	public void serialize(List<Workspace> arg0, JsonGenerator jgen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		jgen.writeStartArray();
		for (Workspace project : arg0) {
			jgen.writeStartObject();
	        jgen.writeStringField("id", project.getId());
	        jgen.writeStringField("name", project.getName() );
	        jgen.writeEndObject();
		}
		jgen.writeEndArray();
		
	}

	
}