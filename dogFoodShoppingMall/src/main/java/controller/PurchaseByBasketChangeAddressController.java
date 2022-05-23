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

@WebServlet("/loginCheck/purchaseByBasketChangeAddressController")
public class PurchaseByBasketChangeAddressController extends HttpServlet {
	private BasketDao basketDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String sessionMemberId = (String)session.getAttribute("sessionMemberId");
		System.out.println("sefesfs : " + sessionMemberId);
		
		basketDao = new BasketDao();
		List<MemberBasket> memberBasketList = basketDao.selectMemberBasketList(sessionMemberId);
		int totalPriceByBasket = 0;
		
		for(MemberBasket m : memberBasketList) {
			totalPriceByBasket += m.getPrice() * m.getQuantity();
		}
		
		request.setAttribute("memberBasketList", memberBasketList);
		request.setAttribute("totalPriceByBasket", totalPriceByBasket);
		
		request.getRequestDispatcher("/WEB-INF/view/purchaseByBasketChangeAddress.jsp").forward(request, response);
	}
}
