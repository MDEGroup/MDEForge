package org.mdeforge.presentation.frontend;

import javax.servlet.http.HttpServletRequest;

import org.mdeforge.business.UserService;
import org.mdeforge.business.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignIn {
	
	@Autowired
    protected AuthenticationManager authenticationManager;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/signin", method = { RequestMethod.GET })
	public String signIn(Model model) {
		model.addAttribute("",new User());
		return "public.signin";
	}
	@RequestMapping(value = "/signin", method = { RequestMethod.POST })
	public String signInPost(Model model, @ModelAttribute ("transformation") User user,
			HttpServletRequest request) {
		userService.create(user);
		authenticateUserAndSetSession(user, request);
		return "redirect:/private/dashboard";
	}
	
    private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        // generate session if one doesn't exist
        request.getSession();
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
    }
	
	
//	@RequestMapping(value = "/search_metamodel_by_example/result", method = { RequestMethod.POST })
//	public String searchEcoreMetamodelResultByExampleTop5(
//			Model model,
//			@RequestParam("metamodelfile") MultipartFile file) throws IOException {
//		EcoreMetamodel m = new EcoreMetamodel();
//		byte[] bytes = file.getBytes();
//		GridFileMedia gfm = new GridFileMedia();
//		gfm.setByteArray(bytes);
//		gfm.setFileName("searchFragment.ecore");
//		m.setFile(gfm);
//		m.setName("searchFragment");        
//		List<EcoreMetamodel> el = ecoreMetamodelService.searchByExample(m, 0.5);
//		for (EcoreMetamodel ecoreMetamodel : el) {
//			ecoreMetamodel.setFile(null);
//		}
//		model.addAttribute("artifactListByExample", el);
//		return "public.search";
//
//	}
	

}
