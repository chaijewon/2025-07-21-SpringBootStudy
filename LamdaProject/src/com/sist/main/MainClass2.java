package com.sist.main;
/*
 *   함수형 인터페이스 ⭐
     => 람다식은 함수형 인터페이스에만 사용 가능
     조건
     추상 메서드 1개
     
     @FunctionalInterface 붙이는 이유
       “이 인터페이스는 람다용이다”를 컴파일러에게 명확히 알려주는 안전장치
      람다는 추상 메서드가 1개인 인터페이스에만 사용 가능합니다.
      
      @FunctionalInterface
       interface Calc {
            int sum(int a, int b);

            default int sub(int a, int b) {
             return a - b;
            }

       static void info() {
           System.out.println("Calc Interface");
       }
}
       Calc c = new Calc() {
		    @Override
		    public int sum(int a, int b) {
		        return a + b;
		    }
		};
		👉 문법만 짧아졌을 뿐, 객체는 동일
		
		왜 람다는 빠를까?
		비교	익명      클래스	   람다
		class 파일	생성됨	생성 안 됨
		메모리	큼	작음
		this 참조	내부 클래스	외부 클래스
		재사용	어려움	쉬움
		
		
		**** 객체는 생성되지만, 클래스는 생성되지 않는다
 */
@FunctionalInterface
interface Calc{
	int sum(int a, int b);
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *    Calc c = new Calc() {
				    @Override
				    public int sum(int a, int b) {
				        return a + b;
				    }
				};
		 */
        Calc c = (a,b)->a+b;
        
        System.out.println(c.sum(10,20));
	}

}
