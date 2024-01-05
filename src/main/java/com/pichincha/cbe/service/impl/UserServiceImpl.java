package com.pichincha.cbe.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if(username == null || username.isBlank()){
            throw new UsernameNotFoundException("Invalid user");
        }

        return User.builder()
                .username(username)
                .password("123")
                .build();
    }
}
