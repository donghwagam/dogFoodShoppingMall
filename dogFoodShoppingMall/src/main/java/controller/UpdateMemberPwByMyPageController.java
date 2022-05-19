package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/updateMemberPwByMyPageController")
public class UpdateMemberPwByMyPageController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//세션에서 현재 로그인된 아이디 들고오기
		String memberId = (String) session.getAttribute("sessionMemberId");
		
		//디버깅
		System.out.println("updateMemberPwByMyPageController.doGet() memberId : " + memberId);
		
		request.setAttribute("memberId", memberId);
		
		request.getRequestDispatcher("/WEB-INF/view/updateMemberByMyPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
