package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BasketDao;
import vo.GuestBasket;
import vo.MemberBasket;

@WebServlet("/basketListController")
public class BasketListController extends HttpServlet {
	// 회원,비회원 장바구니 리스트 출력위한 컨트롤러
	private BasketDao basketDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.basketDao = new BasketDao();
		
		//세션호출
	    HttpSession session = request.getSession();
	    
	    String memberId = (String) session.getAttribute("sessionMemberId");
	    // 세션에 있는 장바구니 목록을 쓰기 위해 basketList로 저장
	    // List<GuestBasket> guestBasketList = (List<GuestBasket>)session.getAttribute("guestBasketList");
	 		
	    List<MemberBasket> memberBasketList = basketDao.selectMemberBasketList(memberId);
	    int productId = 0;
	    
	    System.out.println("---------------------------------BasketListController BEGIN---------------------------");
	    if(memberId != null) { // 로그인 된 상태로 컨트롤러 들어왔다면
	    	
	    	if(session.getAttribute("guestBasketList") != null) { // 비회원일때 장바구니에 상품을 담았었는지 체크 // 사이즈가 0이라면
	    		List<GuestBasket> guestBasketList = (List<GuestBasket>)session.getAttribute("guestBasketList");
	    		
	    		for(int j=0; j<guestBasketList.size(); j=j+1) { // 비회원 장바구니 리스트 돌리면서 (session) 
	    			boolean chk = false; // 회원장바구니에 원래 있던 상품인지 아닌지를 체크하기 위한 변수
	    			
	    			for(int i=0; i<memberBasketList.size(); i=i+1) { // 멤버 장바구니 리스트 돌리면서 (DB)
	    				System.out.println("guestBasketList--------------" + guestBasketList.get(j).getProductId());
    					System.out.println("memberBasketList--------------" + memberBasketList.get(i).getProductId());
	    				if(guestBasketList.get(j).getProductId() == memberBasketList.get(i).getProductId()) { // 같은 아이디가 있다면
	    					productId = memberBasketList.get(i).getProductId();
	    					basketDao.updateBasket(productId, memberId); // quantity수량 하나 올려주는 메서드 호출
	    					chk = true; // quantity값 바꿔줬으면 chk값 true로 변경
	    				}
	    			}
	    			
	    			System.out.println("chk  -------:"+chk);
	    			if(!chk) { // 같은 상품이 없었다면
	    				int quantity = 1;  // 초기 수량을 1로 정해주기
	    				productId = guestBasketList.get(j).getProductId(); // 리스트 돌리면서 productId 들고와서 
	    			    basketDao.insertBasket(productId, memberId, quantity); // db에 넣어주기
	    			}
	    		}
	    	}
	    	
	    	memberBasketList = basketDao.selectMemberBasketList(memberId);
	    }	
	    
	    request.setAttribute("memberBasketList", memberBasketList);
	    System.out.println("---------------------------------BasketListController END---------------------------");
 		//뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/basketList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
