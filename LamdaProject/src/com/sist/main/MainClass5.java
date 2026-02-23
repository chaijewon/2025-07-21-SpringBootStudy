package com.sist.main;
/*
 *   필터링 
 *   
 *   ❌ Before
		List<User> admins = new ArrayList<>();
		for (User u : users) {
		    if ("ADMIN".equals(u.getRole())) {
		        admins.add(u);
		    }
		}
		
		✅ After
		List<User> admins =
		    users.stream()
		         .filter(u -> "ADMIN".equals(u.getRole()))
		         .toList();
      특정 필드 추출 
		List<String> names =
		    users.stream()
		         .map(User::getName)
		         .toList();
		         
	  중복 제거 (distinct)
		List<String> roles =
		    users.stream()
		         .map(User::getRole)
		         .distinct()
		         .toList();
		         
	  정렬 (sorted)
		나이 오름차순
		users.stream()
		     .sorted(Comparator.comparing(User::getAge))
		     .forEach(System.out::println);
		
		나이 내림차순
		users.stream()
		     .sorted(Comparator.comparing(User::getAge).reversed())
		     .forEach(System.out::println);
		     
	  전체 합계 / 평균 (reduce)
		합계
		int totalAge =
		    users.stream()
		         .map(User::getAge)
		         .reduce(0, Integer::sum);
		
		평균
		double avgAge =
		    users.stream()
		         .mapToInt(User::getAge)
		         .average()
		         .orElse(0);
	    첫 번째 값 찾기 (findFirst)
		User firstUser =
		    users.stream()
		         .filter(u -> u.getAge() >= 30)
		         .findFirst()
		         .orElse(null);
		 그룹핑 (groupingBy) ⭐⭐⭐
			역할별 사용자 묶기
			Map<String, List<User>> usersByRole =
			    users.stream()
			         .collect(Collectors.groupingBy(User::getRole));
 */
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
