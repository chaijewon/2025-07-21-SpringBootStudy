package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecipeController {
   @GetMapping("/recipe/list")
   public String recipe_list()
   {
	   return "recipe/list";
   }
}
