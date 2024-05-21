package com.test.mybatis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.mybatis.dao.MyBatisDAO;
import com.test.mybatis.dto.AddressDTO;
import com.test.mybatis.dto.DetailDTO;
import com.test.mybatis.dto.MyBatisDTO;
import com.test.mybatis.dto.UserDTO;

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
	
	@GetMapping("/m11.do")
	public String m11(Model model, String gender) {
		
		// MyBatis + 동적 쿼리
		// - SQL 작성 + 제어(JSTL 유사)
		// - 동적으로 상황에 따른 SQL 작성할 수 있는 기능
		
		// if 문
		// - 주로 where절의 일부를 조작할 때 많이 사용한다.
		
		// - m11.do?gender=m
		// - m11.do?gender=f
		
		List<MyBatisDTO> list = dao.m11(gender);
		
		model.addAttribute("list", list);
		
		
		return "result";
	}
	
	
	@GetMapping("/m12.do")
	public String m12(Model model, String gender) {
		
		
		// gender 유/무
		// - m12.do?gender=m
		// - m12.do?gender=f
		// - m12.do
		
		//Cause: java.sql.SQLException: 실행할 SQL 문은 비어 있거나 널일 수 없음

		List<MyBatisDTO> list = dao.m12(gender);
		
		model.addAttribute("list", list);
		
		
		return "result";
		
	}
	
	@GetMapping("/m13.do")
	public String m13(Model model, MyBatisDTO dto) {
		
		// gender or address 조건으로 사용
		// - m13.do?gender=m
		// - m13.do?address=강동구
		// - m13.do/gender=f&address=강남구
		// - m13.do
		
		List<MyBatisDTO> list = dao.m13(dto);
		model.addAttribute("list", list);
		
		return "result";
	}
	
	
	@GetMapping("/m14.do") // 값형 에러 방지 1. Integer, 2. @RequestParam(name = "type", defaultValue = "1")
	public String m14(Model model, Integer type) {
		
		// - m14.do?type=1 > select name, age
		// - m14.do?type=2 > select name, gender, address
		// - m14.do		   > select * 
		
		System.out.println(type);
		
		List<MyBatisDTO> list = dao.m14(type);
		
		model.addAttribute("list", list);
		
		return "result";
	}
	
	
	@GetMapping("/m15.do")
	public String m15(Model model, String column, String word) {
		
		// 검색
		// - m15.do?column=컬럼명&word=검색어
		
		// - m15.do?column=name&word=강아지	> 동등 비교
		// - m15.do?column=gender&word=m	> 동등 비교
		// - m15.do?column=seq&word=3		> 동등 비교
		
		// - m15.do?column=age&word=2		> 우위 비교
		
		// - m15.do?column=address&word=강동	> 패턴 비교
		
		
		// 1개 이상이므로  Map 에 담아서 보내기
		Map<String, String> map = new HashMap<String, String>();
		map.put("column", column);
		map.put("word", word);
		
		List<MyBatisDTO> list = dao.m15(map);
		
		model.addAttribute("list", list);
		
		
		return "result";
		
	}
	
	@GetMapping("/m16.do")
	public String m16(Model model, MyBatisDTO dto) {
		
		
		//1개 이상의 조건 검색(다중 조건)
		//- m16.do
		//- m16.do?age=3
		//- m16.do?gender=f
		//- m16.do?gender=m&age=3
		//- m16.do?gender=m&age=3&address=강남구
		
		// - <where> 태그는 콘텐츠의 내용 중 "and"나 "or"로 시작하면 그 "and"나 "or"를 자동으로 삭제한다. (문맥에 맞춰서)
		
		List<MyBatisDTO> list = dao.m16(dto);
		model.addAttribute("list", list);
		
		return "result";
		
		
	}
	
	
	@GetMapping("/m17.do")
	public String m17(Model model, MyBatisDTO dto) {
		
		
		// <set> : 수정할 때
		// - update tblAddress set

		// 기존값 + 새로운값 업데이트 
		// - m17.do?seq=1&gender=f
		// > update tblAddress SET gender = 'f' where seq = '1'
		
		// - m17.do?seq=1&age=5
		// > update tblAddress SET age = '5' where seq = '1' 
		
		// - m17.do?seq=1&address=서울시 강남구 역삼동 우체국 빌딩&age=6
		// > update tblAddress SET age = '6', address = '서울시 강남구 역삼동 우체국 빌딩' where seq = '1' 
		
		dao.m17(dto);
		
		// 에러 방지를 위해 빈 값 반환  !!!  
		model.addAttribute("list", new ArrayList<MyBatisDTO>());
		
		
		
		return "result";
		
	}
	
	@GetMapping("/m18.do")
	public String m18(Model model, @RequestParam("name") List<String> name) {
		
		// 반복문
		// - m18.do
		// - m18.do?name=강아지
		// - m18.do?name=강아지&name=고양이&name=타조
		
		// System.out.println(name); // [강아지, 고양이, 타조]
		
		
		List<MyBatisDTO> list = dao.m18(name);
		model.addAttribute("list", list);
		
		
		
		return "result";
		
		
	}
	
	@GetMapping("/m19.do")
	public String m19(Model model, UserDTO udto, DetailDTO ddto) {
		
		
		// 다중 쿼리 > selectKey
		// - mapper는 한번에 한개의 SQL만 실행 가능하다.
	
		
		// - tblUser > 회원(기본정보)
		// - tblDetail > 회원(추가정보)
		
		// - m19.do?name=홍길동&email=hong@test.com
		// - m19.do?name=아무개&email=aaa@test.com
		// - m19.do?name=강아지
		
//		dao.addUser(udto);
//		user_seq 얻기 위해 
//		String seq = dao.getSeq();
//		ddto.setUser_seq(seq);
//		dao.addDetail(ddto);
		
		dao.addUser(udto);
		
		ddto.setUser_seq(udto.getSeq());
		dao.addDetail(ddto);
		
//		System.out.println(udto.getSeq());

		
	
		return "result";
		
	}
	
	@GetMapping("/m20.do")
	public String m20(Model model) {
		
		// Join 상황
		// - 1:1
		
		// AddressDTO(부모) + InfoDTO(자식) 
		// select * from tblAddress a inner join tblInfo i on a.seq = i.seq
		
		// List<??> jlist = dao.m20();
		// 방법 1. AddressDTO + InfoDTO = DTO
		// 방법 2. AddressDTO(InfoDTO) 멤버변수로 
		
		List<AddressDTO> jlist = dao.m20();
		
		model.addAttribute("jlist", jlist);
		
		
		return "result";
		
	}
	
	
	@GetMapping("/m21.do")
	public String m21(Model model) {
		
		
		
		List<AddressDTO> jlist = dao.m21();
		
		model.addAttribute("jlist", jlist);
		
		return "result";
		
		
	}
	
	
	@GetMapping("/m22.do")
	public String m22(Model model) {
		
		
		// 1:N
		// tblAddress + tblMemo
		
		List<AddressDTO> mlist = dao.m22();
		
		model.addAttribute("mlist", mlist);
		
		return "result";
		
		
	}
	

}





