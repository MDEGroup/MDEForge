package org.mdeforge.business.model.serializer.json;

import java.io.IOException;
import java.util.List;

import org.mdeforge.business.model.User;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UserListSerializer extends JsonSerializer<List<User>> {

	@Override
	public void serialize(List<User> arg0, JsonGenerator jgen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		jgen.writeStartArray();
		for (User user : arg0) {
			jgen.writeStartObject();
	        jgen.writeStringField("id", user.getId());
	        jgen.writeStringField("firstname", user.getFirstname());
	        jgen.writeStringField("lastname", user.getLastname());
	        jgen.writeStringField("email", user.getEmail() );
	        jgen.writeStringField("username", user.getUsername() );
	        jgen.writeEndObject();
		}
		jgen.writeEndArray();
		
		
	}
}