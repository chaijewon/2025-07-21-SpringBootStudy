package com.sist.web.mapper;
/*
 *    <select id="musicListData" resultType="com.sist.web.vo.MusicVO">
   SELECT no,cno,title,singer,album,poster,state,idcrement
   FROM genie_music 
   ORDER BY no ASC
   LIMIT #{start},20
  </select>
  <select id="musicTotalPage" resultType="int">
    SELECT CEIL(COUNT(*)/20.0) FROM genie_music
  </select>
 */
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
@Mapper
@Repository
public interface MusicMapper {
   /*
    *     <select id="musicListData" resultType="com.sist.web.vo.MusicVO">
		   SELECT no,cno,title,singer,album,poster,state,idcrement
		   FROM genie_music 
		   ORDER BY no ASC
		   LIMIT #{start},20
		  </select>
    */
	public List<MusicVO> musicListData(int start);
	// interface는 Only public 
	/*
	 *   <select id="musicTotalPage" resultType="int">
          SELECT CEIL(COUNT(*)/20.0) FROM genie_music
         </select>
	 */
	public int musicTotalPage();
	/*
	 *   <select id="musicGetTitle" resultType="string">
		    SELECT title FROM genie_music
		    WHERE no=#{no}
		  </select>
	 */
	public String musicGetTitle(int no);
}
