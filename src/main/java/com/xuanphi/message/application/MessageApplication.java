package com.xuanphi.message.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages =
                {
                        "com.xuanphi.message.application",
                        "com.xuanphi.message.rest",
                        "com.xuanphi.message.service"
                })
public class MessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

}
