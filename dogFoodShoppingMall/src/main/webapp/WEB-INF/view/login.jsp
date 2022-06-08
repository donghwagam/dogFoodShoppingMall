<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
   .msgbox{
   position: fixed;
   top:10px;
   left: 35%;
   background-color: #ffffff;
   padding-top: 100px;
   padding-bottom: 100px;
   padding-left: 50px;
   padding-right: 50px;
   width: 500px;
   height: 600px;
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
               <div class="form-group">
               	  <input type="hidden" name="productId" value="${productId}">
               	  <c:choose>
               	  	<c:when test="${cookieId!=null}">
               	  		<input type="text" class="form-control" name="memberId" id="memberId" value="${cookieId}" placeholder="아이디">
               	  	</c:when>
               	  	<c:otherwise>
               	  		<input type="text" class="form-control" name="memberId" id="memberId" value="admin" placeholder="아이디">
               	  	</c:otherwise>
               	  </c:choose>
               </div>
               <div class="form-group">
                  <input type="password" class="form-control" name="memberPw" id="memberPw" value="1234" placeholder="비밀번호">
               </div>
               <div class="forgot" style="text-align:right;">
                  <input type="checkbox" name="idSave"> 아이디 저장<br>
                  <a href="${pageContext.request.contextPath}/insertMemberController" >회원가입</a> /
                  <a href="${pageContext.request.contextPath}/searchMemberIdController" >아이디 찾기</a> /
                  <a href="${pageContext.request.contextPath}/searchMemberPwController" >비밀번호 찾기</a>  
               </div>
               <button type="submit" class="btn btn-primary">로그인</button>
            </form>
            <c:if test="${msg!=null}" >
            <!-- Modal --> 
              <div class="msgbox">
                 비밀번호를 변경 3개월 경과하였습니다. <br>
                 개인정보 보호를 위해 비밀번호를 변경하시겠습니까?
                 <br>
                 <div class="text-center">
                 <a href="${pageContext.request.contextPath}/extensionPwController" class="btn">3개월 더 연장하기</a>
                 <a href="${pageContext.request.contextPath}/updateChkNowPwController" class="btn">비밀번호 변경하기</a>
                 </div>
              </div>        
            </c:if>
         </div>
      </div>
   </div>
</body>
</html>