package com.test.begin.di3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	
	public static void main(String[] args) {
		
		// 목적] > Hong(실무자)에게 일을 시키자!!!
		// Main > Hong(X) 다이렉트로 접근 X
		// Main > Service(관리자) > Hong (O)
		
		
		// Hong hong = new Hong();
		
		// Main > (위임) > Service > (위임) > Hong
		// Main <-> (의존관계) <-> Service <-> (의존관계) <-> Hong 
		// Main > Service(의존객체)
		// **** 필요할 때마다 직접(***) 의존 객체를 생성해서 사용하는 방식을 사용해왔다.
		
		
//		Hong hong = new Hong();
		
//		Service service = new Service();
//		service.setHong(hong); // 의존 주입 발생(DI)
//		service.work();
		
//		Service service = new Service(hong); // 의존 주입 발생(DI)
//		service.work();
		
		// ----------------------------------------------------------
		// Hong 객체 생성하기
		// 1. 개발자가 직접 생성
		// Hong hong = new Hong();
		
		// 2. 스프링을 통해서 생성 > 빈 생성
		// - di3.xml 환경 설정을 읽어오기
		
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("file:/src/main/java/com/test/begin/di3/di3.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/begin/di3/di3.xml");
	
		// 형변환 필수 
//		Hong hong = (Hong)context.getBean("hong");
//		hong.conding();
		
		// 스프링에서 의존 주입 구현
		Service service = (Service) context.getBean("service");
		
//		service.setHong(hong);
		
		service.work();
		
		// <bean id="hong2" name="h1, h2, h3" class="com.test.begin.di3.Hong"></bean>
		Hong hong2 = (Hong) context.getBean("hong2");
		Hong hong3 = (Hong) context.getBean("h1");
		Hong hong4 = (Hong) context.getBean("h2");
		Hong hong5 = (Hong) context.getBean("h3");
		
		hong2.conding();
		hong5.conding();
		
		
	}

}
