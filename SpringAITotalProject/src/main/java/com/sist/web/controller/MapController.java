package com.sist.web.controller;

import java.util.ArrayList;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.AIService;
import com.sist.web.service.SeoulService;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MapController {
  private final SeoulService sService;
  private final AIService aService;
  /*private String data="""
자연 및 공원
하늘공원
노을공원
문화비축기지
난지한강공원
경의선 숲길 (연트럴파크)
망원한강공원
문화 및 쇼핑
홍대 걷고싶은거리
망원시장
연남동 공방거리
상수동 카페거리
메세나폴리스
역사 및 랜드마크
절두산 순교성지
양화진 외국인선교사묘원
광흥창터
  		              """;*/
  @RequestMapping("/")
  public String map_page(@RequestParam(value = "title",required = false) String title , Model model)
  {
	  if(title==null)
		  title="성수동";
	  
	  List<String> titles=sService.seoulGetTitle();
	  //System.out.println(titles);
	  String result="";
	  try
	  {
		  Pattern[] p=new Pattern[titles.size()];
		  for(int i=0;i<p.length;i++)
		  {
			  
			  p[i]=Pattern.compile(titles.get(i)); // 단어 패턴 
		  }
		  
		  //Matcher[] m=new Matcher[titles.size()];
		  String data=aService.aiChat(title);

		  String[] ss=data.split("\n");
		  int i=0;
		  List<String> res=new ArrayList<String>();
		  for(String str:ss)
		  {
			  System.out.println(str);
			  for(int j=0;j<p.length;j++)
			  {
			      Matcher m=p[j].matcher(str);
			      while(m.find())
			      {
				    String k=m.group();
				    if(k.length()>1)
				    {
				      res.add(k);
				      System.out.println(k);
				    }
			      }
			  }
			  i++;
		  }
		  
		  
		  List<String> rList=new ArrayList<String>(new HashSet<String>(res));
		  List<SeoulVO> sList=new ArrayList<SeoulVO>();
		  for(int k=0;k<rList.size();k++)
		  {
			  SeoulVO vo=sService.seoulData(rList.get(k));
			  vo.setRank(k+1);
			  vo.setColor("#ff4c4c");
			  sList.add(vo);
		  }
		  
		  model.addAttribute("list", sList);
	  }catch(Exception ex) {
		  ex.printStackTrace();
	  }
	  return "map";
  }
}
