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
	   height: 300px;
	   display: block;
   }
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
							<!-- ?????????/????????????/??????????????? ??????  -->
							<div class="header__top__right__auth">
							<!--sessionMemberId ?????? null?????? ????????? ??????/ null??? ????????? ???????????????,???????????? ?????? ??????  -->
								<c:choose> 
									<c:when test="${sessionMemberId == null}">
										<a href="${pageContext.request.contextPath}/loginDenied/loginController"><i class="fa fa-user"></i> Login</a>
									</c:when>
									<c:otherwise>
										<div>
											<span style="font-size: 14px">${sessionMemberId} ??? ???????????????</span> 
											<a href="${pageContext.request.contextPath}/memberOneController" style="display: inline">| ??????????????? </a>
											<a href="${pageContext.request.contextPath}/loginCheck/logoutController" style="display: inline"> | ???????????? </a>
										</div>
									</c:otherwise>
								</c:choose>
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
				<!--  ?????????  -->
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="${pageContext.request.contextPath}/productSearchController">????????????</a></li>
							<li><a href="${pageContext.request.contextPath}/noticeController">????????????</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
                        <ul>
                            <li>????????????<a href="${pageContext.request.contextPath}/basketListController"><i class="fa fa-shopping-bag"></i></a></li>
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
							<i class="fa fa-bars"></i> <span>??????????????? ??????</span>
						</div>
						<!-- ??????????????? ????????????  -->	
						<ul>
                            <li><a href="${pageContext.request.contextPath}/memberOneController">??????/?????? ??????</a></li>
							<li><a href="${pageContext.request.contextPath}/purchaseMemberListController">????????????</a></li>
							<c:if test="${sessionMemberId eq 'admin'}">
								<li><a href="${pageContext.request.contextPath}/adminCheck/adminPageController">??????????????????</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="col-9">
					<h3 class="bottom">????????????</h3>
						<table class="table">
							<tr>
								<th>????????????</th>
								<th>????????????</th>
								<th>?????????</th>
								<th>??????</th>
								<th>??????</th>
								<th>??????</th>
								<th>????????????</th>
								<th>??????</th>
								<th>??????</th>
							</tr>
						<c:forEach var="p" items="${purchaseMemberList}">	
							
							<tr>
								<td>${p.purchaseId}</td>
								<td><a href="${pageContext.request.contextPath}/mainProductOneController?productId=${p.productId}"><img src= "${pageContext.request.contextPath}/images/${p.originalName }" width="100" height="100" ></a></td>
								<td><a href="${pageContext.request.contextPath}/mainProductOneController?productId=${p.productId}">${p.name}</a></td>
								<td>${p.gram}kg</td>
								<td>${p.price}???</td>
								<td>${p.quantity}???</td>
								<td>${p.status}</td>
								<td>${p.totalPrice}???</td>
								<td><a href="${pageContext.request.contextPath}/loginCheck/insertReviewController?purchaseId=${p.purchaseId}&productId=${p.productId}">????????????</a></td>					
							</tr>
						</c:forEach>	
						</table>
				</div>
			</div>
		</div>
		<c:if test="${msg!=null}">
			<!-- Modal -->
			<div class="msgbox">
                 ???????????? ????????? ??????????????? ??? ??? ????????????
                 <br>
                 <div class="text-center">
                 	<button type="button" class="btn btn-secondary float-right" id="chk">??????</button>
                 </div>
            </div>    
		</c:if>
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
							<li><a href="https://github.com/donghwagam">donghwagam</a> @?????????</li>
							<li><a href="https://github.com/Ohhyein12">Ohhyein12</a> @?????????</li>
							<li><a href="https://github.com/rutong2">rutong2</a> @?????????</li>
							<li><a href="https://github.com/Parkhw317">Parkhw317</a> @?????????</li>
							<li><a href="https://github.com/yvestumor">yvestumor</a> @?????????</li>
							<li><a href="https://github.com/JeonJW118">JeonJW118</a> @?????????</li>
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
	$('#chk').click(function () {
		$('.msgbox').css('display','none');
	})
</script>
</html>
