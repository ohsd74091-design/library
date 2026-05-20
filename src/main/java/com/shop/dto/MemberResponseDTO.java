package com.shop.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//응답용 (비밀번호 제외 .....)
public class MemberResponseDTO {
	 private Long id;
	    private String loginId;
	    private String name;
	    private String phone;
	    private String email;
	    private String address;
	    private LocalDateTime createdAt;
}
