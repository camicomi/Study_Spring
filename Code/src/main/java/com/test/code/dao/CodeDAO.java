package com.test.code.dao;

import java.util.List;

import com.test.code.dto.CodeDTO;

public interface CodeDAO {
	
	// 글쓰기
	int add(CodeDTO dto);
	
	
	// 목록 보기
	List<CodeDTO> list();
	// List<CodeDTO> list(List<String> language);
	
	
	// 상세 보기
	CodeDTO view(String seq);
	

}
