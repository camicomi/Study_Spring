package com.test.java.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.java.dto.BoardDTO;
import com.test.java.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardDAOImpl implements BoardDAO {

	private final BoardMapper mapper;

	@Override
	public List<BoardDTO> list() {
		
		return mapper.list();
	}

	@Override
	public int add(BoardDTO dto) {
		
		return mapper.add(dto);
	}

	@Override
	public BoardDTO view(String seq) {
		
		return mapper.view(seq);
	}

	@Override
	public int edit(BoardDTO dto) {
		
		return mapper.edit(dto);
	}

	@Override
	public int del(String seq) {
		
		return mapper.del(seq);
	}
	
}









