package com.sist.web.controller;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.web.service.*;
import com.sist.web.vo.*;

@Controller
// Vue => 데이터 받기 / 화면 이동 => Spring 
// Router => Vue router
public class FoodController {
   
   @GetMapping("/food/list")
   public String food_list()
   {
	   return "food/list";
   }
}
