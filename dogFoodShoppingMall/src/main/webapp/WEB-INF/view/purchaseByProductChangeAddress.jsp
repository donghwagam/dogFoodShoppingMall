<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	.invoice-title h2, .invoice-title h3 {
	    display: inline-block;
	}
	
	.table > tbody > tr > .no-line {
	    border-top: none;
	}
	
	.table > thead > tr > .no-line {
	    border-bottom: none;
	}
	
	.table > tbody > tr > .thick-line {
	    border-top: 2px solid;
	}
</style>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>purchase</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-12">
    		<div class="invoice-title">
    			<h2>결제</h2>
    		</div>
    		<hr>
    		<div class="row">
    			<div class="col-xs-12">
    				<address>
	    				<strong><a href="${pageContext.request.contextPath}/loginCheck/purchaseByProductController?productId=${productId}&photoName=${photoName}&productName=${productName}&quantity=${quantity}&totalPriceByProduct=${totalPriceByProduct}">기본정보</a></strong> &nbsp;&nbsp;|&nbsp;
	    				<strong><a href="${pageContext.request.contextPath}/loginCheck/purchaseByProductChangeAddressController?productId=${productId}&photoName=${photoName}&productName=${productName}&quantity=${quantity}&totalPriceByProduct=${totalPriceByProduct}">배송정보변경</a></strong>
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
	    					<table>
	    						<tr>
	    							<input type="hidden" name="productId" value="${productId}">
	    							<td>상세주소 &nbsp; |&nbsp;&nbsp;&nbsp;</td>
	    							<td><input type="text" name="detailAddr" style="width: 500px;"></td>
	    						</tr>
	    						<tr>
	    							<td>전화번호 &nbsp; |</td>
	    							<td><input type="text" name="phone"></td>
	    						</tr>
	    						<tr>
	    							<td>받는사람 &nbsp; |</td>
	    							<td><input type="text" name="name"></td>
	    						</tr>
	    					</table>
    				</address>
    			</div>
    		</div>
				<address>
					<strong>결제방법</strong><br>
					<input type="hidden" name="payment" value="무통장입금">무통장입금
				</address>
    	</div>
    </div>
    
    	<div class="row">
    		<div class="col-md-12">
    			<div class="panel panel-default">
    				<div class="panel-heading">
    					<h3 class="panel-title"><strong>결제 정보</strong></h3>
    				</div>
    				<div class="panel-body">
    					<div class="table-responsive">
    						<table class="table table-condensed">
	    						<thead>
	                                <tr>
	        							<td><strong>사진</strong></td>
	        							<td class="text-center"><strong>상품</strong></td>
	        							<td class="text-center"><strong>수량</strong></td>
	        							<td class="text-right"><strong>총 가격</strong></td>
	                                </tr>
	    						</thead>
    							<tbody>
	    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
	    							<tr>
	    								<td><input type="text" name="photoName" value="${photoName}" readonly="readonly" style="border:0 solid black"></td>
	    								<td class="text-center"><input class="text-center" type="text" name="productName" value="${productName}" readonly="readonly" style="border:0 solid black"></td>
	    								<td class="text-center"><input class="text-center" type="text" name="quantity" value="${quantity}" readonly="readonly" style="border:0 solid black"></td>
	    								<td class="text-right"><input class="text-right" type="text" name="totalPriceByProduct" value="${totalPriceByProduct}" readonly="readonly" style="border:0 solid black">원</td>
	    							</tr>
	    							<tr>
	    								<td class="thick-line"></td>
	    								<td class="thick-line"></td>
	    								<td class="thick-line text-center"><strong>총 가격</strong></td>
	    								<td class="thick-line text-right">${totalPriceByProduct}원</td>
	    							</tr>
	    							<tr>
	    								<td colspan="4" class="text-right"><button type="submit">결제하기</button></td>
	    							</tr>
    							</tbody>
    						</table>
    					</form>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
</div>
</html>
