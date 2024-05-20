package com.test.code;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class DBTest {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionTemplate template;
	
	@Test
	public void testMapper() {
		
		String time = template.selectOne("code.time");
		log.info(time);
		
	}
	
	@Test
	public void testConnectionPool() throws SQLException {
		
		assertNotNull(dataSource);
		
		
		Connection conn = dataSource.getConnection();
		// level info 여서 그 위로만 출력 . . .
		// 나머지 debug, trace 출력하고 싶으면 level 변경 . . 
		log.fatal("연결 상태: " + conn.isClosed());
		log.error("연결 상태: " + conn.isClosed());
		log.warn("연결 상태: " + conn.isClosed());
		log.info("연결 상태: " + conn.isClosed());
		log.debug("연결 상태: " + conn.isClosed());
		log.trace("연결 상태: " + conn.isClosed());
		
		
	}

}
