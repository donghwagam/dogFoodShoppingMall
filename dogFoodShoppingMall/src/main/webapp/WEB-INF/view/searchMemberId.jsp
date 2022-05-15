<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
   body { padding-top:30px; }
   .form-control { margin-bottom: 10px; }
   .helper {
      color : #FF0000;
   }
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
               <form id="searchMemberIdForm" action="${pageContext.request.contextPath}/loginDenied/searchMemberIdController" method="post" class="form" role="form">
                  <input class="form-control" id="name" name="name" placeholder="이름" type="text" required/>
                  <span id="nameHelper" class="helper"></span>
                  <input class="form-control" id="phone" name="phone" placeholder="전화번호" type="text"/>
                  <span id="phoneHelper" class="helper"></span>
                  <br/>
                  <br/>
                  <button id="signUp" class="btn btn-lg btn-primary btn-block" type="button">아이디 찾기</button>
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
<script>
   $('#name').blur(function(){
      if($('#name').val() == ''){
    	  $('#nameHelper').text('이름을 입력해주세요.');
         $('#name').focus();
      } else {
         $('#nameHelper').text('');
      }
   });
   $('#phone').blur(function(){
      if($('#phone').val().indexOf('-') != -1){
         $('#phoneHelper').text('-을 제외해서 입력해주세요.');
         $('#phone').focus();
      } else {
         $('#phoneHelper').text('');
      }
   });

   $('#signUp').click(function(){
      if($('#name').val() == ''){
         $('#nameHelper').text('이름을 입력해주세요.');
         $('#name').focus();
      } else if ($('#phone').val() == '') {
         $('#nameHelper').text('')
         $('#phoneHelper').text('핸드폰번호를 입력해주세요.');
         $('#phone').focus();
      } else {
         $('#searchMemberIdForm').submit();
      }   
   });

</script>


</html>