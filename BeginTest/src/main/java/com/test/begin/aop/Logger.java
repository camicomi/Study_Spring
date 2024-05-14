package com.test.begin.aop;

import java.util.Calendar;


// 보조 업무 객체
public class Logger {
	
	public void log(String message) {
	
		
		Calendar now = Calendar.getInstance();
		System.out.printf("[LOG]%tF %tT > %s\n", now, now, message);
		
		
	}
	
	
	// 보조 업무 구현
	public void after() {
		
		System.out.println("보조 업무를 실행합니다.");
		
		
	}

}
