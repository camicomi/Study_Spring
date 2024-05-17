package com.test.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.test.web.service.BoardService;
import com.test.web.service.DataService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/*
 
 	스프링 의존 주입
 	1. 필드 주입, Field Injection > private final 안됨
 	2. Setter 주입 > private final 안됨
 	3. 생성자 주입 > *** 가장 권장
 	
 	
 
 
 
 */


@Controller
// @Setter
// @Getter
// @NoArgsConstructor // 인자값없는 기본 생성자
// @AllArgsConstructor // 모든 멤버  변수 > 인자값 있는 생성자 
@RequiredArgsConstructor  // final 를 생성자 의존주입 
public class Ex10Controller {
	
//	private final BoardService service;
	// 인터페이스는 빈이 될 수 없음 
	// @Qualifier("memo") > 권장X 
	private final DataService service;
	
	
	
	// 필드 주입
//	@Autowired
//	private final BoardService service;
	
	// Setter 의존주입 
//	@Autowired
//	public void setService(BoardService service) {
//		
//		this.service = service;
//		
//	}
	
	// 생성자 의존주입 
//	@Autowired
//	public Ex10Controller(BoardService service) {
//		this.service = service;
//	}
	
	@GetMapping(value="/addBoard.do")
	public String add(String message) {
		
		// BoardService service = new BoardService();
		
		service.add(message);
		
		
		return "ex10";
	}
	
	

}
