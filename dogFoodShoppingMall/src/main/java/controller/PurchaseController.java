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
		// System.out.println("PurchaseController (doGet) count: "+ count);
		
		String photoName = request.getParameter("photoName");
		String productName = request.getParameter("productName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int totalPriceByProduct = Integer.parseInt(request.getParameter("totalPriceByProduct"));
		
		// 디버깅
		System.out.println("PurchaseCompleteController.doGet() photoName : " + photoName);
		System.out.println("PurchaseCompleteController.doGet() productName : " + productName);
		System.out.println("PurchaseCompleteController.doGet() quantity : " + quantity);
		System.out.println("PurchaseCompleteController.doGet() totalPriceByProduct : " + totalPriceByProduct);
		
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		
		memberDao = new MemberDao();
		
		Map<String, Object> memberMap = memberDao.selectMemberInfo(sessionMemberId);
		
		session.setAttribute("name", memberMap.get("name"));
		session.setAttribute("phone", memberMap.get("phone"));
		session.setAttribute("address", memberMap.get("addr"));
		request.setAttribute("photoName", photoName);
		request.setAttribute("productName", productName);
		request.setAttribute("quantity", quantity);
		request.setAttribute("totalPriceByProduct", totalPriceByProduct);
		
		request.getRequestDispatcher("/WEB-INF/view/purchase.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 구매하기 버튼을 눌렀을때 넘어오는 값 받아오기
		int productId = Integer.parseInt(request.getParameter("productId")); // 상품번호
		int quantity = Integer.parseInt(request.getParameter("quantity")); // 수량
		
		// 디버깅
		System.out.println("PurchaseController.doPost() productId : " + productId);
		System.out.println("PurchaseController.doPost() quantity : " + quantity);
		
		purchaseDao = new PurchaseDao();
		Map<String, Object> map = purchaseDao.selectPurchaseByProductOne(productId, quantity);
		
		String photoName = (String)map.get("photoName");
		String productName = (String)map.get("productName");
		int totalPriceByProduct = (int)map.get("price")*quantity;
		
		// 디버깅
		System.out.println("PurchaseController.doPost() photoName : " + photoName);
		System.out.println("PurchaseController.doPost() productName : " + productName);
		System.out.println("PurchaseController.doPost() totalPriceByProduct : " + totalPriceByProduct);
		
		response.sendRedirect(request.getContextPath()+"/loginCheck/purchaseController?photoName="+photoName+"&productName="+productName+"&quantity="+quantity+"&totalPriceByProduct="+totalPriceByProduct);
		
	}

	
	
}
