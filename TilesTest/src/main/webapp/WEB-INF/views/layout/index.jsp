<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tiles</title>
<tiles:insertAttribute name="asset"></tiles:insertAttribute>

</head>
<body>
	<header>
		<h1>Titles</h1>
		<tiles:insertAttribute name="main_menu"></tiles:insertAttribute>

	</header>
	
		<tiles:insertAttribute name="content"></tiles:insertAttribute>

</body>
</html>