package com.test.websocket.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Message {
	// 같은 역할(chat.jsp)
//	const message = {
//			
//			code: '1',
//			sender: name,
//			receiver: '',
//			content: '',
//			regdate: dayjs().format('YYYY-MM-DD HH:mm:ss')
//			
//	};
	
	// {"code":"1","sender":"강아지","receiver":"","content":"","regdate":"2024-05-23 15:35:20"} 를  잘라서 넣어야함
	// gson 사용 > pom.xml 에서 설정
	
	private String code;
	private String sender;
	private String receiver;
	private String content;
	private String regdate;
	

}
