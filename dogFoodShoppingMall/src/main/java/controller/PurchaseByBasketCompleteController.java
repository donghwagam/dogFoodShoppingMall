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
	private MemberDao memberDao;
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
		
		int totalPriceByBasket = 0;
		int row = 0;
		String totalAddress = null;
		
		basketDao = new BasketDao();
		List<MemberBasket> memberBasketList = basketDao.selectMemberBasketList(sessionMemberId);
		memberDao = new MemberDao(); // 메서드 사용을 위한 객체 생성
		Map<String, Object> memberMap = memberDao.selectMemberInfo(sessionMemberId); // 사용자의 정보 가져오는 메서드 실행 후 저장
		List<Integer> basketPurchaseId = new ArrayList<Integer>();
		
		for(MemberBasket m : memberBasketList) {
			totalPriceByBasket += m.getPrice() * m.getQuantity();
			basketPurchaseId.add(m.getProductId());
			basketPurchaseId.add(m.getQuantity());
		}
		
		// 디버깅
		for(int i=0; i<basketPurchaseId.size()/2; i=i+2) {
			System.out.println("fsfsefsefse" + i + "번째 " + basketPurchaseId.get(i));
			System.out.println("fsfsefsefse" + (i+1) + "번째 " + basketPurchaseId.get(i+1));
		}
		
		System.out.println("PurchaseByBasketCompleteController.doPost() totalPriceByBasket : " + totalPriceByBasket);
		
		request.setAttribute("memberBasketList", memberBasketList);
		request.setAttribute("totalPriceByBasket", totalPriceByBasket);
		request.setAttribute("name", memberMap.get("name"));
		request.setAttribute("phone", memberMap.get("phone"));
		request.setAttribute("address", memberMap.get("addr"));
		request.getRequestDispatcher("/WEB-INF/view/purchaseByBasket.jsp").forward(request, response);
		
		if(detailAddr != null) {
			totalAddress = address + " " + detailAddr;
		} else {
			totalAddress = address;
		}
		
		// 디버깅
		System.out.println("PurchaseByBasketCompleteController.doPost() sessionMemberId : " + sessionMemberId);
		System.out.println("PurchaseByBasketCompleteController.doPost() detailAddr : " + detailAddr);
		System.out.println("PurchaseByBasketCompleteController.doPost() payment : " + payment);
		System.out.println("PurchaseByBasketCompleteController.doPost() name : " + name);
		System.out.println("PurchaseByBasketCompleteController.doPost() phone : " + phone);
		System.out.println("PurchaseByBasketCompleteController.doPost() address : " + address);
		System.out.println("PurchaseByBasketCompleteController.doPost() totalPriceByBasket : " + totalPriceByBasket);
		System.out.println("PurchaseByBasketCompleteController.doPost() totalAddress : " + totalAddress);
		
		Map<String, Object> map = new HashMap<>(); // insertPurchaseByProduct() 메서드의 매개변수로 사용할 map 생성
		// map에 정보 저장
		map.put("memberId", sessionMemberId);
		map.put("payment", payment);
		map.put("totalPriceByBasket", totalPriceByBasket);
		map.put("purchaseName", name);
		map.put("purchasePhone", phone);
		map.put("address", totalAddress);
		
		purchaseDao = new PurchaseDao(); // 메서드 사용을 위한 객체 생성
		List<Integer> list = purchaseDao.insertPurchaseByBasket(map, basketPurchaseId); // 구매목록 DB 저장 -> 성공하면 row에 1 저장
		
		if(list.get(1) == 1) { // 결제 성공했을때(DB 저장)
			List<Map<String, Object>> basketStockList = purchaseDao.selectStockByBasket(); // 구매한 상품의 재고 정보 받아온 후 저장
			int deleteRow = purchaseDao.deleteBasketByPurchase(sessionMemberId);
			
			if(deleteRow == 1) {
				System.out.println("장바구니 목록 삭제 완료");
			} else {
				System.out.println("장바구니 목록 삭제 실패");
			}
			
			for(Map m : basketStockList) {
				System.out.println("PurchaseByBasketCompleteController.doPost() basketStockList.get(productId)" + m.get("productId"));
				System.out.println("PurchaseByBasketCompleteController.doPost() basketStockList.get(stock)" + m.get("stock"));
				System.out.println("PurchaseByBasketCompleteController.doPost() basketStockList.get(quantity)" + m.get("quantity"));
				row = purchaseDao.updateStockByBasket(basketStockList); // 구매한 상품 재고 업데이트 -> 성공하면 row2에 1 저장
			}
			int purchaseId = list.get(0);
			PurchaseAddress purchaseAddress = purchaseDao.selectPurchaseAddress(purchaseId);
			if(row == 1) { // 재고 수정이 완료되면
				System.out.println("재고 수정 완료");
			} else { // 재고 수정 실패하면
				System.out.println("재고 수정 실패");
			}
			// purchaseByProductComplete.jsp에 값을 넘겨주기 위해 저장
			request.setAttribute("purchaseAddress", purchaseAddress);
			request.setAttribute("totalAddress", totalAddress);
			request.setAttribute("name", name);
			request.setAttribute("phone", phone);
			request.setAttribute("totalPriceByBasket", totalPriceByBasket);
			
			// purchaseByBasketComplete.jsp 연결
			request.getRequestDispatcher("/WEB-INF/view/purchaseByBasketComplete.jsp").forward(request, response);
			System.out.println("결제 성공");
		} else { // 결제 실패했을때
			// 메인페이지로 이동
			response.sendRedirect(request.getContextPath()+"/basketListController");
			System.out.println("결제 실패");
		}
	}

}
