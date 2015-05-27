package org.mdeforge.presentation.backend;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/private")
public class PrivateController {
	
	

	@RequestMapping(value = "/use", method = { RequestMethod.GET })
	public String dashboard() throws IOException {

		return "private.use.dashboard";
	}

	
}
