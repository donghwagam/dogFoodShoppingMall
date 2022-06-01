<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style type="text/css">
.helper {
       color : #FF0000;
    }
	h1.page-header {
    margin-top: -5px;
}

.sidebar {
	padding-left: 0;
}

.main-container { 
	background: #FFF;
	padding-top: 15px;
	margin-top: -20px;
}

.footer {
	width: 100%;
}  

:focus {
	outline: none;
}

.side-menu {
	position: relative;
	width: 100%;
	height: 100%;
	background-color: #f8f8f8;
	border-right: 1px solid #e7e7e7;
}
.side-menu .navbar {
	border: none;
}
.side-menu .navbar-header {
	width: 100%;
	border-bottom: 1px solid #e7e7e7;
}
.side-menu .navbar-nav .active a {
	background-color: transparent;
	margin-right: -1px;
	border-right: 5px solid #e7e7e7;
}
.side-menu .navbar-nav li {
	display: block;
	width: 100%;
	border-bottom: 1px solid #e7e7e7;
}
.side-menu .navbar-nav li a {
	padding: 15px;
}
.side-menu .navbar-nav li a .glyphicon {
	padding-right: 10px;
}
.side-menu #dropdown {
	border: 0;
	margin-bottom: 0;
	border-radius: 0;
	background-color: transparent;
	box-shadow: none;
}
.side-menu #dropdown .caret {
	float: right;
	margin: 9px 5px 0;
}
.side-menu #dropdown .indicator {
	float: right;
}
.side-menu #dropdown > a {
	border-bottom: 1px solid #e7e7e7;
}
.side-menu #dropdown .panel-body {
	padding: 0;
	background-color: #f3f3f3;
}
.side-menu #dropdown .panel-body .navbar-nav {
	width: 100%;
}
.side-menu #dropdown .panel-body .navbar-nav li {
	padding-left: 15px;
	border-bottom: 1px solid #e7e7e7;
}
.side-menu #dropdown .panel-body .navbar-nav li:last-child {
	border-bottom: none;
}
.side-menu #dropdown .panel-body .panel > a {
	margin-left: -20px;
	padding-left: 35px;
}
.side-menu #dropdown .panel-body .panel-body {
	margin-left: -15px;
}
.side-menu #dropdown .panel-body .panel-body li {
	padding-left: 30px;
}
.side-menu #dropdown .panel-body .panel-body li:last-child {
	border-bottom: 1px solid #e7e7e7;
}
.side-menu #search-trigger {
	background-color: #f3f3f3;
	border: 0;
	border-radius: 0;
	position: absolute;
	top: 0;
	right: 0;
	padding: 15px 18px;
}
.side-menu .brand-name-wrapper {
	min-height: 50px;
}
.side-menu .brand-name-wrapper .navbar-brand {
	display: block;
}
.side-menu #search {
	position: relative;
	z-index: 1000;
}
.side-menu #search .panel-body {
	padding: 0;
}
.side-menu #search .panel-body .navbar-form {
	padding: 0;
	padding-right: 50px;
	width: 100%;
	margin: 0;
	position: relative;
	border-top: 1px solid #e7e7e7;
}
.side-menu #search .panel-body .navbar-form .form-group {
	width: 100%;
	position: relative;
}
.side-menu #search .panel-body .navbar-form input {
	border: 0;
	border-radius: 0;
	box-shadow: none;
	width: 100%;
	height: 50px;
}
.side-menu #search .panel-body .navbar-form .btn {
	position: absolute;
	right: 0;
	top: 0;
	border: 0;
	border-radius: 0;
	background-color: #f3f3f3;
	padding: 15px 18px;
}
/* Main body section */
.side-body {
	margin-left: 310px;
}
/* small screen */
@media (max-width: 768px) {
	.side-menu {
		position: relative;
		width: 100%;
		height: 0;
		border-right: 0;
	}

	.side-menu .navbar {
		z-index: 999;
		position: relative;
		height: 0;
		min-height: 0;
		background-color:none !important;
		border-color: none !important;
	}
	.side-menu .brand-name-wrapper .navbar-brand {
		display: inline-block;
	}
	/* Slide in animation */
	@-moz-keyframes slidein {
		0% {
			left: -300px;
		}
		100% {
			left: 10px;
		}
	}
	@-webkit-keyframes slidein {
		0% {
			left: -300px;
		}
		100% {
			left: 10px;
		}
	}
	@keyframes slidein {
		0% {
			left: -300px;
		}
		100% {
			left: 10px;
		}
	}
	@-moz-keyframes slideout {
		0% {
			left: 0;
		}
		100% {
			left: -300px;
		}
	}
	@-webkit-keyframes slideout {
		0% {
			left: 0;
		}
		100% {
			left: -300px;
		}
	}
	@keyframes slideout {
		0% {
			left: 0;
		}
		100% {
			left: -300px;
		}
	}
	/* Slide side menu*/
	/* Add .absolute-wrapper.slide-in for scrollable menu -> see top comment */
	.side-menu-container > .navbar-nav.slide-in {
		-moz-animation: slidein 300ms forwards;
		-o-animation: slidein 300ms forwards;
		-webkit-animation: slidein 300ms forwards;
		animation: slidein 300ms forwards;
		-webkit-transform-style: preserve-3d;
		transform-style: preserve-3d;
	}
	.side-menu-container > .navbar-nav {
		/* Add position:absolute for scrollable menu -> see top comment */
		position: fixed;
		left: -300px;
		width: 300px;
		top: 43px;
		height: 100%;
		border-right: 1px solid #e7e7e7;
		background-color: #f8f8f8;
		overflow: auto;
		-moz-animation: slideout 300ms forwards;
		-o-animation: slideout 300ms forwards;
		-webkit-animation: slideout 300ms forwards;
		animation: slideout 300ms forwards;
		-webkit-transform-style: preserve-3d;
		transform-style: preserve-3d;
	}
	@-moz-keyframes bodyslidein {
		0% {
			left: 0;
		}
		100% {
			left: 300px;
		}
	}
	@-webkit-keyframes bodyslidein {
		0% {
			left: 0;
		}
		100% {
			left: 300px;
		}
	}
	@keyframes bodyslidein {
		0% {
			left: 0;
		}
		100% {
			left: 300px;
		}
	}
	@-moz-keyframes bodyslideout {
		0% {
			left: 300px;
		}
		100% {
			left: 0;
		}
	}
	@-webkit-keyframes bodyslideout {
		0% {
			left: 300px;
		}
		100% {
			left: 0;
		}
	}
	@keyframes bodyslideout {
		0% {
			left: 300px;
		}
		100% {
			left: 0;
		}
	}
	/* Slide side body*/
	.side-body {
		margin-left: 5px;
		margin-top: 70px;
		position: relative;
		-moz-animation: bodyslideout 300ms forwards;
		-o-animation: bodyslideout 300ms forwards;
		-webkit-animation: bodyslideout 300ms forwards;
		animation: bodyslideout 300ms forwards;
		-webkit-transform-style: preserve-3d;
		transform-style: preserve-3d;
	}
	.body-slide-in {
		-moz-animation: bodyslidein 300ms forwards;
		-o-animation: bodyslidein 300ms forwards;
		-webkit-animation: bodyslidein 300ms forwards;
		animation: bodyslidein 300ms forwards;
		-webkit-transform-style: preserve-3d;
		transform-style: preserve-3d;
	}
	/* Hamburger */
	.navbar-toggle-sidebar {
		border: 0;
		float: left;
		padding: 18px;
		margin: 0;
		border-radius: 0;
		background-color: #f3f3f3;
	}
	/* Search */
	#search .panel-body .navbar-form {
		border-bottom: 0;
	}
	#search .panel-body .navbar-form .form-group {
		margin: 0;
	}
	.side-menu .navbar-header {
		/* this is probably redundant */
		position: fixed;
		z-index: 3;
		background-color: #f8f8f8;
	}
	/* Dropdown tweek */
	#dropdown .panel-body .navbar-nav {
		margin: 0;
	}
}
</style>
</head>
<body>
	<!------ Include the above in your HEAD tag ---------->

<nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle navbar-toggle-sidebar collapsed">
			MENU
			</button>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a href="${pageContext.request.contextPath}/adminCheck/adminPageController" class="navbar-brand"  >
				Administrator
			</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">      
			<form class="navbar-form navbar-left" method="GET" role="search">
				<div class="form-group">
					<input type="text" name="q" class="form-control" placeholder="Search">
				</div>
				<button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown ">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
						${sessionMemberId} 님 반갑습니다
						<span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li class="dropdown-header">SETTINGS</li>
							<li class=""><a href="#">Other Link</a></li>
							<li class=""><a href="#">Other Link</a></li>
							<li class=""><a href="#">Other Link</a></li>
							<li class="divider"></li>
							<li><a href="${pageContext.request.contextPath}/loginCheck/logoutController">Logout</a></li>
						</ul>
					</li>
				</ul>
			</div><!-- /.navbar-collapse -->
		</div><!-- /.container-fluid -->
	</nav>  	<div class="container-fluid main-container">
  		<div class="col-md-2 sidebar">
  			<div class="row">
	<!-- uncomment code for absolute positioning tweek see top comment in css -->
	<div class="absolute-wrapper"> </div>
	<!-- Menu -->
	<div class="side-menu">
		<nav class="navbar navbar-default" role="navigation">
			<!-- Main Menu -->
			<div class="side-menu-container">
				<ul class="nav navbar-nav">
					<li class="active"><a href="${pageContext.request.contextPath}/mainPageController"><span class="glyphicon glyphicon-dashboard"></span>홈</a></li>
					<li><a href="${pageContext.request.contextPath}/memberListController"><span class="glyphicon glyphicon-plane"></span>회원정보</a></li>
					<li><a href="${pageContext.request.contextPath}/productManagementController"><span class="glyphicon glyphicon-cloud"></span> 상품 정보</a></li>
					<li><a href="${pageContext.request.contextPath}/chartListController"><span class="glyphicon glyphicon-signal"></span> 통계</a></li>
				</ul> 
			</div><!-- /.navbar-collapse -->
		</nav>

	</div>
