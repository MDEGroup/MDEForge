package org.mdeforge.business.model.serializer.json;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.model.Relation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class RelationListSerializer extends JsonSerializer<List<Relation>> {

	@Override
	public void serialize(List<Relation> rel, JsonGenerator jgen,
			SerializerProvider arg2) throws IOException,
			JsonProcessingException {
		jgen.writeStartArray();
		
		if (rel != null && rel.size() != 0) {
			for (Relation relation : rel) {
				try {
					if (relation != null) {
						jgen.writeStartObject();
							jgen.writeStringField("id", relation.getId());
							jgen.writeObjectFieldStart("fromArtifact");
								jgen.writeStringField("_class", relation.getFromArtifact().getClass().getCanonicalName() );
								jgen.writeStringField("id", relation.getFromArtifact().getId());
							jgen.writeEndObject();
							jgen.writeObjectFieldStart("toArtifact");
								jgen.writeStringField("_class", relation.getToArtifact().getClass().getCanonicalName() );
								jgen.writeStringField("id", relation.getToArtifact().getId());
							jgen.writeEndObject();
		//					.w
		//					jgen.writeStringField("fromArtifact", relation.getToArtifact().getId());
		//					jjgengen.writeStringField("toArtifact", relation.getFromArtifact().getId());				
							jgen.writeStringField("name", relation.getName());
							jgen.writeStringField("_class", relation.getClass().getCanonicalName());
						jgen.writeEndObject();
					}
				}catch (Exception e) {
					System.err.println(relation.getId());
				}
			}
		}
		jgen.writeEndArray();

	}

}