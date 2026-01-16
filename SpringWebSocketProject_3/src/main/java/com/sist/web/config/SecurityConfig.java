package com.sist.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// XML 코딩 => 자바 설정 
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.sist.web.service.CustomUserDetailService;

import lombok.RequiredArgsConstructor;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomUserDetailService userDetailService;
   /*
    *   http => url의 접근 허용 
    *   => requestMatchers('/login','/admin')
    *   => permitAll() => 전체 허용 
    *   => authenticated() => 인증받은 사용자 => login
    *   => denyAll() => 모두 거절(접군 거부)
    *   => hasRole("ADMIN") => 1개 지정 
    *      ROLE_ADMIN / ROLE_USER
    *   => hasAnyRole() => 2개 지정 
    *   
    *   csrf : 공격자가 인증된 브라우저에서 
    *          쿠키 / 세션을 활용해서 웹서버에서 사용 
    *   
    */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)
	throws Exception
	{
		// 권한 제시 
		http
		  .csrf(csrf -> csrf.disable())
		  .authorizeHttpRequests(auth -> auth
			   .requestMatchers("/","/join","/login").permitAll()
			   .requestMatchers("/user","/chat/**").authenticated()
			   .requestMatchers("/admin").hasAnyRole("ADMIN")
			   .anyRequest().permitAll()
		   )
		// 로그인
		  .formLogin(form -> form
			   .loginPage("/login")
			   .loginProcessingUrl("/login_process")
			   .defaultSuccessUrl("/",true)
			   .failureHandler(loginFailHandler())
		  )
		// 로그아웃
		  .logout(logout -> logout
	         .logoutSuccessUrl("/")
		   )
		// 자동 로그인
		  .rememberMe(remember -> remember
			 .key("remember-my-security-key")	  
			 .tokenValiditySeconds(60*60*24)
			 .userDetailsService(userDetailService)
		   );
		
		return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// 로그인 실패시 처리 
	// 로그인 성공시 처리 ==> 자동으로 session에 등록 
	//
	@Bean
	public AuthenticationFailureHandler loginFailHandler()
	{
		return new LoginFailHandler();
	} 
}
