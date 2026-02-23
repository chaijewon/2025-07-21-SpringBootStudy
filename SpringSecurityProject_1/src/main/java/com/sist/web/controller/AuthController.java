package com.sist.web.controller;

import com.sist.web.security.JwtTokenProvider;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final AuthenticationManager manager;
    private final JwtTokenProvider provider;

    public AuthController(
            AuthenticationManager manager,
            JwtTokenProvider provider){
        this.manager=manager;
        this.provider=provider;
    }
  
    @RequestMapping("/member/login")
    public String login(
            @RequestParam(value="username",required = false) String username,
            @RequestParam(value="password",required = false) String password){

        Authentication auth=
                manager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        username,password));

        UserDetails user=
                (UserDetails)auth.getPrincipal();

        return provider.createToken(
                user.getUsername(),
                user.getAuthorities()
                    .iterator().next()
                    .getAuthority());
    }
}