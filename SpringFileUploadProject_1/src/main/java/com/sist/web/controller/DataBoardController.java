package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
@Controller
@RequestMapping("databoard/")
@RequiredArgsConstructor
public class DataBoardController {
   private final DataBoardService dService;
   
   @GetMapping("list")
   public String databoard_list(
     @RequestParam(name="page",required = false) String page,
     Model model
   )
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<DataBoardVO> list=
			   dService.databoardListData((curpage-1)*10);
	   int totalpage=dService.databoardTotalPage();
	   
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "databoard/list";
   }
   // insert => 업로드  
   @GetMapping("insert")
   public String databoard_insert()
   {
	   return "databoard/insert";
   }
   @PostMapping("insert_ok")
   public String databoard_insert_ok(@ModelAttribute DataBoardVO vo,
     HttpServletRequest request
   )
   throws Exception
   {
	   String uploadDir=request.getServletContext().getRealPath("/upload");
	   List<MultipartFile> files=vo.getFiles();
	   String filename="";
	   String filesize="";
	   for(MultipartFile file:files)
	   {
		   if(file.isEmpty())
		   {
			   vo.setFilename("");
			   vo.setFilesize("");
			   vo.setFilecount(0);
		   }
		   else
		   {
			  String oname=file.getOriginalFilename();
			  File f=new File(uploadDir+"/"+oname);
			  // 중복 확인 
			   
		   }
		   
	   }
	   
	   return "redirect:/databoard/list";
   }
}
