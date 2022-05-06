package com.example.SpringbootRegisterLogin.service;

import com.example.SpringbootRegisterLogin.DTO.UserRegistrationDTO;
import com.example.SpringbootRegisterLogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


public interface UserService extends UserDetailsService {

    User save(UserRegistrationDTO userRegistrationDTO);

}
