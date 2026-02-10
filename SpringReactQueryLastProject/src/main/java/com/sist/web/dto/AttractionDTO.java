package com.sist.web.dto;
/*
 *   private int no,contentid;
     private String infocenter,restdate,usetime,parking,msg;
 */
public interface AttractionDTO extends CommonsDetailDTO{
    public String getInfocenter();
    public String getRestdate();
    public String getUsetime();
    public String getParking();
    public String getMsg();
}
