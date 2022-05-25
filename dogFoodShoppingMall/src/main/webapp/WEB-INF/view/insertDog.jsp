<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Ogani Template">
<meta name="keywords" content="Ogani, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>mainPage</title>

<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="./Resources/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="./Resources/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="./Resources/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="./Resources/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="./Resources/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="./Resources/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="./Resources/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="./Resources/css/style.css" type="text/css">


<style type="text/css">
   body { padding-top:30px; }
   .form-control { margin-bottom: 10px; }
   .helper {
       color : #FF0000;
    }
   .bottom {margin-bottom:15px;}
   .top {margin-top:70px;}
</style>

<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header Section Begin -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="header__top__left">
							<ul>
								<li><i class="fa fa-envelope"></i> donghwagam@gmail.com</li>
								<li>Express Delivery with all Fresh Dog Foods</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="https://www.instagram.com/gaebobheaven/"><i class="fa fa-linkedin"></i></a> 
							 	<a href="https://open.kakao.com/o/gPlN8Ahe"><i class="fa fa-pinterest-p"></i></a>
							</div>
							<!-- 로그인/로그아웃/마이페이지 이동  -->
							<div class="header__top__right__auth">
								<span style="font-size: 14px">${sessionMemberId} 님 반갑습니다</span> 
								<a href="${pageContext.request.contextPath}/memberOneController" style="display: inline">| 마이페이지 </a>
								<a href="${pageContext.request.contextPath}/loginCheck/logoutController" style="display: inline"> | 로그아웃 </a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="header__logo">
						<a href="${pageContext.request.contextPath}/mainPageController"><img src="./Resources/img/dogFood.png"
							alt=""></a>
					</div>
				</div>
				<!--  상단바  -->
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="${pageContext.request.contextPath}/productSearchController">상세검색</a></li>
							<li><a href="${pageContext.request.contextPath}/noticeController">고객센터</a></li>
							
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
                        <ul>
                            <li>장바구니<a href="${pageContext.request.contextPath}/basketListController"><i class="fa fa-shopping-bag"></i></a></li>
                        </ul>
                    </div>
				</div>
			</div>
			<div class="humberger__open">
				<i class="fa fa-bars"></i>
			</div>
		</div>
	</header>
	<!-- Header Section End -->

	<!-- Hero Section Begin -->
	<section class="hero">
		<div class="container">
			<div class="row">
				<div class="col-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>마이페이지 목록</span>
						</div>
						<!-- 마이페이지 목록출력  -->	
						<ul >
                            <li><a href="${pageContext.request.contextPath}/memberOneController">회원/애견 정보</a></li>
							<li><a href="${pageContext.request.contextPath}/purchaseMemberListController">구매내역</a></li>
						</ul>
					</div>
				</div>
				<div class="col-9">
					<legend style="text-align:center;" class="bottom">강아지 등록</legend>
              	 <form id="dogInsertForm" action="${pageContext.request.contextPath}/insertDogController" method="post" class="form" role="form">
                  
                  <input class="form-control" id="dogName" name="dogName" placeholder="강아지 이름" type="text" />
                  <span id="dogNameHelper" class="helper"></span>
                  
                  <select class="form-control" name="spiece" id="spiece">
                     <option value="">견종</option>
                        <c:forEach var="s" items="${spieceList}">
                     		<option value="${s.dogId}">${s.spiece}
                        </c:forEach>
                  </select>
                  <span id="spieceHelper" class="helper"></span>
                  
                  <input class="form-control" id="birth" name="birth" placeholder="출생년도" type="number"/>
                  <span id="birthHelper" class="helper"></span>
                  
                  <input class="form-control" id="weight" name="weight" placeholder="체중(kg)" type="number"/>
                  <span id="weightHelper" class="helper"></span>
                  
                  <input class="form-control" placeholder="아래에서 알러지를 선택해주세요" readOnly="readOnly"/>
                  <c:forEach var="a" items="${allergyList}">
                  	<input type="checkbox" id="allergy" name="allergy" value="${a.allergyId}">${a.name}
               	  </c:forEach>
               	  <span id="allergyHelper" class="helper"></span>
                  <br/>
                  <br/>
                  <button id="dogInsert" class="btn btn-lg site-btn btn-block" type="button">강아지 등록</button>
               </form>
				</div>
			</div>
		</div>

	</section>
	
	<!-- Footer Section Begin -->
	<footer class="footer spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-4 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="${pageContext.request.contextPath}/mainPageController"><img src="./Resources/img/dogFoot.png"
								alt=""></a>
						</div>
						<ul>
							<li>Address: 115, Gasan digital 2-ro, Geumcheon-gu, Seoul, Republic of Korea </li>
							<li>Phone: +82 10.6705.6755</li>
							<li>Email: donghwagam@gmail.com</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-8 offset-lg-1">
					<div class="footer__widget">
						<h6>Git Links</h6>
						<ul>
							<li><a href="https://github.com/donghwagam">donghwagam</a> @감동화</li>
							<li><a href="https://github.com/Ohhyein12">Ohhyein12</a> @오혜인</li>
							<li><a href="https://github.com/rutong2">rutong2</a> @이찬희</li>
							<li><a href="https://github.com/Parkhw317">Parkhw317</a> @박희원</li>
							<li><a href="https://github.com/yvestumor">yvestumor</a> @박성준</li>
							<li><a href="https://github.com/JeonJW118">JeonJW118</a> @전지웅</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<h6>Join Our Website Now</h6>
						<p>This is ShoppingMall that can buy dogFoods for their lovely puppy as our first group project In GDJ46.</p>
						<form action="#">
							<input type="text" placeholder="Enjoy our websites.">
							<button type="submit" class="site-btn">GET JOB</button>
						</form>
						<div class="footer__widget__social">
							 <a href="https://www.instagram.com/gaebobheaven/"><i class="fa fa-instagram"></i></a> 
							 <a href="https://open.kakao.com/o/gPlN8Ahe"><i class="fa fa-pinterest"></i></a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="footer__copyright">
						<div class="footer__copyright__text">
							<p>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved 
							</p>
						</div>
						<div class="footer__copyright__payment">
							<img src="./Resources/img/payment-item.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="./Resources/js/jquery-3.3.1.min.js"></script>
	<script src="./Resources/js/bootstrap.min.js"></script>
	<script src="./Resources/js/jquery.nice-select.min.js"></script>
	<script src="./Resources/js/jquery-ui.min.js"></script>
	<script src="./Resources/js/jquery.slicknav.js"></script>
	<script src="./Resources/js/mixitup.min.js"></script>
	<script src="./Resources/js/owl.carousel.min.js"></script>
	<script src="./Resources/js/main.js"></script>



