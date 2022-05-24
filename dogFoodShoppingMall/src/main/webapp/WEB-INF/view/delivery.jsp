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
   .top {margin-top:15px;}
   .fs {font-size: 27px; font-weight: bold;}
</style>

</head>

<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Humberger Begin -->
	<div class="humberger__menu__overlay"></div>
	<div class="humberger__menu__wrapper">
		<div class="humberger__menu__logo">
			<a href="${pageContext.request.contextPath}/mainPageController"><img src="./Resources/img/dogFood.png" alt=""></a>
		</div>
		<div class="humberger__menu__cart">
			<ul>
				<li>장바구니<a href="${pageContext.request.contextPath}/basketListController"><i class="fa fa-shopping-bag"></i></a></li>
			</ul>
			<div class="header__cart__price">
				item: <span>$150.00</span>
			</div>
		</div>
		<div class="humberger__menu__widget">
			<div class="header__top__right__language">
				<img src="./Resources/img/language.png" alt="">
				<div>English</div>
				<span class="arrow_carrot-down"></span>
				<ul>
					<li><a href="#">Spanis</a></li>
					<li><a href="#">English</a></li>
				</ul>
			</div>
			<div class="header__top__right__auth">
				<c:choose>
					<c:when test="${sessionMemberId == null}">
						<a href="${pageContext.request.contextPath}/loginDenied/loginController"><i class="fa fa-user"></i> Login</a>
					</c:when>
					<c:otherwise>
						<div>${sessionMemberId}님 반갑습니다 <a href="${pageContext.request.contextPath}/memberOneController">|마이페이지 </a><a href="${pageContext.request.contextPath}/logoutController">| 로그아웃 </a>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<nav class="humberger__menu__nav mobile-menu">
			<ul>
				<li class="active"><a href="./index.html">Home</a></li>
				<li><a href="./shop-grid.html">Shop</a></li>
				<li><a href="#">Pages</a>
					<ul class="header__menu__dropdown">
						<li><a href="./shop-details.html">Shop Details</a></li>
						<li><a href="./shoping-cart.html">Shoping Cart</a></li>
						<li><a href="./checkout.html">Check Out</a></li>
						<li><a href="./blog-details.html">Blog Details</a></li>
					</ul></li>
				<li><a href="./blog.html">Blog</a></li>
				<li><a href="./contact.html">Contact</a></li>
			</ul>
		</nav>
		<div id="mobile-menu-wrap"></div>
		<div class="header__top__right__social">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-pinterest-p"></i></a>
		</div>
		<div class="humberger__menu__contact">
			<ul>
				<li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
				<li>Free Shipping for all Order of $99</li>
			</ul>
		</div>
	</div>
	<!-- Humberger End -->

	<!-- Header Section Begin -->
	<header class="header">
		<div class="header__top">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6">
						<div class="header__top__left">
							<ul>
								<li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
								<li>Free Shipping for all Order of $99</li>
							</ul>
						</div>
					</div>
					<div class="col-lg-6 col-md-6">
						<div class="header__top__right">
							<div class="header__top__right__social">
								<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
									class="fa fa-twitter"></i></a> <a href="#"><i
									class="fa fa-linkedin"></i></a> <a href="#"><i
									class="fa fa-pinterest-p"></i></a>
							</div>
							<div class="header__top__right__language">
								<img src="./Resources/img/language.png" alt="">
								<div>English</div>
								<span class="arrow_carrot-down"></span>
								<ul>
									<li><a href="#">Spanis</a></li>
									<li><a href="#">English</a></li>
								</ul>
							</div>
							<!-- 로그인/로그아웃/마이페이지 이동  -->
							<div class="header__top__right__auth">
								<!--sessionMemberId 값이 null이면 로그인 출력/ null이 아니면 마이페이지,로그아웃 버튼 출력  -->
								${sessionMemberId} 님 반갑습니다 <a href="${pageContext.request.contextPath}/memberOneController">| 마이페이지 </a><a href="${pageContext.request.contextPath}/loginCheck/logoutController"> | 로그아웃 </a>
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
						<!-- 고객센터 목록출력  -->	
						<ul >
                            <li><a href="${pageContext.request.contextPath}/noticeController">공지사항</a></li>
							<li><a href="${pageContext.request.contextPath}/faqController?service=memberService">자주묻는질문</a></li>
							<li><a href="https://open.kakao.com/o/gPlN8Ahe">1:1 문의</a></li>
						</ul>
					</div>
				</div>
				<div class="col-9">
				<h3 class="bottom">자주묻는 질문</h3>
				
				<a href="${pageContext.request.contextPath}/faqController?service=memberService" class="site-btn">회원서비스</a>
				<a href="${pageContext.request.contextPath}/faqController?service=order" class="site-btn">주문/결제</a>
				<a href="${pageContext.request.contextPath}/faqController?service=delivery" class="site-btn">배송</a>
				
					<div id="accordion" class="top">
					
					<!-- 1번 -->
					<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseOne">
				        상품이 발송완료 상태인데, 아직 수령하지 못했습니다.
				      </a>
				    </div>
				    <div id="collapseOne" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        발송완료일로부터 영업일 기준으로 3일이 지났는데도 상품을 받지 못하신 경우에는 채팅 또는 1:1 문의로 연락주시기 바랍니다.<br>   
						업체배송 상품은 정상적인 발송이 되었더라도 배송현황이 조회되지 않을 수 있으며 배송하는 상품보다 시간이 좀 더 소요될 수 있으니 참고해 주시기 바랍니다.<br>
						배송현황은 [MY페이지 > 주문·배송 > 주문상세보기 > 배송조회] 에서 확인하실 수 있습니다.
				      </div>
				    </div>
				  	</div>	
					
					<!-- 2번 -->
					<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
				        상품이 배송되지 않고 반송되었는데, 어떻게 해야 하나요?
				      </a>
				    </div>
				    <div id="collapseTwo" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        반송된 사유 확인을 위해 채팅 또는 1:1문의로 연락주시면 배송사 확인 후 안내해 드리겠습니다.<br>
						고객님의 부재로 반송된 경우 회수 및 발송에 해당하는 왕복배송비를 고객님께서 부담하셔야 하며, 해당 상품을 반품하실 경우에도 편도 배송비는 고객님께서 부담하셔야 합니다.<br>
				      </div>
				    </div>
					</div>	
					
					<!-- 3번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
				        배송 받은 상품이 파손되었을 경우 어떻게 해야 하나요?
				      </a>
				    </div>
				    <div id="collapseThree" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        상품 파손으로 불편드려 죄송합니다.
						교환 또는 반품을 접수해 주시면 신속히 처리해 드리겠습니다.
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 4번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour">
				        주문한 상품과 다른 상품이 왔어요.
				      </a>
				    </div>
				    <div id="collapseFour" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        오발송으로 불편드려 죄송합니다.<br>
						교환 또는 반품을 접수해 주시면 신속히 처리해 드리겠습니다.
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 5번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseFive">
				        주문한 상품중에 일부만 왔어요.
				      </a>
				    </div>
				    <div id="collapseFive" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        주문한 상품 중 일부만 받으셨다면 다음처럼 상황에 따라 확인해 주시기 바랍니다.<br><br>
						업체배송 상품을 함께 구매한 것은 아닌지 확인해 주시기 바랍니다.<br> 
						업체배송 상품은 별도 발송되며, 배송사와 송장번호가 다르기 때문에 수령하는 날짜도 다를 수 있습니다.<br><br>
						일부만 받으셨다면, 상품의 부피와 무게 등으로 인하여 여러 상자로 나누어 발송하기 때문인 경우가 많습니다.<br> 
						여러 상자로 발송한 경우에 고객님께 추가되는 배송비는 없으며, 택배사 사정에 따라 일부 지연되어 1~2일 뒤에 수령하실 수도 있음을 양해해 주시기 바랍니다.<br><br>
						실제로 상품이 누락되었거나 내용 파악이 어려운 경우에는 채팅 또는 1:1 문의를 이용해 주시기 바랍니다. 
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 6번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseSix">
				        토요일, 공휴일에 배송이 가능한가요?
				      </a>
				    </div>
				    <div id="collapseSix" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        토요일에는 배송이 되나 일요일, 공휴일에는 배송이 불가능합니다.
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 7번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseSeven">
				        주문상품을 당일 받아 볼 수 있나요?
				      </a>
				    </div>
				    <div id="collapseSeven" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        주문한 상품은 택배로 발송되어 당일에는 받아보실 수 없습니다. 
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 8번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseEight">
				        발송 마감시간은 언제인가요?
				      </a>
				    </div>
				    <div id="collapseEight" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        당일 발송(출고)을 위한 주문마감 시간은 월~금요일 오후 6시, 일요일 오전 11시이며, 당일 발송(출고)된 상품은 영업일 기준 다음날부터 받아보실 수 있습니다.<br> 
						다만, 업체배송 상품은 업체별 마감 시간이 다를 수 있으며, 상품의 품절이나 택배사 상황에 따라 당일 발송(출고)이 어려운 경우도 있으니 양해 부탁 드립니다. 
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 9번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseNine">
				        상품을 주문하면 언제 받을 수 있나요?
				      </a>
				    </div>
				    <div id="collapseNine" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        월~금요일 오후 6시, 일요일 오전 11시까지 결제 완료한 상품은 영업일 기준 다음날부터 받아보실 수 있으며, 영업일 기준으로 3일 이내 배송을 원칙으로 하고 있습니다.<br>
						다만, 도서산간 등 배송 지역과 기상 상태 등에 따라 받으실 수 있는 기간이 더 소요될 수 있으니 배송기간을 고려하여 주문해 주시기 바랍니다.
				      </div>
			  		</div>
				 	</div>
					  
					</div>
			
			</div>
		</div>
	</div>

	</section>
	
	
	<!-- Footer Section Begin -->
	<footer class="footer spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="${pageContext.request.contextPath}/mainPageController"><img src="./Resources/img/dogFoot.png"
								alt=""></a>
						</div>
						<ul>
							<li>Address: 60-49 Road 11378 New York</li>
							<li>Phone: +65 11.188.888</li>
							<li>Email: hello@colorlib.com</li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
					<div class="footer__widget">
						<h6>Useful Links</h6>
						<ul>
							<li><a href="#">About Us</a></li>
							<li><a href="#">About Our Shop</a></li>
							<li><a href="#">Secure Shopping</a></li>
							<li><a href="#">Delivery infomation</a></li>
							<li><a href="#">Privacy Policy</a></li>
							<li><a href="#">Our Sitemap</a></li>
						</ul>
						<ul>
							<li><a href="#">Who We Are</a></li>
							<li><a href="#">Our Services</a></li>
							<li><a href="#">Projects</a></li>
							<li><a href="#">Contact</a></li>
							<li><a href="#">Innovation</a></li>
							<li><a href="#">Testimonials</a></li>
						</ul>
					</div>
				</div>
				<div class="col-lg-4 col-md-12">
					<div class="footer__widget">
						<h6>Join Our Newsletter Now</h6>
						<p>Get E-mail updates about our latest shop and special
							offers.</p>
						<form action="#">
							<input type="text" placeholder="Enter your mail">
							<button type="submit" class="site-btn">Subscribe</button>
						</form>
						<div class="footer__widget__social">
							<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
								class="fa fa-instagram"></i></a> <a href="#"><i
								class="fa fa-twitter"></i></a> <a href="#"><i
								class="fa fa-pinterest"></i></a>
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
								All rights reserved | This template is made with <i
									class="fa fa-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
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
$(function(){
	$('#service').click(function(){
		if($)
	})
})
</script>

</html>
