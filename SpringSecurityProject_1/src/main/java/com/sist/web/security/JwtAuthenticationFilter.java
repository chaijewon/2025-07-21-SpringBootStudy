package com.sist.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

public class JwtAuthenticationFilter
extends OncePerRequestFilter {

private final UserDetailsService userDetailsService;
private final JwtTokenProvider provider;

public JwtAuthenticationFilter(
    UserDetailsService userDetailsService,
    JwtTokenProvider provider){
this.userDetailsService=userDetailsService;
this.provider=provider;
}

@Override
protected void doFilterInternal(
    HttpServletRequest request,
    HttpServletResponse response,
    FilterChain chain)
    throws ServletException, IOException {

String header=request.getHeader("Authorization");

if(header!=null && header.startsWith("Bearer ")){

    String token=header.substring(7);

    if(provider.validate(token)){

        String username=
                provider.getUsername(token);

        UserDetails user=
                userDetailsService
                .loadUserByUsername(username);

        UsernamePasswordAuthenticationToken auth=
                new UsernamePasswordAuthenticationToken(
                        user,null,user.getAuthorities());

        SecurityContextHolder
                .getContext()
                .setAuthentication(auth);
    }
}

     try {
		chain.doFilter(request,response);
	} catch (java.io.IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ServletException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
