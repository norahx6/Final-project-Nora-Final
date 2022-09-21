package com.example.hrbackend.service;

import com.example.hrbackend.model.User;
import com.example.hrbackend.repository.authUserRepository;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final authUserRepository authuserrepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authuserrepository.findUserByUsername(username);

        if (user==null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return user;
    }
}
