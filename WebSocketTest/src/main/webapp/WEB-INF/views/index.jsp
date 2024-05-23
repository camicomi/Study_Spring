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
	<!--  index.jsp  -->
	<h1>WebSocket <small>chat</small></h1>
	
	<div>
		<div class="group">
			<label>대화명</label>
			<input type="text" name="name" id="name" class="short">
		</div>
	</div>
	
	<div>
		<button type="button" class="in">들어가기</button>
		
		<button type="button" class="in" data-name="강아지">들어가기(강아지)</button>
		
		<button type="button" class="in" data-name="고양이">들어가기(고양이)</button>
		
		<button type="button" class="in" data-name="병아리">들어가기(병아리)</button>
	</div>

	<script src=https://code.jquery.com/jquery-3.7.1.js></script>
	<script>
		$('.in').click(() => {
			
			// 사용자 (data-name) 가져오기
			let name = $(event.target).data('name');
			
			if (name == null || name == '') {
				name = $('#name').val();
			} else {
				$('#name').val(name);
				
			}
			
		
			
			if (name == null || name == '') {
				$('#name').focus();
				return;
			}
			
			const child = window.open('/websocket/chat.do', 'chat', 'width=410 height=530');
			
			// 창이 열리면 이름 변경  통제 
			$('#name').prop('readOnly', true);
			$('.in').prop('disabled', true);
			$('.in').css('opacity', .5);
			
			
			// 딜레이를 주지 않아도 강아지, 고양이 잘 뜬다. 
			child.addEventListener('load', () => {
				
				child.connect(name);
				
			});
			
			
			/*
			좋은 방법은 아님..
			setTimeout(() => {
				
				// window.open보다 먼저 실행되어 1초를 준 것 
				$(child.document).find('#header small').text(name);
				
				
			}, 1000);
			*/
			
			
		});
	</script>
</body>
</html>