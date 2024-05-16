package com.test.web.connect;

public class Service {
	
	public void work() {
		
		// 클래스를 사용한 관계 > 강한 결합
		// 인터페이스를 사용한 관계 > 느슨한 결합
		
//		 Hong worker = new Hong();
//		Lee worker = new Lee();
		

// -----------------------------------
//		객체가 바뀌어도 통일성 있는 관계를 지속해 나갈 수 있다.
//		Worker worker = new Hong();
		Worker worker = new Lee();
		
		String thing = worker.get("키보드");
		System.out.println(thing);
		
	}

}
