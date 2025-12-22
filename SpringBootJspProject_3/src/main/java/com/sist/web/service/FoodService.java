package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.FoodVO;
// Repository VS Service의 차이점 
public interface FoodService {
	public List<FoodVO> foodListData(int start);
	public int foodTotalPage();
}
