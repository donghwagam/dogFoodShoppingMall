package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginCheck/purchaseByProductChangeAddressController")
public class PurchaseByProductChangeAddressController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId")); // 상품번호
		String photoName = request.getParameter("photoName");
		String productName = request.getParameter("productName");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int totalPriceByProduct = Integer.parseInt(request.getParameter("totalPriceByProduct"));
		
		// 디버깅
		System.out.println("PurchaseChangeAddressController.doGet() productId : " + productId);
		System.out.println("PurchaseChangeAddressController.doGet() photoName : " + photoName);
		System.out.println("PurchaseChangeAddressController.doGet() productName : " + productName);
		System.out.println("PurchaseChangeAddressController.doGet() quantity : " + quantity);
		System.out.println("PurchaseChangeAddressController.doGet() totalPriceByProduct : " + totalPriceByProduct);
		
		request.setAttribute("productId", productId);
		request.setAttribute("photoName", photoName);
		request.setAttribute("productName", productName);
		request.setAttribute("quantity", quantity);
		request.setAttribute("totalPriceByProduct", totalPriceByProduct);
		
		request.getRequestDispatcher("/WEB-INF/view/purchaseByProductChangeAddress.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
