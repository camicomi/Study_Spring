package com.test.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

	//접근 권한 없을 때(403) > 안내 페이지
	@GetMapping("/accesserror.do")
	public String accesserror(Authentication auth, Model model) {
		
		System.out.println("Access Denied >>> " + auth);
		
		model.addAttribute("auth", auth);
		
		return "auth/accesserror";
	}
	
	@GetMapping("/customlogin.do")
	public String customlogin(Model model) {
		
		return "auth/customlogin";
	}
	
	@GetMapping("/customlogout.do")
	public String customlogout(Model model) {
		
		return "auth/customlogout";
	}
	
}











