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


@WebServlet("/loginDenied/searchMemberPwController")
public class SearchMemberPwController extends HttpServlet {

	MemberDao memberDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String sessionMemberId = (String) session.getAttribute("sessionMemberId");
		
		if (sessionMemberId != null) {
			response.sendRedirect(request.getContextPath()+"/mainPageController");
			return;
		}
		
		
		request.getRequestDispatcher("/WEB-INF/view/searchMemberPw.jsp").forward(request, response);
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memberId = request.getParameter("memberId");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		
		System.out.println("SearchMemberPwController.doPost() memberId : " + memberId);
		System.out.println("SearchMemberPwController.doPost() name : " + name);
		System.out.println("SearchMemberPwController.doPost() phone : " + phone);
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setName(name);
		member.setPhone(phone);
		
		memberDao = new MemberDao();
		String memberPw = memberDao.searchMemberPw(member);
		System.out.println("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇmemberPw : " + memberPw);
		
		
		if(memberPw != null) {
			response.sendRedirect(request.getContextPath()+"/loginDenied/updateMemberPwController?memberId="+memberId+"&phone="+phone);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/loginDenied/searchMemberPwController");
	}

}
