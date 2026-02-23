package com.sist.web.security;

import com.sist.web.security.*;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class JwtSecurityConfig {

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(
            UserDetailsService uds,
            JwtTokenProvider provider){
        return new JwtAuthenticationFilter(uds,provider);
    }

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            JwtAuthenticationFilter filter)
            throws Exception {

        http
            .csrf(csrf->csrf.disable())
            .sessionManagement(session->
                session.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS))

            .authorizeHttpRequests(auth->auth
                .requestMatchers("/","/member/login").permitAll()
                .requestMatchers("/member/admin").hasRole("ADMIN")
                .anyRequest().permitAll()
            )
            .addFilterBefore(
                filter,
                UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
}