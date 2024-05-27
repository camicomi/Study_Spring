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
	
	<!-- customlogin.jsp -->
	
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Custom Login Page</h2>
	
	<form method="POST" action="/security/login">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="username" required></td>
		</tr>
		<tr>
			<th>암호</th>
			<td><input type="password" name="password" required></td>
		</tr>
	</table>
	<div>
		<button class="in">로그인</button>
	</div>
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
	
</body>
</html>









