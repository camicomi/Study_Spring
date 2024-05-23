package com.test.websocket.server;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;
import com.test.websocket.domain.Message;

@ServerEndpoint("/chatserver.do")
public class ChatServer {

	// 현재 채팅 서버에 접속한 클라이언트 세션
	// 채팅방
	private static List<Session> sessionList = new ArrayList<Session>();

	// 전용 소켓이 Session 에 들어 있다
	@OnOpen
	public void handleOpen(Session session) {

		System.out.println("클라이언트가 접속했습니다.");

		sessionList.add(session);

	}

	@OnMessage
	public void handleMessage(String msg, Session session) {

		// {"code":"1","sender":"강아지","receiver":"","content":"","regdate":"2024-05-23
		// 15:35:20"}
		System.out.println(msg);

		Gson gson = new Gson();

		Message message = gson.fromJson(msg, Message.class);

		// Message(code=1, sender=강아지, receiver=, content=, regdate=2024-05-23 15:42:32)
		System.out.println(message);

		if (message.getCode().equals("1")) {

			// 새로운 유저가 접속했습니다.
			for (Session s : sessionList) {
//				if (현재 접속자 빼고 나머지 사람들에게)
				if (s != session) {

					try {
						// 다른 사람 소켓 가져와서 브로드 캐스팅??
						s.getBasicRemote().sendText(msg);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		} else if (message.getCode().equals("2")) {
			
			
			// 기존 유저가 나갔습니다.
			// 세션 제거
			sessionList.remove(session);

			for (Session s : sessionList) {

				if (s != session) {

					try {						
						s.getBasicRemote().sendText(msg);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
			
			
			
			
		} else if (message.getCode().equals("3") || message.getCode().equals("4")) {
			
			// 대화 내용을 전달 (나 빼고 나머지 사람들)
			
			for (Session s : sessionList) {
				if (s != session) {

					try {
						// 다른 사람 소켓 가져와서 브로드 캐스팅??
						s.getBasicRemote().sendText(msg);

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
			
		} 

	}

	@OnClose
	public void handleClose() {

		System.out.println("클라이언트와 연결이 종료되었습니다.");

	}

	@OnError
	public void handleError(Throwable e) {

	}

}
