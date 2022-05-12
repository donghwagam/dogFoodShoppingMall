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
<title>update MemberPw</title>
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
	            <legend style="text-align:center;">비딜번호 찾기</legend>
	            <form action="${pageContext.request.contextPath}/loginDenied/updateMemberPwController" method="post" class="form" role="form">
	            	<input type="hidden" name="memberId" value="${memberId}">
	            	<input type="hidden" name="phone" value="${phone}">
		            <input class="form-control" name="memberPw" placeholder="변경할 비밀번호" type="password" required/>
		            <input class="form-control" name="memberPwCheck" placeholder="비밀번호 확인" type="password" required/>
		            <br/>
		            <br/>
		            <button class="btn btn-lg btn-primary btn-block" type="submit">비밀번호 수정</button>
	            </form>
	        </div>
	    </div>
	</div>
</body>
</html>