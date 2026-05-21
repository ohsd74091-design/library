package com.shop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration     //cor 설정 <--> 리액트(프론트단)이랑 매칭을 위해합니다(포트 다를시 차단방지!)
public class CorsConfig implements WebMvcConfigurer {
	
	
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
				.allowedOrigins("http://localhost:5173")
				.allowedMethods("GET","POST","PATCH","DELETE","PUT")
				.allowedHeaders("*");
	}
	
	
	

}
