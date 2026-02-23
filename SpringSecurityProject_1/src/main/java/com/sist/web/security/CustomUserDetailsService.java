package com.sist.web.security;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username){

        if(username.equals("admin")){
            return User.builder()
                    .username("admin")
                    .password("{noop}1234")
                    .roles("ADMIN")
                    .build();
        }

        return User.builder()
                .username("user")
                .password("{noop}1234")
                .roles("USER")
                .build();
    }
}