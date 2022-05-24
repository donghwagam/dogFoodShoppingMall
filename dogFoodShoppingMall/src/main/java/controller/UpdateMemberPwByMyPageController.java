package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.Member;

@WebServlet("/updateMemberPwByMyPageController")
public class UpdateMemberPwByMyPageController extends HttpServlet {
	private MemberDao memberDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//세션에서 현재 로그인된 아이디 들고오기
		String memberId = (String) session.getAttribute("sessionMemberId");
		String msg = null;
		if(request.getParameter("msg")!= null) {
			msg = request.getParameter("msg");
		}
		//디버깅
		System.out.println("updateMemberPwByMyPageController.doGet() memberId : " + memberId);
		
		request.setAttribute("msg", msg);
		request.setAttribute("memberId", memberId);
		
		request.getRequestDispatcher("/WEB-INF/view/updateMemberPwByMyPage.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.memberDao = new MemberDao();
		
		HttpSession session = request.getSession();
		
		//세션에서 현재 로그인된 아이디 들고오기
		String memberId = (String) session.getAttribute("sessionMemberId");
		
		//요청값 들고오기
		String changePw = request.getParameter("changePw");

		//디버깅
		System.out.println("updateMemberPwByMyPageController.doPost() memberId : " + memberId);
		System.out.println("updateMemberPwByMyPageController.doPost() changePw : " + changePw);		
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(changePw);
		
		int row = memberDao.updateMemberPwByMyPage(member);
		
		if(row == 1) {
			session.invalidate(); // 세션 끊기
			System.out.println("updateMemberPwByMyPageController.doPost() 비밀번호 변경 성공");
			response.sendRedirect(request.getContextPath()+"/loginDenied/loginController");
		} else {
			System.out.println("updateMemberPwByMyPageController.doPost() 비밀번호 변경 실패");
			response.sendRedirect(request.getContextPath()+"/updateMemberPwByMyPageController?msg=incorrectPw");
		}
	}

}
