<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
</head>
<body>
	<h1>Test</h1>
	
	<!-- defintion에서 정의한 조각 페이지 사용(삽입 = include) -->
	<tiles:insertAttribute name="menu"></tiles:insertAttribute>
	
	<tiles:insertAttribute name="member_menu"></tiles:insertAttribute>
	
	<tiles:insertAttribute name="admin_menu"></tiles:insertAttribute>
	
</body>
</html>


