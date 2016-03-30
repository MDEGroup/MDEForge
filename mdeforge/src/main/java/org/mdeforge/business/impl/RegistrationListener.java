package org.mdeforge.business.impl;

import java.util.UUID;

import org.mdeforge.business.UserService;
import org.mdeforge.business.model.User;
import org.mdeforge.common.spring.security.OnRegistrationCompleteEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    @Autowired
    private UserService userService;
    @Autowired
    private JavaMailSender mailSender;
 
    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }
 
    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.createVerificationToken(user, token);
         
        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl = event.getAppUrl() + "/regitrationConfirm?token=" + token;
        String message = "Activation link: ";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("mdeforge.org@mdeforge.org");
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}

