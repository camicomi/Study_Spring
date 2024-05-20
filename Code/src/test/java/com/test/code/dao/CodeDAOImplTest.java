package com.test.code.dao;

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

import com.test.code.dto.CodeDTO;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml",
				"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j2
public class CodeDAOImplTest {
	
	@Autowired
	private CodeDAO dao;
	
	@Test
	public void testCreateDAO() {
		assertNotNull(dao);
	}
	
	@Test
	@Ignore
	public void testAdd() {
		CodeDTO dto = new CodeDTO();
		dto.setSubject("제목 태그");
		dto.setCode("<h1>제목입니다.</h1>");
		dto.setLanguage("html"); // java, sql, html
		
		int result = dao.add(dto);
		
		assertEquals(1, result);
		// insert into tblCode (seq, subject, code, regdate, language) values (seqCode.nextVal, '테스트 코드입니다.', 'int a = 10;', default, 'java') 
		
	}
	
	@Test
	public void testList() {
		
		List<CodeDTO> list = dao.list();
		
		// 글쓴 갯수
		assertEquals(3, list.size());
		
		log.info(list);
	}
	
	
	@Test
	public void testGet() {
		
		CodeDTO dto = dao.view("1");
		assertNotNull(dto);
		log.info("DTO", dto);
		
	}

}
