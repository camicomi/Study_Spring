package com.test.java.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		//403 발생 > handle() > 상대적으로 URI 지정 방식도 더 구체적인 조작
		System.out.println("Access Denied Handler");
		
		// 권한 없는 페이지로 가면 무조건 시작페이지로 
		response.sendRedirect("/index.do");
		
	}

}











