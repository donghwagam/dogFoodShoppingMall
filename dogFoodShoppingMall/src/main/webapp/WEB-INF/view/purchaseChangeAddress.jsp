<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>purchase</title>
</head>
<body>
<h1>이 사이트는 새로운 주소를 입력하는 페이지지롱~!</h1>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script> 
	<br><a href="${pageContext.request.contextPath}/loginCheck/purchaseController">기본배송정보</a> |
	<a href="${pageContext.request.contextPath}/loginCheck/PurchaseChangeAddressController">배송정보변경</a>
	<br><br>
	<form method="post" action="${pageContext.request.contextPath}/searchAddressController?msg=purchaseChangeAddr">
			주소 : <input class="form-control" name="searchAddress" placeholder="주소" type="text"/>
			<button class="btn btn-sm btn-danger btn-block" type="submit">주소검색</button><br>
	</form>
	<form method="post" action="${pageContext.request.contextPath}/loginCheck/purchaseCompleteController">
		<c:if test="${searchAddressList != null}">
       		<select class="form-control" id="addressId" name="addressId">
   		    	<option value = "" style="text-align:center;">:: 주소 선택 ::</option>
	            <c:forEach var="s" items="${searchAddressList}">
	            	<option value="${s.addressId}" style="text-align:center;">${s.addr}</option>
	            </c:forEach>
	            <span id="addressHelper" class="helper"></span>
           	</select>
      	</c:if>
      	
      	
      	<br><br> 상세주소 : <input class="form-control" id="detailAddr" name="detailAddr" placeholder="상세주소" type="text"/>
		<br><br> 이름 : <input type="text" class="name" name="name" id="name" value="" >
		<br><br> 휴대폰번호 : <input type="text" class="phone" name="phone" id="phone" value="" > 
		
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
		
		<br><br> 결제수단 : <input type="radio" name="payment" value="무통장입금" checked="checked">무통장입금
      	<br><br><button type = "submit">결제하기</button>
     	</form>

</body>
</html>