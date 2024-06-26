package com.test.begin.di2;

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
		
		
		Hong hong = new Hong();
		
//		Service service = new Service();
//		service.setHong(hong); // 의존 주입 발생(DI)
//		service.work();
		
		Service service = new Service(hong); // 의존 주입 발생(DI)
		service.work();
		
		
		
	}

}
