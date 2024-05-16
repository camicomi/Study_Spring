package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// JSP Model2(MVC 패턴)
// - Controller > 클라이언트 요청 + 흐름 통제 > Java Servlet
// - View > 반환할 뷰 페이지 > JSP 페이지
// - Model > 데이터 처리 + 이동

// 이전 수업 > Servlet 역할
// - Controller > 일반 Java 클래스
// - View > JSP 페이지 
// - Model > 동일


public class Ex01Controller implements Controller {

	
	
	// handleReques == doGet/doPost 역할
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 업무코드 작성
		
		// 뷰 호출하기
		// - request.getRequestDispatcher("hello.jsp").forward(req, resp);
		
		// /WEB-INF/views/WEB-INF/view/ex01.jsp.jsp > JSP 페이지의 이름만 작성 
		
		ModelAndView mv = new ModelAndView();
		// JSP 페이지의 이름만 작성
		// mv.setViewName("/WEB-INF/views/ex01.jsp");
		mv.setViewName("ex01");
		
		return mv; // forward()

		
	}

	
	

}
