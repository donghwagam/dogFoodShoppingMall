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

import vo.GuestBasket;

@WebServlet("/removeBasketController")
public class RemoveBasketController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 삭제할 제품의 아이디 불러오기
		int productId = Integer.parseInt(request.getParameter("productId"));
		System.out.println("RemoveBasketController (doGet) productId: "+productId);
	
		// 세션 불러오기
		HttpSession session = request.getSession();
		
		// 세션에 있는 장바구니 목록을 쓰기 위해 basketList로 저장
		List<GuestBasket> basketList = (List<GuestBasket>)session.getAttribute("basketList");
		
		for(int i=0; i<basketList.size(); i+=1) { // 리스트 돌리면서
			if(basketList.get(i).getProductId() == productId) { // 상품아이디 일치하는거 찾아와서
				basketList.remove(i); //지워주기
			}
		}
		//리다이렉트
		response.sendRedirect(request.getContextPath()+"/basketListController");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
