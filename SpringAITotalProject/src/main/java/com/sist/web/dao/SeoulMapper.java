package com.sist.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SeoulMapper {
  @Select("SELECT title FROM seoultravel")
  public List<String> seoulGetTitle();
}
