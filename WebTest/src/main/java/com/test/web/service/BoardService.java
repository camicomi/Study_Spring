package com.test.web.service;

import org.springframework.stereotype.Service;

import com.test.web.dao.BoardDAO;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class BoardService implements DataService {
	
	
	private final BoardDAO dao;
	
	public void add(String message) {
		
		// System.out.println(message);
		
		// BoardDAO dao = new BoardDAO();
		
		
	}

}
