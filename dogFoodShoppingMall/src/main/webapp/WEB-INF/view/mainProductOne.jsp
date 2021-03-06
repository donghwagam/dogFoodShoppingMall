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
    <title>상품상세정보</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="./Resources/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="./Resources/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="./Resources/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="./Resources/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="./Resources/css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="./Resources/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="./Resources/css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="./Resources/css/style.css" type="text/css">
    
    <style>
   .bottom {margin-bottom:15px;}
   .top {margin-top:70px;}
   .fs {font-size: 27px; font-weight: bold;}
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
                    <div class="col-lg-6">
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
								<a href="https://www.instagram.com/gaebobheaven/"><i class="fa fa-instagram"></i></a> 
							 	<a href="https://open.kakao.com/o/gPlN8Ahe"><i class="fa fa-comment"></i></a>
							</div>
                            <div class="header__top__right__auth">
                                <c:choose>
									<c:when test="${sessionMemberId == null}">
										<a href="${pageContext.request.contextPath}/loginController"><i class="fa fa-user"></i> Login</a>
									</c:when>
									<c:otherwise>
										<span style="font-size: 14px">${sessionMemberId} 님 반갑습니다</span> 
										<a href="${pageContext.request.contextPath}/memberOneController" style="display: inline">| 마이페이지 </a>
										<a href="${pageContext.request.contextPath}/loginCheck/logoutController" style="display: inline"> | 로그아웃 </a>
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
                        <a href="${pageContext.request.contextPath}/mainPageController"><img src="./Resources/img/dogFood.png" alt=""></a>
                    </div>
                </div>
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

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="./Resources/img/dogLayer.png">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>상품정보</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Product Details Section Begin -->
    <section class="product-details spad">
        <div class="container">
          <c:forEach var="list" items="${list}">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__pic">
                        <div class="product__details__pic__item">
                        
                            <img class="product__details__pic__item--large"
                                 src="${pageContext.request.contextPath}/images/${list.photoName}" alt="">
                        </div>
                      
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="product__details__text">
                        <h3>${list.productName}</h3>
                        <div class="product__details__rating">
                           <h4>평점 : ${star}</h4>
                        </div>
                        <div class="product__details__price">${list.price} 원</div>
                        <p>${list.info} </p>
                        <c:choose>
                        <c:when test="${memberId == null}">
                        	<a href="${pageContext.request.contextPath}/loginController?productId=${productId}" class="primary-btn">구매하기</a>
                        </c:when>
                        <c:otherwise>	
                        <form method="post" action="${pageContext.request.contextPath}/loginCheck/purchaseByProductController">
	                        <div class="product__details__quantity">
	                            <div class="quantity">
	                                <div class="pro-qty">
	                                    <input type="text" name="quantity" value="1">
	                                </div>
	                            </div>
	                        </div>
	                        <input type="hidden" name="productId" value="${productId}">
	                        <button class="primary-btn" type="submit">구매하기</button>
                        </form>
                        </c:otherwise>
                        
                        </c:choose>
                        <a href="#" class="heart-icon"><span class="icon_heart_alt"></span></a>
                        <ul>
                            <li><b>수량 </b> <span>
                            <c:choose>
                            <c:when test="${list.stock == 0}">
                            품절 
                            </c:when>
                            <c:otherwise>
                            ${list.stock}
                            </c:otherwise>
                            </c:choose>
                            </span></li>
                            <li><b>원산지</b> <span>${list.origin} </li>
                            <li><b>브랜드</b> <span>${list.brandName}</span></li>
                            <li><b>Share on</b>
                                <div class="share">
                                    <a href="#"><i class="fa fa-instagram"></i></a>
                                    <a href="#"><i class="fa fa-comment"></i></a>
                                </div>
                            </li>
                        </ul>
                     
                    </div>
                </div>
                
                <div class="col-lg-12">
                    <div class="product__details__tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link active" data-toggle="tab" href="#tabs-1" role="tab"
                                    aria-selected="true">상품정보</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-2" role="tab"
                                    aria-selected="false">리뷰<span> (${reviewCnt})</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" data-toggle="tab" href="#tabs-3" role="tab"
                                    aria-selected="false">Q&A<span> (${qnaCnt})</span></a>
                            </li>
                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane active" id="tabs-1" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h6>구성표 </h6>
                                    <p>${list.componentName}</p>
                                    <h6>등급 </h6>
                                    <p>${list.rate}</p>
                                    <h6>알갱이크기 </h6>
                                    <p>${list.feedSize}</p>
                                    <h6>무게</h6>
                                    <p>${list.gram*0.001}kg</p>
                                    <h6>상품정보</h6>
                                    <p>${list.info}</p>
                                    <p><c:forEach var="p" items="${photoList}">
                                   	<img src="${pageContext.request.contextPath}/images/${p.name}">
                                    </c:forEach></p>
                                    
                                </div>
                            </div>
                           </c:forEach> 
                            <div class="tab-pane" id="tabs-2" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <h3 class="bottom">리뷰</h3>
                                 	<table class="table">
                                 		<tr>
                                 			<th>사진</th>
                                 			<th>아이디</th>
                                 			<th>견종</th>
                                 			<th>제목</th>
                                 			<th>내용</th>
                                 			<th>평점</th>
                                 			<th>작성날짜</th>
                                 		</tr>
                             	    <c:forEach var="r" items="${selectReviewList}">
                                 		<tr>
                                 			<td><img src="${pageContext.request.contextPath}/insertReviewPhoto/${r.reviewPhotoName}" width="70" height="70" alt=""></td>
                                 			<td>${r.memberId}</td>
                                 			<td>${r.spiece}</td>
                                 			<td>${r.title}</td>
                                 			<td>${r.reviewContent}</td>
                                 			<td>${r.star}</td>
                                 			<td>${r.createDate}</td>
                                 		</tr>
                                	</c:forEach> 
                                 	</table>
                                </div>
                            </div>
                            <div class="tab-pane" id="tabs-3" role="tabpanel">
                                <div class="product__details__tab__desc">
                                    <div class="fs bottom"> Q & A
                                    <c:choose>
                                    <c:when test = "${memberId eq 'admin'}">
                                    	<a href="${pageContext.request.contextPath}/insertQnaController?productId=${productId}&memberId=${memberId}" class="site-btn float-right">답변하기</a>
                                    </c:when>
                                    <c:otherwise>
                                    	<a href="${pageContext.request.contextPath}/insertQnaController?productId=${productId}&memberId=${memberId}" class="site-btn float-right">질문하기</a>
                                    </c:otherwise>
                                     </c:choose>
                                     </div>
                                    <table class="table">
                                    <tr>
                                 		<th>종류</th>
                                 		<th>질문내용</th>
                                 		<th>작성자</th>
                                 		<th>작성일</th>
                                 	</tr>
                                 <c:forEach var="q" items="${selectQnaList}">
                                 	<tr>
                                 		<td>${q.qnaKind}</td>
                                 		<td>${q.memo}</td>
                                 		<td>${q.memberId}</td>
                                 		<td>${q.createDate}</td>
                                 	</tr>
                                 </c:forEach>
                                   </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Details Section End -->

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
							 <a href="https://open.kakao.com/o/gPlN8Ahe"><i class="fa fa-comment"></i></a>
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