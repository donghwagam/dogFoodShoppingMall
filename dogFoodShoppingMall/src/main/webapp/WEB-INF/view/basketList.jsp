<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="get" action="${pageContext.request.contextPath}/purchaseController">
	<table border="1">
		<c:forEach var="b" items="${basketList}">
			<tr>
				<td>
					<img src = "${pageContext.request.contextPath}/images/${b.photoName}"  width="200" height="200"> 
				</td>
				<td>
					${b.productName} ${b.gram}g
				</td>
				<td>
					${b.price}원
				</td>
				<td>
				<select name="basketCount">
					<c:forEach var="i" begin="1" end="10">
						<option value="${i}" <c:if test="${i eq b.quantity}">selected</c:if>> ${i} </option>
					</c:forEach>
				</select>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/removeBasketController?productId=${b.productId}">삭제</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<button type="submit">결제하기</button>
</form>	
</body>
</html>