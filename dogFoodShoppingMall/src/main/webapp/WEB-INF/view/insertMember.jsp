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
<title>insert Login</title>
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
	            <legend style="text-align:center;">회원가입</legend>
	            <form method="post" action="${pageContext.request.contextPath}/searchAddressController">
		          	<input class="form-control" name="searchAddress" placeholder="주소" type="text"/>
		          	<button class="btn btn-sm btn-danger btn-block" type="submit">주소검색</button><br>
		        </form>
	            <form id="signupForm" action="${pageContext.request.contextPath}/loginDenied/insertMemberController" method="post" class="form" role="form">
	            	<c:if test="${searchAddressList != null}">
	            		<select class="form-control" id="addressId" name="addressId">
		       		    	<option value = "" style="text-align:center;">:: 주소 선택 ::</option>
				            <c:forEach var="s" items="${searchAddressList}">
				            		<option value="${s.addressId}" style="text-align:center;">${s.addr}</option>
				            </c:forEach>
				            <span id="addressHelper" class="helper"></span>
		            	</select>
	            	</c:if>
	            	
		            <input class="form-control" id="detailAddr" name="detailAddr" placeholder="상세주소" type="text"/>
		            <span id="detailAddressHelper" class="helper"></span>
		            
		            <input class="form-control" id="name" name="name" placeholder="이름" type="text" required/>
		            <span id="nameHelper" class="helper"></span>
		            
		            <input class="form-control" id="memberId" name="memberId" placeholder="아이디" type="text"/>
		            <span id="idHelper" class="helper"></span>
		            
		            <input class="form-control" id="memberPw" name="memberPw" placeholder="비밀번호" type="password"/>
		            <span id="pwHelper" class="helper"></span>
		            
		            <input class="form-control" id="memberPwCheck" name="memberPwCheck" placeholder="비밀번호 확인" type="password"/>
		            <span id="pwCheckHelper" class="helper"></span>
		            
		            <input class="form-control" id="birth" name="birth" type="date"/>
		            <span id="dateHelper" class="helper"></span>
		            
		            <input class="form-control" id="phone" name="phone" placeholder="전화번호(-제외)" type="text"/>
		            <span id="phoneHelper" class="helper"></span>
		            
		            <input class="form-control" id="email" name="email" placeholder="이메일주소" type="text"/>   
		            <span id="emailHelper" class="helper"></span>   
		            
		            <label class="radio-inline">
		                <input type="radio" id="gender" name="gender" id="inlineCheckbox1" value="남"/>남
		            </label>
		            <label class="radio-inline">
		                <input type="radio" id="gender" name="gender" id="inlineCheckbox2" value="여"/>여
		            </label>
		            <span id="genderHelper" class="helper"></span>
		            <br/>
		            <br/>
		            <button id="signUp" class="btn btn-lg btn-primary btn-block" type="button">회원가입</button>
	            </form>
	        </div>
	    </div>
	</div>
</body>
<script>
	$('#detailAddr').blur(function() {
		if($('#detailAddr').val().length > 30) {
			$('#detailAddressHelper').text('상세주소는 30자 이내로 입력해주세요.');
			$('#detailAddr').val().substr(0, 30);
			$('#detailAddr').focus();
		} else {
			$('#detailAddressHelper').text('');
		}
	});
	
	$('#memberId').blur(function() {
		if($('#memberId').val().length  > 0 && $('#memberId').val().length < 4) {
			$('#idHelper').text('아이디는 4글자 이상으로 입력해주세요.');
			$('#memberId').focus();
		} else if($('#memberId').val().length > 15) {
			$('#idHelper').text('아이디는 15글자 이내로 입력해주세요.');
			$('#memberId').val().substr(0, 15);
			$('#memberId').focus();
		} else {
			$('#idHelper').text('');
		}
	});
	
	$('#memberPw').blur(function() {
		if($('#memberPw').val().length  > 0 && $('#memberPw').val().length < 4) {
			$('#pwHelper').text('비밀번호는 4글자 이상으로 입력해주세요.');
			$('#memberPw').focus();
		} else if($('#memberPw').val().length > 15) {
			$('#pwHelper').text('비밀번호는 15글자 이내로 입력해주세요.');
			$('#memberPw').val().substr(0, 15);
			$('#memberPw').focus();
		} else {
			$('#pwHelper').text('');
		}
	});
	
	$('#memberPwCheck').blur(function() {
		if($('#memberPw').val() != '') {
			if($('#memberPw').val() != $('#memberPwCheck').val()) {
				$('#pwCheckHelper').text('비밀번호가 일치하지 않습니다.');
			} else {
				$('#pwCheckHelper').text('비밀번호가 일치합니다.');
			}
		}
	});
		
	$('#phone').blur(function() {
		if($('#phone').val().indexOf('-') != -1) {
			$('#phoneHelper').text('-을 제외해서 입력해주세요.');
			$('#phone').focus();
		} else {
			$('#phoneHelper').text('');
		}
	});
	
	$('#email').blur(function() {
		if($('#email').val().indexOf('@') == -1 || $('#email').val().indexOf('.') == -1) {
			$('#emailHelper').text('이메일 형식이 다릅니다.');
			$('#email').focus();
		} else {
			$('#emailHelper').text('');
		}
	});
	
	$('#signUp').click(function() {
		if($('#addressId').val() == '') {
			$('#addressHelper').text('주소를 선택해주세요.');
			$('#addressId').focus();
		} else if($('#detailAddr').val() == '') {
			$('#addressHelper').text('');
			$('#detailAddressHelper').text('상세주소를 입력해주세요.');
			$('#detailAddr').focus();
		} else if($('#name').val() == '') { 
			$('#detailAddressHelper').text('');
			$('#nameHelper').text('이름을 입력해주세요.');
			$('#name').focus();
		} else if($('#memberId').val() == '') {
			$('#nameHelper').text('');
			$('#idHelper').text('아이디를 입력해주세요.');
			$('#memberId').focus();
		} else if($('#memberPw').val().length == 0) {
			$('#idHelper').text('');
			$('#pwHelper').text('비밀번호를 입력해주세요.');
			$('#memberPw').focus();
		} else if($('#memberPwCheck').val() == ''){
			$('#pwHelper').text('');
			$('#pwCheckHelper').text('비밀번호를 입력해주세요.');
			$('#memberPwCheck').focus();
		} else if($('#birth').val() == ''){
			$('#memberPwCheck').text('');
			$('#dateHelper').text('생년월일을 입력해주세요.');
			$('#birth').focus();
		} else if($('#phone').val() == '') {
			$('#dateHelper').text('');
			$('#phoneHelper').text('핸드폰번호를 입력해주세요.');
			$('#phone').focus();
		} else if($('#email').val() == '') {
			$('#phoneHelper').text('');
			$('#emailHelper').text('이메일을 입력해주세요.');
			$('#email').focus();
		} else if($('#gender:checked').length == 0) {
			$('#emailHelper').text('');
			$('#genderHelper').text('성별을 선택해주세요.');
			$('#gender').focus();
		} else if($('#gender:checked').length != 0) {
			$('#genderHelper').text('');
			$('#signupForm').submit();
		} 
	});
</script>
</html>