<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body {
   padding-top: 30px;
}

.form-control {
   margin-bottom: 10px;
}

.helper {
   color: #FF0000;
}
</style>
<meta charset="UTF-8">
<link
   href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
   rel="stylesheet" id="bootstrap-css">
<script
   src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>update MemberPw</title>
</head>
<body>
   <div class="container">
      <div class="row">
         <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
            <legend style="text-align: center;">비밀번호 변경하기</legend>
            <form id="updateMemberIdForm" action="${pageContext.request.contextPath}/loginDenied/updateMemberPwController" method="post" class="form" role="form">
               <input type="hidden" name="memberId" value="${memberId}">
               <input type="hidden" name="phone" value="${phone}">
               
               <input class="form-control" id="memberPw" name="memberPw" placeholder="변경할 비밀번호" type="password" required />
               <span id="pwHelper" class="helper"></span>
               <input class="form-control" id="memberPwCheck" name="memberPwCheck" placeholder="비밀번호 확인" type="password" required />
               <span id="pwCheckHelper" class="helper"></span> <br /> <br />
               <button id="updateMemberPw" class="btn btn-lg btn-primary btn-block" type="button">비밀번호 수정</button>
            </form>
         </div>
      </div>
   </div>
</body>
<script>
   $('#memberPw').blur(function() {
      if ($('#memberPw').val().length > 0 && $('#memberPw').val().length < 4) {
         $('#pwHelper').text('비밀번호는 4글자 이상으로 입력해주세요.');
         $('#memberPw').focus();
      } else if ($('#memberPw').val().length > 15) {
         $('#pwHelper').text('비밀번호는 15글자 이내로 입력해주세요.');
         $('#memberPw').val().substr(0, 15);
         $('#memberPw').focus();
      } else {
         $('#pwHelper').text('');
      }
   });

   $('#memberPwCheck').blur(function() {
      if ($('#memberPwCheck').val().length > 0 && $('#memberPwCheck').val().length < 4) {
         $('#pwCheckHelper').text('비밀번호는 4글자 이상으로 입력해주세요.');
         $('#memberPwCheck').focus();
      } else if ($('#memberPwCheck').val().length > 15) {
         $('#pwCheckHelper').text('비밀번호는 15글자 이내로 입력해주세요.');
         $('#memberPwCheck').val().substr(0, 15);
         $('#memberPwCheck').focus();
      } else {
         $('#pwCheckHelper').text('');
      }
   });

   $('#memberPwCheck').blur(function() {
      if ($('#memberPw').val() != $('#memberPwCheck').val()) {
         $('#pwCheckHelper').text('비밀번호가 일치하지 않습니다.');
      } else {
         $('#pwCheckHelper').text('비밀번호가 일치합니다.');
      }
   });

   $('#updateMemberPw').click(function() {
      if ($('#memberPw').val() == '') {
         $('#pwHelper').text('비밀번호를 입력해주세요.');
         $('#memberPw').focus();
      } else if ($('#memberPwCheck').val() == '') {
         $('#pwHelper').text('');
         $('#pwCheckHelper').text('비밀번호를 입력해주세요.');
         $('#memberPwCheck').focus();
      } else {
         $('#updateMemberPwForm').submit();
      }
   });
</script>
</html>