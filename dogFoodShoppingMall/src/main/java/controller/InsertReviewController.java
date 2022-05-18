package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;


@WebServlet("/loginCheck/insertReviewController")
public class InsertReviewController extends HttpServlet {
	
	private ReviewDao reviewDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int purchaseId = Integer.parseInt(request.getParameter("purchaseId"));
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		request.setAttribute("purchaseId", purchaseId);
		request.setAttribute("productId", productId);
		
		request.getRequestDispatcher("/WEB-INT/view/insertReview.jsp").forward(request, response);
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
	this.reviewDao = new ReviewDao();
	
	
	
	}

}
