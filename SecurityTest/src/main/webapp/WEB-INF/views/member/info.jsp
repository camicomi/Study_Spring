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
	<!-- info.jsp -->
	
	<%@include file="/WEB-INF/views/inc/header.jsp" %>
	
	<h2>Info Page</h2>
	
	<div class="message" title="principal">
		<!-- CustomUser -->
		<sec:authentication property="principal"/>
	</div>
	
	<div class="message" title="MemberDTO">
		<sec:authentication property="principal.member"/>
	</div>
	
	<div class="message" title="사용자 아이디">
		<sec:authentication property="principal.username"/>
	</div>
	
	<div class="message" title="사용자 아이디">
		<sec:authentication property="principal.member.memberid"/>
	</div>
	
	<div class="message" title="사용자 이름">
		<sec:authentication property="principal.member.membername"/>
	</div>
	
	<div class="message" title="이메일">
		<sec:authentication property="principal.member.email"/>
	</div>
	
	<div class="message" title="사용자 권한">
		<sec:authentication property="principal.member.authlist"/>
	</div>
	
	
</body>
</html>










