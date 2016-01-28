package org.mdeforge.presentation.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/public")
public class PublicController {

	@RequestMapping(value = "/", method = { RequestMethod.GET })
	public String index() {
		return "public.index";
	}
	
	@RequestMapping(value = "/about", method = { RequestMethod.GET })
	public String about() {
		return "public.about";
	}

	@RequestMapping(value = "/members", method = { RequestMethod.GET })
	public String members() {
		return "public.members";
	}

	@RequestMapping(value = "/publications", method = { RequestMethod.GET })
	public String publications() {
		return "public.publications";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "public.login";
	}
}
