package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;


@WebServlet("/updateChkNowPwController")
public class UpdateChkNowPwController extends HttpServlet {
	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//세션에서 현재 로그인된 아이디 들고오기
		String memberId = (String) session.getAttribute("sessionMemberId");
		
		request.setAttribute("memberId", memberId);
		
		//뷰 포워딩
		request.getRequestDispatcher("/WEB-INF/view/updateChkNowPw.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberDao = new MemberDao();
		
		HttpSession session = request.getSession();
		
		//세션에서 현재 로그인된 아이디 들고오기
		String memberId = (String) session.getAttribute("sessionMemberId");
		
		// 요청값 불러오기
		String nowPw = request.getParameter("nowPw");
		
		// 디버깅
		System.out.println("updateChkNowPwController.doPost() nowPw : "+ nowPw);
		
		// 사용자가 넣은 비밀번호에 들어간 아이디값 받아오기
		String id = memberDao.selectMemberNowPw(nowPw, memberId);
		System.out.println("id ------------: "+id);
		
		if(!id.equals(memberId)) {
			System.out.println("updateChkNowPwController.doPost() 비밀번호 잘못됨");
			response.sendRedirect(request.getContextPath()+"/updateChkNowPwController?msg=incorrectNowPw");
		} else {
			System.out.println("updateChkNowPwController.doPost() 비밀번호 확인 성공");
			response.sendRedirect(request.getContextPath()+"/updateMemberPwByMyPageController");
		}
	}

}
