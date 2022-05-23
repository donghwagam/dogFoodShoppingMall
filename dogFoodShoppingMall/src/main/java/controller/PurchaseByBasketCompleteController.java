package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import dao.MemberDao;
import dao.PurchaseDao;
import vo.MemberBasket;
import vo.PurchaseAddress;


@WebServlet("/loginCheck/purchaseByBasketCompleteController")
public class PurchaseByBasketCompleteController extends HttpServlet {
	
	private BasketDao basketDao;
	private PurchaseDao purchaseDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// purchaseByProduct or purchaseByProductChangeAddress에서 넘어온 정보받기
		HttpSession session = request.getSession(); // 현재 세션 받아오기
		String sessionMemberId = (String)session.getAttribute("sessionMemberId"); // 현재 로그인한 사용자 아이디 가져오기
		String detailAddr = request.getParameter("detailAddr"); // 상세주소
		String payment = request.getParameter("payment"); // 결제방법
		String name = request.getParameter("name"); // 이름
		String phone = request.getParameter("phone"); // 핸드폰번호
		String address = request.getParameter("address"); // 주소
		int totalPriceByBasket = Integer.parseInt(request.getParameter("totalPriceByBasket"));
		
		// 디버깅
		System.out.println("PurchaseByBasketCompleteController.doPost() sessionMemberId : " + sessionMemberId);
		System.out.println("PurchaseByBasketCompleteController.doPost() detailAddr : " + detailAddr);
		System.out.println("PurchaseByBasketCompleteController.doPost() payment : " + payment);
		System.out.println("PurchaseByBasketCompleteController.doPost() name : " + name);
		System.out.println("PurchaseByBasketCompleteController.doPost() phone : " + phone);
		System.out.println("PurchaseByBasketCompleteController.doPost() address : " + address);
		System.out.println("PurchaseByBasketCompleteController.doPost() totalPriceByBasket : " + totalPriceByBasket);
		
		int row = 0;
		String totalAddress = null;
		
		if(detailAddr != null) {
			totalAddress = address + " " + detailAddr;
		} else {
			totalAddress = address;
		}
		
		System.out.println("PurchaseByBasketCompleteController.doPost() totalAddress : " + totalAddress);
		
		basketDao = new BasketDao();
		List<MemberBasket> memberBasketList = basketDao.selectMemberBasketList(sessionMemberId);
		
		for(MemberBasket m : memberBasketList) {
			System.out.println("lesrgselg : " + m.getPhotoName());
			System.out.println("lesrgselg : " + m.getQuantity());
			System.out.println("lesrgselg : " + m.getPrice());
		}
		
		Map<String, Object> map = new HashMap<>(); // insertPurchaseByProduct() 메서드의 매개변수로 사용할 map 생성
		// map에 정보 저장
		map.put("memberId", sessionMemberId);
		map.put("payment", payment);
		map.put("totalPriceByBasket", totalPriceByBasket);
		map.put("purchaseName", name);
		map.put("purchasePhone", phone);
		map.put("address", totalAddress);
		
		purchaseDao = new PurchaseDao(); // 메서드 사용을 위한 객체 생성
		List<Integer> list = purchaseDao.insertPurchaseByBasket(map, memberBasketList); // 구매목록 DB 저장 -> 성공하면 row에 1 저장
		
		if(list.get(1) == 1) { // 결제 성공했을때(DB 저장)
			List<Map<String, Object>> basketStockList = purchaseDao.selectStockByBasket(sessionMemberId); // 구매한 상품의 재고 정보 받아온 후 저장
			int updateRow = purchaseDao.updateStockByBasket(basketStockList);
			int deleteRow = purchaseDao.deleteBasketByPurchase(sessionMemberId);
			
			if(updateRow == 1) { // 재고 수정이 완료되면
				System.out.println("재고 수정 완료");
			} else { // 재고 수정 실패하면
				System.out.println("재고 수정 실패");
			}
			
			if(deleteRow == 1) {
				System.out.println("장바구니 목록 삭제 완료");
			} else {
				System.out.println("장바구니 목록 삭제 실패");
			}
			
			int purchaseId = list.get(0);
			PurchaseAddress purchaseAddress = purchaseDao.selectPurchaseAddress(purchaseId);
			// purchaseByProductComplete.jsp에 값을 넘겨주기 위해 저장
			request.setAttribute("purchaseAddress", purchaseAddress);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			request.setAttribute("totalPriceByBasket", totalPriceByBasket);
			request.setAttribute("memberBasketList", memberBasketList);
			
			// purchaseByBasketComplete.jsp 연결
			request.getRequestDispatcher("/WEB-INF/view/purchaseByBasketComplete.jsp").forward(request, response);
			System.out.println("결제 성공");
			return;
		}
		
		// 결제 실패했을때
		// 메인페이지로 이동
		response.sendRedirect(request.getContextPath()+"/basketListController");
		System.out.println("결제 실패");
	
	}

}
