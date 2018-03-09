package org.mdeforge.business.model.serializer.json;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.model.Jsfiddle;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class JsfiddleListSerializer extends JsonSerializer<List<Jsfiddle>>{

	@Override
	public void serialize(List<Jsfiddle> arg0, JsonGenerator jgen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		// TODO Auto-generated method stub
		
		jgen.writeStartArray();
		if (arg0 != null && arg0.size() != 0) {
			for(Jsfiddle jsfiddle : arg0){
				if(jsfiddle!=null){
					jgen.writeStartObject();
					jgen.writeStringField("id", jsfiddle.getId());
					jgen.writeEndObject();
				}
			}
		}
		jgen.writeEndArray();
	}

}
