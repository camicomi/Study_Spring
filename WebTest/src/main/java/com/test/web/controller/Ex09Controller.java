package com.test.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ex09Controller {

	
	@GetMapping(value="/ex09.do")
	public String ex09(Model model) {
		
		int num = 0;
		
		model.addAttribute("result", 100 / num);
		
		return "ex09";
		
	}
	
}
