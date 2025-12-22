package com.sist.web.service;
import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

import com.sist.web.mapper.*;
@Service
@RequiredArgsConstructor
public class EmpServiceImpl  implements EmpService{
   private final EmpMapper mapper;
   // 구현 

   @Override
   public List<EmpVO> empListData() {
	// TODO Auto-generated method stub
	return mapper.empListData();
   }
}
