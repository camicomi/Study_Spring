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
	
	<h2>Board <small>list</small></h2>
	
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>아이디</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td><a href="/board/view.do?seq=${dto.seq}">${dto.subject}</a></td>
			<td>${dto.memberid}</td>
			<td>${dto.regdate}</td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<!--  인증 받은 사용자만 -->
		<sec:authorize access="isAuthenticated()">
		<button type="button" onclick="location.href='/board/add.do';">글쓰기</button>		
		</sec:authorize>
	</div>
	
	
</body>
</html>











