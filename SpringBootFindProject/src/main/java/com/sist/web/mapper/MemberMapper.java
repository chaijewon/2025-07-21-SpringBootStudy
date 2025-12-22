package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.MemberVO;
@Mapper
@Repository
public interface MemberMapper {
  @Select("SELECT COUNT(*) FROM member "
		 +"WHERE id=#{id}")
  public int memberIdCount(String id);
  
  @Select("SELECT id,name,sex,address,pwd FROM member "
		 +"WHERE id=#{id}")
  public MemberVO memberInfoData(String id);
}
