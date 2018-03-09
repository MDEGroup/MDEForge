package org.mdeforge.business.model.serializer.json;

import java.io.IOException;

import org.mdeforge.business.model.User;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class UserSerializer extends JsonSerializer<User> {

	@Override
	public void serialize(User arg0, JsonGenerator jgen, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		jgen.writeStartObject();
        jgen.writeStringField("id", arg0.getId());
        jgen.writeStringField("username", arg0.getUsername() );
        jgen.writeEndObject();
		
	}
    
}