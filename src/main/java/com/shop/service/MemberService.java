package com.shop.service;

import com.shop.dto.MemberJoinDTO;
import com.shop.dto.MemberLoginDTO;
import com.shop.dto.MemberResponseDTO;

public interface MemberService {

	//회원가입
	void join(MemberJoinDTO dto);
	 // 아이디 중복체크
    boolean checkLoginId(String loginId);

    // 휴대폰 중복체크
    boolean checkPhone(String phone);

    // 로그인
    MemberResponseDTO login(MemberLoginDTO dto);

    // 아이디 찾기
    String findLoginId(String name, String phone);

    // 비밀번호 찾기
    boolean findPassword(String loginId, String email);
}
