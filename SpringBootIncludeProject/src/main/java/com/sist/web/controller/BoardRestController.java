package com.sist.web.controller;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import groovyjarjarantlr4.v4.parse.ANTLRParser.exceptionGroup_return;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor

/*
 *    @RequiredArgsConstructor
 *    class A
 *    {
 *       @Autowired 
 *       private B b;
 *       
 *       @Autowired 
 *       public A(B b)
 *       {
 *       }
 *    }
 *    
 *    => 1. @RestController 
 *          | 자바스크립트 / 모바일 연동 => 데이터만 전송 
 *            ---------
 *            | router : react / vue 
 *              ------
 *              vue연동 : cnd (vuex , pinia) 
 *       2. @RequiredArgsConstructor
 *           생성자에서 @Autowired
 *       3. @CrossOrigin(origins = "*") : port가 다른 경우 
 *           port 허용 
 *       4. @RequestParam => 한개의 요청값 
 *          @ModelAttribute => VO단위로 값을 받는 경우 
 *          @RequestBody => JSON으로 받는 경우 = 객체 변환 
 *              
 */
@CrossOrigin(origins = "*")
public class BoardRestController {
    private final BoardService bService;
    
    @GetMapping("/board/list_vue/")
    public ResponseEntity<Map> board_list_vue(
      @RequestParam("page") int page
    )
    {
    	Map map=new HashMap();
    	try
    	{
    		 List<BoardVO> list=bService.boardListData((page*10)-10);
    		 int totalpage=bService.boardTotalPage();
    		 
    		 map.put("list", list);
    		 map.put("curpage", page);
    		 map.put("totalpage", totalpage);
    		 
    	}catch(Exception ex)
    	{
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return new ResponseEntity<>(map,HttpStatus.OK);
    }
    
    @GetMapping("/board/detail_vue/")
    public ResponseEntity<BoardVO> board_detail_vue(
      @RequestParam("no") int no)
    {
    	BoardVO vo=new BoardVO();
    	try
    	{
    		 vo=bService.boardDetailData(no);
    		 
    	}catch(Exception ex)
    	{
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return new ResponseEntity<>(vo,HttpStatus.OK);
    }
    // 글쓰기 vuex => pinia(개인 프로젝트) 
    
    @PostMapping("/board/insert_vue/")
    public ResponseEntity<Map> board_insert_vue(
      @RequestBody BoardVO vo
    )
    {
    	Map map=new HashMap();
    	try
    	{
    		bService.boardInsert(vo);
    		map.put("msg", "yes");
    	}catch(Exception ex)
    	{
    		map.put("msg", "no");
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return new ResponseEntity<>(map,HttpStatus.OK);
    }
    @PostMapping("/board/update_vue/")
    public ResponseEntity<Map> board_update_vue(
    	@RequestBody BoardVO vo
    )
    {
    	System.out.println("번호:"+vo.getNo());
    	System.out.println("이름:"+vo.getName());
    	System.out.println("제목:"+vo.getSubject());
    	System.out.println("내용:"+vo.getContent());
    	System.out.println("비번:"+vo.getPwd());
    	Map map=new HashMap();
    	try
    	{
    		boolean bCheck=bService.boardUpdate(vo);
    		if(bCheck==true)
    		{
    			map.put("msg", "yes");
    		}
    		else
    		{
    			map.put("msg", "no");
    		}
    	}catch(Exception ex)
    	{
    		return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	return new ResponseEntity<>(map,HttpStatus.OK);
    }
     
}
