package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginCheck/logoutController")
public class LogoutController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // 현재 세션 받아오기
		session.invalidate(); // 세션 끊기
		response.sendRedirect(request.getContextPath()+"/mainPageController"); // 메인페이지로 이동 
	}

}
