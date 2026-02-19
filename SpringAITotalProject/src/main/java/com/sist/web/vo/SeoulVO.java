package com.sist.web.vo;

import lombok.Data;

/*
 *   NO int 
     TITLE text 
     IMAGE1 text 
     IMAGE2 text 
     X double 
     Y double 
     CONTENTID int 
     ADDRESS text 
     CONTENTTYPE int 
     HIT int
 */
@Data
public class SeoulVO {
   private int no,contentid,contenttype,hit,rank;
   private double x,y;
   private String title,image1,image2,address,color;
}
