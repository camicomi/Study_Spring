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
		<%@include file="/WEB-INF/views/inc/admin_menu.jsp" %>
	</header>
	
	<h1>관리자 <small>환경설정</small></h1>
	
	<div>
		<button class="setting">권한 설정하기</button>
	</div>


</body>
</html>