package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MainProductDao;
import dao.ReviewDao;
import vo.Category;

@WebServlet("/mainProductOneController")
public class MainProductOneController extends HttpServlet {
	private MainProductDao mainProductDao; //맴버 변수 MainProductDao 선언
	private ReviewDao reviewDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 선택한 상품의 productId값을 받아옴
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("MainProductOneController.doGet() productId : " + productId);
		
		request.setAttribute("productId", productId);
		
		this.mainProductDao = new MainProductDao(); // dao 호출
		
		// 선택한 상품 상세정보 불러오는 리스트
		List<Map<String, Object>> list = mainProductDao.selectProductOne(productId);
		System.out.println("MainProductOneController.doGet() list size : " + list.size());
		
		// 선택한 상품 상세정보 페이지에서 리뷰 불러오는 리스트
		this.reviewDao = new ReviewDao();
		List<Map<String, Object>> selectReviewList = reviewDao.selectReview(productId);
		request.setAttribute("selectReviewList", selectReviewList);
		System.out.println("MainProductController.doGet() selectReviewList size : " + selectReviewList.size());
		
		// 카테고리 정보 불러오는 리스트
		List<Category> categoryList =  mainProductDao.selectCategoryList();
		
		System.out.println("MainProductController.doGet() categoryList size :" + categoryList.size());
		request.setAttribute("categoryList", categoryList);
		
		request.setAttribute("list", list);
	
		request.getRequestDispatcher("/WEB-INF/view/mainProductOne.jsp").forward(request, response);
	}

}
