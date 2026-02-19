package com.sist.web.vo;

import lombok.Data;

/*
 *   no int AI PK 
loc varchar(100) 
recomm text
 */
@Data
public class RecommandVO {
  private int no;
  private String loc,recomm;
}
