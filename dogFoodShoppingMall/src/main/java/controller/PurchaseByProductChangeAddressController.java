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
		// 배송정보변경을 선택한 결제페이지
		int productId = Integer.parseInt(request.getParameter("productId")); // 상품번호
		String photoName = request.getParameter("photoName"); // 사진 이름
		String productName = request.getParameter("productName"); // 상품 이름
		int quantity = Integer.parseInt(request.getParameter("quantity")); // 수량
		int totalPriceByProduct = Integer.parseInt(request.getParameter("totalPriceByProduct")); // 상품 1개의 총 가격
		
		// 디버깅
		System.out.println("PurchaseChangeAddressController.doGet() productId : " + productId);
		System.out.println("PurchaseChangeAddressController.doGet() photoName : " + photoName);
		System.out.println("PurchaseChangeAddressController.doGet() productName : " + productName);
		System.out.println("PurchaseChangeAddressController.doGet() quantity : " + quantity);
		System.out.println("PurchaseChangeAddressController.doGet() totalPriceByProduct : " + totalPriceByProduct);
		
		// purchaseByProductChangeAddress.jsp에 값을 넘겨주기 위해 저장
		request.setAttribute("productId", productId);
		request.setAttribute("photoName", photoName);
		request.setAttribute("productName", productName);
		request.setAttribute("quantity", quantity);
		request.setAttribute("totalPriceByProduct", totalPriceByProduct);
		
		// purchaseByProductChangeAddress.jsp 연결
		request.getRequestDispatcher("/WEB-INF/view/purchaseByProductChangeAddress.jsp").forward(request, response);
	}

}
