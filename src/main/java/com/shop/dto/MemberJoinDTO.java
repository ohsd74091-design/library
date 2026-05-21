package com.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
