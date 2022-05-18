package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaseDao;

@WebServlet("/loginCheck/purchaseByProductCompleteController")
public class PurchaseByProductCompleteController extends HttpServlet {
	private PurchaseDao purchaseDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		int productId = Integer.parseInt(request.getParameter("productId"));
		String detailAddr = request.getParameter("detailAddr");
		String payment = request.getParameter("payment");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String photoName = request.getParameter("photoName");
		String productName = request.getParameter("productName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int totalPriceByProduct = Integer.parseInt(request.getParameter("totalPriceByProduct"));
		
		
		// 디버깅
		System.out.println("PurchaseCompleteController.doPost() sessionMemberId : " + sessionMemberId);
		System.out.println("PurchaseCompleteController.doPost() productId : " + productId);
		System.out.println("PurchaseCompleteController.doPost() detailAddr : " + detailAddr);
		System.out.println("PurchaseCompleteController.doPost() payment : " + payment);
		System.out.println("PurchaseCompleteController.doPost() name : " + name);
		System.out.println("PurchaseCompleteController.doPost() phone : " + phone);
		System.out.println("PurchaseCompleteController.doPost() address : " + address);
		System.out.println("PurchaseCompleteController.doPost() photoName : " + photoName);
		System.out.println("PurchaseCompleteController.doPost() productName : " + productName);
		System.out.println("PurchaseCompleteController.doPost() quantity : " + quantity);
		System.out.println("PurchaseCompleteController.doPost() totalPriceByProduct : " + totalPriceByProduct);
		
		Map<String, Object> map = new HashMap<>();
		map.put("memberId", sessionMemberId);
		map.put("productId", productId);
		map.put("payment", payment);
		map.put("totalPriceByProduct", totalPriceByProduct);
		map.put("quantity", quantity);
		purchaseDao = new PurchaseDao();
		int row = purchaseDao.insertPurchaseByProduct(map);
		
		
		
		if(row == 1) {
			request.setAttribute("detailAddr", detailAddr);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			request.setAttribute("address", address);
			request.setAttribute("photoName", photoName);
			request.setAttribute("productName", productName);
			request.setAttribute("quantity", quantity);
			request.setAttribute("totalPriceByProduct", totalPriceByProduct);
			request.getRequestDispatcher("/WEB-INF/view/purchaseByProductComplete.jsp").forward(request, response);
			System.out.println("결제 성공");
		} else {
			response.sendRedirect(request.getContextPath()+"/mainPageController");
			System.out.println("결제 실패");
		}
		
	
	}

}
