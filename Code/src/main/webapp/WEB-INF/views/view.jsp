<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  code highlighter
https://highlightjs.org/  -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/styles/obsidian.css">
<link rel="stylesheet" href="http://pinnpublic.dothome.co.kr/cdn/example-min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/highlight.js/11.9.0/highlight.min.js"></script>
<style>
	#code {
		margin: 1rem;
		border: 1px solid var(--border-color);
	}
	#code * {
		font-family: consolas;
	}
</style>
</head>
<body>
	<h1>Code <small>상세보기</small></h1>
	
	<table>
		<tr>
			<th>번호</th>
			<td>${dto.seq}</td>
			<th>날짜</th>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<td colspan="4">${dto.subject}</td>
		</tr>
	</table>
	
	<pre id="code"><code class="language-${dto.language}"><c:out value="${dto.code}"></c:out></code></pre>
	
	<div>
		<button type="button" class="back"
			onclick="location.href='/code/list.do';">돌아가기</button>
	</div>
	
	<script>
		hljs.highlightAll();
	</script>
</body>
</html>

