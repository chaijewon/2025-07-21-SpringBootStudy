package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// router => 화면 변경 
@Controller
public class FoodController {
  @GetMapping("/food/find")
  public String food_find()
  {
	  return "food/find"; // templates/food/find.html
  }
  @GetMapping("/food/detail")
  public String food_detail(@RequestParam("fno") int fno,Model model)
  {
	  model.addAttribute("fno", fno);
	  return "food/detail";
  }
}
