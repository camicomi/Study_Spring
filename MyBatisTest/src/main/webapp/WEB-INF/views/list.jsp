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
	<h1>결과</h1>
	
	<div>result: ${result}</div>
	
	<div>count: ${count}</div>
	
	<div>dto: ${dto}</div>
	
	<div>names: ${names}</div>
	
	<ul>
		<c:forEach items="${list}" var="dto">
		<li>${dto.name} - ${dto.address}</li>
		</c:forEach>
	</ul>
	
</body>
</html>
















