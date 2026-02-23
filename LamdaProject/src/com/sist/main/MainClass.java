package com.sist.main;
/*
 *   람다식이란?
       1. 람다식 = 익명 함수
       2. 메서드를 값처럼 전달
       3. 코드 간결화
       4. 함수형 프로그래밍 스타일
       
       기본문법 
         => (매개변수) -> { 실행문 }
       축약 규칙
       규칙        	예
       타입 생략	(int a) → (a)
       매개변수 1개	(a) → a
       한 줄 실행	{ return a+1; } → a+1
       예: (a, b) -> a + b
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	/*Runnable r=new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				    System.out.println("쓰레드 실행");	
				}
			};*/
        	Runnable r=()->System.err.println("쓰레드 실행2");
			
			new Thread(r).start();
        }catch(Exception ex) {}
	}

}
