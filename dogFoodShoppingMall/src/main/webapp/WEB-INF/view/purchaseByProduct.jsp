<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>purchase</title>
</head>
<body>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script> 
	<br><a href="${pageContext.request.contextPath}/loginCheck/purchaseByProductController?productId=${productId}&photoName=${photoName}&productName=${productName}&quantity=${quantity}&totalPriceByProduct=${totalPriceByProduct}">기본배송정보</a> |
	<a href="${pageContext.request.contextPath}/loginCheck/purchaseByProductChangeAddressController?productId=${productId}&photoName=${photoName}&productName=${productName}&quantity=${quantity}&totalPriceByProduct=${totalPriceByProduct}">배송정보변경</a>
	
	
	<form method="post" action="${pageContext.request.contextPath}/loginCheck/purchaseByProductCompleteController">
		<input type="hidden" name="productId" value="${productId}">
		<br><br> 이름 : <input type="text" class="name" name="name" id="name" readonly="readonly" value="${name}" >
		<br><br> 휴대폰번호 : <input type="text" class="phone" name="phone" id="phone" readonly="readonly" value="${phone}" > 
		<br><br> 주소 : <input type="text" class="address" name="address" id="address" readonly="readonly" value="${address}" style="width:400px;">
		
		<table>
			<tr>
				<th>사진</th>
				<th>상품</th>
				<th>수량</th>
				<th>가격</th>
			</tr>
			<tr>
				<td><input type="text" name="photoName" value="${photoName}" readonly="readonly"></td>
				<td><input type="text" name="productName" value="${productName}" readonly="readonly"></td>
				<td><input type="text" name="quantity" value="${quantity}" readonly="readonly"></td>
				<td><input type="text" name="totalPriceByProduct" value="${totalPriceByProduct}" readonly="readonly"></td>
			</tr>
		</table>
		
		<br><br> 결제수단 : <input type="radio" name="payment" value="무통장입금" checked="checked">무통장입금
      	<br><br><button type = "submit">결제하기</button>
	</form>
	
</body>
<script>
	
</script>
</html>
