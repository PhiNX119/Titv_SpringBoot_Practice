package com.xuanphi.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/hello")
    public String hello1() {
        return "Hello World!";
    }

    @GetMapping("/hello/vietnamese")
    public String hello2() {
        return "Xin Chào!";
    }
}