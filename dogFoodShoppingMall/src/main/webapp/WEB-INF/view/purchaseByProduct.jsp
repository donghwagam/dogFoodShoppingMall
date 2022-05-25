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
										<a href="${pageContext.request.contextPath}/loginDenied/loginController"><i class="fa fa-user"></i> Login</a>
									</c:when>
									<c:otherwise>
										<div>
											<span style="font-size: 14px">${sessionMemberId} 님 반갑습니다</span> 
											<a href="${pageContext.request.contextPath}/memberOneController?memberId=${sessionMemberId}" style="display: inline">| 마이페이지 </a>
											<a href="${pageContext.request.contextPath}/loginCheck/logoutController" style="display: inline"> | 로그아웃 </a>
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
						<a href="${pageContext.request.contextPath}/mainPageController"><img src="${pageContext.request.contextPath}/Resources/img/dogFood.png" alt=""></a>
					</div>
				</div>
				<!--  상단바  -->
				<div class="col-lg-6">
					<nav class="header__menu">
						<ul>
							<li><a href="${pageContext.request.contextPath}/productSearchController">상세검색</a></li>
							<li><a href="${pageContext.request.contextPath}/mainPageController">고객센터</a></li>
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
				<div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero Section End -->
	
	<!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="${pageContext.request.contextPath}/Resources/img/dogLayer.png">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>결제</h2>
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
		    			<h2>결제</h2>
		    		</div>
		    		<hr>
		    		<div class="row">
		    			<div class="col-xs-12">
		    				<address>
			    				<strong><a href="${pageContext.request.contextPath}/loginCheck/purchaseByProductController?productId=${productId}&photoName=${photoName}&productName=${productName}&quantity=${quantity}&totalPriceByProduct=${totalPriceByProduct}">기본정보</a></strong> &nbsp;&nbsp;|&nbsp;
			    				<strong><a href="${pageContext.request.contextPath}/loginCheck/purchaseByProductChangeAddressController?productId=${productId}&photoName=${photoName}&productName=${productName}&quantity=${quantity}&totalPriceByProduct=${totalPriceByProduct}">배송정보변경</a></strong>
			    				<br><br>
		    					<form method="post" action="${pageContext.request.contextPath}/loginCheck/purchaseByProductCompleteController">
			    					<table>
			    						<tr>
			    							<input type="hidden" name="productId" value="${productId}">
			    							<td>받는사람 &nbsp; |&nbsp;&nbsp;&nbsp;</td>
			    							<td><input type="text" name="name" value="${name}" style="border:0 solid black" readonly="readonly"></td>
			    						</tr>
			    						<tr>
			    							<td>전화번호 &nbsp; |</td>
			    							<td><input type="text" name="phone" value="${phone}" style="border:0 solid black" readonly="readonly"></td>
			    						</tr>
			    						<tr>
			    							<td>배송주소 &nbsp; |</td>
			    							<td><input type="text" name="address" value="${address}" style="width: 500px; border:0 solid black" readonly="readonly"></td>
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
			    							<!-- foreach ($order->lineItems as $line) or some such thing here -->
			    							<tr>
			    								<td><img src="${pageContext.request.contextPath}/images/${photoName}" width="100px" height="100px"></td>
			    								<td class="text-center"><input class="text-center" type="text" name="photoName" value="${productName}" readonly="readonly" style="border:0 solid black"></td>
			    								<td class="text-center"><input class="text-center" type="text" name="quantity" value="${quantity}" readonly="readonly" style="border:0 solid black"></td>
			    								<td class="text-right"><input class="text-right" type="text" name="totalPriceByProduct" value="${totalPriceByProduct}" readonly="readonly" style="border:0 solid black">원</td>
			    							</tr>
			    							<tr>
			    								<td class="thick-line"></td>
			    								<td class="thick-line"></td>
			    								<td class="thick-line text-center"><strong>총 가격</strong></td>
			    								<td class="thick-line text-right">${totalPriceByProduct}원</td>
			    							</tr>
			    							<tr>
			    								<td colspan="4" class="text-right"><button type="submit">결제하기</button></td>
			    							</tr>
		    							</tbody>
		    						</table>
		    					</form>
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
