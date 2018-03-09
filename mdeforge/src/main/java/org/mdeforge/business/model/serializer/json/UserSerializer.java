package org.mdeforge.business.model.serializer.json;

import java.io.IOException;

import org.mdeforge.business.model.User;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UserSerializer extends JsonSerializer<User> {

	@Override
	public void serialize(User user, JsonGenerator jgen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();
        jgen.writeStringField("id", user.getId());
        jgen.writeStringField("firstname", user.getFirstname() );
        jgen.writeStringField("lastname", user.getLastname() );
        jgen.writeStringField("email", user.getEmail() );
        jgen.writeStringField("username", user.getUsername() );
        jgen.writeEndObject();
		
	}
    
}