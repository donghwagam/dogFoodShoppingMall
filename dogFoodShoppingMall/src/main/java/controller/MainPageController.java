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
		this.mainProductDao = new MainProductDao();
		HttpSession session = request.getSession(); // 세션 정보 불러오기
		
		String memberId = (String)session.getAttribute("sessionMemberId");
		System.out.println("MainPageController.doGet() memberId :" + memberId);
		
		String categoryName = request.getParameter("categoryName"); // 카테고리 받아오기 
		System.out.println("MainPageController.doGet() categoryName : " + categoryName);
		int currentPage = 1;  // 현재 페이지 
		if (request.getParameter("currentPage") != null ) { // 현재패이지값이 null 이 아니면 
			currentPage = Integer.parseInt(request.getParameter("currentPage")); // 현재 페이지 값 불러
		}
		
		int rowPerPage = 12; // 한패이지당 회원정보 12개씩 출력 
		int beginRow = (currentPage - 1)*rowPerPage;
		// 1) 상품리스트를 보여주는 리스트 
		List<Map<String, Object>> productList = mainProductDao.selectProductList(beginRow, rowPerPage); 
		System.out.println("MainPageController.doGet() productList : " + productList.size());
		int lastPage = 0; // 마지막 페이지 
		int categoryLastPage = 0;
		int totalCount = mainProductDao.selectProductTotalRow();
			
		int categoryTotalCount = mainProductDao.selectProductTotalRowByCategory(categoryName);
		
		lastPage = (int)Math.ceil((double)totalCount / (double)rowPerPage); // 마지막 페이지 구하기
		categoryLastPage = (int)Math.ceil((double)categoryTotalCount / (double)rowPerPage); 
		//----------------------------------------------------------
		System.out.println("-----------------메서드---------------");
		// 1) 상품리스트를 보여주는 리스트 
		
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
		List<Map<String ,Object>> productCategoryList =  mainProductDao.selectProductListByCategory(categoryName,beginRow,rowPerPage);
		System.out.println("MainPageController.doGet() productCategoryList :" + productCategoryList.size());
		request.setAttribute("productCategoryList", productCategoryList);
		
		request.setAttribute("categoryName",categoryName);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("categoryLastPage", categoryLastPage);
		request.getRequestDispatcher("/WEB-INF/view/mainPage.jsp").forward(request,response); // 뷰 포워딩 
	}

}
