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
						<a href="${pageContext.request.contextPath}/loginController"><i class="fa fa-user"></i> Login</a>
					</c:when>
					<c:otherwise>
						<div>
							${sessionMemberId}님 반갑습니다 
							<a href="${pageContext.request.contextPath}/memberOneController">|마이페이지 </a>
							<a href="${pageContext.request.contextPath}/loginCheck/logoutController">| 로그아웃 </a>
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
								<c:choose> 
									<c:when test="${sessionMemberId == null}">
										<a href="${pageContext.request.contextPath}/loginController"><i class="fa fa-user"></i> Login</a>
									</c:when>
									<c:otherwise>
										<div>
											${sessionMemberId} 님 반갑습니다 
											<a href="${pageContext.request.contextPath}/memberOneController?memberId=${sessionMemberId}">| 마이페이지 </a>
											<a href="${pageContext.request.contextPath}/loginCheck/logoutController"> | 로그아웃 </a>
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
							<li>장바구니<a href="${pageContext.request.contextPath}/basketListController"><i class="fa fa-shopping-bag"></i> </a></li>
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
				<div class="col-lg-3">
					<div class="hero__categories">
						<div class="hero__categories__all">
							<i class="fa fa-bars"></i> <span>카테고리</span>
						</div>
						 <ul>
                            <li>
                            <!-- 카테고리 리스트 출력  -->
							<c:forEach var="category" items="${categoryList}">
								<tr>
									<td><a href="${pageContext.request.contextPath}/mainPageController?categoryName=${category.name}">${category.name}</a></td>
								</tr>
							</c:forEach>
							</li>
						</ul>
						
					</div>
				</div>
				<div class="col-lg-9">
					<div class="hero__item set-bg"
						data-setbg="./Resources/img/hero/dog.png">
						<div class="hero__text">
							<span>DOG FOOD FRESH</span>
							<h2>
								Allergy <br/>Customized
							</h2>
							<p>Free Pickup and Delivery Available</p>
							<a href="${pageContext.request.contextPath}/productSearchController" class="primary-btn">바로 구매</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- jstl의 if~else 사용 categoryName 이 null 일때 일반 상품 리스트 출력 null이 아닐때 카테고리 관련된 상품 출력  -->
	<div class="container">
		<div class="row">
				<c:choose>
					<c:when test="${categoryName == null}">
					<c:forEach var="p" items="${productList}">
							<div class="col-lg-4 col-md-4 col-sm-4">
								<div class="product__item">
									<div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/images/${p.photoName}">
									<ul class="product__item__pic__hover">
										<c:choose>
	                           				<c:when test="${sessionMemberId== null}">
	                                 			<li><a href="${pageContext.request.contextPath}/addGuestBasketController?productId=${p.productId}"><i class="fa fa-shopping-cart"></i></a></li>
	                              			</c:when>
	                              			<c:otherwise>
	                                 			<li><a href="${pageContext.request.contextPath}/addMemberBasketController?productId=${p.productId}"><i class="fa fa-shopping-cart"></i></a></li>
	                              			</c:otherwise>
	                           			</c:choose>
									</ul>
								</div>
								<div class="product__item__text">
									<a href="${pageContext.request.contextPath}/mainProductOneController?productId=${p.productId}&memberId=${memberId}">
										<h6>${p.productName}</h6>
										<h5>${p.price} 원</h5>
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
					</c:when>
					<c:otherwise>
					<c:forEach var="cl" items="${productCategoryList}">
					<div class="col-lg-4 col-md-4 col-sm-4">
							<div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/images/${cl.photoName}">
								<ul class="product__item__pic__hover">
									<c:choose>
	                       				<c:when test="${sessionMemberId== null}">
	                             			<li><a href="${pageContext.request.contextPath}/addGuestBasketController?productId=${cl.productId}"><i class="fa fa-shopping-cart"></i></a></li>
	                          			</c:when>
	                          			<c:otherwise>
	                             			<li><a href="${pageContext.request.contextPath}/addMemberBasketController?productId=${cl.productId}"><i class="fa fa-shopping-cart"></i></a></li>
	                          			</c:otherwise>
	                           		</c:choose>
								</ul>
							</div>
							<div class="product__item__text">
								<a href="${pageContext.request.contextPath}/mainProductOneController?productId=${cl.productId}">
									<h6>${cl.productName}</h6>
									<h5>${cl.price} 원</h5>
								</a>
							</div>
					</div>
					</c:forEach>
					</c:otherwise>
				</c:choose>
			</div>
			<c:choose>
				<c:when test="${categoryName == null}">
 				<c:if test="${currentPage > 1}">
                     <a href="${pageContext.request.contextPath}/mainPageController?currentPage=${currentPage-1}">이전</a>
                </c:if>
                <c:if test="${currentPage  < lastPage}">
                     <a  href="${pageContext.request.contextPath}/mainPageController?currentPage=${currentPage+1}">다음</a>
                </c:if>
                </c:when>
                <c:otherwise>
                	<c:if test="${currentPage > 1}">
                     <a href="${pageContext.request.contextPath}/mainPageController?currentPage=${currentPage-1}&categortName=${categoryName}">이전</a>
                </c:if>
                <c:if test="${currentPage  < categoryLastPage}">
                     <a  href="${pageContext.request.contextPath}/mainPageController?currentPage=${currentPage+1}&categoryName=${categoryName}">다음</a>
                </c:if>
                </c:otherwise>
                </c:choose>
	</div>
	<div>
	</div>

	<!-- Latest Product Section Begin -->
	<section class="latest-product spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-lg-6">
					<div class="latest-product__text">
						<h4>Latest Products</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
							<!--  최신순으료 정렬  -->
								<c:forEach var="l" items="${latestProductList}" begin="0" end="2" step="1"> 
								<a href="${pageContext.request.contextPath}/mainProductOneController?productId=${l.productId}" class="latest-product__item">
										<div class="latest-product__item_pic">
											<img src="${pageContext.request.contextPath}/images/${l.photoName}" width="100" height="400" alt="">
										</div>
								</a>
									<div class="latest-product__item_text">
										<h6>${l.productName}</h6>
										<span>${l.price} 원</span>
									</div>
								</c:forEach> 
							</div>
							<div class="latest-prdouct__slider__item">
							<c:forEach var="l" items="${latestProductList}" begin="3" end="5" step="1">
								<a href="${pageContext.request.contextPath}/mainProductOneController?productId=${l.productId}" class="latest-product__item">
										<div class="latest-product__item_pic">
												<img src="${pageContext.request.contextPath}/images/${l.photoName}" width="100" height="400" alt="">
										</div>
								</a>
									<div class="latest-product__item_text">
										<h6>${l.productName}</h6>
										<span>${l.price}원</span>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-lg-6">
					<div class="latest-product__text">
						<h4>TopRate Products</h4>
						<div class="latest-product__slider owl-carousel">
							<div class="latest-prdouct__slider__item">
							
							
									<c:forEach var="t" items="${topRateList}" begin="0" end="2" step="1">
									<a href="${pageContext.request.contextPath}/mainProductOneController?productId=${t.productId}" class="latest-product__item">
										<div class="latest-product__item_pic">
											<img src="${pageContext.request.contextPath}/images/${t.photoName}" width="100" height="400" alt="">
										</div>
									</a>
									<div class="latest-product__item_text">
										<h6>${t.productName}</h6>
										<span>${t.price}원</span>
									</div>
									
								</c:forEach>
								
							</div>
							<div class="latest-prdouct__slider__item">
							<c:forEach var="t" items="${topRateList}" begin="3" end="5" step="1">
							<a href="${pageContext.request.contextPath}/mainProductOneController?productId=${t.productId}" class="latest-product__item">
										<div class="latest-product__item_pic">
												<img src="${pageContext.request.contextPath}/images/${t.photoName}" width="100" height="400" alt="">
										</div>
							</a>
									<div class="latest-product__item_text">
										<h6>${t.productName}</h6>
										<span>${t.price} 원</span>
									</div>
								</c:forEach>
							</div>
						</div>
				</div>
				
			</div>
			</div>
			</div>
			</section>
	<!-- Latest Product Section End -->

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

</html>
