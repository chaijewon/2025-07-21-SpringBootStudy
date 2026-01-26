package com.sist.test;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*CityGrid city=CityGrid.SEOUL;
        System.out.println(city);
        System.out.println(city.getKrName());
        System.out.println(city.getNx());
        System.out.println(city.getNy());
        */
		/*Scanner scan=new Scanner(System.in);
		System.out.print("지역입력:");
		String name=scan.next();
		CityGrid c=CityGrid.from(name);
		System.out.println(c.getKrName());
        System.out.println(c.getNx());
        System.out.println(c.getNy());*/
		Scanner scan=new Scanner(System.in);
		System.out.print("지역입력:");
		String name=scan.next();
		
		for(CityGrid c:CityGrid.values())
		{
		  if(c.getKrName().equals(name))
		  {
			switch(c)
			{
			  case SEOUL -> System.out.println("서울 날씨");
			  case BUSAN -> System.out.println("부산 날씨");
			  case JEJU -> System.out.println("제주 날씨");
			}
		  }
		}
		
	}

}
