package com.xuanphi.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${xuanphi.test}")
    private String test;

    @GetMapping("/")
    public String index(){
        return "Hi " + test;
    }

    @GetMapping("/h2")
    public String index2(){
        return serverPort;
    }
}
