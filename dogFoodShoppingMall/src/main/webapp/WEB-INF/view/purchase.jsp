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
	<br><a href="${pageContext.request.contextPath}/loginCheck/purchaseController">기본배송정보</a> |
	<a href="${pageContext.request.contextPath}/loginCheck/PurchaseChangeAddressController">배송정보변경</a>
	
	
	<form method="post" action="${pageContext.request.contextPath}/loginCheck/purchaseCompleteController">
		<br><br> 이름 : <input type="text" class="name" name="name" id="name" readonly="readonly" value="${name}" >
		<br><br> 휴대폰번호 : <input type="text" class="phone" name="phone" id="phone" readonly="readonly" value="${phone}" > 
		<br><br> 주소 : <input type="text" class="address" name="address" id="address" readonly="readonly" value="${address}" style="width:400px;">
		
		
		<br><br> 사진 : <input type="text" class="photoName" name="photoName" id="photoName" readonly="readonly" value="${photoName}" > 
		<br><br> 상품이름 : <input type="text" class="productName" name="productName" id="productName" readonly="readonly" value="${productName}" > 
		<br><br> 수량 : <input type="text" class="quantity" name="quantity" id="quantity" readonly="readonly" value="${quantity}" > 
		<br><br> 상품합계 : <input type="text" class="totalPriceByProduct" name="totalPriceByProduct" id="totalPriceByProduct" readonly="readonly" value="${totalPriceByProduct}" > 
		
		
		<br><br> 결제수단 : <input type="radio" name="payment" value="무통장입금" checked="checked">무통장입금
      	<br><br><button type = "button">결제하기</button>
	</form>
	
</body>
<script>
	
</script>
</html>
