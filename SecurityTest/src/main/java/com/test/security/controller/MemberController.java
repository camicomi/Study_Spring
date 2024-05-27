package com.test.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.security.dto.AuthDTO;
import com.test.security.dto.MemberDTO;
import com.test.security.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberMapper mapper;
	private final PasswordEncoder encoder;

	@GetMapping("/register.do")
	public String register() {
		
		return "member/register";
	}
	
	@PostMapping("/registerok.do")
	public String registerok(MemberDTO dto) {
		
		//암호 인코딩
		dto.setMemberpw(encoder.encode(dto.getMemberpw()));
		
		mapper.register(dto);
		
		if (Integer.parseInt(dto.getAuth()) >= 1) {
			
			AuthDTO adto = new AuthDTO();
			
			adto.setMemberid(dto.getMemberid());
			adto.setAuth("ROLE_MEMBER");
			
			mapper.registerAuth(adto);
		} 
		
		if (dto.getAuth().equals("2")) {
			
			AuthDTO adto = new AuthDTO();
			
			adto.setMemberid(dto.getMemberid());
			adto.setAuth("ROLE_ADMIN");
			
			mapper.registerAuth(adto);
		}
		
		return "redirect:/index.do";
	}
	
	@GetMapping("/info.do")
	public String info() {
		
		return "member/info";
	}
	
}








