package com.test.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.test.mybatis.dao.MyBatisDAO;
import com.test.mybatis.dto.MyBatisDTO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MyBatisController {
	
	private final MyBatisDAO dao;
	
	@GetMapping("/m1.do")
	public String m1() {
		
		//반환값(X), 인자값(X)
		dao.m1();
		
		return "list";
	}
	
	@GetMapping("/m2.do")
	public String m2(Model model, String seq) {
		
		//반환값(X), 인자값(O) > 단일값
		//- delete from tblAddress where seq = ?
		
		//m2.do?seq=1
		
		//INFO : jdbc.sqlonly - delete from tblAddress where seq = '1' 
		
		int result = dao.m2(seq);
		
		model.addAttribute("result", result);
		
		return "list";
	}
	
	
	@GetMapping("/m3.do")
	public String m3(Model model) {
		
		//insert
		//- 다중 데이터 > Map or DTO
		Map<String, String> map = new HashMap<>();
		
		map.put("name", "아무개");
		map.put("age", "25");
		map.put("address", "서울시");
		map.put("gender", "m");
		
		//insert into tblAddress values (seqAddress.nextVal, '아무개', '25', '서울시', 'm') 
		int result = dao.m3(map);
		
		model.addAttribute("result", result);
		
		return "list";
	}
	
	
	@GetMapping("/add.do")
	public String add() {
		
		return "add";
	}
	
	@PostMapping("/addok.do")
	public String addok(Model model, MyBatisDTO dto) {
		
		int result = dao.add(dto);
		
		model.addAttribute("result", result);
		
		return "addok";
	}
	
	@GetMapping("/m4.do")
	public String m4(Model model) {
		
		//단일값 반환(1행 1열)
		//- select count(*) from tblAddress
		
		int count = dao.m4();
		
		model.addAttribute("count", count);
		
		return "list";
	}
	
	@GetMapping("/m5.do")
	public String m5(Model model, String seq) {
		
		//다중값 반환(1행)
		//select * from tblAddress where seq = ?
		
		MyBatisDTO dto = dao.m5(seq);
		
		model.addAttribute("dto", dto);
		
		return "list";
	}
	
	
	@GetMapping("/m6.do")
	public String m6(Model model) {
		
		//다중값 반환(N행 1열)
		//select name from tblAddress
		
		List<String> names = dao.m6();
		
		model.addAttribute("names", names);
		
		return "list";
	}
	
	@GetMapping("/m7.do")
	public String m7(Model model) {
		
		//다중값 반환(N행 N열)
		//select * from tblAddress
		
		List<MyBatisDTO> list = dao.m7();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping("/m8.do")
	public String m8(Model model, String table) {
		
		//m8.do?table=tblAddress
		//- select count(*) from tblAddress
		
		//m8.do?table=tblMemo
		//- select count(*) from tblMemo
		
		//DB에 식별자를 전달하는 방법
		int count = dao.m8(table);
		
		model.addAttribute("count", count);
		
		return "list";		
	}
	
	@GetMapping("/m9.do")
	public String m9(Model model) {
		
		//select * from tblAddress where age > 25
		
		List<MyBatisDTO> list = dao.m9();
		
		model.addAttribute("list", list);
		
		return "list";
	}
	
	@GetMapping("/m10.do")
	public String m10(Model model, String search) {
		
		//select * from tblAddress where address like '%검색어%'
		List<MyBatisDTO> list = dao.m10(search);
		
		model.addAttribute("list", list);
		
		return "list";		
	}

}
















