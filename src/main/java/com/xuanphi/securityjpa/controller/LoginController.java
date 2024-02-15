package com.xuanphi.securityjpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/show-login-page")
    public String showLoginPage(){
        return "login";
    }
    @GetMapping("/show-page-403")
    public String showPage403(){
        return "error/403";
    }
}
