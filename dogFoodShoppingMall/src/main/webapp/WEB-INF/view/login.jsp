<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	body#LoginForm {
		background-image:
			url("https://hdwallsource.com/img/2014/9/blur-26347-27038-hd-wallpapers.jpg");
		background-repeat: no-repeat;
		background-position: center;
		background-size: cover;
		padding: 10px;
	}
	
	.form-heading {
		color: #fff;
		font-size: 23px;
	}
	
	.panel h2 {
		color: #444444;
		font-size: 18px;
		margin: 0 0 8px 0;
	}
	
	.panel p {
		color: #777777;
		font-size: 14px;
		margin-bottom: 30px;
		line-height: 24px;
	}
	
	.login-form .form-control {
		background: #f7f7f7 none repeat scroll 0 0;
		border: 1px solid #d4d4d4;
		border-radius: 4px;
		font-size: 14px;
		height: 50px;
		line-height: 50px;
	}
	
	.main-div {
		background: #ffffff none repeat scroll 0 0;
		border-radius: 2px;
		margin: 10px auto 30px;
		max-width: 38%;
		padding: 50px 70px 70px 71px;
	}
	
	.login-form .form-group {
		margin-bottom: 10px;
	}
	
	.login-form {
		text-align: center;
	}
	
	.forgot a {
		color: #777777;
		font-size: 14px;
		text-decoration: underline;
	}
	
	.login-form  .btn.btn-primary {
		background: #f0ad4e none repeat scroll 0 0;
		border-color: #f0ad4e;
		color: #ffffff;
		font-size: 14px;
		width: 100%;
		height: 50px;
		line-height: 50px;
		padding: 0;
	}
	
	.forgot {
		text-align: left;
		margin-bottom: 30px;
	}
	
	.botto-text {
		color: #ffffff;
		font-size: 14px;
		margin: auto;
	}
	
	.login-form .btn.btn-primary.reset {
		background: #ff9900 none repeat scroll 0 0;
	}
	
	.back {
		text-align: left;
		margin-top: 10px;
	}
	
	.back a {
		color: #444444;
		font-size: 13px;
		text-decoration: none;
	}
</style>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<title>Login</title>
</head>
<body id="LoginForm">
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>로그인</h2><br>
				</div>
				<form method="post" action="${pageContext.request.contextPath}/loginController" id="Login">
					<input type="number" name="productId" value="${productId}" hidden="hidden">
					<div class="form-group">
						<input type="text" class="form-control" name="memberId" id="memberId" value="${cookieId}" placeholder="아이디">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="memberPw" id="memberPw" placeholder="비밀번호">
					</div>
					<div class="forgot" style="text-align:right;">
						<input type="checkbox" name="idSave"> 아이디 저장<br>
						<a href="${pageContext.request.contextPath}/loginDenied/insertMemberController" >회원가입</a> /
						<a href="${pageContext.request.contextPath}/loginDenied/searchMemberIdController" >아이디 찾기</a> /
						<a href="${pageContext.request.contextPath}/loginDenied/searchMemberPwController" >비밀번호 찾기</a>  
					</div>
					<button type="submit" class="btn btn-primary">로그인</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>