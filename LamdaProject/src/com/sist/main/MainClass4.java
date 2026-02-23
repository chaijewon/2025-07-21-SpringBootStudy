package com.sist.main;
/*
 *   1️⃣ 람다식이 필요한 이유 (Before → After)
		예제 1: 스레드 실행
		❌ 기존 방식
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("작업 실행");
		    }
		}).start();
		
		✅ 람다식
		new Thread(() -> System.out.println("작업 실행")).start();
		
		
		✔ 익명 클래스 제거 → 코드 절반 이하
		
		2️⃣ 매개변수 있는 람다식
		예제 2: 두 수 더하기
		함수형 인터페이스
		@FunctionalInterface
		interface Calc {
		    int add(int a, int b);
		}
		
		람다 사용
		Calc c1 = (int a, int b) -> {
		    return a + b;
		};
		
		Calc c2 = (a, b) -> a + b;
		
		System.out.println(c2.add(3, 5)); // 8
		
		
		✔ 타입, return, 중괄호 생략 가능
		
		3️⃣ 컬렉션 반복 처리
		예제 3: 리스트 출력
		❌ for문
		List<String> list = List.of("A", "B", "C");
		
		for (String s : list) {
		    System.out.println(s);
		}
		
		✅ 람다식
		list.forEach(s -> System.out.println(s));
		
		✅ 더 줄이기 (메서드 참조)
		list.forEach(System.out::println);
		
		4️⃣ 조건 처리 (Predicate)
		예제 4: 짝수만 출력
		List<Integer> nums = List.of(1,2,3,4,5,6);
		
		nums.stream()
		    .filter(n -> n % 2 == 0)
		    .forEach(System.out::println);
		
		
		✔ n -> n % 2 == 0 이 조건 함수
		
		5️⃣ 값 변환 (Function)
		예제 5: 문자열 길이 변환
		List<String> words = List.of("java", "spring", "security");
		
		words.stream()
		     .map(w -> w.length())
		     .forEach(System.out::println);
		
		
		➡ String → Integer 변환
		
		6️⃣ 실무형 예제 (메뉴 권한 처리)
		예제 6: ADMIN 메뉴만 추출
		List<Map<String, Object>> menuList = getMenuList();
		
		menuList.stream()
		        .filter(m -> m.get("roles").toString().contains("ADMIN"))
		        .forEach(m -> System.out.println(m.get("menu_name")));
		
		7️⃣ 정렬 (Comparator)
		예제 7: 길이 기준 정렬
		List<String> list = List.of("java", "spring", "boot");
		
		list.stream()
		    .sorted((a, b) -> a.length() - b.length())
		    .forEach(System.out::println);
		
		8️⃣ Optional + 람다
		예제 8: null 체크 제거
		❌ 기존
		String name = getName();
		if (name != null) {
		    System.out.println(name.toUpperCase());
		}
		
		✅ 람다 + Optional
		Optional.ofNullable(getName())
		        .map(n -> n.toUpperCase())
		        .ifPresent(System.out::println);
		
		9️⃣ 외부 변수 사용 (주의)
		예제 9: 컴파일 에러
		int sum = 0;
		
		list.forEach(n -> {
		    sum += n; // ❌ 에러
		});
		
		
		✔ 람다 안에서는 변수 변경 불가
		
		🔟 람다 vs 메서드 참조
		예제 10: 출력
		list.forEach(s -> System.out.println(s));
		
		
		⬇
		
		list.forEach(System.out::println);
		
		
		✔ 기능 동일, 표현만 간결
		
		1️⃣1️⃣ 언제 람다를 쓰면 좋은가?
		
		✅ 한 줄 로직
		✅ 조건 / 변환 / 소비 로직
		❌ 복잡한 비즈니스 로직
		❌ 디버깅이 중요한 코드
		
		람다식은 “작은 동작을 코드 블록 없이 바로 전달하기 위한 문법”이다.
 */
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
