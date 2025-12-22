package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serial;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
@Repository
public interface FoodMapper {
   /*
    *   <select id="foodListData" resultType="com.sist.web.vo.FoodVO"
		    parameterType="int"
		   >
		     SELECT fno,name,poster,address 
		     FROM menupan_food
		     ORDER BY fno ASC
		     OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY
		   </select>
		   
		 resultType : 리턴형 => 여러개인 경우 (List) 한개 : FoodVO
		                         = selectList         selectOne
		 parameterType : 매개변수 
		 id : 메소드명 
    */
	public List<FoodVO> foodListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalPage();
	/*
	 *   @Controller 
	 *     => 매개변수 
	 *        int / String => 그대로 처리 
	 *     => 체크박스 : String[]
	 *     => <input type=text name="name[0]">
	 *        <input type=text name="name[1]">
	 *        <input type=text name="name[2]">
	 *        => List => file업로드 여러개 
	 */
}









