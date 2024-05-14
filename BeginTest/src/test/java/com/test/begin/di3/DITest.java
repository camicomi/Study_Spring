package com.test.begin.di3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("di3.xml")
public class DITest {

	// Junit Test Case 
	
	private Service service;
	
	@Autowired
	public void setService(Service service) {
		this.service = service;
	}
	
	@Test
	public void testDI() {
		
		
		// Service 객체 생성 + 의존 주입
		this.service.work();
		
		
		
	}
	
	
	

}
