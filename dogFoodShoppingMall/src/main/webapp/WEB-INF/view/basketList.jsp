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
		<!--  비회원으로 들어왔을때 -->
		<c:forEach var="g" items="${guestBasketList}">
			<tr>
				<td>
					<img src = "${pageContext.request.contextPath}/images/${g.photoName}"  width="200" height="200"> 
				</td>
				<td>
					${g.productName} ${g.gram}g
				</td>
				<td>
					${g.price}원
				</td>
				<td>
				<select name="basketCount">
					<c:forEach var="i" begin="1" end="10">
						<option value="${i}" <c:if test="${i eq g.quantity}">selected</c:if>> ${i} </option>
					</c:forEach>
				</select>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/removeGuestBasketController?productId=${g.productId}">삭제</a>
				</td>
			</tr>
		</c:forEach>
		
		<!--  회원으로 들어왔을때 -->
		<c:forEach var="m" items="${memberBasketList}">
			<tr>
				<td>
					<img src = "${pageContext.request.contextPath}/images/${m.photoName}"  width="200" height="200"> 
				</td>
				<td>
					${m.productName} ${m.gram}g
				</td>
				<td>
					${m.price}원
				</td>
				<td>
				<select name="basketCount">
					<c:forEach var="i" begin="1" end="10">
						<option value="${i}" <c:if test="${i eq m.quantity}">selected</c:if>> ${i} </option>
					</c:forEach>
				</select>
				</td>
				<td>
					<a href="${pageContext.request.contextPath}/removeMemberBasketController?productId=${m.productId}">삭제</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<button type="submit">결제하기</button>
</form>	
</body>
</html>