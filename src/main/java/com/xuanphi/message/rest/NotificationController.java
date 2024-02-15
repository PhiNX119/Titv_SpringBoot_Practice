package com.xuanphi.message.rest;

import com.xuanphi.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    /* Field Injection */
    //@Autowired
    private MessageService service;

    /* Constructor Injection */
    @Autowired
    public NotificationController(@Qualifier("emailService") MessageService service) {
        this.service = service;
    }

    /* Setter Injection */
//    @Autowired
//    public void setEmail(EmailService email){
//        this.email = email;
//    }

    @GetMapping("/")
    public String index() {
        return "Hi Xuan Phi";
    }

    @GetMapping("/send-message")
    public String sendMessage() {
        return this.service.sendMessage();
    }
}
