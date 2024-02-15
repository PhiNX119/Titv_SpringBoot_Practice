package com.xuanphi.securityjpa.controller;

import com.xuanphi.securityjpa.dao.RoleRepository;
import com.xuanphi.securityjpa.entity.Role;
import com.xuanphi.securityjpa.entity.User;
import com.xuanphi.securityjpa.service.UserService;
import com.xuanphi.securityjpa.web.RegisterUser;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
@RequestMapping("/register")
public class RegisterController {
    UserService userService;
    RoleRepository roleRepository;

    @Autowired
    public RegisterController(UserService userService, RoleRepository roleRepository) {
        this.userService = userService;
        this.roleRepository = roleRepository;
    }

    @GetMapping("/show-register-form")
    public String showRegisterForm(Model model) {
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("registerUser", registerUser);
        return "register/form";
    }

    @InitBinder
    private void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/process")
    public String process(@Valid @ModelAttribute("registerUser") RegisterUser registerUser,
                          BindingResult bindingResult,
                          Model model,
                          HttpSession httpSession) {
        String username = registerUser.getUsername();

        // Form validation
        if (bindingResult.hasErrors()) {
            return "register/form";
        }

        // Check existed information
        User user = userService.findByUsername(username);
        if (user != null) {
            model.addAttribute("registerUser", registerUser);
            model.addAttribute("error", "Existed account.");
            return "register/form";
        }

        // If not exist
        User newUser = new User();
        newUser.setUsername(username);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        newUser.setPassword(bCryptPasswordEncoder.encode(registerUser.getPassword()));
        newUser.setFirstName(registerUser.getFirstName());
        newUser.setLastName(registerUser.getLastName());
        newUser.setEmail(registerUser.getEmail());

        Role defaultRole = roleRepository.findByName("ROLE_USER");
        Collection<Role> roles = new ArrayList<>();
        roles.add(defaultRole);
        newUser.setRoles(roles);

        userService.save(newUser);
        System.out.println("them thanh cong");

        // Send notice
        httpSession.setAttribute("newUser", newUser);

        return "register/confirmation";
    }
}
