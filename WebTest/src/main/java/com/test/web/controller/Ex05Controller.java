package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping(value="/ex05.do")
@RequestMapping(value="/board") // 모든 주소에 붙는 접두어가 됨
public class Ex05Controller {
	
//	@RequestMapping
//	public String ex05() {
//		
//		
//		return "ex05";
//	}
	
//	Ambiguous mapping. Cannot map 'ex05Controller' method  1개만 
//	@RequestMapping
//	public String test() {
//		return "ex05";
//	}
	
	
	@RequestMapping(value="/ex05.do") // 여기다 작성하면 class에 작성 하지 않아도 됨 
	public String ex05() {
		
		
		return "ex05";
		
	}
	
	
	@RequestMapping(value="/test.do", method={RequestMethod.GET, RequestMethod.POST}) // 주소로 식별이 되므로 여러 개 작성 OK , list, add, del 등 마다 따로 파일을 만들지 않아도 됨
	public String test() {
		
		return "ex05";
		
	}
	
//	@RequestMapping(value="/add.do", method=RequestMethod.GET)
//	public String add() {
//	
//		
//		return "add";
//		
//	}
//	
//	@RequestMapping(value="/addok.do", method=RequestMethod.POST)
//	public String addok() {
//		
//		
//		return "addok";
//		
//	}
	
	
	// /board/add.do
//	@RequestMapping(value="/add.do", method=RequestMethod.GET)
//	public String add() {
//	
//		
//		return "add";
//		
//	}
//	
//	// /board/addok.do
//	@RequestMapping(value="/addok.do", method=RequestMethod.POST)
//	public String addok() {
//		
//		
//		return "addok";
//		
//	}
	
	
	// 스프링 4.3 이후 만들어짐, 에러 나면 스프링 버전 확인
	// @GetMapping(value="/add.do")
	@GetMapping("/add.do") // Get 전용
	public String add() {
		
		
		return "add";
		
	}
	
	
	// @PostMapping(value="addok.do")
	@PostMapping("addok.do")
	public String addok() {
		
		return "addok";
	}
	

}
