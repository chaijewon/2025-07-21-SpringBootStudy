package com.sist.web.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.service.*;
/*
 *    [{"snippet":{"publishTime":"2025-07-11T04:00:07Z",
 *    "publishedAt":"2025-07-11T04:00:07Z",
 *    "description":"BLACKPINK - 뛰어(JUMP) I'm not that easy to tame You should see me under these lights All my tears turn to ice That's the ...",
 *    "title":"BLACKPINK - \u2018뛰어(JUMP)\u2019 M\/V",
 *    "thumbnails":{"default":{"width":120,"url":"https:\/\/i.ytimg.com\/vi\/CgCVZdcKcqY\/default.jpg","height":90},
 *    "high":{"width":480,"url":"https:\/\/i.ytimg.com\/vi\/CgCVZdcKcqY\/hqdefault.jpg","height":360},
 *    "medium":{"width":320,"url":"https:\/\/i.ytimg.com\/vi\/CgCVZdcKcqY\/mqdefault.jpg","height":180}},
 *    "channelId":"UCOmHUn--16B90oW2L6FRR3A","channelTitle":"BLACKPINK","liveBroadcastContent":"none"},
 *    "kind":"youtube#searchResult",
 *    "etag":"jTM7WY0cVOe1Viot_KnbDaYMTLQ",
 *    "id":{"kind":"youtube#video","videoId":"CgCVZdcKcqY"}},
 *

 */
@Controller
@RequiredArgsConstructor
public class MusicController {
    private final MusicService mService;
    
    @GetMapping("/")
    public String music_list(
      @RequestParam(name="page",required = false) String page,
      Model model  /* 전송 객체*/
    )
    {
    	/*
    	 *   1. 사용자가 보내준 데이터 받기 => 매개변수로 처리
    	 *   --------------------------------------
    	 *   2. 데이터베이스 연동 / 크롤링 / Spring AI 
    	 *      => 요청처리에 필요한 데이터 읽기 
    	 *   --------------------------------------
    	 *   3. 데이터를 브라우저로 전송 
    	 *   4. 어떤 JSP로 전송할 지 설정 
    	 *   
    	 *   => 1. 개발 
    	 *         => 웹 개발 
    	 *         => 3년 => 본인의 개발  SI 
    	 */
    	// 요청 처리 
    	if(page==null)
    		page="1";
    	int curpage=Integer.parseInt(page);
    	// 처리된 데이터 읽기 
    	List<MusicVO> list=mService.musicListData((curpage-1)*20);
    	int totalpage=mService.musicTotalPage();
    	// 브라우저로 전송 
    	model.addAttribute("list", list);
    	model.addAttribute("curpage", curpage);
    	model.addAttribute("totalpage", totalpage);
    	// 어떤 JSP로 출력 
        return "list";	
    }
    @GetMapping("/detail")
    public String music_detail(
      @RequestParam("no") int no,
      Model model
    )throws Exception
    {
    	String title=mService.musicGetTitle(no);
    	System.out.println("title="+title);
    	String s="https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=28&q="+URLEncoder.encode(title,"UTF-8")+"&type=video&key=AIzaSyCjkIwifNo8t4OGYoxVIyUAoATzIFjEK34";
    	URL url=new URL(s);
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    	StringBuffer sb=new StringBuffer();
    	if(conn!=null)
    	{
    		BufferedReader in=
    				new BufferedReader(
    					new InputStreamReader(conn.getInputStream(),"UTF-8"));
    		
    		while(true)
    		{
    			String json=in.readLine();
    			if(json==null)
    				break;
    			sb.append(json);
    			//System.out.println(json);
    		}
    		conn.disconnect();
    		in.close();
    	}
    	//System.out.println(sb.toString());
    	//Document doc=Jsoup.connect("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=12&q="+title+"&type=video&key=AIzaSyCjkIwifNo8t4OGYoxVIyUAoATzIFjEK34").get();
    	//System.out.println(doc.toString());
    	JSONParser jp=new JSONParser();
    	JSONObject root=(JSONObject)jp.parse(sb.toString());
    	//.out.println(root.toJSONString());
    	JSONArray arr=(JSONArray)root.get("items");
    	List<MovieVO> list=new ArrayList<MovieVO>();
    	for(int i=0;i<arr.size();i++)
    	{
    		JSONObject obj=(JSONObject)arr.get(i);
    		JSONObject snippet=(JSONObject)obj.get("snippet");
    		String name=(String)snippet.get("title");
    		//System.out.println(name);
    		JSONObject id=(JSONObject)obj.get("id");
    		String key=(String)id.get("videoId");
    		
    		MovieVO vo=new MovieVO();
    		vo.setTitle(title);
    		vo.setKey(key);
    		list.add(vo);
    	}
    	model.addAttribute("list", list);
    	//System.out.println(arr.toJSONString());
    	return "detail";
    }
	/*
	 * @GetMapping("/map") public String map_page() { return "map"; }
	 */
}
