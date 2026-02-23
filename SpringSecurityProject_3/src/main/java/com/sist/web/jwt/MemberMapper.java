package com.sist.web.jwt;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	MemberVO findByKakaoId(Long kakaoId);
    void insertKakaoMember(MemberVO vo);
}
