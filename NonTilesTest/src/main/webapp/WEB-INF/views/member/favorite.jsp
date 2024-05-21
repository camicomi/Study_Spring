<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NonTiles</title>
<%@include file="/WEB-INF/views/inc/asset.jsp" %>
</head>
<body>
	<header>
		<h1>NonTitles</h1>
		<%@include file="/WEB-INF/views/inc/main_menu.jsp" %>
		<%@include file="/WEB-INF/views/inc/member_menu.jsp" %>
	</header>
	
	<h1>회원 <small>즐겨찾기</small></h1>

	<div><a href="#">구글</a></div>
	<div><a href="#">스택오버플로우</a></div>
	<div><a href="#">깃헙</a></div>

</body>
</html>