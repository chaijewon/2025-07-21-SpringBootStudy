package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// router => 화면 변경 
@Controller
public class FoodController {
  @GetMapping("/food/find")
  public String food_find()
  {
	  return "food/find"; // templates/food/find.html
  }
}
