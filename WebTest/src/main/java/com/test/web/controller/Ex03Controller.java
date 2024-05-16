package com.test.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.test.web.dao.BoardDAO;

// Ex03Controller > 의존 > BoardDAO 
public class Ex03Controller implements Controller {
	
	// 생성자 or Setter
	private BoardDAO dao;
	
	// 의존 주입 도구
	public Ex03Controller(BoardDAO dao) {
		this.dao = dao;
	}
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		// DB 작업 > 반환값 > 출력
		
		// 의존 객체 생성(X)
		// BoardDAO dao = new BoardDAO();
		
		String data = dao.getData();
		
		ModelAndView mv = new ModelAndView("ex03");
		mv.addObject("data", data);
		
		
		return mv;
		
	}

}
