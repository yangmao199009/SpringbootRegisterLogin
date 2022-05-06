package com.example.SpringbootRegisterLogin.service;

import com.example.SpringbootRegisterLogin.DTO.UserRegistrationDTO;
import com.example.SpringbootRegisterLogin.model.Role;
import com.example.SpringbootRegisterLogin.model.User;
import com.example.SpringbootRegisterLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository=userRepository;
    }
    @Override
    public User save(UserRegistrationDTO userRegistrationDTO) {
        User user  = new User(userRegistrationDTO.getFirstName(),userRegistrationDTO.getLastName(),
                userRegistrationDTO.getEmail(), bCryptPasswordEncoder.encode( userRegistrationDTO.getPassword()),
                Arrays.asList(new Role("Role_User")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
