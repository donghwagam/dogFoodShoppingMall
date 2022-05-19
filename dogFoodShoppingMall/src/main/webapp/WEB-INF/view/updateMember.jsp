<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
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
         <a href="#"><img src="./Resources/img/logo.png" alt=""></a>
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
	                      <!-- null이 아니면 마이페이지,로그아웃 버튼 출력  -->
	                      <div>${sessionMemberId} 님 반갑습니다 <a href="${pageContext.request.contextPath}/memberOneController">| 마이페이지 </a><a href="${pageContext.request.contextPath}/loginCheck/logoutController"> | 로그아웃 </a></div>
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
                  <a href="./index.html"><img src="./Resources/img/fakeLogo.png"
                     alt=""></a>
               </div>
            </div>
            <!--  상단바  -->
            <div class="col-lg-6">
               <nav class="header__menu">
                  <ul>
                     <li class="active"><a href="${pageContext.request.contextPath}/productSearchController">상세검색</a></li>
                     <li><a href="./shop-grid.html">브랜드</a></li>
                     <li><a href="./blog.html">랭킹</a></li>
                     <li><a href="./contact.html">신상품</a></li>
                  </ul>
               </nav>
            </div>
            <div class="col-lg-3">
               <div class="header__cart">
                  <ul>
                     <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                     <li><a href="${pageConext.request.contextPath}/basketListController"><i class="fa fa-shoppintg-bag"></i> <span>3</span></a></li>
                  </ul>
                  <div class="header__cart__price">
                     item: <span>$150.00</span>
                  </div>
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
                     <!-- 마이페이지 목록출력  -->   
                     <ul>
						<li><a href="${pageContext.request.contextPath}/memberOneController">회원/애견 정보</a></li>
                        <li><a href="${pageContext.request.contextPath}/purchaseMemberListController">구매내역</a></li>
                     </ul>
                  </div>
               </div>
               <div class="col-9">
                  <h3>회원정보 수정</h3>
                  <!-- 회원정보 수정 -->
                     <form method="post" action="${pageContext.request.contextPath}/updateMemberController">
                        <table class="table">
                           <tr>
                              <td>아이디</td>
                              <td><input class="form-control" name="memberId" type="text" value="${MemberMap.memberId}" readonly="readonly"></td>
                           </tr>
                           <tr>
                              <td>이름</td>
                              <td><input class="form-control" type="text" name="memberName" value="${MemberMap.name}"></td>
                           </tr>
                           <tr>
                           	  <td>성별</td>
                           	  <td>
                           	  	  <input type="radio" name="gender" <c:if test= "${MemberMap.gender eq '남'}">checked</c:if> value="남"/>남
                           	      <input type="radio" name="gender" <c:if test= "${MemberMap.gender eq '여'}">checked</c:if> value="여"/>여
                           	  </td>
                           </tr>
                           <tr>
                              <td>생년월일</td>
                              <td><input class="form-control" name="birth" type="date" value="${MemberMap.birth}"/></td>
                           </tr>
                           <tr>
                              <td>휴대전화</td>
                              <td><input class="form-control" name="phone" type="text" value="${MemberMap.phone}" placeholder="-를 제외하고 입력해주세요"/></td>
                           </tr>
                           <tr>
                              <td>이메일</td>
                              <td><input class="form-control" name="email" type="text" value="${MemberMap.email}"/></td>
                           </tr>
                        </table>
                        <button type="submit">정보 수정</button>
                     </form>
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
                     <a href="./index.html"><img src="./Resources/img/logo.png"
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