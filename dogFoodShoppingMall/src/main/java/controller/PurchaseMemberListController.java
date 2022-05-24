package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaseDao;

@WebServlet("/purchaseMemberListController")
public class PurchaseMemberListController extends HttpServlet {
	
	private PurchaseDao purchaseDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.purchaseDao = new PurchaseDao();
		
		// 세션호출
		HttpSession session = request.getSession();
		
		String memberId = (String) session.getAttribute("sessionMemberId");
		
		List<Map<String, Object>> purchaseMemberList = purchaseDao.selectPurchaseMemberListByPage(memberId);
		
		String msg = null;
		if(request.getParameter("msg")!=null) {
			msg = request.getParameter("msg");
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("purchaseMemberList", purchaseMemberList);
		// 구매내역 뷰단으로 포워딩
		request.getRequestDispatcher("/WEB-INF/view/purchaseMemberList.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
