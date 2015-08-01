package org.mdeforge.presentation.rest;

import java.util.List;

import org.mdeforge.business.BusinessException;
import org.mdeforge.business.RoleService;
import org.mdeforge.business.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;
@Controller
@RestController
@RequestMapping("/api/role")
public class RoleRESTController {

	
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping(method=RequestMethod.GET )
	public @ResponseBody HttpEntity<List<Role>> findAll()
	{
		List<Role> roles = roleService.findAll();
		return new ResponseEntity<List<Role>>(roles,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/schema", method = RequestMethod.GET)
	public @ResponseBody HttpEntity<JsonSchema> getJsonSchema() {
		ObjectMapper MAPPER = new ObjectMapper();
		JsonSchemaGenerator generator = new JsonSchemaGenerator(MAPPER);
        try {
			JsonSchema jsonSchema = generator.generateSchema(Role.class);
			return new ResponseEntity<JsonSchema>(jsonSchema, HttpStatus.OK);
		} catch (JsonMappingException e) {
			return new ResponseEntity<JsonSchema>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET )
	public @ResponseBody HttpEntity<Role> findOne(@PathVariable("id") String id)
	{
		try
		{
			Role role = roleService.findById(id);
			return new ResponseEntity<Role>(role, HttpStatus.OK);
		}
		catch (BusinessException e)
		{
			return new ResponseEntity<Role>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
}
