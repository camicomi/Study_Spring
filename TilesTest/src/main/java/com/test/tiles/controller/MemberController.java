package com.test.tiles.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@GetMapping("/info.do")
	public String info() {
		

		
		
		// http://localhost:8080/tiles/member/info.do
		// member/info >  definition 이름으로 변경 !!!  
		// * 구분을 위해!! member.info
		return "member.info";
		
	}
	
	@GetMapping("/history.do")
	public String history() {
		

		
		
		return "member.history";
		
	}
	
	@GetMapping("/favorite.do")
	public String favorite() {
		

	
		
		return "member.favorite";
		
	}
	
	

}
