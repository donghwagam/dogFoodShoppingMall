package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;


@WebServlet("/loginDenied/updateMemberPwController")
public class UpdateMemberPwController extends HttpServlet {
	
	MemberDao memberDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String phone = request.getParameter("phone");
		
		System.out.println("updateMemberPwController.doGet() memberId : " + memberId);
		System.out.println("updateMemberPwController.doGet() phone : " + phone);
		
		request.setAttribute("memberId", memberId);
		request.setAttribute("phone", phone);
		
		request.getRequestDispatcher("/WEB-INF/view/updateMemberPw.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String phone = request.getParameter("phone");
		String memberPw = request.getParameter("memberPw");
		
		System.out.println("updateMemberPwController.doPost() memberPw : " + memberPw);
		
		memberDao = new MemberDao();
		Member member = new Member();
		
		member.setMemberPw(memberPw);
		member.setMemberId(memberId);
		member.setPhone(phone);
		
		memberDao.updateMemberPw(member);
		
		System.out.println("비밀번호 수정 완료");
		
		response.sendRedirect(request.getContextPath()+"/loginDenied/loginController");
		
		
		
	}

}
