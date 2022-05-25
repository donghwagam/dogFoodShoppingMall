<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ogani | Template</title>

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
   .bottom {margin-bottom:70px;}
   .top {margin-top:15px;}
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

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="./Resources/img/dogLayer.png">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>상세 검색</h2>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    
   <!-- Search Box Begin -->
   <div class="container">
      <form method="get" action="${pageContext.request.contextPath}/productSearchController">
         <table class="table table-bordered" style = "margin-top : 50px">
            <tr>
               <td>연령</td>
               <td>
                  <input type="radio" name="age" value="${a.name}" checked="checked">선택안함
                  <c:forEach var="a" items="${ageList}">
                        <input type="radio" name="age" value="${a.categoryId}"
                        	<c:if test="${a.categoryId eq ageId}">checked</c:if>
                        /> ${a.name}
                  </c:forEach>  
               </td>
            </tr>
            <tr>
               <td>알러지</td> 
               <td>
                  <select name="component" id="component">
                     <option value="">선택없음</option>
                     <c:forEach var="c" items="${componentList}">
                        <option value="${c.componentId}"
                        	<c:if test="${c.componentId eq componentId}">selected</c:if>
                        />${c.name}</option>
                     </c:forEach>
                  </select>
               </td>
            </tr>
            <tr>
               <td>사료타입</td>
               <td>
                  <input type="radio" name="feedType" value="" checked="checked">선택안함
                     <c:forEach var="t" items="${feedTypeList}">
                        <input type="radio" name="feedType" value="${t.categoryId}"
                        	<c:if test="${t.categoryId eq feedTypeId}">checked</c:if>
                        />${t.name}
                     </c:forEach>
               </td>
            </tr>
            <tr>
               <td>알갱이 크기</td>
               <td>
                  <input type="radio" name="size" value="" checked="checked">선택안함
                  <input type="radio" name="size" value="소" <c:if test="${'소' eq size}">checked</c:if> />소
                  <input type="radio" name="size" value="중" <c:if test="${'중' eq size}">checked</c:if> />중
                  <input type="radio" name="size" value="대" <c:if test="${'대' eq size}">checked</c:if> />대
               </td>
            </tr>
         </table>
         <button type="submit" class="btn site-btn form-control bottom">상품 검색하기</button>
      </form>
 	</div>
   <!-- Search Box End -->

   <!-- 사용자가 검색을 했다면 검색 조건 맞춰서 출력 검색 안했을시는 최신순 출력-->
   <div class = "container">
		<div class = "row">
		   <c:forEach var="sc" items="${searchCategoryList}">
				<div class="col-lg-4 col-md-4 col-sm-4">
					<div class="product__item">
						<div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/images/${sc.photoName}">
							<ul class="product__item__pic__hover">
								<c:choose>
									<c:when test="${sessionMemberId== null}">
				   						<li><a href="${pageContext.request.contextPath}/addGuestBasketController?productId=${sc.productId}"><i class="fa fa-shopping-cart"></i></a></li>
					   				</c:when>
					   				<c:otherwise>
					   					<li><a href="${pageContext.request.contextPath}/addMemberBasketController?productId=${sc.productId}"><i class="fa fa-shopping-cart"></i></a></li>
					   				</c:otherwise>
					   			</c:choose>
							</ul>
						</div>
						<div class="product__item__text">
							<a href="${pageContext.request.contextPath}/mainProductOneController?productId=${sc.productId}">
								<h6>${sc.productName} ${sc.gram}g</h6>
			  					<h5>${sc.price}원</h5>
			  				</a>
						</div>
					 </div>
				</div>
		  </c:forEach>
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