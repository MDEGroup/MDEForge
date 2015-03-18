package org.mdeforge.business.model.serializer.json;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.model.Project;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class ProjectListSerializer extends JsonSerializer<List<Project>> {

	@Override
	public void serialize(List<Project> arg0, JsonGenerator jgen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		jgen.writeStartArray();
		if (arg0 != null && arg0.size() != 0) {
			for (Project project : arg0) {
				if (project != null) {
					jgen.writeStartObject();
					jgen.writeStringField("id", project.getId());
					jgen.writeStringField("name", project.getName());
					jgen.writeEndObject();
				}
			}
		}
		jgen.writeEndArray();

	}

}