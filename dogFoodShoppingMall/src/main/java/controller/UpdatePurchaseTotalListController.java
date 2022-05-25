package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.AdminDao;

@WebServlet("/updatePurchaseTotalListController")
public class UpdatePurchaseTotalListController extends HttpServlet {
	private AdminDao adminDao; // 지역변수 AdminDao 선언
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao(); //AdminDao호출 
		int purchaseId = Integer.parseInt(request.getParameter("purchaseId")); // purchaseId 값 받아오
		// 디버깅 
		System.out.println("UpdatePurchaseTotalListController.doGet() purchaseId : " + purchaseId); 
		
		List<Map<String, Object>> list = adminDao.selectUpdatePurchaseList(purchaseId); // 수정할 리스트의 값을 가져오는 메서드 
		// 디버깅 
		for(Map<String, Object> m : list) {
			System.out.println("UpdatepurchaseTotalListController.doGet() list purchaseId : " + m.get("purchaseId"));
			System.out.println("UpdatepurchaseTotalListController.doGet() list cnt : " + m.get("cnt"));
			System.out.println("UpdatepurchaseTotalListController.doGet() list productName : " + m.get("productName"));
			System.out.println("UpdatepurchaseTotalListController.doGet() list memberId : " + m.get("memberId"));
			System.out.println("UpdatepurchaseTotalListController.doGet() list status : " + m.get("status"));
			System.out.println("UpdatepurchaseTotalListController.doGet() list payment : " + m.get("payment"));
			System.out.println("UpdatepurchaseTotalListController.doGet() list totalPrice : " + m.get("totalPrice"));
			System.out.println("UpdatepurchaseTotalListController.doGet() list createDate : " + m.get("createDate"));
		}
		
		request.setAttribute("list", list);
		request.setAttribute("purchaseId", purchaseId);
		
		request.getRequestDispatcher("/WEB-INF/view/updatePurchaseTotalList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.adminDao = new AdminDao();
		int purchaseId = Integer.parseInt(request.getParameter("purchaseId"));
		System.out.println("UpdatepurchaseTotalListController.doPost() purchaseId : " + purchaseId);
		String status = request.getParameter("status");
		System.out.println("UpdatepurchaseTotalListController.doPost() status : " + status);
		String memberId = request.getParameter("memberId");
		System.out.println("UpdatePurchaseTotalListController.doPost() memberId : " + memberId);
		
		adminDao.updatePurchaseList(status,purchaseId);
		
		System.out.println("배송정보 변경완료");
		
		
		response.sendRedirect(request.getContextPath() + "/purchaseTotalListController?memberId=" + memberId);
	}

}
