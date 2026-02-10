package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
 *   NO          NOT NULL NUMBER         
TITLE                VARCHAR2(1024) 
IMAGE1               VARCHAR2(1024) 
IMAGE2               VARCHAR2(1024) 
X                    NUMBER(20,12)  위도
Y                    NUMBER(20,12)  경도 
CONTENTID            NUMBER         상세보기     
ADDRESS              VARCHAR2(300)  
CONTENTTYPE          NUMBER(2)      카테고리 
HIT                  NUMBER 
 */
@Entity
@Table(name="seoultravel")
@Data
public class SeoulTravel {
   @Id
   @Column(name="contentid")
   private int contentid;
   
   private int no;
   private String title;
   private String image1;
   private String image2;
   
   private String address;
   private double x,y;
   private int contenttype,hit;
}
