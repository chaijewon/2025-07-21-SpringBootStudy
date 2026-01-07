package com.sist.web.controller;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class FoodController {
   private final FoodService fService;
   
   @GetMapping("/list")
   public String food_list(
     @RequestParam(name="page",required = false) String page,
     Model model
   )
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   map.put("pStart", (curpage-1)*12);
	   List<FoodVO> list=fService.foodListData(map);
	   int totalpage=fService.foodTotalPage();
	   
	   model.addAttribute("list", list);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("curpage", curpage);
	   
	   return "list";
   }
   @GetMapping("/detail")
   public String food_detail(
	@RequestParam("fno") int fno,
	Model model
   )
   {
	   Map map=new HashMap();
	   map.put("pNo", fno);
	   FoodVO vo=fService.foodDetailData(map);
	   System.out.println(vo);
	   model.addAttribute("vo", vo);
	   return "detail";
   }
}
