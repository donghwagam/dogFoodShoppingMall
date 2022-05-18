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
	<a href="${pageContext.request.contextPath}/loginCheck/purchaseByProductChangeAddressController?photoName=${photoName}&productName=${productName}&quantity=${quantity}&totalPriceByProduct=${totalPriceByProduct}">배송정보변경</a>
	<br><br>
	<form method="post" action="${pageContext.request.contextPath}/searchAddressController?productId=${productId}&msg=purchaseChangeAddr&photoName=${photoName}&productName=${productName}&quantity=${quantity}&totalPriceByProduct=${totalPriceByProduct}">
			주소 : <input class="form-control" name="searchAddress" placeholder="주소" type="text"/>
			<button class="btn btn-sm btn-danger btn-block" type="submit">주소검색</button><br>
	</form>
	<form method="post" action="${pageContext.request.contextPath}/loginCheck/purchaseByProductCompleteController">
		<c:if test="${searchAddressList != null}">
       		<select class="form-control" id="address" name="address">
   		    	<option value = "" style="text-align:center;">:: 주소 선택 ::</option>
	            <c:forEach var="s" items="${searchAddressList}">
	            	<option value="${s.addr}" style="text-align:center;">${s.addr}</option>
	            </c:forEach>
	            <span id="addressHelper" class="helper"></span>
           	</select>
      	</c:if>
      	
      	<input type="hidden" name="productId" value="${productId}">
      	<br><br> 상세주소 : <input class="form-control" id="detailAddr" name="detailAddr" placeholder="상세주소" type="text"/>
		<br><br> 이름 : <input type="text" class="name" name="name" id="name" placeholder="이름" value="" >
		<br><br> 휴대폰번호 : <input type="text" class="phone" name="phone" id="phone" placeholder="핸드폰번호" value="" > 
		
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
</html>