<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
</head>
<body>
	<!--  test.jsp -->
	<h1>WebSocket <small>기본 사용법</small></h1>
	
	<div>
		<button type="button" class="in" id="btn-connect">연결하기</button>
		<button type="button" class="out" id="btn-disconnect">종료하기</button>
	</div>
	
	<hr>
	
	<div>
		<!--  대화 보내기 버튼  -->
		<input type="text" class="long" id="msg">
		<button type="button" id="btn-echo">에코 테스트</button>
	</div>
	
	<hr>
	
	<!--  관련 로그 찍기  -->
	<div class="message full"></div>


	<script src=https://code.jquery.com/jquery-3.7.1.js></script>
	<script>
	
		// 서버측 주소
		// 통신 테스트 > echo 테스트
		// const url = 'ws://echo.websocket.org'; 사용 불가
		// 우리가 만든 주소
		const url = 'ws://localhost:8080/websocket/server.do';
		
		
		// 웹소켓(전화기) 만들기
		let ws;
		
	
		$('#btn-connect').click(() => {
			
			// 1. 소켓 생성
			// 2. 서버 접속(연결)
			// 3. 통신
			// 4. 서버 접속 종료
			
			// 1. 소켓 생성 + 서버 접속(연결)시도 
			ws = new WebSocket(url);
			
			// 소켓 이벤트 > 콜백
			// 비동기 처리(ajax 의 success처럼) > 상대방이 언제 연결될 지 모르기 때문)
			// 서버측에서 소켓 연결을 받아들이고 서로 연결이 되는 순간 발생
			ws.onopen = evt => {
				log('서버와 연결되었습니다.');
			};
			
			//상대방이 나에게 메세지를 전달 > 내가 수신하는 순간 발생
			ws.onmessage = evt => {
				
				log('서버로부터 응답받은 데이터 >>> ' + evt.data);
				
			};
			
			ws.onclose = evt => {
				log('서버와 연결이 종료되었습니다.');
			};
			
			ws.onerror = evt => {
				log('에러가 발생했습니다.');	
			};
			
			
		});
		
		$('#btn-disconnect').click(() => {
			
			ws.close();
			
		});
		
		
		function log(msg) {
			$('.message.full').prepend(`<div>[\${new Date().toLocaleTimeString()}] \${msg}</div>`);
		}
		
		
		$('#btn-echo').click(() => {
			
			// 현재 연결되어 있는 서버측에게 데이터 전송하기
			// ws.send('안녕하세요.');
			
			ws.send($('#msg').val());
			
			log('메시지를 전송했습니다.');
			
			
		});
	
	</script>
</body>
</html>