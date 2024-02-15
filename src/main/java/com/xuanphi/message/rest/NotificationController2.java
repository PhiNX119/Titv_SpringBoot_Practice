//package com.xuanphi.message.rest;
//
//import com.xuanphi.message.service.MessageService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class NotificationController2 {
//    /* Field Injection */
//    //@Autowired
//    private final MessageService emailService;
//    private final MessageService smsService;
//    private final MessageService zaloService;
//
//    /* Constructor Injection */
//    @Autowired
//    public NotificationController2(
//            @Qualifier("emailService") MessageService emailService,
//            @Qualifier("smsService") MessageService smsService,
//            @Qualifier("zaloService") MessageService zaloService
//    ) {
//        this.emailService = emailService;
//        this.smsService = smsService;
//        this.zaloService = zaloService;
//    }
//
//    @GetMapping("/send-email")
//    public String sendEmail() {
//        return this.emailService.sendMessage();
//    }
//
//    @GetMapping("/send-sms")
//    public String sendSms() {
//        return this.smsService.sendMessage();
//    }
//
//    @GetMapping("/send-zalo")
//    public String sendZalo() {
//        return this.zaloService.sendMessage();
//    }
//}
