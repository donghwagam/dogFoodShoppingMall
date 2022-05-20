package controller;

import java.io.IOException;
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
import vo.MemberBasket;

@WebServlet("/loginCheck/purchaseByBasketController")
public class PurchaseByBasketController extends HttpServlet {
	private BasketDao basketDao;
	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int totalPriceByBasket = 0;
		
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		
		basketDao = new BasketDao();
		List<MemberBasket> memberBasketList = basketDao.selectMemberBasketList(sessionMemberId);
		memberDao = new MemberDao(); // 메서드 사용을 위한 객체 생성
		Map<String, Object> memberMap = memberDao.selectMemberInfo(sessionMemberId); // 사용자의 정보 가져오는 메서드 실행 후 저장
		
		
		for(MemberBasket m : memberBasketList) {
			totalPriceByBasket += m.getPrice() * m.getQuantity();
		}
		
		System.out.println("PurchaseByBasketController.doPost() totalPriceByBasket : " + totalPriceByBasket);
		
		request.setAttribute("memberBasketList", memberBasketList);
		request.setAttribute("totalPriceByBasket", totalPriceByBasket);
		request.setAttribute("name", memberMap.get("name"));
		request.setAttribute("phone", memberMap.get("phone"));
		request.setAttribute("address", memberMap.get("addr"));
		request.getRequestDispatcher("/WEB-INF/view/purchaseByBasket.jsp").forward(request, response);
	}

}
