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
	
	<table>
		<tr>
			<th>seq</th>
			<th>name</th>
			<th>age</th>
			<th>gender</th>
			<th>address</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.name}</td>
			<td>${dto.age}</td>
			<td>${dto.gender}</td>
			<td>${dto.address}</td>
		</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<table>
		<tr>
			<th>seq</th>
			<th>name</th>
			<th>age</th>
			<th>gender</th>
			<th>address</th>
			<th>seq</th>
			<th>school</th>
			<th>country</th>
		</tr>
		<c:forEach items="${jlist}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.name}</td>
			<td>${dto.age}</td>
			<td>${dto.gender}</td>
			<td>${dto.address}</td>
			<!--  infoDTO  -->
			<td>${dto.info.seq}</td>
			<td>${dto.info.school}</td>
			<td>${dto.info.country}</td>
		</tr>
		</c:forEach>
	</table>
	
	<hr>
	
	<table>
		<tr>
			<th>seq</th>
			<th>name</th>
			<th>age</th>
			<th>gender</th>
			<th>address</th>
		</tr>
		<c:forEach items="${mlist}" var="dto">
		<tr>
			<td>${dto.seq}</td>
			<td>${dto.name}</td>
			<td>${dto.age}</td>
			<td>${dto.gender}</td>
			<td>${dto.address}</td>
		</tr>
		<tr>
			<td colspan="5">
			<ul>
			<c:forEach items="${dto.memo}" var="mdto">
				<li>${mdto.memo} - ${mdto.regdate}</li>
			</c:forEach>
			</ul>
			</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>













