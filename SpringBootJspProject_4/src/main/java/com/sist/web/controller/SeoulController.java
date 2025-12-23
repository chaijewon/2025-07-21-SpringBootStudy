package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// => 화면 변경 => router
@Controller
public class SeoulController {
  @GetMapping("/seoul")
  public String seoul_location(Model model) {
	  
	  model.addAttribute("seoul_jsp", "../seoul/location.jsp");
	  model.addAttribute("main_jsp", "../seoul/seoul_main.jsp");
	  return "main/main";
  }
}
