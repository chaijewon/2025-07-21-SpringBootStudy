package com.sist.web.vo;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class BoardVO {
   private int no,hit;
   private String name,subject,content,pwd,dbday;
   private String regdate;
   
}
