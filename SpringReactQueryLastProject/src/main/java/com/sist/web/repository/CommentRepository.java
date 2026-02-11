package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.CommentEntity;
import java.util.*;
import com.sist.web.dto.*;
public interface CommentRepository extends JpaRepository<CommentEntity, Integer>{
   @Query(value="SELECT no,cno,id,name,msg,TO_CHAR(regdate,'YYYY-MM-DD HH24:MI:SS') as dbday "
		       +"FROM comment_0 "
		       +"WHERE cno=:contentid "
		       +"ORDER BY no DESC",nativeQuery = true)
   public List<CommentDTO> commentListData(@Param("contentid") int contentid);
   
   @Query(value="SELECT NVL(MAX(no)+1,1) FROM comment_0",nativeQuery = true)
   public int maxNo();
   
   public CommentEntity findByNo(int no); // update 
}
