package org.mdeforge.presentation.frontend;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.mdeforge.business.UserService;
import org.mdeforge.business.model.EcoreMetamodel;
import org.mdeforge.business.model.User;
import org.mdeforge.business.model.VerificationToken;
import org.mdeforge.common.spring.security.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.gridfs.GridFSFile;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

@Controller
public class SignIn {
	
	@Autowired
    protected AuthenticationManager authenticationManager;
	@Autowired
	ReCaptchaImpl reCaptcha;
	@Autowired
	private UserService userService;
	@Autowired
	ApplicationEventPublisher eventPublisher;
	@Autowired
	GridFsTemplate operations;
	@RequestMapping(value = "/signin", method = { RequestMethod.GET })
	public String signIn(Model model) {
		model.addAttribute("user",new User());
		return "public.signin";
	}
	@RequestMapping(value = "/signin", method = { RequestMethod.POST })
	public String signInPost(Model model, @ModelAttribute ("user") User user,
			@RequestParam("photo") MultipartFile photo,
			@RequestParam("recaptcha_challenge_field") String challangeField, 
			@RequestParam("recaptcha_response_field") String responseField, 
			HttpServletRequest request) {
		String remoteAddress = request.getServerName();
		try {
			GridFSFile s = operations.store(photo.getInputStream(), photo.getOriginalFilename(),"");
			System.out.println(s.getId());
			user.setImage(operations.store(photo.getInputStream(), photo.getOriginalFilename(),"").getId().toString());
		} catch (IOException e1) {
			System.out.println("ERROR");
		}
		ReCaptchaResponse reCaptchaResponse = this.reCaptcha.checkAnswer(remoteAddress, challangeField, responseField);
		if(reCaptchaResponse.isValid() ){
			String appUrl = request.getContextPath();
			try {
				eventPublisher.publishEvent(new OnRegistrationCompleteEvent
						(user, request.getLocale(), appUrl));
			}catch (Exception e) {System.out.println(e.getMessage());}
		}
		else {
			model.addAttribute("user", user);
			model.addAttribute("captcha",true);
			return "public.signin";
		}
		return "public.registration.request";
	}

    @RequestMapping(value = "/regitrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration
          (HttpServletRequest request, Model model, @RequestParam("token") String token) {
        VerificationToken verificationToken = userService.getVerificationToken(token);
        if (verificationToken == null) {
            model.addAttribute("message", "The user couldn't be found!");
            return "public.registration.status"; 
        }
        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            model.addAttribute("message", "The token has been expired!");
            return "public.registration.status"; 
        } 
        User user = verificationToken.getUser();
        model.addAttribute("message", "User is confirmed. Please login!");
        user.setEnabled(true); 
        userService.saveRegisteredUser(user); 
        return "public.registration.status"; 
    }

	

}
