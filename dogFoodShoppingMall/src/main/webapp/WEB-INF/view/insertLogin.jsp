<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body { padding-top:30px; }
	.form-control { margin-bottom: 10px; }
</style>
<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>insert Login</title>
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
	            <legend style="text-align:center;">회원가입</legend>
	            <form method="post" action="${pageContext.request.contextPath}/searchAddressController">
		          	<input class="form-control" name="searchAddress" placeholder="주소" type="text""/>
		          	<button class="btn btn-sm btn-danger btn-block" type="submit">주소검색</button><br>
		        </form>
	            <form action="${pageContext.request.contextPath}/insertMemberController" method="post" class="form" role="form">
	            	<c:if test="${searchAddressList != null}">
	            		<select class="form-control" name="addressId">
		       		    	<option value = "" style="text-align:center;">:: 주소 선택 ::</option>
				            <c:forEach var="s" items="${searchAddressList}">
				            		<option value="${s.addressId}" style="text-align:center;">${s.addr}</option>
				            </c:forEach>
		            	</select>
	            	</c:if>
		            <input class="form-control" name="detailAddr" placeholder="상세주소" type="text"/>
		            <input class="form-control" name="name" placeholder="이름" type="text" required/>
		            <input class="form-control" name="memberId" placeholder="아이디" type="text"/>
		            <input class="form-control" name="memberPw" placeholder="비밀번호" type="password"/>
		            <input class="form-control" name="memberPwCheck" placeholder="비밀번호 확인" type="password"/>
		            <input class="form-control" name="birth" type="date"/>
		            <input class="form-control" name="phone" placeholder="전화번호" type="text"/>
		            <input class="form-control" name="email" placeholder="이메일주소" type="text"/>
		            
		            <label class="radio-inline">
		                <input type="radio" name="gender" id="inlineCheckbox1" value="남"/>남
		            </label>
		            <label class="radio-inline">
		                <input type="radio" name="gender" id="inlineCheckbox2" value="여"/>여
		            </label>
		            <br/>
		            <br/>
		            <button class="btn btn-lg btn-primary btn-block" type="submit">회원가입</button>
	            </form>
	        </div>
	    </div>
	</div>
</body>
</html>