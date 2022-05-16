package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;
import java.util.Map;

import dao.MainProductDao;
import vo.Category;

@WebServlet("/mainPageController")
public class MainPageController extends HttpServlet {
	
	private MainProductDao mainProductDao; //멤버 변수 MainProductDao 선언 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession(); // 세션 정보 불러오기
		
		
		this.mainProductDao = new MainProductDao(); // dao 호출
		//-------------------------------------------------------
		String categoryName = request.getParameter("categoryName"); // 카테고리 받아오기 
		System.out.println("MainPageController.doGet() categoryName : " + categoryName);
		
		
		//----------------------------------------------------------
		System.out.println("-----------------메서드---------------");
		// 1) 상품리스트를 보여주는 리스트 
		List<Map<String, Object>> productList = mainProductDao.selectProductList(); 
		
		System.out.println("MainPageController.doGet() productList : " + productList.size());
		request.setAttribute("productList", productList);
		
		// 2) 카테고리 정보 보여주는 리스트 
		List<Category> categoryList =  mainProductDao.selectCategoryList();
		System.out.println("MainPageController.doGet() categoryList : " + categoryList.size());
		request.setAttribute("categoryList", categoryList);
		// 3) 최신순으로 보여주는 리스트  
		List<Map<String, Object>> latestProductList =  mainProductDao.selectProductListByLatest();
		System.out.println("MainPageController.doGet() latestProductList : " + latestProductList.size());
		request.setAttribute("latestProductList", latestProductList);
		
		// 4) 상품을 인기순으로 보여주는 리스트 
		List<Map<String,Object>> topRateList =  mainProductDao.selectProductListByTopRated();
		System.out.println("MainPageController.doGet() topRateList : " + topRateList.size());
		request.setAttribute("topRateList", topRateList);
		
		// 5) 카테고리 정보로 상품을 보여주는 리스트
		List<Map<String ,Object>> productCategoryList =  mainProductDao.selectProductListByCategory(categoryName);
		System.out.println("MainPageController.doGet() productCategoryList :" + productCategoryList.size());
		request.setAttribute("productCategoryList", productCategoryList);
		
		request.getRequestDispatcher("/WEB-INF/view/mainPage.jsp").forward(request,response); // 뷰 포워딩 
	}

}
