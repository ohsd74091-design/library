package com.shop.service;

import org.springframework.stereotype.Service;

import com.shop.dto.MemberJoinDTO;
import com.shop.dto.MemberLoginDTO;
import com.shop.dto.MemberResponseDTO;
import com.shop.entity.Member;
import com.shop.repository.MemberRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

	private final MemberRepository memberRepository;
	
	//회원가입 로직 ...
	@Override
	public void join(MemberJoinDTO dto) {
		Member member=Member.builder()
				.loginId(dto.getLoginId())
				.password(dto.getPassword())
				.name(dto.getName())
				.phone(dto.getPhone())
				.email(dto.getEmail())
				.address(dto.getAddress())
				.build();
		memberRepository.save(member);
		
	}

	@Override
	public boolean checkLoginId(String loginId) {
		
		return memberRepository.existsByLoginId(loginId);
	}

	@Override
	public boolean checkPhone(String phone) {
		return memberRepository.existsByPhone(phone);
	}

	@Override
	public MemberResponseDTO login(MemberLoginDTO dto) {
		Member member= memberRepository.findByLoginId(dto.getLoginId())
				.orElseThrow(() -> new RuntimeException("존재하지않는 아이디입니다"));
		
		if(!dto.getPassword().equals(member.getPassword())) {
			throw new RuntimeException("비밀번호가 일치하지않습니다!!");
		}
		return MemberResponseDTO.builder()
				.id(member.getId())
				.loginId(member.getLoginId())
				.name(member.getName())
				.phone(member.getPhone())
				.email(member.getEmail())
				.address(member.getAddress())
				.createdAt(member.getCreatedAt())
				.build();
	}

	@Override
	public String findLoginId(String name, String phone) {
		Member member= memberRepository.findByNameAndPhone(name, phone)
				.orElseThrow(()-> new RuntimeException("일치하는 회원이 없습니다.."));
		return member.getLoginId();
	}

	@Override
	public boolean findPassword(String loginId, String email) {
	
		return memberRepository.findByLoginIdAndEmail(loginId, email).isPresent();
	}
	

}
