package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDao;

@WebServlet("/adminCheck/insertQnaController")
public class InsertQnaController extends HttpServlet {
	private QnaDao qnaDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("sessionMemberId");
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("InsertQnaController.doGet() productId" + productId);
		
		request.setAttribute("memberId", memberId);
		request.setAttribute("productId", productId);

		request.getRequestDispatcher("/WEB-INF/view/insertQna.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
