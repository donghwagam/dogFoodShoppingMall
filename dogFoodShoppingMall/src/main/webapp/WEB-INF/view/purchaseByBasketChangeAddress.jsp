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
											<a href="${pageContext.request.contextPath}/memberOneController?memberId=${sessionMemberId}" style="display: inline">| ??????????????? </a>
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
						<a href="${pageContext.request.contextPath}/mainPageController"><img src="${pageContext.request.contextPath}/Resources/img/dogFood.png" alt=""></a>
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
                        <h2>??????</h2>
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
		    			<h2>??????</h2>
		    		</div>
		    		<hr>
		    		<div class="row">
		    			<div class="col-xs-12">
		    				<address>
			    				<strong><a href="${pageContext.request.contextPath}/loginCheck/purchaseByBasketController">????????????</a></strong> &nbsp;&nbsp;|&nbsp;
	    						<strong><a href="${pageContext.request.contextPath}/loginCheck/purchaseByBasketChangeAddressController">??????????????????</a></strong>
			    				<br><br>
			    				<form method="post" action="${pageContext.request.contextPath}/searchAddressController?msg=purchaseByBasketChangeAddr">
									?????? : <input class="form-control" name="searchAddress" placeholder="??????" type="text"/>
									<button class="btn btn-sm btn-danger btn-block" type="submit">????????????</button><br>
								</form>
		    					<form method="post" action="${pageContext.request.contextPath}/loginCheck/purchaseByBasketCompleteController">
		    						<c:if test="${searchAddressList != null}">
							       		<select class="form-control" id="address" name="address">
							   		    	<option value = "" style="text-align:center;">:: ?????? ?????? ::</option>
								            <c:forEach var="s" items="${searchAddressList}">
								            	<option value="${s.addr}" style="text-align:center;">${s.addr}</option>
								            </c:forEach>
								            <span id="addressHelper" class="helper"></span>
							           	</select>
		      						</c:if>
			    					<table>
			    						<tr>
			    							<input type="hidden" name="productId" value="${productId}">
			    							<td>???????????? &nbsp; |&nbsp;&nbsp;&nbsp;</td>
			    							<td><input type="text" name="detailAddr" style="width: 500px;"></td>
			    						</tr>
			    						<tr>
			    							<td>???????????? &nbsp; |</td>
			    							<td><input type="text" name="phone"></td>
			    						</tr>
			    						<tr>
			    							<td>???????????? &nbsp; |</td>
			    							<td><input type="text" name="name"></td>
			    						</tr>
			    					</table>
		    				</address>
		    			</div>
		    		</div>
						<address>
							<strong>????????????</strong><br>
							<input type="hidden" name="payment" value="???????????????">???????????????
						</address>
		    	</div>
		    </div>
		    
		    	<div class="row">
		    		<div class="col-md-12">
		    			<div class="panel panel-default">
		    				<div class="panel-heading">
		    					<h3 class="panel-title"><strong>?????? ??????</strong></h3>
		    				</div>
		    				<div class="panel-body">
		    					<div class="table-responsive">
		    						<table class="table table-condensed">
			    						<thead>
			                                <tr>
			        							<td><strong>??????</strong></td>
			        							<td class="text-center"><strong>??????</strong></td>
			        							<td class="text-center"><strong>??????</strong></td>
			        							<td class="text-right"><strong>??? ??????</strong></td>
			                                </tr>
			    						</thead>
		    							<tbody>
		    								<c:forEach var="m" items="${memberBasketList}">
		    									<tr>
				    								<td><img src="${pageContext.request.contextPath}/images/${m.photoName}" width="100px" height="100px"></td>
				    								<td class="text-center"><input class="text-center" type="text" name="photoName" value="${m.productName}" readonly="readonly" style="border:0 solid black"></td>
				    								<td class="text-center"><input class="text-center" type="text" name="quantity" value="${m.quantity}" readonly="readonly" style="border:0 solid black"></td>
				    								<td class="text-right"><input class="text-right" type="text" name="totalPriceByBasket" value="${m.price * m.quantity}" readonly="readonly" style="border:0 solid black">???</td>
			    								</tr>
		    								</c:forEach>
			    								<tr>
				    								<td class="thick-line"></td>
				    								<td class="thick-line"></td>
				    								<td class="thick-line text-center"><strong>??? ??????</strong></td>
				    								<td class="thick-line text-right">${totalPriceByBasket}???</td>
			    								</tr>
			    								<tr>
			    									<td colspan="4" class="text-right"><button type="submit">????????????</button></td>
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
