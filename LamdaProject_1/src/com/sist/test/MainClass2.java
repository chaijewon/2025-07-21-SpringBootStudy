package com.sist.test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
        System.out.println(LocalTime.now().format(DateTimeFormatter.ofPattern("HH00")));
        String city="SEOUL";
        String s=String.format("""
        		 sfsfsfsf %s
        		 sfsfsfsf
        		 sfsfsfsf
        		 sfsfsfsf
        		""",city);
        System.out.println(s);
	}

}
