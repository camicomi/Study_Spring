package com.test.security.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		
		System.out.println("Login Success");
		
		
		//권한별 처리
		//- 회원 > /member.do
		//- 관리자 > /admin.do
		
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(authority -> {
			//System.out.println(authority.getAuthority());
			roleNames.add(authority.getAuthority());
		});
		
		System.out.println("로그인 계정의 권한 >>> " + roleNames);
		
		if (roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/security/admin.do");
			return;
		}
		
		if (roleNames.contains("ROLE_MEMBER")) {
			response.sendRedirect("/security/member.do");
			return;
		}		
		
		//모두 다 시작 페이지로
		response.sendRedirect("/security/index.do");
		
	}
	
	

}












