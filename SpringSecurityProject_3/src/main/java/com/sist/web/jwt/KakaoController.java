package com.sist.web.jwt;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KakaoController {
  @GetMapping("/login")
  public String main_main()
  {
	  return "login";
  }
}
