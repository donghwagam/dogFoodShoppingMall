package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import vo.Basket;
import vo.MemberBasket;


@WebServlet("/addMemberBasketController")
public class AddMemberBasketController extends HttpServlet {
	private BasketDao basketDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.basketDao = new BasketDao();
		
		System.out.println("AddMemberBasketController BEGIN");
		
		//세션호출
	    HttpSession session = request.getSession();
	    
	    Basket basket = new Basket();
	    
	    //요청값 불러오기
	    int productId = Integer.parseInt(request.getParameter("productId"));
	    String memberId = (String) session.getAttribute("sessionMemberId");
	    //디버깅
	    System.out.println("AddGuestBasketController(doGet) productId : " + productId);
	    System.out.println("AddGuestBasketController(doGet) memberId : " + memberId);

	    //멤버 아이디로 멤버 구매내역 눌러서 memberBasketList에 저장
	    List<MemberBasket> memberBasketList = basketDao.selectMemberBasketList(memberId);
	    System.out.println(basketDao.selectMemberBasketList(memberId));
	    
	    boolean chk = false; // 원래 있던 상품인지 아닌지를 체크하기 위한 변수 
	    for(int i=0; i<memberBasketList.size(); i=i+1) {
	    	if(memberBasketList.get(i).getProductId() == productId) { // 현재 장바구니에 동일한 상품이 있을 때 
	    		basketDao.updateBasket(productId, memberId); // quantity수량 하나 올려주는 메서드 호출
        		chk = true; // quantity값 바꿔줬으면 chk값 true로 변경
        		break; 
	    	 }
	     }
	    
	    if(!chk) { // 원래 있던 상품이 아니라면
	    	int quantity = 1;  // 초기 수량을 1로 정해주기
		    basketDao.insertBasket(productId, memberId, quantity);
	    }
	    
	    System.out.println("AddMemberBasketController END");
	    
	    //리다이렉트
	    response.sendRedirect(request.getContextPath()+"/basketListController");
	}

}
