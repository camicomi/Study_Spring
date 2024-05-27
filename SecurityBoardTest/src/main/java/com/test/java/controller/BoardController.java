package com.test.java.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.java.dao.BoardDAO;
import com.test.java.dto.BoardDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardDAO dao;
	
	@GetMapping("/board/list.do")
	public String list(Model model) {
		
		model.addAttribute("list", dao.list());
		
		return "board/list";
	}
	
	// URL 접근 직전 인증 받은 사용자만 (security-context.xml url 허가 설정과 같음)
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/board/add.do")
	public String add(Model model) {
		
		return "board/add";
	}
	
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/board/addok.do")
	public String addok(Model model, BoardDTO dto) {
		
		// dto.setMemberid("dog");
		dao.add(dto);
		
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/board/view.do")
	public String view(Model model, String seq) {
		
		BoardDTO dto = dao.view(seq);
		
		model.addAttribute("dto", dto);
		
		return "board/view";
	}
	
	@PreAuthorize("(isAuthenticated() and principal.username == #memberid) or hasRole('ROLE_ADMIN')")
	@GetMapping("/board/edit.do")
	public String edit(Model model, String seq, String memberid) {
		
		BoardDTO dto = dao.view(seq);
		
		model.addAttribute("dto", dto);
		
		return "board/edit";
	}
	
	// dto 가 넘어왔으므로 dto.memberid 주의
	@PreAuthorize("(isAuthenticated() and principal.username == #dto.memberid) or hasRole('ROLE_ADMIN')")
	@PostMapping("/board/editok.do")
	public String editok(Model model, BoardDTO dto) {
		
		dao.edit(dto);
		
		return "redirect:/board/list.do";
	}
	
	@PreAuthorize("(isAuthenticated() and principal.username == #memberid) or hasRole('ROLE_ADMIN')")
	@GetMapping("/board/del.do")
	public String del(Model model, String seq, String memberid) {
		
		model.addAttribute("seq", seq);
		
		return "board/del";
	}
	
	@PreAuthorize("isAuthenticated() or hasRole('ROLE_ADMIN')")
	@PostMapping("/board/delok.do")
	public String delok(Model model) {
		
		return "redirect:/board/list.do";
	}
	
}









