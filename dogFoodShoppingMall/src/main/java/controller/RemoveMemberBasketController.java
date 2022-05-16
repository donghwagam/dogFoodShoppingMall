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
import vo.MemberBasket;

@WebServlet("/removeMemberBasketController")
public class RemoveMemberBasketController extends HttpServlet {
	private BasketDao basketDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.basketDao = new BasketDao();
		
		// 삭제할 제품의 아이디 불러오기
		int productId = Integer.parseInt(request.getParameter("productId"));
		// 디버깅
		System.out.println("RemoveMemberBasketController (doGet) productId: "+productId);
		
		//세션호출
	    HttpSession session = request.getSession();
	    
	    //세션에 저장된 아이디 memberId에 저장
		String memberId = (String) session.getAttribute("sessionMemberId");
		
		//멤버 아이디로 멤버 구매내역 눌러서 memberBasketList에 저장
		List<MemberBasket> memberBasketList = basketDao.selectMemberBasketList(memberId);
		
		for(int i=0; i<memberBasketList.size(); i+=1) { // 리스트 돌리면서
			if(memberBasketList.get(i).getProductId() == productId) { // 상품아이디 일치하는거 찾아와서
				basketDao.deleteBasket(productId, memberId); // 일치하는 테이블 정보 삭제
			}
		}
		
		//리다이렉트
		response.sendRedirect(request.getContextPath()+"/basketListController");
	}

}
