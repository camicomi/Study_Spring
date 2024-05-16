package com.test.web.connect;

public class Main {
	
	public static void main(String[] args) {
		
		// Main > Service > Hong
		
		// *** 계층과 게층간에 연결 > 클래스 사용(X), 인터페이스 사용(O) > 권장
		
		Service service = new Service();
		service.work();
		
	}

}
