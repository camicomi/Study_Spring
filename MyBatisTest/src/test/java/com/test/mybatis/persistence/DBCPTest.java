package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DBCPTest {
	
	
	// <bean> 획득
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		assertNotNull(dataSource);
		
		try {
			
			Connection conn = dataSource.getConnection();
			
			System.out.println(conn.isClosed()); // false > 정상
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