</body>

<script>
	$('#dogName').blur(function() {
		if($('#dogName').val().length > 30) {
			$('#dogNameHelper').text('강아지이름을 입력해주세요.');
			$('#dogName').val().substr(0, 30);
			$('#dogName').focus();
		} else {
			$('#dogNameHelper').text('');
		}
	});
	
	$('#spiece').blur(function() {
		if($('#spiece').val().length > 30) {
			$('#spieceHelper').text('견종을 입력해주세요.');
			$('#spiece').val().substr(0, 30);
			$('#spiece').focus();
		} else {
			$('#spieceHelper').text('');
		}
	});
	
	$('#birth').blur(function() {
		if($('#birth').val().length > 30) {
			$('#birthHelper').text('출생년도을 입력해주세요.');
			$('#birth').val().substr(0, 30);
			$('#birth').focus();
		} else {
			$('#birthHelper').text('');
		}
	});
	
	$('#weight').blur(function() {
		if($('#weight').val().length > 30) {
			$('#weightHelper').text('체중을 입력해주세요.');
			$('#weight').val().substr(0, 30);
			$('#weight').focus();
		} else {
			$('#weightHelper').text('');
		}
	});
	
   $('#dogInsert').click(function() {
      if($('#dogName').val() == '') {
         $('#dogNameHelper').text('강아지 이름을 입력해주세요.');
         $('#dogName').focus();
      } else if($('#spiece').val() == '') {
         $('#dogNameHelper').text('');
         $('#spieceHelper').text('견종을 입력해주세요.');
         $('#spiece').focus();
      } else if($('#birth').val() == '') { 
         $('#spieceHelper').text('');
         $('#birthHelper').text('태어난 해를 입력해주세요.');
         $('#birth').focus();
      } else if($('#weight').val() == '') {
         $('#birthHelper').text('');
         $('#weightHelper').text('체중을 입력해주세요.');
         $('#weight').focus();
      } else if($('#weight').length != 0) {
         $('#weightHelper').text('');
         $('#dogInsertForm').submit();
      } 
   });
	
</script>

</html>
