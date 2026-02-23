package com.sist.web.jwt;

import java.util.Collections;
import java.util.Map;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.*;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService
    implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberMapper memberMapper;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest)
            throws OAuth2AuthenticationException {

    	OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate
                = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
        String email = null;
        Map<String, Object> attr = oAuth2User.getAttributes();

        Long kakaoId = (Long) attr.get("id");

        Map<String, Object> account =
            (Map<String, Object>) attr.get("kakao_account");
        /*if(account!=null)
        {
          email = (String) account.get("email");
        }*/
        Map<String, Object> profile =
            (Map<String, Object>) account.get("profile");

        String nickname = (String) profile.get("nickname");

        MemberVO vo = memberMapper.findByKakaoId(kakaoId);

        if (vo == null) {
            vo = new MemberVO();
            vo.setKakaoId(kakaoId);
            //vo.setEmail(email);
            vo.setNickname(nickname);
            memberMapper.insertKakaoMember(vo);
        }

        return new DefaultOAuth2User(
            Collections.singleton(
                new SimpleGrantedAuthority("ROLE_USER")),
            attr,
            "id"
        );
    }
}