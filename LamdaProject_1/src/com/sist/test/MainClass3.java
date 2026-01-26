package com.sist.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import oracle.jdbc.driver.json.Jsonp;

public class MainClass3 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        Document doc=Jsoup.connect("https://rank.ezme.net").get();
        Elements words=doc.select(".rank_word");
        Elements images=doc.select(".rank_img");
        for(int i=0;i<words.size();i++)
        {
        	String w=words.get(i).text();
        	String img=images.get(i).attr("data-pagespeed-lazy-src");
        	System.out.println(w);
        	System.out.println(img);
        	System.out.println("============================");
        }
        
	}

}
