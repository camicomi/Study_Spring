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
	<h1>등록하기</h1>
	
	<form metho="POST" action="/mybatis/addok.do">
	<table class="vertical">
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="number" name="age" required></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" required></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<select name="gender">
					<option value="m">남자</option>
					<option value="f">여자</option>
				</select>
			</td>
		</tr>
	</table>
	<div>
		<input type="submit" value="보내기">
	</div>
</form>

</body>
</html>