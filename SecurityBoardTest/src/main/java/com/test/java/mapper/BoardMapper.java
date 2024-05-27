package com.test.java.mapper;

import java.util.List;

import com.test.java.dto.BoardDTO;

public interface BoardMapper {

	List<BoardDTO> list();
	
	int add(BoardDTO dto);
	
	BoardDTO view(String seq);
	
	int edit(BoardDTO dto);
	
	int del(String seq);

}










