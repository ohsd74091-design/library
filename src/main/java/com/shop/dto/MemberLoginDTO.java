package com.shop.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
//로그인용 ...
public class MemberLoginDTO {

	private String loginId;
	private String password;
}
