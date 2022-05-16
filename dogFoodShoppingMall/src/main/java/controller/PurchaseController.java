package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.PurchaseDao;

@WebServlet("/loginCheck/purchaseController")
public class PurchaseController extends HttpServlet {
	private MemberDao memberDao;
	private PurchaseDao purchaseDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//int count = 0;
		//if(request.getParameter("count") != null) {
		//	count = Integer.parseInt(request.getParameter("basketCount"));
		//}
		// System.out.println("PurchaseController (doGet) count: "+ count)
		int productId = Integer.parseInt(request.getParameter("productId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		System.out.println("PurchaseController (doGet) quantity : "+ quantity);
		System.out.println("PurchaseController (doGet) productId : "+ productId);	
		
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		
		memberDao = new MemberDao();
		purchaseDao = new PurchaseDao();
		
		Map<String, Object> memberMap = memberDao.selectMemberInfo(sessionMemberId);
		Map<String, Object> purchaseMap = purchaseDao.selectPurchaseByProductOne(productId, quantity);
		
		session.setAttribute("name", memberMap.get("name"));
		session.setAttribute("phone", memberMap.get("phone"));
		session.setAttribute("address", memberMap.get("addr"));
		
		int totalPriceByProduct = (int)purchaseMap.get("price")*quantity;
		request.setAttribute("photoName", purchaseMap.get("photoName"));
		request.setAttribute("productName", purchaseMap.get("productName"));
		request.setAttribute("quantity", purchaseMap.get("quantity"));
		request.setAttribute("totalPriceByProduct", purchaseMap.get("totalPriceByProduct"));
		
	
		request.getRequestDispatcher("/WEB-INF/view/purchase.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
	}

	
	
}
