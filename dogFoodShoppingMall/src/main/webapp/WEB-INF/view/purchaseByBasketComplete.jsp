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
<title>purchaseComplete</title>
</head>
<body>
	<div class="container">
		<div class="row">
	        <div class="col-xs-12">
	    		<div class="invoice-title">
	    			<h2>결제완료</h2>
	    		</div>
	    		<hr>
	    		<div class="row">
	    			<div class="col-xs-12">
	    				<address>
	    					<table>
	    						<tr>
	    							<td>받는사람 &nbsp; |&nbsp;&nbsp;&nbsp;</td>
	    							<td><input type="text" name="name" value="${purchaseAddress.purchaseName}" style="border:0 solid black" readonly="readonly"></td>
	    						</tr>
	    						<tr>
	    							<td>전화번호 &nbsp; |</td>
	    							<td><input type="text" name="phone" value="${purchaseAddress.purchasePhone}" style="border:0 solid black" readonly="readonly"></td>
	    						</tr>
	    						<tr>
	    							<td>배송주소 &nbsp; |</td>
	    							<td><input type="text" name="address" value="${purchaseAddress.address}" style="width: 500px; border:0 solid black" readonly="readonly"></td>
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
    								<c:forEach var="m" items="${memberBasketList}">
    									<tr>
		    								<td><input type="text" name="photoName" value="${m.photoName}" readonly="readonly" style="border:0 solid black"></td>
		    								<td class="text-center"><input class="text-center" type="text" name="photoName" value="${m.productName}" readonly="readonly" style="border:0 solid black"></td>
		    								<td class="text-center"><input class="text-center" type="text" name="quantity" value="${m.quantity}" readonly="readonly" style="border:0 solid black"></td>
		    								<td class="text-right"><input class="text-right" type="text" name="totalPriceByBasket" value="${m.price * m.quantity}" readonly="readonly" style="border:0 solid black">원</td>
	    								</tr>
    								</c:forEach>
	    								<tr>
		    								<td class="thick-line"></td>
		    								<td class="thick-line"></td>
		    								<td class="thick-line text-center"><strong>총 가격</strong></td>
		    								<td class="thick-line text-right">${totalPriceByBasket}원</td>
	    								</tr>
    							</tbody>
    						</table>
	    				</div>
	    			</div>
	    		</div>
	    	</div>
	    </div>
	</div>
</body>
</html>