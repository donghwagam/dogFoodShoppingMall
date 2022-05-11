<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
</head>
<body>
<h1>mainPage</h1>
	<table border="1">
		<c:forEach var="category" items="${categoryList}">
			<tr>
				<td><a href ="<%=request.getContextPath()%>/MainPageController?categoryName=${category.name}">${category.name}</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<table border="1">
		<c:forEach var="product" items="${productList}">
			<tr>
				<td>${product.productName}</td>
				<td>${product.price }</td>
				<td>${product.gram }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>