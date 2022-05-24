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
