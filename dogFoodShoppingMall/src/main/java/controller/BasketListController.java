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
	    List<MemberBasket> memberBasketList = new ArrayList<>();
	    
	    if(memberId != null) {
	    	memberBasketList = basketDao.selectMemberBasketList(memberId);
	    }
	    
	    request.setAttribute("memberBasketList", memberBasketList);
	    
 		//뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/basketList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
