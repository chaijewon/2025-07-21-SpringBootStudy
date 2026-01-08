package com.sist.web.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.web.mapper.*;
import com.sist.web.vo.UserRolesVO;
import com.sist.web.vo.UsersVO;

import lombok.RequiredArgsConstructor;


@Controller
@RequiredArgsConstructor
public class MainController {
   private final PasswordEncoder pEncoder;
   private final UsersMapper mapper;
   
   @GetMapping("/")
   public String main_page() {
	   return "main";
   }
   @GetMapping("/join")
   public String join_page() {
	   return "join";
   }
   @PostMapping("/join")
   public String join_ok_page(@ModelAttribute("vo") UsersVO vo)
   {
	   vo.setPassword(pEncoder.encode(vo.getPassword()));
	   // pwd.match()
	   mapper.usersInsert(vo);
	   UsersVO dbVO=mapper.findByUsername(vo.getUsername());
	   
	   UserRolesVO rvo=new UserRolesVO();
	   rvo.setUser_id(dbVO.getId());
	   rvo.setRole_name("ROLE_USER");
	   mapper.userRolesInsert(rvo);
	   
	   return "redirect:/";
   }
   @GetMapping("/login")
   public String login_page() {
	   return "login";
   }
}
