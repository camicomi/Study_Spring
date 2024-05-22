package com.test.aop.singleton;

import org.springframework.stereotype.Repository;

// 빈 선언
// 1. XML: <bean>
// 2. Annotation: @Component
// 3. Java : 자바 설정 파일 필요 


//@Repository
// Java 로 !!! 
public class TestDAO {

	
	public String service() {

		return "data";

	}

}
