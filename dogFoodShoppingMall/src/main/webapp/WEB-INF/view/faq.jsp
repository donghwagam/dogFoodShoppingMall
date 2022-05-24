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
				<li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
				<li><a href="${pageContext.request.contextPath}/basketListController"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
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
				        탈퇴했던 아이디로 다시 가입할 수 있나요?
				      </a>
				    </div>
				    <div id="collapseOne" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        탈퇴한 아이디는 재가입이 불가능합니다.
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 2번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
				        회원탈퇴하면 이전정보는 어떻게 되나요?
				      </a>
				    </div>
				    <div id="collapseTwo" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        회원탈퇴 시 개인정보는 모두 삭제됩니다.
						개인정보 중 아래와 같이 상법 및 전자상거래 관련 법령의 규정에 의하여 거래 관련 권리 의무 관계의 확인 등을 이유로 보유할 필요가 있을 경우에는 정해진 기간동안 보유한 후 파기합니다.<br>
						 ① 계약 또는 청약철회 등에 관한 기록 : 5년<br>    
						 ② 대금결제 및 재화 등의 공급에 관한 기록 : 5년<br>    
						 ③ 소비자의 불만 또는 분쟁처리에 관한 기록 : 3년<br>    
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 3번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
				        회원탈퇴는 어떻게 하나요?
				      </a>
				    </div>
				    <div id="collapseThree" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        [MY페이지 > 아이디 >  비밀번호 입력 > 나의 정보 > 회원탈퇴] 에서 탈퇴 가능합니다.
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 4번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour">
				        비밀번호변경은 어떻게 하나요?
				      </a>
				    </div>
				    <div id="collapseFour" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        [MY페이지 > 아이디 >  비밀번호 입력 > 나의 정보 > 비밀번호 수정] 에서 변경 가능합니다.
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 5번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseFive">
				        아이디, 비밀번호를 잊어버렸어요. 어떻게 해야 하나요?
				      </a>
				    </div>
				    <div id="collapseFive" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        아이디를 잊으신 경우 [로그인 > 아이디 찾기]에서 이름, 이메일주소 또는 휴대폰 번호를 입력하시면 확인이 가능합니다.<br><br>
				        비밀번호를 잊으시 경우 [로그인 > 비밀번호 찾기]에서 가입 시 이메일 주소를 입력하시면 비밀번호를 새로 설정할 수 있도록 메일을 전송해 드립니다.
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 6번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseSix">
				        회원 정보는 어떻게 변경하나요?
				      </a>
				    </div>
				    <div id="collapseSix" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        회원정보 중 비밀번호와 휴대폰 번호만 변경이 가능하며,<br>
						[MY페이지 > 아이디 >  비밀번호 입력 > 나의 정보]에서 변경 가능합니다.<br>
						그 외에 회원명, 이메일 주소 변경은 고객센터 1:1 또는 채팅으로 문의 바랍니다.
				      </div>
			  		</div>
				 	</div>
				 	
				 	<!-- 7번 --> 
				  	<div class="card">
				    <div class="card-header">
				      <a class="collapsed card-link" data-toggle="collapse" href="#collapseSeven">
				        아이디 변경이 가능한가요?
				      </a>
				    </div>
				    <div id="collapseSeven" class="collapse" data-parent="#accordion">
				      <div class="card-body">
				        아이디 변경은 불가능합니다. 아이디 변경을 원하실 경우 새로운 아이디로 가입해 주시기 바랍니다.
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
