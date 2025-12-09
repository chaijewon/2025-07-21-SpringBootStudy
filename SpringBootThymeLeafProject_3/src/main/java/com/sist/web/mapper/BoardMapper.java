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
	/*
	 *   <update id="boardHitIncrement" parameterType="int">
		    UPDATE springReplyBoard SET
		    hit=hit+1
		    WHERE no=#{no}
		  </update>
		  <select id="boardDetailData" resultType="com.sist.web.vo.BoardVO"
		   parameterType="int"
		  >
		    SELECT no,name,subject,content,hit,
		           TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday
		    FROM springReplyBoard
		    WHERE no=#{no}
		  </select>
	 */
	public BoardVO boardDetailData(int no);
	public void boardHitIncrement(int no);
	/*
	 *   <select id="boardGetPassword" resultType="string"
		   parameterType="int"
		  >
		   SELECT pwd FROM springReplyBoard
		   WHERE no=#{no}
		  </select>
		  <update id="boardUpdate" parameterType="com.sist.web.vo.BoardVO">
		   UPDATE springReplyBoard SET
		   name=#{name} , subject=#{subject}, content=#{content}
		   WHERE no=#{no}
		  </update>
	 */
	public String boardGetPassword(int no);
	public void boardUpdate(BoardVO vo);
}
