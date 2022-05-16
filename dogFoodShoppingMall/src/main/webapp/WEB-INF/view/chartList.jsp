<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
   <meta charset="UTF-8">
   <meta name="description" content="Ogani Template">
   <meta name="keywords" content="Ogani, unica, creative, html">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>통계</title>
   
   <!-- Google Font -->
   <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">
   
   <!-- Css Styles -->
   <link rel="stylesheet" href="./Resources/css/bootstrap.min.css" type="text/css">
   <link rel="stylesheet" href="./Resources/css/font-awesome.min.css" type="text/css">
   <link rel="stylesheet" href="./Resources/css/elegant-icons.css"   type="text/css">
   <link rel="stylesheet" href="./Resources/css/nice-select.css" type="text/css">
   <link rel="stylesheet" href="./Resources/css/jquery-ui.min.css"   type="text/css">
   <link rel="stylesheet" href="./Resources/css/owl.carousel.min.css" type="text/css">
   <link rel="stylesheet" href="./Resources/css/slicknav.min.css" type="text/css">
   <link rel="stylesheet" href="./Resources/css/style.css" type="text/css">
</head>
<body>
// chart 구현 css 템플릿 구하기 ( 막대그래프 , 꺽은선 그래프)

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
            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
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
                  <a href="${pageContext.request.contextPath}/loginDenied/loginController"><i   class="fa fa-user"> Login</i></a>
               </c:when>
               <c:otherwise>
                  <div>${sessionMemberId}님 반갑습니다 
                     <a href="${pageContext.request.contextPath}/memberOneController">|마이페이지</a>
                     <a href="${pageContext.request.contextPath}/logoutController">|로그아웃</a>
                  </div>
               </c:otherwise>
            </c:choose>
         </div>
      </div>
      <nav class="humberger__menu__nav mobile-menu">
         <ul>
            <li class="active">
               <a href="${pageContext.request.contextPath}/mainPageController">Home</a>
            </li>
            <li>
               <a href="./shop-grid.html">Shop</a>
            </li>
            <li>
               <a href="#">Pages</a>
               <ul class="header__menu__dropdown">
                  <li><a href="./Resources/shop-details.html">Shop Details</a></li>
                  <li><a href="./Resources/shoping-cart.html">Shoping Cart</a></li>
                  <li><a href="./Resources/checkout.html">Check Out</a></li>
                  <li><a href="./Resources/blog-details.html">Blog Details</a></li>
               </ul>
            </li>
            <li><a href="./Resources/blog.html">Blog</a></li>
            <li><a href="./Resources/contact.html">Contact</a></li>
         </ul>
      </nav>
      <div id="mobile-menu-wrap"></div>
      <div class="header__top__right__social">
         <a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i class="fa fa-twitter"></i></a> 
         <a href="#"><i class="fa fa-linkedin"></i></a>
         <a href="#"><i class="fa fa-pinterest-p"></i></a>
      </div>
      <div class="humberger__menu__contact">
         <ul>
            <li><i class="fa fa-envelope">hello@colorlib.com</i></li>
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
               <div class="col-lg-6">
                  <div class="header__top__left">
                     <ul>
                        <li><i class="fa fa-envelope">hello@colorlib.com</i></li>
                        <li>Free Shipping for all Order of $99</li>
                     </ul>
                  </div>
               </div>
               <div class="col-lg-6">
                  <div class="header__top__right">
                     <div class="header__top__right__social">
                        <a href="#"><i class="fa fa-facebook"></i></a> 
                        <a href="#"><i class="fa fa-twitter"></i></a> 
                        <a href="#"><i class="fa fa-linkedin"></i></a> 
                        <a href="#"><i class="fa fa-pinterest-p"></i></a>
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
                     <div class="header__top__right__auth">
                        <c:choose>
                           <c:when test="${sessionMemberId == null}">
                              <a href="${pageContext.request.contextPath}/loginDenied/loginController"><i class="fa fa-user">Login</i></a>
                           </c:when>
                           <c:otherwise>
                              <div>${sessionMemberId}님 반갑습니다 
                                 <a href="${pageContext.request.contextPath}/memberOneController">|마이페이지</a>
                                 <a href="${pageContext.request.contextPath}/logoutController">|로그아웃</a>
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
                  <a href="./Resources/index.html"><img src="./Resources/img/logo.png" alt=""></a>
               </div>
            </div>
            <div class="col-lg-6">
               <nav class="header__menu">
                  <ul>
                     <li><a href="${pageContext.request.contextPath}/mainPageController">Home</a></li>
                     <li class="active"><a href="./Resources/shop-grid.html">Shop</a></li>
                     <li><a href="#">Pages</a>
                        <ul class="header__menu__dropdown">
                           <li><a href="./Resources/shop-details.html">Shop Details</a></li>
                           <li><a href="./Resources/shoping-cart.html">Shoping   Cart</a></li>
                           <li><a href="./Resources/checkout.html">Check Out</a></li>
                           <li><a href="./Resources/blog-details.html">Blog Details</a></li>
                        </ul></li>
                     <li><a href="./Resources/blog.html">Blog</a></li>
                     <li><a href="./Resources/contact.html">Contact</a></li>
                  </ul>
               </nav>
            </div>
            <div class="col-lg-3">
               <div class="header__cart">
                  <ul>
                     <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                     <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
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
   <!--  헤드 부분 css 끝 -->
   
   
   
   
   
   
   
   
   <section class="latest-product spad">
      <div class="container">
         <div class="row">
            <div class="col-lg-4 col-md-6">
               <div class="latest-product__text">
                  <h4>상품별 판매량</h4>
                  <div class="latest-product__slider owl-carousel">
                     <div class="latest-prdouct__slider__item">
                     <!--  최신순으료 정렬  -->
                        <c:forEach var="c" items="${chartListByProductList}" begin="0" end="2" step="1"> 
                           <a href="${pageCotext.request.contextPath}/mainProductOneController?productName=${c.productId}" class="latest-product__item">
                           <div class="latest-product__item_text">
                              <h6>${c.productName}</h6>
                              <h6>${c.price} 원</h6>
                              <h6>${c.sum} 개</h6>
                              <span> 총액 : </span>
                           </div>
                           </a>
                        </c:forEach> 
                     </div>
                     <div class="latest-prdouct__slider__item">
                        <c:forEach var="c" items="${chartListByProductList}" begin="3" end="5" step="1">
                           <a href="${pageCotext.request.contextPath}/mainProductOneController?productName=${c.productId}" class="latest-product__item">
                              <div class="latest-product__item_text">
                                 <h6>${c.productName}</h6>
                                 <h6>${c.price} 원</h6>
                                 <h6>${c.sum} 개</h6>
                                 <span> 총액 : </span>
                              </div>
                           </a> 
                        </c:forEach>
                     </div>
                  </div>
               </div>
               // ??? 해당 날짜 클릭시 해당 날짜에 상품별 판매량 구현
               <div class="latest-product__text">
                  <h4>날짜별 판매량</h4>
                  <div class="latest-product__slider owl-carousel">
                     <div class="latest-prdouct__slider__item">
                        <c:forEach var="c" items="${chartListByDateList}" begin="0" end="2" step="1">
                           <a href="${pageContext.request.contextPath}/mainProductOneController?productId=${c.productId}" class="latest-product__item">
                           <div class="latest-product__item_text">
                              <h6>${c.updateDate}</h6>
                              <h6>${c.sum} 개</h6>
                              <span> 총액 : </span>
                           </div>
                           </a> 
                        </c:forEach>
                     </div>
                     <div class="latest-prdouct__slider__item">
                        <c:forEach var="c" items="${chartListByDateList}" begin="3" end="5" step="1">
                           <a href="${pageContext.request.contextPath}/mainProductOneController?productId=${c.productId}" class="latest-product__item">
                           <div class="latest-product__item_text">
                              <h6>${c.updateDate}</h6>
                              <h6>${c.sum} 개</h6>
                              <span> 총액 : </span>
                           </div>
                           </a> 
                        </c:forEach>
                     </div>
                  </div>
               </div>
               // ??? 해당 카테고리 클릭시 해당 카테고리 상품별 판매량 구현
               <div class="latest-product__text">
                  <h4>카테고리별 판매량</h4>
                  <div class="latest-product__slider owl-carousel">
                     <div class="latest-prdouct__slider__item">
                        <c:forEach var="c" items="${chartListByCategoryList}" begin="0" end="2" step="1">
                           <a href="${pageContext.request.contextPath}/mainProductOneController?productId=${c.productId}" class="latest-product__item">
                           <div class="latest-product__item_text">
                              <h6>${c.categoryName}</h6>
                              <h6>${c.sum} 개</h6>
                              <span> 총액 : </span>
                           </div>
                           </a> 
                        </c:forEach>
                     </div>
                     <div class="latest-prdouct__slider__item">
                        <c:forEach var="c" items="${chartListByDateList}" begin="3" end="5" step="1">
                           <a href="${pageContext.request.contextPath}/mainProductOneController?productId=${c.productId}" class="latest-product__item">
                           <div class="latest-product__item_text">
                              <h6>${c.categoryName}</h6>
                              <h6>${c.sum} 개</h6>
                              <span> 총액 : </span>
                           </div>
                           </a> 
                        </c:forEach>
                     </div>
                  </div>
               </div>
               // ??? 해당 브랜드 클릭시 해당 브랜드 상품별 판매량 구현
               <div class="latest-product__text">
                  <h4>브랜드별 판매량</h4>
                  <div class="latest-product__slider owl-carousel">
                     <div class="latest-prdouct__slider__item">
                        <c:forEach var="c" items="${chartListByBrandList}" begin="0" end="2" step="1">
                           <a href="${pageContext.request.contextPath}/mainProductOneController?productId=${c.productId}" class="latest-product__item">
                           <div class="latest-product__item_text">
                              <h6>${c.brandName}</h6>
                              <h6>${c.sum} 개</h6>
                              <span> 총액 : </span>
                           </div>
                           </a> 
                        </c:forEach>
                     </div>
                     <div class="latest-prdouct__slider__item">
                        <c:forEach var="c" items="${chartListByDateList}" begin="3" end="5" step="1">
                           <a href="${pageContext.request.contextPath}/mainProductOneController?productId=${c.productId}" class="latest-product__item">
                           <div class="latest-product__item_text">
                              <h6>${c.brandName}</h6>
                              <h6>${c.sum} 개</h6>
                              <span> 총액 : </span>
                           </div>
                           </a> 
                        </c:forEach>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </section>
   
      
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   <!--  하단부 ccs 시작 -->
   <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./index.html"><img src="./Resources/img/logo.png" alt=""></a>
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
                        <p>Get E-mail updates about our latest shop and special offers.</p>
                        <form action="#">
                            <input type="text" placeholder="Enter your mail">
                            <button type="submit" class="site-btn">Subscribe</button>
                        </form>
                        <div class="footer__widget__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-instagram"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-pinterest"></i></a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p>
                           <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;
                            <script>document.write(new Date().getFullYear());</script>
                            All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by 
                            <a href="https://colorlib.com" target="_blank">Colorlib</a>
                       <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
                    </div>
                        <div class="footer__copyright__payment"><img src="./Resources/img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->
    <!-- 하단부 css 끝 -->

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
