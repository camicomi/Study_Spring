package com.test.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.web.dto.AddressDTO;

@Controller
public class Ex06Controller {

	@GetMapping(value = "/add.do")
	public String add() {

		return "add";
	}

	/*
	 * @PostMapping(value="/addok.do") public String addok(HttpServletRequest req){
	 * 
	 * // req.setCharacterEncoding("UTF-8"); > 필터 처리
	 * 
	 * 
	 * String num = req.getParameter("num");
	 * 
	 * // ModelAndView mv;
	 * 
	 * req.setAttribute("num", num);
	 * 
	 * 
	 * return "addok"; }
	 */

	// 스프링에서는 요청 메서드에게 넘어오는 대부분의 데이터를 매개 변수 형태로 받는다.
	// String > int num 자동 형변환
	/*
	 * @PostMapping("/addok.do") public String addok(@RequestParam("num") int num) {
	 * 
	 * System.out.println(num);
	 * 
	 * return "addok";
	 * 
	 * }
	 * 
	 */

	// 생략시 변수명은 똑같이 해야 한다.
	/*
	 * @PostMapping("/addok.do") public String addok(String num, Model model) {
	 * 
	 * System.out.println(num);
	 * 
	 * // Model > dto // ModelAndView
	 * 
	 * model.addAttribute("num", num);
	 * 
	 * 
	 * return "addok";
	 * 
	 * }
	 */

	/*
	 * @PostMapping("/addok.do") public String addok(Model model,
	 * 
	 * @RequestParam("name") String name,
	 * 
	 * @RequestParam("age") String age,
	 * 
	 * @RequestParam("address") String address) {
	 * 
	 * model.addAttribute("name", name); model.addAttribute("age", age);
	 * model.addAttribute("address", address);
	 * 
	 * 
	 * return "addok"; }
	 */

	/*
	 * @PostMapping("/addok.do") public String addok(Model model, String name, int
	 * age, String address) {
	 * 
	 * // 가장 많이 하는 행동 ? > DTO 담기 AddressDTO dto = new AddressDTO();
	 * dto.setName(name); dto.setAge(age); dto.setAddress(address);
	 * 
	 * 
	 * 
	 * // model.addAttribute("name", name); // model.addAttribute("age", age); //
	 * model.addAttribute("address", address);
	 * 
	 * model.addAttribute("dto", dto);
	 * 
	 * 
	 * return "addok";
	 * 
	 * }
	 */

	/*
	 * @PostMapping("/addok.do") public String addok(Model model, AddressDTO dto,
	 * 
	 * @RequestParam(defaultValue = "100") int id) {
	 * 
	 * 
	 * // int > null 이면, 에러남 따라서 @RequestParam(defaultValue = "100") 초기값 설정
	 * 
	 * // 1. req.getParameter() // 2. DTO 생성 // 모두 처리 해 준다
	 * 
	 * System.out.println(id);
	 * 
	 * model.addAttribute("dto", dto);
	 * 
	 * 
	 * return "addok";
	 * 
	 * }
	 */

	
	/*
	@PostMapping("/addok.do")
	public String addok(Model model, String[] cb
			
			) {

		// 1,2,3,4,5
		// 1,5
		// @RequestParam("cb") List<String> cb
		// @RequestParam("cb") ArrayList<String> cb

//		System.out.println(cb);

		
		// String[] cb
		// @RequestParam("cb") String[] cb
		System.out.println(Arrays.toString(cb));
		
		return "addok";

	}
	*/
	
	@PostMapping("/addok.do")
	public String addok(Model model, @ModelAttribute("num") String num) {
		
		
//		model.addAttribute("num", num);
		
		// @ModelAttribute
		// - 모델 객체에 데이터를 추가하지 않아도 자동으로 추가된다.
		
		
		return "addok";
		
	}

}
