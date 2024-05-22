package com.test.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component // <bean>
@Aspect // <aop:aspect ref="logger">
public class Logger {
	
	// 포인트컷
	// OOOAdvice > 결합
	
	
	@Pointcut("execution(public String com.test.aop.controller.AOPController.add(..))")
	public void pc1() {
		
		// 구현부(X)
		
		
	}
	
	
	@After("pc1()")
	public void m1() {
		
		
		System.out.println("[LOG] 로그를 작성합니다.");
		
		
	}
	
	
	
}
