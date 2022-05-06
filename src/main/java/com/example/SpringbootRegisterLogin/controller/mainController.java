package com.example.SpringbootRegisterLogin.controller;

import com.example.SpringbootRegisterLogin.DTO.UserRegistrationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String userlogin() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }




}
