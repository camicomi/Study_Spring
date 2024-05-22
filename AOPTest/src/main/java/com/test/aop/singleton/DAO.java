package com.test.aop.singleton;



// 객체 단 1개만 구현 > 싱글톤 패턴
public class DAO {
	
	
	private static DAO obj;
	
	// 생성자 를 private > new DAO()로 직접 생성 불가능 > 싱글톤
	private DAO() {}
	
	// 프로세스
	// - 운영체제가 1개의 프로그램을 실행하는 단위 
	
	// 쓰레드(Thread) 안정성
	// - synchronized : 임계 영역(Lock) 생성하는 키워드
	
	// 사용중일 때  다른쪽에서  접근 불가하도록 작업
	//public static synchronized DAO getInstance()
	
	public static DAO getInstance() {
		
		if (obj == null) {
			obj = new DAO(); // 100번지
			
			
		}
		
		return obj;
		
	}

	


}





