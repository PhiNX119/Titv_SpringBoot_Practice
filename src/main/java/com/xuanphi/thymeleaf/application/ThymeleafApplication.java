package com.xuanphi.thymeleaf.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages =
                {
                        "com.xuanphi.thymeleaf.application",
                        "com.xuanphi.thymeleaf.rest"
                })
public class ThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafApplication.class, args);
    }

}
