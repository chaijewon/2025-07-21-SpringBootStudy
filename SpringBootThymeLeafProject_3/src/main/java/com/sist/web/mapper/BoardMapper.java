package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.*;
import com.sist.web.vo.*;
@Mapper
@Repository
public interface BoardMapper {
   /*
    *   <select id="boardListData" resultType="com.sist.web.vo.BoardVO"
		  parameterType="hashmap"
		 >
		   SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,num 
		   FROM (SELECT no,subject,name,regdate,hit,rownum as num 
		   FROM (SELECT no,subject,name,regdate,hit
		   FROM springReplyBoard ORDER BY group_id DESC , group_step ASC))
		   WHERE num BETWEEN #{start} AND #{end}
		 </select>
		 <select id="boardRowCount" resultType="int">
		   SELECT COUNT(*) FROM springReplyBoard
		 </select>
		 <insert id="boardInsert" parameterType="com.sist.web.vo.BoardVO">
		   INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id)
		   VALUES(srb_no_seq.nextval,#{name},#{subject},
		   #{content},#{pwd},(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))
		 </insert>
    */
	public List<BoardVO> boardListData(Map map);
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
}
