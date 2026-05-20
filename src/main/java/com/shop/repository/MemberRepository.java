package com.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
	//아이디 중복체크 ...
	boolean existsByLoginId(String loginId);
	
	
	//휴대폰 중복체크 
	boolean existsByPhone(String phone);
	
	//로그인용 ...
	Optional<Member> findByLoginId(String loginId);
	
	Optional<Member> findByNameAndPhone(String name, String phone);
	
	// 비밀번호 찾기
    Optional<Member> findByLoginIdAndEmail(String loginId, String email);
	
}
