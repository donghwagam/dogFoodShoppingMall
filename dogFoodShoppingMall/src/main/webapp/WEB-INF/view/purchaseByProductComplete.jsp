<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>purchaseComplete</title>
</head>
<body>
	<h1>결제 완료!!</h1>
	<h2>배송정보</h2>
	<div>
		${name} ${phone}</br>
		${address} ${detailAddr}
	</div>
	<table>
		<tr>
			<th>사진</th>
			<th>상품</th>
			<th>수량</th>
			<th>가격</th>
		</tr>
		<tr>
			<td>${photoName}</td>
			<td>${productName}</td>
			<td>${quantity}</td>
			<td>${totalPriceByProduct}</td>
		</tr>
	</table>
	<div>
		<a href="${pageContext.request.contextPath}/mainPageController">메인페이지로</a>
	</div>
</body>
</html>