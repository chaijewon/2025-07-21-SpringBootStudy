package com.sist.web.jwt;
import java.util.*;

import lombok.Data;
@Data
public class MemberVO {
	private Long id;
    private Long kakaoId;

    private String nickname;
    private String role;
    private Date joinDate;
}
