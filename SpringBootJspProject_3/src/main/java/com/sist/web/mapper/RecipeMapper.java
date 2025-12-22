package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
@Mapper
@Repository
public interface RecipeMapper {
   @Select("SELECT no,title,poster,chef "
		  +"FROM recipe "
		  +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail) "
		  +"ORDER BY no ASC "
		  +"OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
   public List<RecipeVO> recipeListData(int start);
   
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
		  +"WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)")
   public int recipeTotalPage();
   
   /*
    *   NO              NUMBER(38)     
POSTER          VARCHAR2(4000) 
TITLE           VARCHAR2(4000) 
CHEF            VARCHAR2(4000) 
CHEF_POSTER     VARCHAR2(4000) 
CHEF_PROFILE    VARCHAR2(4000) 
INFO1           VARCHAR2(26)   
INFO2           VARCHAR2(26)   
INFO3           VARCHAR2(26)   
CONTENT         VARCHAR2(4000) 
FOODMAKE        VARCHAR2(4000)
    */
   @Update("UPDATE recipe SET hit=hit+1 WHERE no=#{no}")
   public void recipeHitIncrement(int no);
   
   @Select("SELECT no,poster,title,chef,chef_poster,chef_profile,"
		  +"info1,info2,info3,content,foodmake "
		  +"FROM recipeDetail "
		  +"WHERE no=#{no}")
   public RecipeDetailVO recipeDetailData(int no);
}
