package com.test.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.test.java.dao.BoardDAO;
import com.test.java.dto.BoardDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations={
				"file:src/main/webapp/WEB-INF/spring/root-context.xml",
				"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
				})
public class BoardTest {
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	@Ignore
	public void testList() {
		
		List<BoardDTO> list = dao.list();
		
		assertEquals(1, list.size());
		
		System.out.println(list);
		
	}
	
	@Test
	@Ignore
	public void testAdd() {
		
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject("단위 테스트 중..");
		dto.setContent("내용");
		dto.setMemberid("cat");
		
		int result = dao.add(dto);
		assertEquals(1, result);
		
	}
	
	@Test
	@Ignore
	public void testView() {
		
		String seq = "1";
		
		BoardDTO dto = dao.view(seq);
		
		assertNotNull(dto);
		
		System.out.println(dto);
		
	}
	
	@Test
	public void testEdit() {
		BoardDTO dto = dao.view("1");
		dto.setSubject("수정된 제목");
		
		int result = dao.edit(dto);
		assertEquals(1, result);		
	}
	
	@Test
	public void testDel() {
		int result = dao.del("2");
		assertEquals(1, result);
	}

}













