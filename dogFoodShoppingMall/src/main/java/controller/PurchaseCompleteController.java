package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginCheck/purchaseCompleteController")
public class PurchaseCompleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String photoName = request.getParameter("photoName");
		String productName = request.getParameter("productName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int totalPriceByProduct = Integer.parseInt(request.getParameter("totalPriceByProduct"));
		
		// 디버깅
		System.out.println("PurchaseCompleteController.doGet() photoName : " + photoName);
		System.out.println("PurchaseCompleteController.doGet() productName : " + productName);
		System.out.println("PurchaseCompleteController.doGet() quantity : " + quantity);
		System.out.println("PurchaseCompleteController.doGet() totalPriceByProduct : " + totalPriceByProduct);
		
		request.setAttribute("photoName", photoName);
		request.setAttribute("productName", productName);
		request.setAttribute("quantity", quantity);
		request.setAttribute("totalPriceByProduct", totalPriceByProduct);
		
		request.getRequestDispatcher("/WEB-INF/view/purchaseComplete.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
