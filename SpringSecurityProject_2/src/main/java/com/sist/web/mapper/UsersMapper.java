package com.sist.web.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;
/*
 *      ID       NOT NULL NUMBER        
		USERNAME NOT NULL VARCHAR2(50)  
		PASSWORD NOT NULL VARCHAR2(300) 
		ENABLED           NUMBER(1)
		ROLE_NAME
		
		user  / admin
		        | ROLE_ADMIN , ROLE_USER 
		 | ROLE_USER
 */
@Mapper
@Repository
public interface UsersMapper {
  @Insert("INSERT INTO users(username,password) VALUES(#{username},#{password})")
  public void usersInsert(UsersVO vo);
  
  @Select("SELECT * FROM users WHERE username=#{username}")
  public UsersVO findByUsername(String username);
  
  @Select("SELECT role_name FROM user_role WHERE user_id=#{userId}")
  public List<String> findRolesByUserId(int userId);
  
  //로그인 ...
}
