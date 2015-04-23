package org.mdeforge.presentation.backend;

import org.mdeforge.business.UserService;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {
	@Autowired
	private UserService userService;

	@RequestMapping(value="/registration", method={RequestMethod.GET})
	public String registration_start(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "common.registration";
	}
	
	@RequestMapping(value="/registration", method={RequestMethod.POST})
	public String registration(@ModelAttribute User user) {
		userService.create(user);
		return "redirect:/registrationok";
	}
}
