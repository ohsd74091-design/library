package com.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.MemberJoinDTO;
import com.shop.dto.MemberLoginDTO;
import com.shop.dto.MemberResponseDTO;
import com.shop.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	
	
	//회원가입 
	@PostMapping("/join")
	public String join(@RequestBody MemberJoinDTO dto) {
		memberService.join(dto);
		return "회원가입성공";
	}
	
	//아이디 중복체크 
	@GetMapping("/check/loginId/{loginId}")
	public boolean checkLoginId(@PathVariable String loginId) {
		return memberService.checkLoginId(loginId);
	}
	
	//휴대폰 중복체크
	@GetMapping("/check/phone/{phone}")
	public boolean checkPhone(@PathVariable String phone) {
		return memberService.checkPhone(phone);
	}

	
	//로그인 
	@PostMapping("/login")
	public MemberResponseDTO login(@RequestBody MemberLoginDTO dto) {
		return memberService.login(dto);
	}
	
	
	
	//아이디찾기
	@GetMapping("find/loginId")
	public String findLoginId(@RequestParam String name,
			@RequestParam String phone) {
		
		return memberService.findLoginId(name, phone);
	}
	
	//비밀번호 찾기 
	@GetMapping("/find/password")
	public boolean findPassword(@RequestParam String loginId,
			@RequestParam String email) {
		return memberService.findPassword(loginId, email);
	}
	
	
}