</div>
 </div>
  	<div class="container">
	<div class="row">
		<div class="span5">
		<form method="post" id="insertProductForm" action="${pageContext.request.contextPath}/insertProductController" enctype="multipart/form-data">
            <table class="table table-striped table-condensed">
                  <tr>
                      <th>상품 이름</th>
                      <td>
                     	 <input type="text" name="productName" id="productName" placeholder="상품이름" >
                     	 <span id="productNameHelper" class="helper"></span>
                      </td>
                      
                  </tr>
                  <tr>
                      <th>가격</th>
                      <td>
                     	 <input type="number" id= "price" name="price" placeholder="가격">원
                     	 <span id="priceHelper" class="helper"></span>
                      </td>
                  </tr>
                  <tr>
                      <th>그램</th>
                      <td>
                      	<input type="text" name="gram" id="gram" placeholder="무게">g
                      	<span id="gramHelper" class="helper"></span>
                      </td>
                  </tr>
                  <tr>
                  	<th>등급</th>
                  	<td>
                  		<select name="rate" id="rate">
                  				<option value="" selected="selected">::등급선택::</option>
	                    		<option value="로가닉">로가닉</option>
	                    		<option value="오가닉">오가닉</option>
	                    		<option value="홀리스틱">홀리스틱</option>
	                    		<option value="슈퍼프리미엄">슈퍼프리미엄</option>
	                    		<option value="프리미엄">프리미엄</option>
	                    		<option value="일반">일반</option>
	                    </select>
	                    <span id="rateHelper" class="helper"></span>
                  	</td>
                  </tr>
                  <tr>
                      <th>알갱이크기</th>
                      <td>
                      	<select name="feedSize" id="feedSize">
                      			<option value="" selected="selected">::크기선택::</option>
	                    		<option value="소">소</option>
	                    		<option value="중">중</option>
	                    		<option value="대">대</option>
	                    </select>
	                    <span id="feedSizeHelper" class="helper"></span>
                      </td>
                  </tr>
                  <tr>
                      <th>원산지</th>
                      <td>
                      	<input type="text" name="origin" id="origin" placeholder="원산지">
                      	<span id="originHelper" class="helper"></span>
                      </td>
                  </tr>
                  <tr>
                      <th>정보</th>
                      <td>
                      <textarea name="info" id="info"></textarea>
                      <span id="infoHelper" class="helper"></span>
                      </td>
                  </tr>
                  <tr>
                      <th>상품 사진</th>
                      <td>
                      	<input type="file" name="productPhoto" id="productPhoto">
                      	<span id="productPhotoHelper" class="helper"></span>
                      </td>
                  </tr>
                  <tr>
                      <th>재고</th>
                      <td>
                      	<input type="number" name="stock" id="stock">
                      	<span id="stockHelper" class="helper"></span>
                      </td>
                  </tr>
                  <tr>
                      <th>브랜드</th>
                      <td>
                      	<select name="brandId" id="brandId">
                      			<option value="" selected="selected">::브랜드선택::</option>
                      		<c:forEach var="b" items="${brandList}">
	                    		<option value="${b.brandId}">${b.name}</option>
	                    	</c:forEach>
	                    </select>
	                    <span id="brandHelper" class="helper"></span>
                      </td>
                  </tr>
                  <tr>
                  	<th>구성 성분</th>
                  	<td>
                  	<c:forEach var="co" items="${componentList}">
	                  	<input type="checkbox" name="component" id="component" value="${co.componentId}">${co.name}
	                 </c:forEach>
	                 <span id="componentHelper" class="helper"></span>
                  	</td>
                  </tr>
                  <tr>
                      <th>카테고리</th>
                      <td>
                      	<c:forEach var="c" items="${categoryList}">
                      		<input type="checkbox" name="category" id="category" value="${c.categoryId}">${c.name}
                       	</c:forEach>
                       	<span id="categoryHelper" class="helper"></span>
                      </td>
                  </tr>
			</table>
			 <button id="insertProduct" type="submit" class="btn btn-success form-control">제품 추가</button>
			</form>
		</div>
	</div>
