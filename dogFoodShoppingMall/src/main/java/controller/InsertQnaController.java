package controller;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QnaDao;
import vo.Qna;

@WebServlet("/insertQnaController")
public class InsertQnaController extends HttpServlet {
	private QnaDao qnaDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String memberId = (String)session.getAttribute("sessionMemberId");
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("InsertQnaController.doGet() productId : " + productId);
		
		request.setAttribute("memberId", memberId);
		request.setAttribute("productId", productId);
		
		
		if (memberId.equals("admin")) {
			request.getRequestDispatcher("/WEB-INF/view/insertQnaAnswer.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/view/insertQnaQuestion.jsp").forward(request, response);
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String memberId = request.getParameter("memberId");
		String qnaKind = request.getParameter("qnaKind");
		String memo = request.getParameter("memo");
		int productId = Integer.parseInt(request.getParameter("productId"));
		int row = 0;
		
		System.out.println("InsertQnaController.doPost() productId : " + productId);
		System.out.println("InsertQnaController.doPost() memberId : " + memberId);
		System.out.println("InsertQnaController.doPost() qnaKind : " + qnaKind);
		System.out.println("InsertQnaController.doPost() memo : " + memo);
		
		Qna qna = new Qna();
		this.qnaDao = new QnaDao();
		
		qna.setProductId(productId);
		qna.setMemberId(memberId);
		qna.setQnaKind(qnaKind);
		qna.setMemo(memo);
		
		row = qnaDao.insertQna(qna);
		
		if(row == 1) {
			response.sendRedirect(request.getContextPath()+"/mainProductOneController?productId="+productId+"&memberId="+memberId);
			System.out.println("InsertQnaController.doPost() : Q&A 입력 완료");
		} else {
			response.sendRedirect(request.getContextPath()+"/insertQnaController?productId="+productId+"&memberId="+memberId);
			System.out.println("InsertQnaController.doPost() : Q&A 입력 실패");
		}
		
		
		
		
	}

}
