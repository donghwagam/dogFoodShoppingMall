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
<title>insert Dog</title>
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-xs-12 col-sm-12 col-md-4 well well-sm">
	            <legend style="text-align:center;">강아지 등록</legend>
	            <form id="dogInsertForm" action="${pageContext.request.contextPath}/loginCheck/insertDogController" method="post" class="form" role="form">
		            
		            <input class="form-control" id="dogName" name="dogName" placeholder="강아지 이름" type="text" />
		            <span id="dogNameHelper" class="helper"></span>
		            
		           	<input class="form-control" id="spiece" name="spiece" placeholder="견종" type="text" />
		            <span id="spieceHelper" class="helper"></span>
		            
		            <input class="form-control" id="birth" name="birth" placeholder="태어난 해" type="number"/>
		            <span id="birthHelper" class="helper"></span>
		            
		            <input class="form-control" id="weight" name="weight" placeholder="체중(kg)" type="text"/>
		            <span id="weightHelper" class="helper"></span>
		            
                	<input class="form-control" id="allergy" name="allergy" placeholder="알러지" type="text"/>
		            <span id="allergyHelper" class="helper"></span>
		            <br/>
		            <br/>
		            <button id="dogInsert" class="btn btn-lg btn-primary btn-block" type="button">강아지 등록</button>
	            </form>
	        </div>
	    </div>
	</div>
</body>
<script>

	
	$('#dogInsert').click(function() {
		if($('#dogName').val() == '') {
			$('#dogNameHelper').text('강아지 이름을 입력해주세요.');
			$('#dogName').focus();
		} else if($('#spiece').val() == '') {
			$('#dogNameHelper').text('');
			$('#spieceHelper').text('품종을 입력해주세요.');
			$('#spiece').focus();
		} else if($('#birth').val() == '') { 
			$('#spieceHelper').text('');
			$('#birthHelper').text('태어난 해를 입력해주세요.');
			$('#birth').focus();
		} else if($('#weight').val() == '') {
			$('#birthHelper').text('');
			$('#weightHelper').text('체중을 입력해주세요.');
			$('#weight').focus();
		} else if($('#allergy').val().length == 0) {
			$('#weightHelper').text('');
			$('#allergyHelper').text('알러지를 입력해주세요.');
			$('#allergy').focus();
		} else if($('#allergy').length != 0) {
			$('#allergyHelper').text('');
			$('#dogInsertForm').submit();
		} 
	});
</script>
</html>