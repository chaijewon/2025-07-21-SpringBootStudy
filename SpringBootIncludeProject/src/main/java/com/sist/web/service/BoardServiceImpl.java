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

   @Override
   public BoardVO boardDetailData(int no) {
	// TODO Auto-generated method stub
	mapper.hitIncrement(no);
	return mapper.boardDetailData(no);
   }

   @Override
   public void boardInsert(BoardVO vo) {
	// TODO Auto-generated method stub
	 mapper.boardInsert(vo);
   }

   @Override
   public BoardVO boardUpdateData(int no) {
	// TODO Auto-generated method stub
	return mapper.boardDetailData(no);
   }

   @Override
   public boolean boardUpdate(BoardVO vo) {
	// TODO Auto-generated method stub
	   boolean bCheck=false;
	   String db_pwd=mapper.boardGetPassword(vo.getNo());
	   if(db_pwd.equals(vo.getPwd()))
	   {
		   bCheck=true;
		   mapper.boardUpdate(vo);
	   }
	   return bCheck;
   }
   
   
}
