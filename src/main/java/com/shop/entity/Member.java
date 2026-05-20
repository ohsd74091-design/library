package com.shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
	@SequenceGenerator(name = "member_seq", sequenceName = "MEMBER_SEQ",allocationSize = 1)
	private Long id;
	
    @Column(nullable = false, unique = true, length = 50)
    private String loginId;        // 아이디
    @Column(nullable = false)
    private String password;     // 비밀번호 (암호화)
    @Column(nullable = false, length = 20)
    private String name;           // 이름
    @Column(nullable = false, unique = true, length = 20)
    private String phone;          // 휴대폰번호
    @Column(unique = true, length = 100)
    private String email;          // 이메일
    @Column(length = 200)
    private String address;        // 주소
    @Column(name = "created_at")
    private java.time.LocalDateTime createdAt;  // 가입일
   
    @PrePersist //DB에 인서트되기전 자동으로 실행되는 메서드...
    public void prePersist() {
    	this.createdAt= java.time.LocalDateTime.now();
    }

	
}
