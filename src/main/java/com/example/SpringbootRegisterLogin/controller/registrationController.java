package com.example.SpringbootRegisterLogin.controller;

import com.example.SpringbootRegisterLogin.DTO.UserRegistrationDTO;
import com.example.SpringbootRegisterLogin.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")

public class registrationController {
    @Autowired
    private UserServiceImpl userService;

    @ModelAttribute("user")
    public UserRegistrationDTO userRegistrationDto() {
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String register() {

        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO registrationDto) {
        System.out.println(registrationDto.getFirstName());
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
