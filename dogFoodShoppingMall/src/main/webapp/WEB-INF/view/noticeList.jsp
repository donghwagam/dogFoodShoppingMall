<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>noticeList</title>
</head>
<body>
	<h1>공지사항</h1>
	<table>
		<tr>
			<th>제목</th>
			<th>작성날짜</th>
		</tr>
			<c:forEach var="n" items="${noticeList}">
				<tr>
					<td>${n.noticeTitle}</td>
					<td>${n.createDate}</td>
				</tr>
			</c:forEach>
	</table>
</body>
</html>