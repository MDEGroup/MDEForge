package org.mdeforge.presentation.backend;

import java.util.List;

import org.mdeforge.business.UserService;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/private/user")
public class UserController {

	@Autowired
	private UserService userSerivce;
	@RequestMapping("/list")
	public @ResponseBody List<User> elenco() {
		List<User> ul = userSerivce.findAll();
		return ul;
	}
	@RequestMapping("/list_web")
	public String userList(Model model){
		List<User> ul = userSerivce.findAll();
		model.addAttribute("userList",ul);
		return "private.use.user";
	}
	

}
