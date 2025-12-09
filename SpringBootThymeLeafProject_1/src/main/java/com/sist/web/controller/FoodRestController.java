package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;
@RestController
@CrossOrigin(origins = "*")
public class FoodRestController {
  @Autowired
  private FoodService fService;
  
  @GetMapping("/food/list_vue/")
  public Map food_list(@RequestParam(name="page",required=false) String page)
  {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   Map map=new HashMap();
	   map.put("start", start);
	   map.put("end", end);
	   List<FoodVO> list=fService.foodListData(map);
	   int totalpage=fService.foodTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   /*
	    *   curpage 1~10 ==> startPage 1
	    *   curpage 11~20 ==> startPage 11
	    *   
	    *   curpage 1~10 ==> endPage 10
	    *   curpage 11~20 ==> ennPagg 20
	    */
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
	       endPage=totalpage;
	   
	   // thymeLeaf로 값 전송 
	   map.put("list", list);
	   map.put("curpage", curpage);
	   map.put("totalpage", totalpage);
	   map.put("startPage", startPage);
	   map.put("endPage", endPage);
	   
	   return map; // forward 
  }
  @GetMapping("/food/detail_vue/")
  public FoodVO food_detail(@RequestParam("fno") int  fno)
  {
	  FoodVO vo=fService.foodDetailData(fno);
	  return vo;
  }
}
