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
<title>purchaseByBasket</title>
<!-- Google Font -->
<link
	href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap"
	rel="stylesheet">

<!-- Css Styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/bootstrap.min.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/elegant-icons.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/nice-select.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/jquery-ui.min.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/owl.carousel.min.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/slicknav.min.css"
	type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/Resources/css/style.css" type="text/css">


<style type="text/css">
   body { padding-top:30px; }
   .form-control { margin-bottom: 10px; }
   .helper {
       color : #FF0000;
    }
   .bottom {margin-bottom:15px;}
   .top {margin-top:40px;}
   .invoice-title h2, .invoice-title h3 {
	    display: inline-block;
	}
	
	.table > tbody > tr > .no-line {
	    border-top: none;
	}
	
	.table > thead > tr > .no-line {
	    border-bottom: none;
	}
	
	.table > tbody > tr > .thick-line {
	    border-top: 2px solid;
	}
</style>

<meta charset="UTF-8">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
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
			<a href="#"><img src="${pageContext.request.contextPath}/Resources/img/logo.png" alt=""></a>
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
				<img src="${pageContext.request.contextPath}/Resources/img/language.png" alt="">
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
						<li><a href="/shop-details.html">Shop Details</a></li>
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
								<img src="${pageContext.request.contextPath}/Resources/img/language.png" alt="">
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
								<c:choose> 
									<c:when test="${sessionMemberId == null}">
										<a href="${pageContext.request.contextPath}/loginDenied/loginController"><i class="fa fa-user"></i> Login</a>
									</c:when>
									<c:otherwise>
										<div>
										${sessionMemberId} 님 반갑습니다 
										<a href="${pageContext.request.contextPath}/memberOneController?memberId=${sessionMemberId}">| 마이페이지 </a>
										<a href="${pageContext.request.contextPath}/loginCheck/logoutController"> | 로그아웃 </a></div>
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
						<a href="${pageContext.request.contextPath}/mainPageController"><img src="${pageContext.request.contextPath}/Resources/img/fakeLogo.png" alt=""></a>
					</div>
				</div>
				<!--  상단바  -->
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="${pageContext.request.contextPath}/productSearchController">상세검색</a></li>
							<li><a href="./shop-grid.html">브랜드</a></li>
							<li><a href="./blog.html">랭킹</a></li>
							<li><a href="./contact.html">신상품</a></li>
						</ul>
					</nav>
				</div>
				<div class="col-lg-3">
					<div class="header__cart">
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/basketListController"><i class="fa fa-shopping-bag"></i></a></li>
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
				<div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->
	
	<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="${pageContext.request.contextPath}/Resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>결제완료</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    
    <!-- Shoping Cart Purchase Section Begin -->
    <section class="shoping-cart spad">
	<div class="container">
		<div class="row">
	        <div class="col-xs-12">
	    		<div class="invoice-title">
	    			<h2>결제완료</h2>
	    		</div>
	    		<hr>
	    		<div class="row">
	    			<div class="col-xs-12">
	    				<address>
	    					<table>
	    						<tr>
	    							<td>받는사람 &nbsp; |&nbsp;&nbsp;&nbsp;</td>
	    							<td><input type="text" name="name" value="${purchaseAddress.purchaseName}" style="border:0 solid black" readonly="readonly"></td>
	    						</tr>
	    						<tr>
	    							<td>전화번호 &nbsp; |</td>
	    							<td><input type="text" name="phone" value="${purchaseAddress.purchasePhone}" style="border:0 solid black" readonly="readonly"></td>
	    						</tr>
	    						<tr>
	    							<td>배송주소 &nbsp; |</td>
	    							<td><input type="text" name="address" value="${purchaseAddress.address}" style="width: 500px; border:0 solid black" readonly="readonly"></td>
	    						</tr>
	    					</table>
	    				</address>
	    			</div>
	    		</div>
				<address>
					<strong>결제방법</strong><br>
					<input type="hidden" name="payment" value="무통장입금">무통장입금
				</address>
	    	</div>
    	</div>
		<div class="row">
    		<div class="col-md-12">
    			<div class="panel panel-default">
    				<div class="panel-heading">
    					<h3 class="panel-title"><strong>결제 정보</strong></h3>
    				</div>
    				<div class="panel-body">
    					<div class="table-responsive">
    						<table class="table table-condensed">
	    						<thead>
	                                <tr>
	        							<td><strong>사진</strong></td>
	        							<td class="text-center"><strong>상품</strong></td>
	        							<td class="text-center"><strong>수량</strong></td>
	        							<td class="text-right"><strong>총 가격</strong></td>
	                                </tr>
	    						</thead>
    							<tbody>
    								<c:forEach var="m" items="${memberBasketList}">
    									<tr>
		    								<td><input type="text" name="photoName" value="${m.photoName}" readonly="readonly" style="border:0 solid black"></td>
		    								<td class="text-center"><input class="text-center" type="text" name="photoName" value="${m.productName}" readonly="readonly" style="border:0 solid black"></td>
		    								<td class="text-center"><input class="text-center" type="text" name="quantity" value="${m.quantity}" readonly="readonly" style="border:0 solid black"></td>
		    								<td class="text-right"><input class="text-right" type="text" name="totalPriceByBasket" value="${m.price * m.quantity}" readonly="readonly" style="border:0 solid black">원</td>
	    								</tr>
    								</c:forEach>
	    								<tr>
		    								<td class="thick-line"></td>
		    								<td class="thick-line"></td>
		    								<td class="thick-line text-center"><strong>총 가격</strong></td>
		    								<td class="thick-line text-right">${totalPriceByBasket}원</td>
	    								</tr>
    							</tbody>
    						</table>
	    				</div>
	    			</div>
	    		</div>
	    	</div>
	    </div>
	</div>
	
	<!-- Footer Section Begin -->
	<footer class="footer spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 col-sm-6">
					<div class="footer__about">
						<div class="footer__about__logo">
							<a href="./index.html"><img src="${pageContext.request.contextPath}/Resources/img/logo.png"
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
							<img src="${pageContext.request.contextPath}/Resources/img/payment-item.png" alt="">
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- Footer Section End -->

	<!-- Js Plugins -->
	<script src="${pageContext.request.contextPath}/Resources/js/jquery-3.3.1.min.js"></script>
	<script src="${pageContext.request.contextPath}/Resources/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/Resources/js/jquery.nice-select.min.js"></script>
	<script src="${pageContext.request.contextPath}/Resources/js/jquery-ui.min.js"></script>
	<script src="${pageContext.request.contextPath}/Resources/js/jquery.slicknav.js"></script>
	<script src="${pageContext.request.contextPath}/Resources/js/mixitup.min.js"></script>
	<script src="${pageContext.request.contextPath}/Resources/js/owl.carousel.min.js"></script>
	<script src="${pageContext.request.contextPath}/Resources/js/main.js"></script>



</body>
</html>
