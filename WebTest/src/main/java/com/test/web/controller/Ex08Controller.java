package com.test.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.web.dto.AddressDTO;

@Controller
public class Ex08Controller {

	// 1. String
	// - JSP 파일 경로
	// - ViewResolver 호출
//	@GetMapping("/ex08.do")
//	public String ex08() {
//		
//	
//		
//		return "ex08";
//	}
	
	
	// 2. void
	// - 가상주소와 동일한 JSP 페이지가 호출됨
//	@GetMapping("/ex08.do")
//	public void ex08() {
//		
//	
//		System.out.println("페이지 호출");
//		// 뷰 호출
//		// return "ex08";
//		
//		
//	}
	
	
	// 3. String 키워드
	// - "redirect:URL" > resp.sendRedirect(URL)
	// - "forward:URL" > pageContext.forward(URL)
	// - QueryString 생성 가능
//	@GetMapping("/ex08.do")
//	public String ex08(RedirectAttributes rttr) {
//		
//		
//		
//		rttr.addAttribute("seq", 10);
//		rttr.addAttribute("mode", "del");
//		
//		// 					add.do?seq=10&mode=del
//		// add 페이지로
//		return "redirect:/add.do";
//		
//		
//	}
	
	
	// 4. JSON
	// - JSON 생성
	// - 의존성 1개 추가 > jackson-databind > pom.xml 추가
	// https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind/2.17.1

//	@GetMapping("/ex08.do")
//	public @ResponseBody String ex08() {
//		
//		String name = "Hong";
//		
//		// WEB-INF/views/홍길동.jsp
//		return name;
//		
//	}
	
//	@GetMapping("/ex08.do")
//	public @ResponseBody AddressDTO ex08() {
//		
//		AddressDTO dto = new AddressDTO();
//		dto.setName("hong");
//		dto.setAge(20);
//		dto.setAddress("서울시");
//		
//		return dto;
//		
//		
//	}
	
	
//	@GetMapping("/ex08.do")
//	public @ResponseBody List<String> ex08() {
//		
//		List list = List.of("홍길동", "아무개", "하하하", "호호호", "후후후");
//		
//		return list;
//		
//	
//	}
	
	
	@GetMapping("/ex08.do")
	public @ResponseBody ArrayList<AddressDTO> ex08() {
		
		AddressDTO dto = new AddressDTO();
		
		dto.setName("홍길동");
		dto.setAge(20);
		dto.setAddress("서울시");
		
		AddressDTO dto2 = new AddressDTO();
		
		dto2.setName("아무개");
		dto2.setAge(20);
		dto2.setAddress("부산시");
		
		
		ArrayList<AddressDTO> list = new ArrayList<AddressDTO>();
		list.add(dto);
		list.add(dto2);
		
		
		return list;
	
	}

	


}
