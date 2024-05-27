package com.test.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

	@GetMapping(value="/index.do")
	public String index() {
		
		System.out.println("TestController > index");
		
		return "index";
	}
	
	@GetMapping(value="/member.do")
	public String member() {
		
		System.out.println("TestController > member");
		
		return "member";
	}
	
	@GetMapping(value="/admin.do")
	public String admin() {
		
		System.out.println("TestController > admin");
		
		return "admin";
	}
	
}
















