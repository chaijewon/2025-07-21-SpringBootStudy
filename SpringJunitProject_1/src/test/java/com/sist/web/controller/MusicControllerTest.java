package com.sist.web.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.MusicService;
import com.sist.web.vo.MusicVO;

@WebMvcTest(MusicController.class)
public class MusicControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
	private MusicService mService;
    
	@Test
	@DisplayName("뮤직 페이지 목록 조회")
    void musicList()throws Exception
    {
		System.out.println(mService);
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
    	int page=2;
    	int curpage=page;
    	// 처리된 데이터 읽기 
    	List<MusicVO> list=mService.musicListData((curpage-1)*20);
    	int totalpage=mService.musicTotalPage();
    	// 브라우저로 전송 
    	assertThat(list).isNotNull();
    	//assertThat(list.size()).isLessThan(20);
    	assertThat(list.get(0).getNo()).isGreaterThan(21);
    	System.out.println(list);
    	System.out.println(list.get(0).getNo());
    }
}
