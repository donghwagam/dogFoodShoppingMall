package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import vo.Member;

@WebServlet("/searchMemberIdController")
public class SearchMemberIdController extends HttpServlet {
	MemberDao memberDao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("WEB-INF/view/searchMemberId.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		System.out.println("SearchMemberController.doPost() name : " + name);
		System.out.println("SearchMemberController.doPost() phone : " + phone);
		
		Member member = new Member();
		member.setName(name);
		member.setPhone(phone);
		
		memberDao = new MemberDao();
		
		String memberId = memberDao.searchMemberId(member);
		
		request.setAttribute("memberId", memberId);
		
		request.getRequestDispatcher("/WEB-INF/view/searchMemberId.jsp").forward(request, response);
		
	}

}
