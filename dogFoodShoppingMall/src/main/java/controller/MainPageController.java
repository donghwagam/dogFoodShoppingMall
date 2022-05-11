package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import vo.Category;

@WebServlet("/mainPageController")
public class MainPageController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProductDao productDao = new ProductDao(); // productDao 호출 
		
		String categoryName = request.getParameter("categoryName"); // 카테고리 받아오기 
		
		// 1) 상품리스트를 보여주는 리스트 
		List<Map<String, Object>> productList = productDao.selectProductList(); 
		request.setAttribute("productList", productList);
		// 2) 카테고리 정보 보여주는 리스트 
		List<Category> categoryList = productDao.selectCategoryList();
		request.setAttribute("categoryList", categoryList);
		// 3) 최신순으로 보여주는 리스트  
		List<Map<String, Object>> latestProductList = productDao.selectProductListByLatest();
		request.setAttribute("latestProductList", latestProductList);
		
		// 4) 상품을 인기순으로 보여주는 리스트 
		List<Map<String,Object>> topRateList = productDao.selectProductListByTopRated();
		request.setAttribute("topRateList", topRateList);
		
		// 5) 카테고리 정보로 상품을 보여주는 리스트
		List<Map<String ,Object>> productCategoryList = productDao.selectProductListByCategory(categoryName);
		request.setAttribute("productCategoryList", productCategoryList);
		
		request.getRequestDispatcher("WEB-INF/view/mainPage.jsp").forward(request,response); // 뷰 포워딩 
	}

}
