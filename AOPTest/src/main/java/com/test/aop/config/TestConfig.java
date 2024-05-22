package com.test.aop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.aop.singleton.TestDAO;

@Configuration
public class TestConfig {

	// 자바 설정 파일 
	
	
	@Bean
	public TestDAO getTestDAO() {
		
		
		return new TestDAO();
		
	}
	
	
}
















