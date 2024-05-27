package com.test.security;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={
				"file:src/main/webapp/WEB-INF/spring/root-context.xml",
				"file:src/main/webapp/WEB-INF/spring/security-context.xml"
				})
public class MemberTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	@Ignore
	public void testPasswordEncoder() {
		
		//$2a$10$e59aYHAzm3aCyLufq0yEZ.JJ6U5.BDrdtEIiBDn9Mh2IEr3g2rCDa
		String pw = "1111";
		
		System.out.println(encoder.encode(pw));
		
	}
	
	@Test
	@Ignore
	public void testInsertMember() {
		
		String sql = "insert into member (memberid, memberpw, membername, enabled, email, gender, regdate) values (?, ?, ?, default, ?, ?, default)";
		
		try {
			
			Connection conn = dataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setString(1, "dog");
			stat.setString(2, encoder.encode("1111"));
			stat.setString(3, "강아지");
			stat.setString(4, "dog@gmail.com");
			stat.setString(5, "m");
			
			stat.executeUpdate();
			
			
			
			stat.setString(1, "cat");
			stat.setString(2, encoder.encode("1111"));
			stat.setString(3, "고양이");
			stat.setString(4, "cat@gmail.com");
			stat.setString(5, "f");
			
			stat.executeUpdate();
			
			
			
			stat.setString(1, "tiger");
			stat.setString(2, encoder.encode("1111"));
			stat.setString(3, "호랑이");
			stat.setString(4, "tiger@gmail.com");
			stat.setString(5, "m");
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testInsertAuth() {
		
		String sql = "insert into member_auth (memberid, auth) values (?, ?)";
		
		try {
			
			Connection conn = dataSource.getConnection();
			PreparedStatement stat = conn.prepareStatement(sql);
			
			stat.setString(1, "dog");
			stat.setString(2, "ROLE_MEMBER");
			stat.executeUpdate();
			
			stat.setString(1, "cat");
			stat.setString(2, "ROLE_MEMBER");
			stat.executeUpdate();
			
			stat.setString(1, "tiger");
			stat.setString(2, "ROLE_ADMIN");
			stat.executeUpdate();
			
			stat.setString(1, "tiger");
			stat.setString(2, "ROLE_MEMBER");
			stat.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}














