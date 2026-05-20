package com.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//회원가입용 
public class MemberJoinDTO {
	private String loginId;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
}
