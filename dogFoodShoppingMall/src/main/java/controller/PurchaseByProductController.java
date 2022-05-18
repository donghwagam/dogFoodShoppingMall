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

@WebServlet("/loginCheck/purchaseByProductController")
public class PurchaseByProductController extends HttpServlet {
	private MemberDao memberDao;
	private PurchaseDao purchaseDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 기본배송정보를 선택한 결제페이지
		int productId = Integer.parseInt(request.getParameter("productId")); // 상품번호
		String photoName = request.getParameter("photoName"); // 사진이름
		String productName = request.getParameter("productName"); // 상품이름
		int quantity = Integer.parseInt(request.getParameter("quantity")); // 수량
		int totalPriceByProduct = Integer.parseInt(request.getParameter("totalPriceByProduct")); // 상품 1개의 총 가격
		
		// 디버깅
		System.out.println("PurchaseByProductController.doGet() productId : " + productId);
		System.out.println("PurchaseByProductController.doGet() photoName : " + photoName);
		System.out.println("PurchaseByProductController.doGet() productName : " + productName);
		System.out.println("PurchaseByProductController.doGet() quantity : " + quantity);
		System.out.println("PurchaseByProductController.doGet() totalPriceByProduct : " + totalPriceByProduct);
		
		HttpSession session = request.getSession(); // 현재 세션 받아오기
		String sessionMemberId = (String)session.getAttribute("sessionMemberId"); // 현제 로그인한 아이디 가져오기
		
		memberDao = new MemberDao(); // 메서드 사용을 위한 객체 생성
		
		Map<String, Object> memberMap = memberDao.selectMemberInfo(sessionMemberId); // 사용자의 정보 가져오는 메서드 실행 후 저장
		
		// purchaseByProduct.jsp에 정보 보내주기 위해 저장
		request.setAttribute("productId", productId);
		request.setAttribute("name", memberMap.get("name"));
		request.setAttribute("phone", memberMap.get("phone"));
		request.setAttribute("address", memberMap.get("addr"));
		request.setAttribute("photoName", photoName);
		request.setAttribute("productName", productName);
		request.setAttribute("quantity", quantity);
		request.setAttribute("totalPriceByProduct", totalPriceByProduct);
		
		// purchaseByProduct.jsp 연결
		request.getRequestDispatcher("/WEB-INF/view/purchaseByProduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 구매하기 버튼을 눌렀을때 넘어오는 값 받아오기
		int productId = Integer.parseInt(request.getParameter("productId")); // 상품번호
		int quantity = Integer.parseInt(request.getParameter("quantity")); // 수량
		
		// 디버깅
		System.out.println("PurchaseByProductController.doPost() productId : " + productId);
		System.out.println("PurchaseByProductController.doPost() quantity : " + quantity);
		
		purchaseDao = new PurchaseDao(); // 메서드 사용을 위한 객체 생성
		Map<String, Object> map = purchaseDao.selectPurchaseByProduct(productId, quantity); // 구매한 상품정보 가져오는 메서드 실행 후 저장
		
		String photoName = (String)map.get("photoName"); // map에 저장된 photoName 변수에 저장
		String productName = (String)map.get("productName"); // map에 저장된 productName 변수에 저장
		int totalPriceByProduct = (int)map.get("price")*quantity; // map에 저장된 price*선택한 수량 계산 후 변수에 저장
		
		// 디버깅
		System.out.println("PurchaseByProductController.doPost() photoName : " + photoName);
		System.out.println("PurchaseByProductController.doPost() productName : " + productName);
		System.out.println("PurchaseByProductController.doPost() totalPriceByProduct : " + totalPriceByProduct);
		
		// purchaseByProductController로 보내기
		response.sendRedirect(request.getContextPath()+"/loginCheck/purchaseByProductController?productId="+productId+"&photoName="+photoName+"&productName="+productName+"&quantity="+quantity+"&totalPriceByProduct="+totalPriceByProduct);
		
	}

	
	
}
