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
	<div class="message" title="txt">${txt}</div>
	
	<div class="message" title="file"><a href="/file/resources/files/${filename}" download>${filename}</a></div>

	<div class="message" title="file"><a href="/file/download.do?filename=${filename}">${filename}</a></div>
	
	<c:forEach items="${attach}" var="file">
	<div>첨부파일명 : ${file.originalFilename}</div>
	</c:forEach>
	
</body>
</html>