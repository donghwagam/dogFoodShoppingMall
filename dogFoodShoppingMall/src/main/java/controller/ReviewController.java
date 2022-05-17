package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;


@WebServlet("/loginCheck/reviewController")
public class ReviewController extends HttpServlet {
	private ReviewDao reviewDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		reviewDao = new ReviewDao();
		List<Map<String, Object>> selectReviewList = reviewDao.selectReview(productId);
		
		request.setAttribute("selectReviewList", selectReviewList);
		System.out.println("[테스트]리뷰 리스트 항목입니다! 희희희희희 ▶▶▶▶▶▶▶▶" + selectReviewList.size());

		
		request.getRequestDispatcher("/WEB-INF/view/mainProductOne.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		
		
	}

}
