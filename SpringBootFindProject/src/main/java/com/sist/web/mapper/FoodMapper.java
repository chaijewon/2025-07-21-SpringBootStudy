package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
@Mapper
@Repository
public interface FoodMapper {
  /*
   *   <select id="foodListData" resultType="com.sist.web.vo.FoodVO"
	   parameterType="hashmap"
	  >
	  SELECT fno,name,poster,address,num
	  FROM (SELECT fno,name,poster,address,rownum as num
	  FROM (SELECT fno,name,poster,address
	  FROM menupan_food ORDER BY fno ASC))
	  WHERE num BETWEEN #{start} AND #{end}
	  </select>
   */
	// => selectList
	public List<FoodVO> foodListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM menupan_food")
	public int foodTotalPage();
}
