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
<title>search MemberId</title>
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
	            <legend style="text-align:center;">아이디 찾기</legend>
	            <form action="${pageContext.request.contextPath}/loginDenied/searchMemberIdController" method="post" class="form" role="form">
		            <input class="form-control" name="name" placeholder="이름" type="text" required/>
		            <input class="form-control" name="phone" placeholder="전화번호" type="text"/>
		            <br/>
		            <br/>
		            <button class="btn btn-lg btn-primary btn-block" type="submit">아이디 찾기</button>
		            <c:if test="${memberId != null}">
	            		 <br>
	            		 <br>
	            		 <input class="form-control" type = "text" value="${memberId}" readonly="readonly">
	            		 <a href="${pageContext.request.contextPath}/loginDenied/loginController" class="btn btn-lg btn-primary btn-block">로그인 하러가기</a>
	            	</c:if>
	            </form>
	        </div>
	    </div>
	</div>
</body>
</html>