</div>
  		<footer class="pull-left footer">
  			<p class="col-md-12">
  				<hr class="divider">
  				Copyright &COPY; 2015 <a href="http://www.pingpong-labs.com">Gravitano</a>
  			</p>
  		</footer>
  	</div>
</body>
<script>
	
	// priductName 유효성 검사 
	$('#productName').blur(function() {
		if($('#productName').val().length > 0 && $('#productName').val().length < 4) {
			$('#productNameHelper').text('상품이름은 4자 이상 입력해주세요');
			$('#productName').focus();
		} else if ($('#productName').val().length > 50) {
			$('#productNameHelper').text('상품이름은 50자 이내로 입력해주세요');
			$('#productName').focus();
		} else {
			$('#productNameHelper').text('');
		}
	});
	// price 유효성 검사 
	$('#price').blur(function(){
		if($('#price').val() == '') {
			$('#priceHelper').text('가격을 입력해주새요');
			$('#price').focus();
		} else if ($('#price').val() < 1000) {
			$('#priceHelper').text('상품가격은 1000원이상 입력해주세요');
			$('#price').focus();
		} else {
			$('#priceHelper').text('');
		}
		
	});
	// gram 유효성 검사 
	$('#gram').blur(function(){
		if($('#gram').val() == '') {
			$('#gramHelper').text('무게를 입력해주세요');
			$('#gram').focus();
		} else if ($('#gram').val() < 100) {
			$('#gramHelper').text('100그램 이상 입력해주세요');
			$('#gram').focus();
		} else {
			$('#gramHelper').text('');
		}
	});
	//rate 유효성 검사 
	$('#rate').blur(function(){
		if($('#rate').val() == '') {
			$('#rateHelper').text('등급을 선택해주세요');
			$('#rate').focus();
		} else {
			$('#rateHelper').text('');
		}
	});
	//feedSize 유효성 검사 
	$('#feedSize').blur(function(){
		if($('#feedSize').val() == '') {
			$('#feedSizeHelper').text('크기를 선택해주세요');
			$('#feedSize').focus();
		} else {
			$('#feedSizeHelper').text('');
		}
	});
	// origin 유효성 검사 
	$('#origin').blur(function() {
		if($('#origin').val() == '') {
			$('#originHelper').text('원산지를 입력해주세요');
			$('#origin').focus();
		} else {
			$('#originHelper').text('');
		}
	});
	//info 유효성 검사
	$('#info').blur(function(){
		if($('#info').val() == '') {
			$('#infoHelper').text('정보를 입력해주세요');
			$('#info').focus();
		} else {
			$('#infoHelper').text('');
		}
	});
	// productPhoto 유효성 검사 
	$('#productPhoto').blur(function(){
		if($('#productPhoto').val() == '') {
			$('#productPhotoHelper').text('사진파일을 등록해주세요');
			$('#productPhoto').focus();
		} else if ($('productPhoto').val() != '') {
			if(!$('#productPhoto').val().match(/(.*?)\.(jpg|jpeg|png)$/)) {
				$('#productPhotoHelper').text('사진파일만 올려주세요');
				$('#productPhoto').focus();
			} else {
				$('#productPhotoHelper').text('');
			}
		}
	});
	// stock 유효성 검사 
	$('#stock').blur(function(){
		if($('#stock').val() == '') {
			$('#stockHelper').text('재고수량을 등록해주세요');
			$('#stock').focus();
		} else {
			$('#stockHelper').text('');
		}
	});
	// brand유효성 검사 
	$('#brandId').blur(function() {
		if($('#brandId').val() == '') {
			$('#brandHelper').text('브랜드를 선택해주세요');
			$('#brandId').focus();
		} else {
			$('#brandHelper').text('');
		}
	});
	
	$('#insertProduct').click(function(){
		if($('#productName').val() == '') {
			$('#productNameHelper').text('상품이름을 등록해주세요');
			$('#productName').focus();
			return false;
		} else if ($('#price').val() == ''){
			$('#productNameHelper').text('');
					
			$('#priceHelper').text('가격을 입력해주세요');
			$('#price').focus();
			return false;
		} else if ($('#gram').val() == '') {
			$('#priceHelper').text('');
			
			$('#gramHelper').text('무게를 입력해주세요');
			$('#gram').focus();
			return false;
		} else if ($('#rate').val() =='') {
			$('#gramHelper').text('');
			
			$('#rateHelper').text('등급을 입력해주세요');
			$('#rate').focus();
			return false;
		} else if ($('#feedSize').val() == '') {
			$('#rateHelper').text('');
			
			$('#feedSizeHelper').text('알맹이 크기를 입력해주세요');
			$('#feedSize').focus();
			return false;
		} else if ($('#origin').val() == '') {
			$('#feedSzieHelper').text('');
			
			$('#originHelper').text('원산지를 입력해주세요');
			$('#origin').focus();
			return false;
		} else if($('#info').val() == '') {
			$('#originHelper').text('');
			
			$('#infoHelper').text('정보를 입력해주세요');
			$('#info').focus();
			return false;
		} else if ($('#productPhoto').val() == '') {
			$('#infoHelper').text('');
			
			$('#productPhotoHelper').text('사진을 등록해주세요');
			$('#productPhoto').focus();
			return false;
		} else if ($('#stock').val() == '') {
			$('#productPhotoHelper').text('');
			
			$('#stockHelper').text('재고를 등록해주세요');
			$('#stock').focus();
			return false;
		} else if ($('#brandId').val() == '') {
			$('#stockHelper').text('');
			
			$('#brandHelper').text('브랜드를 입력해주세요');
			$('#brandId').focus();
			return false;
		} else if ($('#component:checked').length == 0) {
			$('#brandHelper').text('');
			
			$('#componentHelper').text('구성성분을 한개 이상 선택해주세요');
			$('#component').focus();
			return false;
		} else if ($('#category:checked').length == 0) {
			$('#componentHelper').text('');
			
			$('#categoryHelper').text('카테고리를 하나 이상선택해주세요');
			$('#category').focus();
			return false;
		} else {
			$('#insertProductForm').submit();
		}
	});
	
	
</script>
</html>
