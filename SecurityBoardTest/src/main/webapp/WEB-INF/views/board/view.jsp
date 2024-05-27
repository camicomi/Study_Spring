<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
</head>
<body>
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Board <small>view</small></h2>
	
	<table class="vertical">
		<tr>
			<th>제목</th>
			<td>${dto.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><c:out value="${dto.content}"></c:out></td>
		</tr>
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${dto.memberid}</td>
		</tr>
		<tr>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
	</table>
	<div>
		<button type="button" onclick="location.href='/board/list.do';">돌아가기</button>
		<!--  인증 받은 사용자 + 본인  또는 관리자  -->
		<sec:authorize access="(isAuthenticated() and principal.username == #dto.memberid) or hasRole('ROLE_ADMIN')">
		<button type="button" onclick="location.href='/board/edit.do?seq=${dto.seq}&memberid=${dto.memberid}';">수정하기</button>
		<button type="button" onclick="location.href='/board/del.do?seq=${dto.seq}&memberid=${dto.memberid}';">삭제하기</button>
		</sec:authorize>
	</div>
	
	
	
</body>
</html>











