package com.sist.main;
/*
 *    자바 기본 함수형 인터페이스 
 *    Runnable	실행	run()
      Supplier<T>	공급	get()
      Consumer<T>	소비	accept(T)
      Function<T,R>	변환	apply(T)
      Predicate<T>	조건	test(T)
      
      람다 + 컬렉션
      for (String s : list) {
        System.out.println(s);
      } 
      
      list.forEach(s -> System.out.println(s));
      ***메소드 참조 
      list.forEach(System.out::println);
      
      주요 연산
      중간	filter, map, sorted, distinct
      최종	forEach, collect, count
      
      
      메뉴 목록에서 URL만 추출
		List<String> urls =
		    menuList.stream()
		            .map(m -> m.get("menu_url").toString())
		            .collect(Collectors.toList());
      ADMIN 메뉴만 필터링
       menuList.stream()
        .filter(m -> m.get("roles").toString().contains("ADMIN"))
        .forEach(System.out::println);
 */
import java.util.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = List.of("kim", "lee", "park");

		/*names.stream()
		     .filter(n -> n.startsWith("k"))
		     .map(String::toUpperCase)
		     .forEach(System.out::println);*/
		
	}

}
