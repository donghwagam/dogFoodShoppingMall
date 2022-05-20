package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaseDao;
import vo.PurchaseAddress;

@WebServlet("/loginCheck/purchaseByProductCompleteController")
public class PurchaseByProductCompleteController extends HttpServlet {
	private PurchaseDao purchaseDao;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// purchaseByProduct or purchaseByProductChangeAddress에서 넘어온 정보받기
		HttpSession session = request.getSession(); // 현재 세션 받아오기
		String sessionMemberId = (String)session.getAttribute("sessionMemberId"); // 현재 로그인한 사용자 아이디 가져오기
		int productId = Integer.parseInt(request.getParameter("productId")); // 상품 번호
		String detailAddr = request.getParameter("detailAddr"); // 상세주소
		String payment = request.getParameter("payment"); // 결제방법
		String name = request.getParameter("name"); // 이름
		String phone = request.getParameter("phone"); // 핸드폰번호
		String address = request.getParameter("address"); // 주소
		String photoName = request.getParameter("photoName"); // 사진이름
		String productName = request.getParameter("productName"); // 상품이름
		int quantity = Integer.parseInt(request.getParameter("quantity")); // 수량
		int totalPriceByProduct = Integer.parseInt(request.getParameter("totalPriceByProduct")); // 상품 1개의 총 가격
		String totalAddress = null;
		
		if(detailAddr != null) {
			totalAddress = address + " " + detailAddr;
		} else {
			totalAddress = address;
		}
		
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
		System.out.println("PurchaseCompleteController.doPost() totalAddress : " + totalAddress);
		
		Map<String, Object> map = new HashMap<>(); // insertPurchaseByProduct() 메서드의 매개변수로 사용할 map 생성
		// map에 정보 저장
		map.put("memberId", sessionMemberId);
		map.put("productId", productId);
		map.put("payment", payment);
		map.put("totalPriceByProduct", totalPriceByProduct);
		map.put("quantity", quantity);
		map.put("purchaseName", name);
		map.put("purchasePhone", phone);
		map.put("address", totalAddress);
		
		purchaseDao = new PurchaseDao(); // 메서드 사용을 위한 객체 생성
		List<Integer> list = purchaseDao.insertPurchaseByProduct(map); // 구매목록 DB 저장 -> 성공하면 row에 1 저장
		
		if(list.get(1) == 1) { // 결제 성공했을때(DB 저장)
			int stock = purchaseDao.selectStockByProduct(productId); // 구매한 상품의 재고 정보 받아온 후 저장
			System.out.println("PurchaseCompleteController.doPost() stock : " + stock); // 디버깅
			int row2 = purchaseDao.updateStockByProduct(stock, quantity, productId); // 구매한 상품 재고 업데이트 -> 성공하면 row2에 1 저장
			int purchaseId = list.get(0);
			PurchaseAddress purchaseAddress = purchaseDao.selectPurchaseAddress(purchaseId);
			if(row2 == 1) { // 재고 수정이 완료되면
				System.out.println("재고 수정 완료");
			} else { // 재고 수정 실패하면
				System.out.println("재고 수정 실패");
			}
			// purchaseByProductComplete.jsp에 값을 넘겨주기 위해 저장
			request.setAttribute("purchaseAddress", purchaseAddress);
			request.setAttribute("totalAddress", totalAddress);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			request.setAttribute("photoName", photoName);
			request.setAttribute("productName", productName);
			request.setAttribute("quantity", quantity);
			request.setAttribute("totalPriceByProduct", totalPriceByProduct);
			
			// purchaseByProductComplete.jsp 연결
			request.getRequestDispatcher("/WEB-INF/view/purchaseByProductComplete.jsp").forward(request, response);
			System.out.println("결제 성공");
		} else { // 결제 실패했을때
			// 메인페이지로 이동
			response.sendRedirect(request.getContextPath()+"/mainProductOneController?productId="+productId);
			System.out.println("결제 실패");
		}
		
	
	}

}
