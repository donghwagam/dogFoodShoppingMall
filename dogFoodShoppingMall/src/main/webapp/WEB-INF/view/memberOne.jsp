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

<style>
   .bottom {margin-bottom:15px;}
   .top {margin-top:70px;}
</style>

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
							<c:if test="${memberId==admin}">
							<li><a href="${pageContext.request.contextPath}/adminCheck/adminPageController">관리자페이지</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="col-9">
					<h3 class="bottom">회원정보</h3>
					<table class="table">
						<colgroup>
							<col width="20%">
							<col width="*">
						</colgroup>
						<tr>
							<th>아이디</th>
							<td>${memberMap.memberId}</td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td>**** <a class="float-right" href="${pageContext.request.contextPath}/updateChkNowPwController">수정</a></td>
						</tr>
						<tr>
							<th>이름</th>
							<td>${memberMap.name}</td>
						</tr>
						<tr>
							<th>성별</th>
							<td>${memberMap.gender}</td>
						</tr>
						<tr>
							<th>생년월일</th>
							<td>${memberMap.birth}</td>
						</tr>
						<tr>
							<th>휴대전화</th>
							<td>${memberMap.phone}</td>
						</tr>
						<tr>
							<th>주소</th>
							<td>${memberMap.addr} <a class="float-right" href="${pageContext.request.contextPath}/updateAddressController">수정</a></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td>${memberMap.email}</td>
						</tr>
						<tr>
							<th>가입일</th>
							<td>${memberMap.createDate}</td>
						</tr>
					</table>
					
					<div class="float-right bottom">
						<a href="${pageContext.request.contextPath}/updateMemberController" class="site-btn" role="button">수정</a>
						<a href="${pageContext.request.contextPath}/deleteMemberController" class="site-btn" role="button">탈퇴</a>
					</div>
					
					<h3 class="top bottom">애견정보</h3>
					<c:forEach var="m" items="${memberDogList}">
						<table class="table">
							<colgroup>
								<col width="20%">
								<col width="*">
							</colgroup>
							<tr>
								<th>이름</th>
								<td>${m.dogName}</td>
							</tr>
							<tr>
								<th>견종</th>
								<td>${m.spiece}</td>
							</tr>
							<tr>
								<th>출생연도</th>
								<td>${m.birth}</td>
							</tr>
							<tr>
								<th>체중</th>
								<td>${m.weight}</td>
							</tr>
							<tr>
								<th>알러지</th>
								<td>${m.allergyName}</td>
							</tr>
						</table>
						<div class="float-right bottom">
						<button type="button" class="site-btn" data-toggle="modal" data-target="#deleteDogModal">삭제</button>
						</div>
				
						<!-- Modal -->
						<div class="modal fade" id="deleteDogModal" tabindex="-1" role="dialog" aria-labelledby="deleteDogModalLabel" aria-hidden="true">
						  <div class="modal-dialog" role="document">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="deleteDogModalLabel">강아지 삭제</h5>
						        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
						          <span aria-hidden="true">&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						       	 사용자의 강아지를 삭제하시겠습니까?
						      </div>
						      <div class="modal-footer">
							      <a href="${pageContext.request.contextPath}/deleteDogController?memberDogId=${m.memberDogId}" class="btn btn-success" role="button">삭제하기</a>
							      <button type="button" class="btn btn-secondary" data-dismiss="modal">취소하기</button>
						      </div>
						    </div>
						  </div>
						</div>	
						
					</c:forEach>
					
					<a href="${pageContext.request.contextPath}/insertDogController" class="site-btn" role="button">새로운 강아지 등록</a>
				</div>
			</div>
		</div>
	</section>
	`
	
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

</html>
