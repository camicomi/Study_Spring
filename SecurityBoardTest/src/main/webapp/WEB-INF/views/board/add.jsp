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
	
	<h2>Board <small>add</small></h2>
	
	<form method="POST" action="/board/addok.do">
	<table class="vertical">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" required class="full"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" required class="full"></textarea></td>
		</tr>
	</table>
	<div>
		<button type="button" onclick="location.href='/board/list.do';">돌아가기</button>
		<button>글쓰기</button>
	</div>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	<input type="hidden" name="memberid" value="<sec:authentication property="principal.username" />">
	</form>
	
	
</body>
</html>











