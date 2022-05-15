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
                <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
            </ul>
            <div class="header__cart__price">item: <span>$150.00</span></div>
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
                <a href="#"><i class="fa fa-user"></i> Login</a>
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
                    </ul>
                </li>
                <li><a href="./blog.html">Blog</a></li>
                <li><a href="./contact.html">Contact</a></li>
            </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        <div class="header__top__right__social">
            <a href="#"><i class="fa fa-facebook"></i></a>
            <a href="#"><i class="fa fa-twitter"></i></a>
            <a href="#"><i class="fa fa-linkedin"></i></a>
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
                <div class="row">>
                        </div>
          
                    <div class="col-lg-6">
                        <div class="header__top__left">
                            <ul>
                                <li><i class="fa fa-envelope"></i> hello@colorlib.com</li>
                                <li>Free Shipping for all Order of $99</li>
                            </ul>
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
                                <a href="#"><i class="fa fa-user"></i> Login</a>
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
                        <a href="./index.html"><img src="./Resources/img/logo.png" alt=""></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="./index.html">Home</a></li>
                            <li class="active"><a href="./shop-grid.html">Shop</a></li>
                            <li><a href="#">Pages</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./shop-details.html">Shop Details</a></li>
                                    <li><a href="./shoping-cart.html">Shoping Cart</a></li>
                                    <li><a href="./checkout.html">Check Out</a></li>
                                    <li><a href="./blog-details.html">Blog Details</a></li>
                                </ul>
                            </li>
                            <li><a href="./blog.html">Blog</a></li>
                            <li><a href="./contact.html">Contact</a></li>
                        </ul>
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li>
                            <li><a href="#"><i class="fa fa-shopping-bag"></i> <span>3</span></a></li>
                        </ul>
                        <div class="header__cart__price">item: <span>$150.00</span></div>
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
    <section class="breadcrumb-section set-bg" data-setbg="./Resources/img/breadcrumb.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>Organi Shop</h2>
                        <div class="breadcrumb__option">
                            <a href="./index.html">Home</a>
                            <span>Shop</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->
    
   <!-- Search Box Begin -->
   <div class="container">
      <form method="post" action="${pageContext.request.contextPath}/productSearchController">
         <table border="1">
            <tr>
               <td>연령</td>
               <td>
                  <input type="radio" name="age" value="" checked="checked">선택안함
                  <c:forEach var="a" items="${ageList}">
                        <input type="radio" name="age" value="${a.categoryId}"> ${a.name}
                  </c:forEach>  
               </td>
               <td rowspan="4">
                  <button type="submit">Search</button>
               </td>
            </tr>
            <tr>
               <td>알러지</td>
               <td>
                  <select name="component">
                     <option value="">선택없음</option>
                     <c:forEach var="c" items="${componentList}">
                        <option value="${c.componentId}">${c.name}</option>
                    </c:forEach>
                  </select>
               </td>
            </tr>
            <tr>
               <td>사료타입</td>
               <td>
                  <input type="radio" name="feedType" value="" checked="checked">선택안함
                     <c:forEach var="t" items="${feedTypeList}">
                        <input type="radio" name="feedType" value="${t.categoryId}">${t.name}
                     </c:forEach>
               </td>
            </tr>
            <tr>
               <td>알갱이 크기</td>
               <td>
                  <input type="radio" name="size" value="" checked="checked">선택안함
                  <input type="radio" name="size" value="소">소
                  <input type="radio" name="size" value="중">중
                  <input type="radio" name="size" value="대">대
               </td>
            </tr>
         </table>
      </form>
   </div>
   <!-- Search Box End -->
   
   <!-- 검색을 안했다면 -->  
   <!-- 최신순으로 리스트 출력 -->  
   <c:set var="i" value="0"/>
   <c:set var="j" value="4"/>
   <table border="1">
	   <c:forEach var="s" items="${searchList}"> 
		   <c:if test="${i%j == 0}">
		   		<tr> 
		   </c:if>
		   <td>
			   <div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/images/${s.photoName}">
			   		<a href="${pageContext.request.contextPath}/addGuestBasketController?productId=${s.productId}">><i class="fa fa-shopping-cart"></i></a>
			   </div>
			   <div class="product__item__text">
			   		<h6>${s.productName} ${s.gram}g</h6>
			   		<h5>$ ${s.price}</h5>
			   		<div>${s.star}</div>
			   </div>
		   </td> 
		   <c:if test="${i%j == j-1}"> 
		  		</tr> 
		   </c:if>
		   <c:set var="i" value="${i+1}"/>
	   </c:forEach>
   </table>
   
   <!-- 사용자가 검색을 했다면 -->
   <!--  검색조건에 맞는 리스트 출력 -->
   <c:set var="i" value="0"/>
   <c:set var="j" value="4"/>				
   <table border="1">
       <c:forEach var="sc" items="${searchCategoryList}">
          <c:if test="${i%j == 0}">
		   		<tr> 
		   </c:if>
           <td>
           <div class="product__item__pic set-bg" data-setbg="${pageContext.request.contextPath}/images/${sc.photoName}">
		   <a href="${pageContext.request.contextPath}/addGuestBasketController?productId=${sc.productId}">><i class="fa fa-shopping-cart"></i></a>
		   </div>
			<div class="product__item__text">
				<h6>${sc.productName} ${sc.gram}g</h6>
			   	<h5>$ ${sc.price}</h5>
			   	<div>${sc.star}</div>
			</div>
     		</td>
     	<c:if test="${i%j == j-1}">
     		</tr>
     	</c:if>
     	<c:set var="i" value="${i+1}"/>
       </c:forEach>
   </table>
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
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="./Resources/img/payment-item.png" alt=""></div>
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