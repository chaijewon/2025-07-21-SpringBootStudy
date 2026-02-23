package com.sist.main;

import java.util.stream.Collectors;

public class MainClass6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str="""
        		  오전 11:00 | 서울식물원
                  거대한 온실과 호수원을 산책하며 이국적인 식물 감상
                  오후 01:30 | 마곡나루역 인근 맛집 탐방
                  마곡의 깔끔하고 트렌디한 식당가에서 점심 식사
                  오후 03:00 | LG아트센터 서울 또는 스페이스K 서울
                  세계적인 건축가 안도 다다오가 설계한 공연장 구경 혹은 컨템포러리 미술 전시 관람
                  오후 05:00 | 국립항공박물관
                  비행기의 역사와 실물 항공기 전시 관람 (가족/아이 동반 추천)
        		""";
           String result = str.lines() // 1. 한 줄씩 스트림으로 변환
                .filter(line -> line.contains("|")) // 2. '|'가 포함된 줄만 필터링
                .map(line -> line.split("\\|")[1].trim()) // 3. '|' 기준으로 나누고 뒤쪽 문자열 공백 제거
                .collect(Collectors.joining("\n")); // 4. 다시 줄바꿈으로 합치기

            System.out.println(result);
	}

}
