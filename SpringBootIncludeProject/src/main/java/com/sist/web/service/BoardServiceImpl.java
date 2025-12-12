package com.sist.web.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.mapper.*;
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
   private final BoardMapper mapper;

   @Override
   public List<BoardVO> boardListData(int start) {
	// TODO Auto-generated method stub
	return mapper.boardListData(start);
   }

   @Override
   public int boardTotalPage() {
	// TODO Auto-generated method stub
	return mapper.boardTotalPage();
   }
   
   
}
